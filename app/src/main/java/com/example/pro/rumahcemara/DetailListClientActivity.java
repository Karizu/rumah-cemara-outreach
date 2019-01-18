package com.example.pro.rumahcemara;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro.rumahcemara.adapter.AdapterDetailListClient;
import com.example.pro.rumahcemara.adapter.AdapterHistoryAppointment;
import com.example.pro.rumahcemara.adapter.AdapterRequestAppointment;
import com.example.pro.rumahcemara.apihelper.API;
import com.example.pro.rumahcemara.apihelper.ApiResponse;
import com.example.pro.rumahcemara.config.SessionManagement;
import com.example.pro.rumahcemara.models.DetailClientModel;
import com.example.pro.rumahcemara.models.response.AppointmentDataResponse;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailListClientActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    SessionManagement session;
    private String userId, sId, sTokenId, sBearerToken;
    View view;
    private String typeProvider = "worker";
    private String search = " ";
    private int limit = 10;
    private String offset = " ";
    private int status = 4;
    private Context activity;
    private List<DetailClientModel> articleModels;
    private SwipeRefreshLayout swipeContainer;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_client);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        populateIntent();

        swipeContainer = findViewById(R.id.swipeContainer);
        swipeContainer.setRefreshing(true);

        activity = getApplicationContext();
        layoutManager = new LinearLayoutManager(activity,
                LinearLayout.VERTICAL,
                false);

        recyclerView = findViewById(R.id.client_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        session = new SessionManagement(this);
        HashMap<String, String> user = session.getUserDetails();
        sId = user.get(SessionManagement.KEY_ID);
        sTokenId = user.get(SessionManagement.KEY_IMG_TOKEN);
        sBearerToken = "Bearer " + sTokenId;

        swipeContainer.setOnRefreshListener(() -> {
            // Your code to refresh the list here.
            // Make sure you call swipeContainer.setRefreshing(false)
            // once the network request has completed successfully.

            populateData(true);
        });

        swipeContainer.setColorSchemeResources(
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        populateData(false);

    }

    private void populateIntent(){
        Bundle bundle = getIntent().getBundleExtra("myData");   //<< get Bundle from Intent

        userId = bundle.getString("id");
        String imgUrl = bundle.getString("imgUrl");
        String fullName = bundle.getString("fullName");
        String phoneNumber = bundle.getString("phoneNumber");

        CircularImageView imageViewProfile = findViewById(R.id.imgListProfile);
        ImageView imgClose = findViewById(R.id.imgBack);
        TextView txtName = findViewById(R.id.tvName);
        TextView txtPhoneNumber = findViewById(R.id.tvPhoneNumber);

        txtName.setText(fullName);
        txtPhoneNumber.setText(phoneNumber);
        Glide.with(this).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_person_signup)).load(imgUrl).into(imageViewProfile);
        imgClose.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    private void populateData(boolean onRefresh){
        try{
            if (onRefresh){
                API.baseApiService().getRequestServicePerId(search, limit, offset, sId, status, userId, sBearerToken).enqueue(new Callback<ApiResponse<List<AppointmentDataResponse>>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<List<AppointmentDataResponse>>> call, Response<ApiResponse<List<AppointmentDataResponse>>> body) {
                        try {
                            if (body != null && body.body().isStatus()) {
                                List<AppointmentDataResponse> res = body.body().getData();
                                articleModels.clear();

                                for (int i = 0; i < res.size(); i++) {
                                    AppointmentDataResponse article = res.get(i);
                                    articleModels.add(new DetailClientModel(article.getId(),
                                            article.getAppointment().getServiceType().getName(),
                                            article.getUser().getProfile().getPicture(),
                                            article.getUser().getProfile().getFullname(),
                                            article.getUser().getProfile().getPhoneNumber(),
                                            article.getStart_date(),
                                            article.getEnd_date(),
                                            article.getDescription(),
                                            article.getWorker().getProfile().getAddress(),
                                            article.getAttachment(),
                                            article.getAppointment()));
                                }

                                adapter.notifyDataSetChanged(); // or notifyItemRangeRemoved

                                swipeContainer.setRefreshing(false);
                            }
                        } catch (Exception e) {

                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<List<AppointmentDataResponse>>> call, Throwable t) {
                        Log.i("response", "Response Failed");
                        Log.i("response", t.toString());
                    }
                });
            } else {
                API.baseApiService().getRequestServicePerId(search, limit, offset, sId, status, userId, sBearerToken).enqueue(new Callback<ApiResponse<List<AppointmentDataResponse>>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<List<AppointmentDataResponse>>> call, Response<ApiResponse<List<AppointmentDataResponse>>> body) {
                        System.out.println("RESPONSE:  "+body.toString() +"\n"+"BODY: "+body.body().getData() +"\n"+"RAW: "+body.raw() +"\n"+"MESSAGE: "+body.message());

                        if (body != null) {
                            List<AppointmentDataResponse> res = body.body().getData();
                            articleModels = new ArrayList<>();

                            for (int i = 0; i < res.size(); i++) {
                                AppointmentDataResponse article = res.get(i);
                                articleModels.add(new DetailClientModel(article.getId(),
                                        article.getService_type().getName(),
                                        article.getUser().getProfile().getPicture(),
                                        article.getUser().getProfile().getFullname(),
                                        article.getUser().getProfile().getPhoneNumber(),
                                        article.getStart_date(),
                                        article.getEnd_date(),
                                        article.getDescription(),
                                        article.getWorker().getProfile().getAddress(),
                                        article.getAttachment(),
                                        article.getAppointment()));
                            }

                            adapter = new AdapterDetailListClient(articleModels, activity);
                            recyclerView.setAdapter(adapter);
                            swipeContainer.setRefreshing(false);
                        } else {
                            Toast.makeText(activity, "Tidak dapat terhubung", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<List<AppointmentDataResponse>>> call, Throwable t) {
                        Log.i("response", "Response Failed");
                        Log.i("response", t.toString());
                        Toast.makeText(activity, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.e("IO","IO"+e);
        }
    }

}
