package com.boardinglabs.rumahcemara.outreach;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.helper.BaseApiService;
import com.boardinglabs.rumahcemara.outreach.helper.UtilsApi;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;
    TextView tvSignUp;
    TextView tvForgotPass;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;

    Intent intent;
    SessionManagement session;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponents();

    }

    private void initComponents() {

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);
        tvForgotPass = findViewById(R.id.tvForgotPassword);

        intent = getIntent();
        if (intent.hasExtra("username"))
            etUsername.setText(intent.getExtras().getString("username"));
        if (intent.hasExtra("password"))
            etPassword.setText(intent.getExtras().getString("password"));
        if (intent.hasExtra("message"))
            Toast.makeText(mContext, intent.getExtras().getString("message"), Toast.LENGTH_LONG).show();

        btnLogin.setOnClickListener(v -> {
            loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
            requestLogin();
        });

        tvSignUp.setOnClickListener(v -> startActivity(new Intent(mContext, RegisterActivity.class)));

        tvForgotPass.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

    }

    private void requestLogin(){
        mApiService.loginRequest(etUsername.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("status").equals("true")){
                                    String nama = jsonRESULTS.getJSONObject("data").getString("username");
                                    id = jsonRESULTS.getJSONObject("data").getString("id");
                                    String group_id = jsonRESULTS.getJSONObject("data").getString("group_id");
                                    String fullname = jsonRESULTS.getJSONObject("data").getJSONObject("profile").getString("fullname");
                                    String phonenumber = jsonRESULTS.getJSONObject("data").getJSONObject("profile").getString("phone_number");
                                    String picture = jsonRESULTS.getJSONObject("data").getJSONObject("profile").getString("picture");
                                    String token = jsonRESULTS.getString("token");
                                    String user_token = FirebaseInstanceId.getInstance().getToken();
                                    session.createLoginSession(nama, fullname, id, phonenumber, picture, token, group_id);
                                    Intent intent = new Intent(mContext, MainActivity.class);
                                    intent.putExtra("result_nama", nama);
                                    intent.putExtra("tokenId", user_token);
                                    intent.putExtra("token", "token");
                                    startActivity(intent);
                                } else {
                                    String error_message = jsonRESULTS.getString("error");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                            Toast.makeText(mContext, "We cant find an account with this credentials. Please make sure you entered the right information", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
    }
}