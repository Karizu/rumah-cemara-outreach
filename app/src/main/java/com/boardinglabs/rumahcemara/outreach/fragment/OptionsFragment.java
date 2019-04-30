package com.boardinglabs.rumahcemara.outreach.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.EditAccountActivity;
import com.boardinglabs.rumahcemara.outreach.MainActivity;
import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.helper.API;
import com.boardinglabs.rumahcemara.outreach.helper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.boardinglabs.rumahcemara.outreach.models.UserDevice;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.HashMap;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OptionsFragment extends Fragment {
    TextView logout;
    TextView notif;
    TextView langeuage;
    CardView bahasa;
    CardView english;
    SessionManagement session;
    Switch switchNotif;

    @BindView(R.id.imgProfile)
    CircularImageView imageProfile;
    @BindView(R.id.tvEdit)
    TextView editAccount;
    @BindView(R.id.tvPhoneNumber)
    TextView prNoHp;
    @BindView(R.id.tvName)
    TextView prFullname;
    @BindView(R.id.tvUsername)
    TextView prUsername;
    @BindView(R.id.tvSignOut)
    TextView prSignOut;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private LoadingDialog loadingDialog;
    private String userId, deviceId;
    private String imgUrl;
    private String fullName;
    private String userName;
    private String phoneNumber;
    private String tokenId;
    private String sBearerToken;
    private boolean isShow = false;
    private Context activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint({"NewApi", "SetTextI18n"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_options, container, false);

        ButterKnife.bind(this, view);
        activity = getActivity();

        session = new SessionManagement(getActivity());
        HashMap<String, String> user = session.getUserDetails();
        HashMap<String, String> userDevice = session.getUserDevice();
        deviceId = userDevice.get(SessionManagement.KEY_ID_DEVICE);
        userId = user.get(SessionManagement.KEY_ID);
        tokenId = user.get(SessionManagement.KEY_IMG_TOKEN);
        sBearerToken = "Bearer " + tokenId;

        loadingDialog = new LoadingDialog(Objects.requireNonNull(getActivity()));

        getProfileDetail();

        logout = view.findViewById(R.id.tvSignOut);
        logout.setOnClickListener(v -> {
            removeUserDevice(deviceId);
            updateStatus();
            session.logoutUser();
        });

        langeuage = view.findViewById(R.id.tvLanguage);
        bahasa = view.findViewById(R.id.cvIndo);
        english = view.findViewById(R.id.cvEnglish);
        notif = view.findViewById(R.id.tvNotification);
        switchNotif = view.findViewById(R.id.swicthNotif);

        bahasa.setVisibility(View.GONE);
        english.setVisibility(View.GONE);

        langeuage.setOnClickListener(v -> {
            isShow = !isShow;
            if (isShow) {
                bahasa.setVisibility(View.VISIBLE);
                english.setVisibility(View.VISIBLE);
            } else {
                bahasa.setVisibility(View.GONE);
                english.setVisibility(View.GONE);
            }
        });

        english.setOnClickListener(v -> {
            session.setLanguage(0);
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
        bahasa.setOnClickListener(v -> {
            session.setLanguage(1);
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });

        editAccount.setOnClickListener(v -> updateDetail());

        if (session.getLanguage() == 0) {
            mToolbar.setTitle("Options");
            langeuage.setText("Language");
            logout.setText("Sign Out");
            notif.setText("Notification");
        } else {
            mToolbar.setTitle("Pengaturan");
            langeuage.setText("Bahasa");
            logout.setText("Keluar");
            notif.setText("Pemberitahuan");
        }

        Log.d("OptionsFragment", "Status notifikasi " + session.getNotification());


        if (session.getNotification() == 0) {
            switchNotif.setChecked(false);
        } else if (session.getNotification() == 1) {
            switchNotif.setChecked(true);
        } else {
            switchNotif.setChecked(true);
        }

        switchNotif.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                session.setNotification(1);
            } else {
                session.setNotification(0);
            }
        });


        return view;
    }

    public void updateDetail() {
        Intent intent = new Intent(getActivity(), EditAccountActivity.class);
        intent.putExtra("userId", userId);
        intent.putExtra("tokenId", tokenId);
        intent.putExtra("fullName", fullName);
        intent.putExtra("userName", userName);
        intent.putExtra("phoneNumber", phoneNumber);
        intent.putExtra("imgURL", imgUrl);
        startActivity(intent);
    }

    private void getProfileDetail() {
        loadingDialog.show();
        API.baseApiService().getProfileDetail(userId, sBearerToken).enqueue(new Callback<ApiResponse<GeneralDataProfile>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<GeneralDataProfile>> call, @NonNull Response<ApiResponse<GeneralDataProfile>> response) {

                if (response.body() != null){
                    loadingDialog.dismiss();
                    final ApiResponse<GeneralDataProfile> user = response.body();
                    System.out.println("JSON: " + user);
                    fullName = user.getData().getProfile().getFullname();
                    phoneNumber = user.getData().getProfile().getPhoneNumber();
                    userName = user.getData().getUsername();
                    imgUrl = user.getData().getProfile().getPicture();
//
                    prUsername.setText(userName);
                    prFullname.setText(fullName);
                    if (phoneNumber == null || phoneNumber.equals("null")) {
                        prNoHp.setText(" - ");
                    } else {
                        prNoHp.setText(phoneNumber);
                    }
                    if (imgUrl != null)
                        Glide.with(Objects.requireNonNull(getActivity())).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_person_signup)).load(imgUrl).into(imageProfile);
                } else {
                    Toast.makeText(activity, "Tidak dapat terhubung", Toast.LENGTH_SHORT).show();
                    loadingDialog.dismiss();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<GeneralDataProfile>> call, @NonNull Throwable t) {
                loadingDialog.dismiss();
//                Toast.makeText(getActivity(), "Error loading!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateStatus(){
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        RequestBody requestBody;
        requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("_method", "PUT")
                .addFormDataPart("status_online", "0")
                .build();

        API.baseApiService().updateStatusWorker(userId, requestBody, "Bearer "+tokenId).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
//                Log.d("Log Response", "RESPONSE:  " + response.toString() + "\n" + "BODY: " + response.body() + "\n" + "RAW: " + response.raw() + "\n" + "MESSAGE: " + response.message());
                loadingDialog.dismiss();
//                Toast.makeText(getActivity(), "Your Status is Changed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable t) {
                loadingDialog.dismiss();
                Log.d("onFailed", t.getMessage());
            }
        });
    }

    private void removeUserDevice(String userDeviceId){
        API.baseApiService().removeUserDevice(userDeviceId, sBearerToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                Log.d("removeUserDevice", response.toString());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }
}
