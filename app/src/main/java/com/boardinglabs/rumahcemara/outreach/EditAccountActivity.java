package com.boardinglabs.rumahcemara.outreach;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.apihelper.API;
import com.boardinglabs.rumahcemara.outreach.apihelper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.apihelper.BaseApiService;
import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.models.MemberProfile;
import com.boardinglabs.rumahcemara.outreach.models.Profile;
import com.boardinglabs.rumahcemara.outreach.models.User;
import com.boardinglabs.rumahcemara.outreach.models.response.MemberDataResponse;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditAccountActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 1;

    @BindView(R.id.etEditName)
    EditText etFullname;
    @BindView(R.id.etEditPhoneNumber)
    EditText etPhoneNumber;
    @BindView(R.id.etEditUsername)
    EditText etUser;
    @BindView(R.id.imgEditProfile)
    CircularImageView etImgProfile;
    @BindView(R.id.tvChangePhoto)
    TextView tvChangePhoto;

    private Realm realmDB;
    private List<String> mInterest;
    private List<String> mSelectedInterest;
    private Bitmap photoImage;
    private File fileImage;
    private final static String TAG = EditAccountActivity.class.getSimpleName();
    private LoadingDialog loadingDialog;

    Toolbar toolbar;
    ByteArrayOutputStream stream;
    FileOutputStream outputStream;
    ProgressBar progressBar;
    BaseApiService mApiService;
    String sId, sTokenId, sBearerToken, sUser, sFullname, sImgURL, sPhonenumber, sEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initToolbar();

        Intent iGet = getIntent();
        sId = iGet.getStringExtra("userId");
        sTokenId = iGet.getStringExtra("tokenId");
        sBearerToken = "Bearer " + sTokenId;
        System.out.println("ID: " + sId + " TOKEN: " + sTokenId);

        loadingDialog = new LoadingDialog(this);

        getProfileDetail();

    }

    @OnClick(R.id.tvChangePhoto)
    void onClickChangeProfilePhoto() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            ImageView img = findViewById(R.id.imgEditProfile);
            stream = new ByteArrayOutputStream();
            photoImage = (Bitmap) data.getExtras().get("data");
            photoImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            img.setImageBitmap(photoImage);
            try {
                File outputDir = getCacheDir();
                fileImage = File.createTempFile("photo", "jpeg", outputDir);
                outputStream = openFileOutput("photo.jpeg", Context.MODE_PRIVATE);
                outputStream.write(stream.toByteArray());
                outputStream.close();
                Log.d("Write File", "Success");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("Write File", "Failed2");
            }
        }
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }

    private void getProfileDetail() {
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        API.baseApiService().getProfileDetail(sId, sBearerToken).enqueue(new Callback<ApiResponse<GeneralDataProfile>>() {
            @Override
            public void onResponse(Call<ApiResponse<GeneralDataProfile>> call, Response<ApiResponse<GeneralDataProfile>> response) {

                loadingDialog.dismiss();
                final ApiResponse<GeneralDataProfile> user = response.body();
                System.out.println("JSON: " + user);
                sFullname = user.getData().getProfile().getFullname();
                sPhonenumber = user.getData().getProfile().getPhoneNumber();
                sUser = user.getData().getUsername();
                sImgURL = user.getData().getProfile().getPicture();
                sEmail = user.getData().getProfile().getEmail();
//
                etUser.setText(sUser);
                etFullname.setText(sFullname);
                if (sPhonenumber == null || sPhonenumber.equals("null")) {
                    etPhoneNumber.setText(" - ");
                } else {
                    etPhoneNumber.setText(sPhonenumber);
                }
                if (sImgURL != null)
                    Glide.with(getApplicationContext()).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_person_signup)).load(sImgURL).into(etImgProfile);

            }

            @Override
            public void onFailure(Call<ApiResponse<GeneralDataProfile>> call, Throwable t) {
                loadingDialog.dismiss();
                Log.e(TAG, t.toString());
                Toast.makeText(getApplicationContext(), "Error loading!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btnEditSave)
    void updateProfile() {

        loadingDialog.setCancelable(false);
        loadingDialog.show();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        File file = new File(getCacheDir(), "file.jpeg");
        RequestBody requestBody;
        String fullname = etFullname.getText().toString();
        String phone_number = etPhoneNumber.getText().toString();

//        if (photoImage != null) {

            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("picture", file.getName(), reqFile);
            RequestBody named = RequestBody.create(MediaType.parse("text/plain"), "picture");

            RequestBody name = RequestBody.create(MediaType.parse("fullname"), etFullname.getText().toString());
            RequestBody phone = RequestBody.create(MediaType.parse("phone_number"), etPhoneNumber.getText().toString());

            HashMap<String,RequestBody> map = new HashMap<>();
            map.put("name",name);
            map.put("phone",phone);
//            photoImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            requestBody = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("fullname", etFullname.getText().toString())
//                    .addFormDataPart("phone_number", etPhoneNumber.getText().toString())
//                    .addFormDataPart("email", sEmail)
//                    .addFormDataPart("picture", "photo.jpeg", RequestBody.create(MediaType.parse("image/jpeg"), stream.toByteArray()))
//                    .build();
//        } else {
//            RequestBody name = RequestBody.create(MediaType.parse("fullname"), etFullname.getText().toString());
//            RequestBody phone = RequestBody.create(MediaType.parse("phone_number"), etPhoneNumber.getText().toString());
//
//            HashMap<String,RequestBody> map = new HashMap<>();
//            map.put("name",name);
//            map.put("phone",phone);
//            requestBody = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("fullname", etFullname.getText().toString())
//                    .addFormDataPart("phone_number", etPhoneNumber.getText().toString())
//                    .addFormDataPart("email", sEmail)
//                    .build();
//        }

        API.baseApiService().updateWorker(fullname, phone_number, sBearerToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE:  " + response.toString() + "\n" + "BODY: " + response.body() + "\n" + "RAW: " + response.raw() + "\n" + "MESSAGE: " + response.message());
                loadingDialog.dismiss();
                Intent intent = new Intent(EditAccountActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("message", "Successfully Updated");
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loadingDialog.dismiss();
            }
        });

    }

//    okhttp3.Call post(okhttp3.Callback callback) {
//        OkHttpClient client = new OkHttpClient();
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        File file = new File(getCacheDir(), "file.jpeg");
//        RequestBody requestBody;
//
//        if (photoImage != null) {
//            photoImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            requestBody = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("fullname", etFullname.getText().toString())
//                    .addFormDataPart("phone_number", etPhoneNumber.getText().toString())
//                    .addFormDataPart("picture", "photo.jpeg", RequestBody.create(MediaType.parse("image/jpeg"), stream.toByteArray()))
//                    .build();
//        } else {
//            requestBody = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("fullname", etFullname.getText().toString())
//                    .addFormDataPart("phone_number", etPhoneNumber.getText().toString())
//                    .build();
//        }
//        Request request = new Request.Builder()
//                .url("http://37.72.172.144/rumah-cemara-api/public/api/profile")
//                .header("Authorization", sBearerToken)
//                .put(requestBody)
//                .build();
////
//        Log.d("Response", "before response");
//        okhttp3.Call call = client.newCall(request);
//        call.enqueue(callback);
//        return call;
//    }
//
//    @OnClick(R.id.btnEditSave)
//    void updateProfile() {
//        loadingDialog.setCancelable(false);
//        loadingDialog.show();
//        post(new okhttp3.Callback() {
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) {
//                System.out.println("RESPONSE:  " + response.toString() + "\n" + "BODY: " + response.body() + "\n" + "RAW: " + response.headers() + "\n" + "MESSAGE: " + response.message());
//                loadingDialog.dismiss();
//                Intent intent = new Intent(EditAccountActivity.this, MainActivity.class);
//                intent.putExtra("message", "Successfully Updated");
//                startActivity(intent);
//            }
//
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//                loadingDialog.dismiss();
//            }
//        });
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
