package com.boardinglabs.rumahcemara.outreach.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;

import com.boardinglabs.rumahcemara.outreach.R;
import com.victor.loading.rotate.RotateLoading;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoadingDialog extends Dialog implements android.view.View.OnClickListener {

    private Context context;

    @BindView(R.id.rotate_loading)
    RotateLoading rotateLoading;

    public LoadingDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);
        ButterKnife.bind(this);
        rotateLoading.start();
    }

    @Override
    public void onClick(View view) {

    }
}