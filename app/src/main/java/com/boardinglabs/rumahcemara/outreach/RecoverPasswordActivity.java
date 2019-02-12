package com.boardinglabs.rumahcemara.outreach;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.helper.API;
import com.boardinglabs.rumahcemara.outreach.helper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecoverPasswordActivity extends AppCompatActivity {

    private Context mContext;

    @BindView(R.id.emailTextInputEditText)
    TextInputEditText email;

    @BindView(R.id.numberTextInputEditText)
    TextInputEditText number;

    @BindView(R.id.passwordTextInputEditText)
    TextInputEditText newPassword;

    LoadingDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mContext = this;
        dialog = new LoadingDialog(this);
    }

    @OnClick(R.id.recover_btn)
    public void doRecover() {
        dialog.show();
        API.baseApiService().postRecoverPassword(email.getText().toString(), number.getText().toString(),
                newPassword.getText().toString()).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                dialog.dismiss();
                Toast.makeText(mContext, "Recover Password Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }
}