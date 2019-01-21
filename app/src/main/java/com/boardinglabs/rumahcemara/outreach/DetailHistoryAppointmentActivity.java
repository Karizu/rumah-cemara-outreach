package com.boardinglabs.rumahcemara.outreach;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.apihelper.API;
import com.boardinglabs.rumahcemara.outreach.apihelper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.models.Appointment;
import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.boardinglabs.rumahcemara.outreach.models.response.AppointmentDataResponse;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class DetailHistoryAppointmentActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;
    private String id;
    int status = 4;
    String serviceId, sToken, sBearerToken;
    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history_appointment);;

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Bundle bundle = getIntent().getBundleExtra("myData");   //<< get Bundle from Intent
        serviceId = bundle.getString("serviceId");

        session = new SessionManagement(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        sToken = user.get(SessionManagement.KEY_IMG_TOKEN);
        sBearerToken = "Bearer "+sToken;

        loadingDialog = new LoadingDialog(this);

        populateData();

//        populateDataRating();
    }


    private void setId(String id){
        this.id = id;
    }

    private void populateData(){
        Bundle bundle = getIntent().getBundleExtra("myData");   //<< get Bundle from Intent

        String serviceName = bundle.getString("serviceName");
        String imgUrl = bundle.getString("imgUrl");
        String fullName = bundle.getString("fullName");
        String phoneNumber = bundle.getString("phoneNumber");
        String endDate = bundle.getString("endDate");
        String rating = bundle.getString("rating");
        String comment = bundle.getString("comment");


        TextView txtServiceName = findViewById(R.id.tvServiceName);
        CircularImageView imageViewProfile = findViewById(R.id.imgRequestDetail);
        ImageView imgClose = findViewById(R.id.imgClose);
        TextView txtEndDate = findViewById(R.id.tvDate);
        TextView txtName = findViewById(R.id.tvName);
        TextView txtPhoneNumber = findViewById(R.id.tvPhoneNumber);
        ImageView imgRating = findViewById(R.id.imgRating);
        TextView txtComment = findViewById(R.id.tvComment);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        try {
            Date date = sdf.parse(endDate);
            String formated = new SimpleDateFormat("EEEE, dd MMM yyyy").format(date);
            txtEndDate.setText(formated);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        txtServiceName.setText(serviceName+" Appointment");
        txtName.setText(fullName);
        txtPhoneNumber.setText(phoneNumber);
        txtComment.setText(comment);
        switch (rating)
        {
            case "0":
                imgRating.setImageResource(R.drawable.rating_0);
                break;
            case "1":
                imgRating.setImageResource(R.drawable.rating_1);
                break;
            case "2":
                imgRating.setImageResource(R.drawable.rating_2);
                break;
            case "3":
                imgRating.setImageResource(R.drawable.rating_3);
                break;
            case "4":
                imgRating.setImageResource(R.drawable.rating_4);
                break;
            case "5":
                imgRating.setImageResource(R.drawable.rating_5);
                break;
        }

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

    private void populateDataRating(){

        loadingDialog.setCancelable(false);
        loadingDialog.show();
        API.baseApiService().getDetailAppointment(serviceId, sBearerToken).enqueue(new Callback<ApiResponse<Appointment>>() {
            @Override
            public void onResponse(Call<ApiResponse<Appointment>> call, Response<ApiResponse<Appointment>> response) {
                System.out.println("RESPONSE:  "+response.toString() +"\n"+"BODY: "+response.body().getData() +"\n"+"RAW: "+response.raw() +"\n"+"MESSAGE: "+response.message());

                loadingDialog.dismiss();
                final ApiResponse<Appointment> appointment = response.body();
                System.out.println("JSON : "+appointment);

                loadingDialog.dismiss();
                String comment = appointment.getData().getRating().getDescription();
                String rating = appointment.getData().getRating().getRating();

                ImageView imgRating = findViewById(R.id.imgRating);
                TextView txtComment = findViewById(R.id.tvComment);

                txtComment.setText(comment);
                switch (rating)
                {
                    case "0":
                        imgRating.setImageResource(R.drawable.rating_0);
                        break;
                    case "1":
                        imgRating.setImageResource(R.drawable.rating_1);
                        break;
                    case "2":
                        imgRating.setImageResource(R.drawable.rating_2);
                        break;
                    case "3":
                        imgRating.setImageResource(R.drawable.rating_3);
                        break;
                    case "4":
                        imgRating.setImageResource(R.drawable.rating_4);
                        break;
                    case "5":
                        imgRating.setImageResource(R.drawable.rating_5);
                        break;
                }

            }

            @Override
            public void onFailure(Call<ApiResponse<Appointment>> call, Throwable t) {
                loadingDialog.dismiss();
                System.out.println("Throwable: "+t.toString()+"\n"+call.toString());
            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
