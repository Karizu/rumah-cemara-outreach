package com.boardinglabs.rumahcemara.outreach;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.apihelper.API;
import com.boardinglabs.rumahcemara.outreach.apihelper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.apihelper.BaseApiService;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditAccountActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 1;
    private final int REQEUST_CAMERA = 1, REQUEST_GALLERY = 2;
    private final int MY_PERMISSIONS_REQUEST_CAMERA = 100;

    @BindView(R.id.etEditName)
    EditText etFullname;
    @BindView(R.id.etEditPhoneNumber)
    EditText etPhoneNumber;
    @BindView(R.id.etEditUsername)
    EditText etUser;
    @BindView(R.id.imgEditProfile)
    ImageView etImgProfile;
    @BindView(R.id.tvChangePhoto)
    TextView tvChangePhoto;

    private Realm realmDB;
    private List<String> mInterest;
    private List<String> mSelectedInterest;
    private Bitmap photoImage;
    private File fileImage;
    private final static String TAG = EditAccountActivity.class.getSimpleName();
    private LoadingDialog loadingDialog;
    Boolean validate = false;

    Context mContext;
    Toolbar toolbar;
    ByteArrayOutputStream stream;
    FileOutputStream outputStream;
    ProgressBar progressBar;
    BaseApiService mApiService;
    String sId, sTokenId, sBearerToken, sUser, sFullname, sImgURL, sPhonenumber, sEmail;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        ButterKnife.bind(this);
        mContext = this;

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initToolbar();

        ActivityCompat.requestPermissions(EditAccountActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

        Intent iGet = getIntent();
        sId = iGet.getStringExtra("userId");
        sTokenId = iGet.getStringExtra("tokenId");
        sBearerToken = "Bearer " + sTokenId;
        System.out.println("ID: " + sId + " TOKEN: " + sTokenId);

        loadingDialog = new LoadingDialog(this);

        getProfileDetail();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted and now can proceed

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(EditAccountActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            // add other cases for more permissions
        }
    }

    @OnClick(R.id.tvChangePhoto)
    void onClickChangeProfilePhoto() {
        changephoto();
    }

    private void changephoto() {
        final CharSequence[] options = {"Take Photo", "Choose From Gallery", "Cancel"};
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("Select Option");
        builder.setItems(options, (dialog, item) -> {
            if (options[item].equals("Take Photo")) {
                EasyImage.openCamera(this, REQEUST_CAMERA);
            } else if (options[item].equals("Choose From Gallery")) {
                EasyImage.openGallery(this, REQUEST_GALLERY);
            } else if (options[item].equals("Cancel")) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                Glide.with(mContext)
                        .load(imageFile)
                        .apply(RequestOptions.circleCropTransform())
                        .into(etImgProfile);
                fileImage = imageFile;
            }
        });

//        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
//            ImageView img = findViewById(R.id.imgEditProfile);
//            stream = new ByteArrayOutputStream();
//            photoImage = (Bitmap) data.getExtras().get("data");
//            photoImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            img.setImageBitmap(photoImage);
//            try {
//                File outputDir = getCacheDir();
//                fileImage = File.createTempFile("photo", "jpeg", outputDir);
//                outputStream = openFileOutput("photo.jpeg", Context.MODE_PRIVATE);
//                outputStream.write(stream.toByteArray());
//                outputStream.close();
//                Log.d("Write File", "Success");
//            } catch (IOException e) {
//                e.printStackTrace();
//                Log.d("Write File", "Failed2");
//            }
//        }
    }

//


    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }

    private void validateField() {

        if (etFullname.getText().toString().length() == 0) {
            etFullname.setError("Name is required!");
        }
        if (etPhoneNumber.getText().toString().length() == 0) {
            etPhoneNumber.setError("Username is required!");
        }

        loadingDialog.dismiss();
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
                    Glide.with(mContext)
                            .load(sImgURL)
                            .apply(RequestOptions.circleCropTransform())
                            .into(etImgProfile);
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
        validateField();

        if (etFullname.getText().toString().length() > 1) {
            String fullname = etFullname.getText().toString();
            String phone_number = etPhoneNumber.getText().toString();
            RequestBody requestBody;
            try {
                if (fileImage != null) {
                    Bitmap bitmap = BitmapFactory.decodeFile(fileImage.getAbsolutePath());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
                    RequestBody reqFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArrayOutputStream.toByteArray());
                    MultipartBody.Part body =
                            MultipartBody.Part.createFormData("picture", fileImage.getName(), reqFile);
                    RequestBody fullName =
                            RequestBody.create(
                                    okhttp3.MultipartBody.FORM, fullname);
                    RequestBody phoneNumber =
                            RequestBody.create(
                                    okhttp3.MultipartBody.FORM, phone_number);
                    RequestBody method =
                            RequestBody.create(
                                    okhttp3.MultipartBody.FORM, "PUT");
                    requestBody = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("_method", "PUT")
                            .addFormDataPart("fullname", fullname)
                            .addFormDataPart("phone_number", phone_number)
                            .addFormDataPart("picture", "photo.jpeg", RequestBody.create(MediaType.parse("image/jpeg"), byteArrayOutputStream.toByteArray()))
                            .build();

                    API.baseApiService().updateProfileData(requestBody, sBearerToken).enqueue(new Callback<ApiResponse>() {
                        @Override
                        public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                            System.out.println("RESPONSE:  " + response.toString() + "\n" + "BODY: " + response.body() + "\n" + "RAW: " + response.raw() + "\n" + "MESSAGE: " + response.message());
                            loadingDialog.dismiss();
                            Intent intent = new Intent(EditAccountActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("message", "Successfully Updated");
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<ApiResponse> call, Throwable t) {
                            loadingDialog.dismiss();
                            t.printStackTrace();
                            Log.e("IO", "IO" + t);
                        }
                    });
                } else {
                    API.baseApiService().updateWorker(fullname, phone_number, sBearerToken).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            System.out.println("RESPONSE:  " + response.toString() + "\n" + "BODY: " + response.body() + "\n" + "RAW: " + response.raw() + "\n" + "MESSAGE: " + response.message());
                            loadingDialog.dismiss();
                            Intent intent = new Intent(EditAccountActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("message", "Successfully Updated");
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            loadingDialog.dismiss();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("IO", "IO" + e);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkPermissionGrant();
    }

    private void checkPermissionGrant() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }
}
