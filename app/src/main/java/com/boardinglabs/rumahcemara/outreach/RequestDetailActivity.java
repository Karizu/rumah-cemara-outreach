package com.boardinglabs.rumahcemara.outreach;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.apihelper.API;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.dialog.Utils;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestDetailActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;
    private String id;
    int status = 1;
    String serviceId, sToken, sBearerToken;
    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_request_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ButterKnife.bind(this);
        session = new SessionManagement(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        sToken = user.get(SessionManagement.KEY_IMG_TOKEN);
        sBearerToken = "Bearer "+sToken;

        loadingDialog = new LoadingDialog(this);

        populateData();

    }

    private void populateData(){
        Bundle bundle = getIntent().getBundleExtra("myData");   //<< get Bundle from Intent

        serviceId = bundle.getString("serviceId");
        String serviceName = bundle.getString("serviceName");
        String imgUrl = bundle.getString("imgUrl");
        String fullName = bundle.getString("fullName");
        String phoneNumber = bundle.getString("phoneNumber");
        String startDate = bundle.getString("startDate");
        String endDate = bundle.getString("endDate");
        String description = bundle.getString("description");
        String location = bundle.getString("location");

        TextView txtServiceName = findViewById(R.id.tvServiceName);
        CircularImageView imageViewProfile = findViewById(R.id.imgRequestDetail);
        ImageView imgClose = findViewById(R.id.imgClose);
        TextView txtDescription = findViewById(R.id.tvDescription);
        TextView txtStartDate = findViewById(R.id.tvStartDate);
        TextView txtEndDate = findViewById(R.id.tvEndDate);
        TextView txtName = findViewById(R.id.tvName);
        TextView txtPhoneNumber = findViewById(R.id.tvPhoneNumber);
        TextView txtLocation = findViewById(R.id.tvLocation);

        txtServiceName.setText(serviceName+" Appointment");
        txtDescription.setText(description);
        txtName.setText(fullName);
        txtPhoneNumber.setText(phoneNumber);
        txtStartDate.setText(startDate);
        txtEndDate.setText(endDate);
        txtLocation.setText(location);
        Glide.with(this).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_person_signup)).load(imgUrl).into(imageViewProfile);
        imgClose.setOnClickListener(view -> {
            onBackPressed();
        });
//        imageView.setOnClickListener(view -> {
//            Intent myIntent = new Intent(getActivity(), ImagePreviewActivity.class);
//            myIntent.putExtra("imgUrl", imgUrl);
//            myIntent.putExtra("type", 1);
//            startActivity(myIntent);
//        });
    }


    private void setId(String id){
        this.id = id;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.btnAccAppointment)
    void onClickButton(){
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        API.baseApiService().updateStatus(serviceId, status, sBearerToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                loadingDialog.dismiss();
                Toast.makeText(RequestDetailActivity.this, "Appointment Accepted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RequestDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loadingDialog.dismiss();
            }
        });
    }
}
