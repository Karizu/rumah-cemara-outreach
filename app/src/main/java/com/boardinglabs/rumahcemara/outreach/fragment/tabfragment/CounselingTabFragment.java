package com.boardinglabs.rumahcemara.outreach.fragment.tabfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.adapter.AdapterAppointment;
import com.boardinglabs.rumahcemara.outreach.helper.API;
import com.boardinglabs.rumahcemara.outreach.helper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.models.RequestModel;
import com.boardinglabs.rumahcemara.outreach.models.response.AppointmentDataResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CounselingTabFragment extends Fragment implements SearchView.OnQueryTextListener{

    private RecyclerView recyclerView;
    SessionManagement session;
    private String sId, sTokenId, sBearerToken;
    View view;
    private String typeProvider = "worker";
    private String search = " ";
    private int limit = 6;
    private String offset = " ";
    private int status = 1;
    private String service_type_id = "17c00365-4987-5f1e-925b-2119fbe5ff8a";
    private Context activity;
    private List<RequestModel> articleModels;
    private SwipeRefreshLayout swipeContainer;
    private AdapterAppointment adapter;
    private LinearLayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_counseling_tab, container, false);

        swipeContainer = view.findViewById(R.id.swipeContainer);
        swipeContainer.setRefreshing(true);

        activity = getActivity();
        layoutManager = new LinearLayoutManager(activity,
                LinearLayout.VERTICAL,
                false);

        recyclerView = view.findViewById(R.id.client_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        session = new SessionManagement(getActivity());
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

        SearchView searchView = view.findViewById(R.id.searchView);

        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.colorAccent));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        searchEditText.setTextSize(15);

        searchView.setOnQueryTextListener(this);

        searchView.setOnClickListener(v -> {
                    searchView.setIconified(false);
                }
        );

        return view;
    }

    // For testing purpose
    private void populateData(boolean onRefresh){
        try{
            if (onRefresh){
                API.baseApiService().getAppointment(search, limit, offset, sId, status, service_type_id,sBearerToken).enqueue(new Callback<ApiResponse<List<AppointmentDataResponse>>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<List<AppointmentDataResponse>>> call, Response<ApiResponse<List<AppointmentDataResponse>>> body) {
                        try {
                            if (body != null && body.body().isStatus()) {
                                List<AppointmentDataResponse> res = body.body().getData();
                                articleModels.clear();

                                for (int i = 0; i < res.size(); i++) {
                                    AppointmentDataResponse article = res.get(i);
                                    articleModels.add(new RequestModel(article.getId(),
                                            article.getService_type().getName(),
                                            article.getUser().getProfile().getPicture(),
                                            article.getUser().getProfile().getFullname(),
                                            article.getUser().getProfile().getPhoneNumber(),
                                            article.getStart_date(),
                                            article.getEnd_date(),
                                            article.getDescription(),
                                            article.getWorker().getProfile().getAddress(),
                                            article.getAppointment(),
                                            article.getWorker_id(),
                                            article.getProvider_id(),
                                            article.getUser_id(),
                                            getFragmentManager()));
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
                API.baseApiService().getAppointment(search, limit, offset, sId, status, service_type_id,sBearerToken).enqueue(new Callback<ApiResponse<List<AppointmentDataResponse>>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<List<AppointmentDataResponse>>> call, Response<ApiResponse<List<AppointmentDataResponse>>> body) {
                        System.out.println("RESPONSE:  "+body.toString() +"\n"+"BODY: "+body.body().getData() +"\n"+"RAW: "+body.raw() +"\n"+"MESSAGE: "+body.message());

                        if (body != null) {
                            List<AppointmentDataResponse> res = body.body().getData();
                            articleModels = new ArrayList<>();

                            for (int i = 0; i < res.size(); i++) {
                                AppointmentDataResponse article = res.get(i);
                                articleModels.add(new RequestModel(article.getId(),
                                        article.getService_type().getName(),
                                        article.getUser().getProfile().getPicture(),
                                        article.getUser().getProfile().getFullname(),
                                        article.getUser().getProfile().getPhoneNumber(),
                                        article.getStart_date(),
                                        article.getEnd_date(),
                                        article.getDescription(),
                                        article.getLocation(),
                                        article.getAppointment(),
                                        article.getWorker_id(),
                                        article.getProvider_id(),
                                        article.getUser_id(),
                                        getFragmentManager()));
                            }

                            adapter = new AdapterAppointment(articleModels, activity);
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
            Toast.makeText(activity, "Terjadi Gangguan", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<RequestModel> newWorker = new ArrayList<>();
        String newTextLowerCase = newText.toLowerCase();
        for (RequestModel user : articleModels) {
            if (user.getFullName().toLowerCase().contains(newTextLowerCase)) {
                newWorker.add(user);
            }
        }
//        adapter.updateData(newWorker);
        adapter.updateData(newWorker);
        return true;
    }
}
