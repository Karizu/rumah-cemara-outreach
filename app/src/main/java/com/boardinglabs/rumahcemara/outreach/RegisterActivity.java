package com.boardinglabs.rumahcemara.outreach;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.helper.API;
import com.boardinglabs.rumahcemara.outreach.helper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.models.Group;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class RegisterActivity extends Activity implements AdapterView.OnItemSelectedListener {

    String[] genderArray = {"male", "female"};
    private final int REQEUST_CAMERA = 1, REQUEST_GALLERY = 2;
    private static final int CAMERA_REQUEST_CODE = 1;
    @BindView(R.id.etName)
    EditText fullname;
    @BindView(R.id.etBirthDay)
    EditText birthDate;
    //    @BindView(R.id.re_phone_number)
//    EditText phoneNumber;
    @BindView(R.id.etEmail)
    EditText email;
    //    @BindView(R.id.re_dso)
//    Spinner dso;
    @BindView(R.id.etUsername)
    EditText username;
    @BindView(R.id.etPassword)
    EditText password;
    @BindView(R.id.spinnerGender)
    Spinner sGender;
    @BindView(R.id.imgProfile)
    ImageView etImgProfile;
    @BindView(R.id.spinnerInstitution)
    Spinner institutionName;
    Boolean validate = false;

    Bitmap bitmap;
    File fileImage;
    ArrayList<String> listValue;
    Context appContext;
    String selectedName, valueName;
    int TAG_CODE_PERMISSION_LOCATION;

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = (datePicker, i, i1, i2) -> {
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);
            updateLabel(calendar);
        };

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("fuck", "need permissions....");
            ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,},
                    TAG_CODE_PERMISSION_LOCATION);
        }

        ActivityCompat.requestPermissions(RegisterActivity.this,
                new String[]{Manifest.permission.CAMERA}, 1);

        birthDate.setKeyListener(null);
        birthDate.setOnClickListener(view -> new DatePickerDialog(RegisterActivity.this,
                date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show());

        appContext = this;
        loadingDialog = new LoadingDialog(this);

        sGender.setOnItemSelectedListener(this);

        settingGenderSpinner();
        initSpinnerDosen();
        institutionName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedName = parent.getItemAtPosition(position).toString();
                valueName = listValue.get(position);
//                requestDetailDosen(selectedName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
                    Toast.makeText(RegisterActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            // add other cases for more permissions
        }
    }

    private void initSpinnerDosen() {
        Log.d("Masuk initSpinner", " ");
        API.baseApiService().getGroup().enqueue(new retrofit2.Callback<ApiResponse<List<Group>>>() {
            @Override
            public void onResponse(retrofit2.Call<ApiResponse<List<Group>>> call, retrofit2.Response<ApiResponse<List<Group>>> response) {
                if (response.isSuccessful()) {
                    List<Group> dataInstitution = response.body().getData();
                    Log.d("Masuk response Sukses", dataInstitution.toString());
                    listValue = new ArrayList<String>();
                    ArrayList<String> listLabel = new ArrayList<String>();
                    for (int i = 0; i < dataInstitution.size(); i++) {
                        listValue.add(dataInstitution.get(i).getId());
                        listLabel.add(dataInstitution.get(i).getName());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(appContext,
                            android.R.layout.simple_spinner_item, listLabel);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    institutionName.setAdapter(adapter);
                } else {
                    Toast.makeText(appContext, "Connecting Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ApiResponse<List<Group>>> call, Throwable t) {
                Log.d("Masuk response gagal ", t.getMessage());
            }
        });

    }

    private void validateField() {

            if (fullname.getText().toString().length() == 0) {
                fullname.setError("Name is required!");
            }
            if (username.getText().toString().length() == 0) {
                username.setError("Username is required!");
            }
            if (email.getText().toString().length() == 0) {
                email.setError("Email is required!");
            }
            if (!email.getText().toString().contains("@")) {
                email.setError("Email format is wrong!");
            }
            if (password.getText().toString().length() == 0) {
                password.setError("Password is required!");
            }
    }

    @OnClick(R.id.tvSelectPicture)
    void onClickChangeProfilePhoto() {
        changephoto();
    }

    @OnClick(R.id.btnSignUp)
    void onClickBtnRegister() {
        validateField();
        loadingDialog.setCancelable(false);
        loadingDialog.show();

        if (username.getText().toString().length() > 2 && email.getText().toString().contains("@") && password.getText().toString().length() > 2) {
            post(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    loadingDialog.dismiss();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    loadingDialog.dismiss();
                    if (response.isSuccessful()) {
                        Log.d("Response", "Response successful");
                        Log.d("Body", response.body().string());
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.putExtra("username", username.getText().toString());
                        intent.putExtra("password", password.getText().toString());
                        intent.putExtra("message", "Thanks for signing up! Please wait for verification by administrator.");
                        startActivity(intent);
                        finish();
                    } else {
                        runOnUiThread(() -> Toast.makeText(appContext, "Username has already been taken.", Toast.LENGTH_SHORT).show());
                        Log.d("Response Failed", response.message());
                        Log.d("Body", response.body().string());
                    }
                }
            });
        } else {
            loadingDialog.dismiss();
        }
    }

    Call post(Callback callback) {
        if (fileImage != null) {
            Log.d("photo", "check photo");
            File file = new File(getCacheDir(), "file.jpeg");
            bitmap = BitmapFactory.decodeFile(fileImage.getAbsolutePath());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
            Log.d("photo", "check after take foto");
            OkHttpClient client = new OkHttpClient();
            String fileName = "file.jpeg";
            RequestBody body = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("fullname", fullname.getText().toString())
                    .addFormDataPart("birth_date", birthDate.getText().toString())
                    .addFormDataPart("email", email.getText().toString())
                    .addFormDataPart("gender", sGender.getSelectedItem().toString())
                    .addFormDataPart("username", username.getText().toString())
                    .addFormDataPart("password", password.getText().toString())
                    .addFormDataPart("picture", "photo.jpeg", RequestBody.create(MediaType.parse("image/jpeg"), byteArrayOutputStream.toByteArray()))
                    .addFormDataPart("group_id", valueName)
                    .addFormDataPart("type", "worker")
                    .build();
            Request request = new Request.Builder()
//                    .url("http://37.72.172.144/rumah-cemara-api/public/api/register")
                    .url("http://68.183.226.23/rumah-cemara-api/public/api/register")
                    .post(body)
                    .build();

            Log.d("Response", "before response");
            Call call = client.newCall(request);
            call.enqueue(callback);
            return call;
        } else {
            Log.d("photo", "check after take foto");
            OkHttpClient client = new OkHttpClient();
            String fileName = "file.jpeg";
            RequestBody body = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("fullname", fullname.getText().toString())
                    .addFormDataPart("birth_date", birthDate.getText().toString())
                    .addFormDataPart("email", email.getText().toString())
                    .addFormDataPart("gender", sGender.getSelectedItem().toString())
                    .addFormDataPart("username", username.getText().toString())
                    .addFormDataPart("password", password.getText().toString())
                    .addFormDataPart("group_id", valueName)
                    .addFormDataPart("type", "worker")
                    .build();
            Request request = new Request.Builder()
//                    .url("http://37.72.172.144/rumah-cemara-api/public/api/register")
                    .url("http://68.183.226.23/rumah-cemara-api/public/api/register")
                    .post(body)
                    .build();

            Log.d("Response", "before response");
            Call call = client.newCall(request);
            call.enqueue(callback);
            return call;
        }
    }

    @OnClick(R.id.tvSignIn)
    void haveAccount() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
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

    private void settingGenderSpinner() {
        // Spinner Drop down elements
        List<String> gender = new ArrayList<String>();
        gender.add("male");
        gender.add("female");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_text, gender);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sGender.setAdapter(dataAdapter);
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
                Glide.with(appContext)
                        .load(imageFile)
                        .apply(RequestOptions.circleCropTransform())
                        .into(etImgProfile);
                fileImage = imageFile;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void updateLabel(Calendar calendar) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);

        birthDate.setText(simpleDateFormat.format(calendar.getTime()));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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

                int MY_PERMISSIONS_REQUEST_CAMERA = 100;
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