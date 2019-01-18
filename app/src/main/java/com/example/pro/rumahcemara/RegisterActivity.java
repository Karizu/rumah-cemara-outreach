package com.example.pro.rumahcemara;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pro.rumahcemara.apihelper.ApiResponse;
import com.example.pro.rumahcemara.dialog.LoadingDialog;
import com.example.pro.rumahcemara.models.Group;
import com.rezkyatinnov.kyandroid.reztrofit.ErrorResponse;
import com.rezkyatinnov.kyandroid.reztrofit.RestCallback;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends Activity {

    String[] genderArray = {"male", "female"};
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
    @BindView(R.id.etGender)
    AutoCompleteTextView gender;
    @BindView(R.id.etIntitutionName)
    EditText institutionName;

    Bitmap photoImage;
    File fileImage;
    ArrayList<String> dsoId;
    Context appContext;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, genderArray);
        AutoCompleteTextView acTextView = findViewById(R.id.etGender);
        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter);

        birthDate.setKeyListener(null);
        birthDate.setOnClickListener(view -> new DatePickerDialog(RegisterActivity.this,
                date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show());

        appContext = this;
        loadingDialog = new LoadingDialog(this);
    }

    @OnClick(R.id.tvSelectPicture)
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

    @OnClick(R.id.btnSignUp)
    void onClickBtnRegister() {
        loadingDialog.setCancelable(false);
        loadingDialog.show();

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
    }

    Call post(Callback callback) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Log.d("photo", "check photo");
        File file = new File(getCacheDir(), "file.jpeg");
        if (photoImage != null)
            photoImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        Log.d("photo", "check after take foto");
        OkHttpClient client = new OkHttpClient();
        String fileName = "file.jpeg";
        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("fullname", fullname.getText().toString())
                .addFormDataPart("birth_date", birthDate.getText().toString())
                .addFormDataPart("email", email.getText().toString())
                .addFormDataPart("gender", gender.getText().toString())
                .addFormDataPart("username", username.getText().toString())
                .addFormDataPart("password", password.getText().toString())
                .addFormDataPart("picture", "photo.jpeg", RequestBody.create(MediaType.parse("image/jpeg"), stream.toByteArray()))
                .build();
        Request request = new Request.Builder()
                .url("http://37.72.172.144/rumah-cemara-api/public/api/register")
                .post(body)
                .build();

        Log.d("Response", "before response");
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    @OnClick(R.id.tvSignIn)
    void haveAccount() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            ImageView img = findViewById(R.id.imgProfile);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photoImage = (Bitmap) data.getExtras().get("data");
            photoImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            img.setImageBitmap(photoImage);
            try {
                File outputDir = getCacheDir();
                fileImage = File.createTempFile("photo", "jpeg", outputDir);
                FileOutputStream outputStream = openFileOutput("photo.jpeg", Context.MODE_PRIVATE);
                outputStream.write(stream.toByteArray());
                outputStream.close();
                Log.d("Write File", "Success");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("Write File", "Failed2");
            }
        }
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
}