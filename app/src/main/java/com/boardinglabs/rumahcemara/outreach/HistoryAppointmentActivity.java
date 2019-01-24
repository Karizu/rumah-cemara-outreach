package com.boardinglabs.rumahcemara.outreach;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.adapter.AdapterHistoryAppointment;
import com.boardinglabs.rumahcemara.outreach.apihelper.API;
import com.boardinglabs.rumahcemara.outreach.apihelper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.models.HistoryModel;
import com.boardinglabs.rumahcemara.outreach.models.RequestModel;
import com.boardinglabs.rumahcemara.outreach.models.response.AppointmentDataResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.support.v4.app.Fragment;

public class HistoryAppointmentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    SessionManagement session;
    private String sId, sTokenId, sBearerToken;
    View view;
    Toolbar toolbar;
    private String typeProvider = "worker";
    private String search = " ";
    private int limit = 6;
    private String offset = " ";
    private int status = 4;
    private Context activity;
    private List<HistoryModel> articleModels;
    private SwipeRefreshLayout swipeContainer;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_appointment);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initToolbar();

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

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }

    // For testing purpose
    private void populateData(boolean onRefresh) {
        try {
            if (onRefresh) {
                API.baseApiService().getRequestService(search, limit, offset, sId, status, sBearerToken).enqueue(new Callback<ApiResponse<List<AppointmentDataResponse>>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<List<AppointmentDataResponse>>> call, Response<ApiResponse<List<AppointmentDataResponse>>> body) {
                        try {
                            if (body != null && body.body().isStatus()) {
                                List<AppointmentDataResponse> res = body.body().getData();
                                articleModels.clear();

                                for (int i = 0; i < res.size(); i++) {
                                    AppointmentDataResponse article = res.get(i);
                                    if (article.getRating() != null){
                                        articleModels.add(new HistoryModel(article.getId(),
                                                article.getService_type().getName(),
                                                article.getUser().getProfile().getPicture(),
                                                article.getUser().getProfile().getFullname(),
                                                article.getUser().getProfile().getPhoneNumber(),
                                                article.getStart_date(),
                                                article.getUpdated_at(),
                                                article.getDescription(),
                                                article.getRating().getRating(),
                                                article.getRating().getDescription(),
                                                article.getAttachment(),
                                                article.getAppointment()));
                                    } else {
                                        articleModels.add(new HistoryModel(article.getId(),
                                                article.getService_type().getName(),
                                                article.getUser().getProfile().getPicture(),
                                                article.getUser().getProfile().getFullname(),
                                                article.getUser().getProfile().getPhoneNumber(),
                                                article.getStart_date(),
                                                article.getUpdated_at(),
                                                article.getDescription(),
                                                "0",
                                                "there is no comment!",
                                                article.getAttachment(),
                                                article.getAppointment()));
                                    }
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
                API.baseApiService().getRequestService(search, limit, offset, sId, status, sBearerToken).enqueue(new Callback<ApiResponse<List<AppointmentDataResponse>>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<List<AppointmentDataResponse>>> call, Response<ApiResponse<List<AppointmentDataResponse>>> body) {
                        System.out.println("RESPONSE:  " + body.toString() + "\n" + "BODY: " + body.body().getData() + "\n" + "RAW: " + body.raw() + "\n" + "MESSAGE: " + body.message());

                        if (body != null) {
                            List<AppointmentDataResponse> res = body.body().getData();
                            articleModels = new ArrayList<>();

                            for (int i = 0; i < res.size(); i++) {
                                AppointmentDataResponse article = res.get(i);
                                if (article.getRating() != null){
                                    articleModels.add(new HistoryModel(article.getId(),
                                            article.getService_type().getName(),
                                            article.getUser().getProfile().getPicture(),
                                            article.getUser().getProfile().getFullname(),
                                            article.getUser().getProfile().getPhoneNumber(),
                                            article.getStart_date(),
                                            article.getUpdated_at(),
                                            article.getDescription(),
                                            article.getRating().getRating(),
                                            article.getRating().getDescription(),
                                            article.getAttachment(),
                                            article.getAppointment()));
                                } else {
                                    articleModels.add(new HistoryModel(article.getId(),
                                            article.getService_type().getName(),
                                            article.getUser().getProfile().getPicture(),
                                            article.getUser().getProfile().getFullname(),
                                            article.getUser().getProfile().getPhoneNumber(),
                                            article.getStart_date(),
                                            article.getUpdated_at(),
                                            article.getDescription(),
                                            "0",
                                            "there is no comment!",
                                            article.getAttachment(),
                                            article.getAppointment()));
                                }

                            }

                            adapter = new AdapterHistoryAppointment(articleModels, activity);
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
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("IO", "IO" + e);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
