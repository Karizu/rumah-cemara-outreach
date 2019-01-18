package com.example.pro.rumahcemara.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro.rumahcemara.EditAccountActivity;
import com.example.pro.rumahcemara.R;
import com.example.pro.rumahcemara.apihelper.API;
import com.example.pro.rumahcemara.apihelper.ApiResponse;
import com.example.pro.rumahcemara.apihelper.MemberHelper;
import com.example.pro.rumahcemara.config.SessionManagement;
import com.example.pro.rumahcemara.dialog.LoadingDialog;
import com.example.pro.rumahcemara.models.GeneralDataProfile;
import com.example.pro.rumahcemara.models.Profile;
import com.example.pro.rumahcemara.models.User;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.rezkyatinnov.kyandroid.localdata.LocalData;
import com.rezkyatinnov.kyandroid.reztrofit.ErrorResponse;
import com.rezkyatinnov.kyandroid.reztrofit.RestCallback;
import com.rezkyatinnov.kyandroid.session.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class OptionsFragment extends Fragment {

    TextView logout;
    SessionManagement session;
    Intent intent;

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


    private LoadingDialog loadingDialog;
    private String userId;
    private String imgUrl;
    private String fullName;
    private String userName;
    private String phoneNumber;
    private String tokenId;
    private String sBearerToken;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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

        editAccount.setOnClickListener(v -> {
            updateDetail();
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
                Log.e(TAG, t.toString());
                Toast.makeText(getActivity(), "Error loading!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
