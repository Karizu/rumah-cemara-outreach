package com.boardinglabs.rumahcemara.outreach.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
import com.boardinglabs.rumahcemara.outreach.apihelper.API;
import com.boardinglabs.rumahcemara.outreach.apihelper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    private String userId;
    private String imgUrl;
    private String fullName;
    private String userName;
    private String phoneNumber;
    private String tokenId;
    private String sBearerToken;
    private boolean isShow = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_options, container, false);

        ButterKnife.bind(this, view);

        session = new SessionManagement(getActivity());
        HashMap<String, String> user = session.getUserDetails();
        userId = user.get(SessionManagement.KEY_ID);
        tokenId = user.get(SessionManagement.KEY_IMG_TOKEN);
        sBearerToken = "Bearer " + tokenId;

        loadingDialog = new LoadingDialog(getActivity());

        getProfileDetail();

        logout = view.findViewById(R.id.tvSignOut);
        logout.setOnClickListener(v -> session.logoutUser());

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
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        API.baseApiService().getProfileDetail(userId, sBearerToken).enqueue(new Callback<ApiResponse<GeneralDataProfile>>() {
            @Override
            public void onResponse(Call<ApiResponse<GeneralDataProfile>> call, Response<ApiResponse<GeneralDataProfile>> response) {

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
                    Glide.with(getActivity()).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_person_signup)).load(imgUrl).into(imageProfile);

            }

            @Override
            public void onFailure(Call<ApiResponse<GeneralDataProfile>> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(getActivity(), "Error loading!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
