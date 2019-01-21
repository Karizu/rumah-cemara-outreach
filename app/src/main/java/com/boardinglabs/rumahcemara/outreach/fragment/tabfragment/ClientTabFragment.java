package com.boardinglabs.rumahcemara.outreach.fragment.tabfragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.adapter.AdapterListClient;
import com.boardinglabs.rumahcemara.outreach.apihelper.API;
import com.boardinglabs.rumahcemara.outreach.apihelper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.models.ClientModel;
import com.boardinglabs.rumahcemara.outreach.models.response.MemberDataResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientTabFragment extends Fragment {

    private RecyclerView recyclerView;
    SessionManagement session;
    private String sTokenId, sBearerToken;
    View view;
    private String search = " ";
    private int limit = 5;
    private String offset = " ";
    private Context activity;
    private List<ClientModel> articleModels;
    private SwipeRefreshLayout swipeContainer;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_client_tab, container, false);

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

        return view;
    }

    // For testing purpose
    private void populateData(boolean onRefresh){
        try{
            if (onRefresh){
                API.baseApiService().getClient(search, limit, offset, sBearerToken).enqueue(new Callback<ApiResponse<List<MemberDataResponse>>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<List<MemberDataResponse>>> call, Response<ApiResponse<List<MemberDataResponse>>> body) {
                        try {
                            if (body != null && body.body().isStatus()) {
                                List<MemberDataResponse> res = body.body().getData();
                                articleModels.clear();

                                for (int i = 0; i < res.size(); i++) {
                                    MemberDataResponse article = res.get(i);
                                    articleModels.add(new ClientModel(article.getProfile().getUserId(),
                                            article.getProfile().getPicture(),
                                            article.getProfile().getFullname(),
                                            article.getProfile().getPhoneNumber(),
                                            article.getProfile().getEmail(),
                                            article.getUser(),
                                            getFragmentManager()));
                                }

                                adapter.notifyDataSetChanged(); // or notifyItemRangeRemoved

                                swipeContainer.setRefreshing(false);
                            }
                        } catch (Exception e) {

                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<List<MemberDataResponse>>> call, Throwable t) {
                        Log.i("response", "Response Failed");
                        Log.i("response", t.toString());
                    }
                });
            } else {
                API.baseApiService().getClient(search, limit, offset, sBearerToken).enqueue(new Callback<ApiResponse<List<MemberDataResponse>>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<List<MemberDataResponse>>> call, Response<ApiResponse<List<MemberDataResponse>>> body) {
                        System.out.println("RESPONSE:  "+body.toString() +"\n"+"BODY: "+body.body() +"\n"+"RAW: "+body.raw() +"\n"+"MESSAGE: "+body.message());

                            if (body != null && body.body().isStatus()) {
                                List<MemberDataResponse> res = body.body().getData();
                                articleModels = new ArrayList<>();

                                for (int i = 0; i < res.size(); i++) {
                                    MemberDataResponse article = res.get(i);
                                    articleModels.add(new ClientModel(article.getProfile().getUserId(),
                                            article.getProfile().getPicture(),
                                            article.getProfile().getFullname(),
                                            article.getProfile().getPhoneNumber(),
                                            article.getProfile().getEmail(),
                                            article.getUser(),
                                            getFragmentManager()));
                                }

                                adapter = new AdapterListClient(articleModels, activity);
                                recyclerView.setAdapter(adapter);
                                swipeContainer.setRefreshing(false);
                            } else {
                                Toast.makeText(activity, "Tidak dapat terhubung", Toast.LENGTH_SHORT).show();
                            }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<List<MemberDataResponse>>> call, Throwable t) {
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

}
