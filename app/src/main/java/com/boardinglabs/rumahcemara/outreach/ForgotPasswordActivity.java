package com.boardinglabs.rumahcemara.outreach;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.helper.API;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText email;
    LoadingDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initToolbar();

        loading = new LoadingDialog(this);

        email = findViewById(R.id.etEmail);
    }

    @OnClick(R.id.btnSendRequest)
    void populateData(){
        loading.show();
        API.baseApiService().forgotPassword(email.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                loading.dismiss();
                if (response != null && response.isSuccessful()) {
                    Intent intent = new Intent(ForgotPasswordActivity.this, RecoverPasswordActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    Toast.makeText(ForgotPasswordActivity.this, "Please check your email", Toast.LENGTH_SHORT).show();
                } else {
                    loading.dismiss();
                    Toast.makeText(ForgotPasswordActivity.this, "Email unauthorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loading.dismiss();
                Log.i("response", "Response Failed");
                Toast.makeText(ForgotPasswordActivity.this, "Email tidak ditemukan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
