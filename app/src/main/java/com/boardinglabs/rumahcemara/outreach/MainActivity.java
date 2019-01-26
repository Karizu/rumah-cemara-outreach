package com.boardinglabs.rumahcemara.outreach;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.apihelper.BaseApiService;
import com.boardinglabs.rumahcemara.outreach.apihelper.UtilsApi;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.fragment.HomeFragment;
import com.boardinglabs.rumahcemara.outreach.fragment.MyListFragment;
import com.boardinglabs.rumahcemara.outreach.fragment.OptionsFragment;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.lang.reflect.Field;
import java.util.HashMap;

import io.reactivex.annotations.NonNull;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Toast backtoast;
    SessionManagement session;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new MyListFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    fragment = new OptionsFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        session = new SessionManagement(getApplicationContext());
        if (session.getLanguage() == 0) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main_id);
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mTextMessage = (TextView) findViewById(R.id.message);

        Intent intent = getIntent();
        if (intent.hasExtra("message")) {
            Toast.makeText(this, intent.getExtras().getString("message"), Toast.LENGTH_LONG).show();
        }
        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionManagement.KEY_NAME);
        String userId = user.get(SessionManagement.KEY_ID);
        mTextMessage.setText(("Username: " + name));

        FirebaseMessaging.getInstance().subscribeToTopic("appointment");

        String tokenIntent = intent.getStringExtra("tokenId");
        Log.d("muhtar", "token " + tokenIntent);
        Log.d("muhtar", "user id " + userId);

        if (tokenIntent != null) {
            registerToken(tokenIntent);
        }

        //session = new SessionManagement(getApplicationContext());
//        session.checkLogin();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.navigation_home); // change to whichever id should be default
        }

    }

    private void registerToken(String token) {
        SessionManagement session = new SessionManagement(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        String userId = user.get(SessionManagement.KEY_ID);
        String tokenId = user.get(SessionManagement.KEY_IMG_TOKEN);
        String bearerToken = "Bearer " + tokenId;
        BaseApiService mApiService = UtilsApi.getAPIService();
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        String type = manufacturer + " " + model;
        Field[] fields = Build.VERSION_CODES.class.getFields();
        String os = fields[Build.VERSION.SDK_INT + 1].getName();
        String version = Build.VERSION.RELEASE;
        mApiService.getUserDevice(userId, type, "Android", version, os,
                token, bearerToken)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("muhtar", response.message());
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("muhtar", t.getLocalizedMessage());
                    }
                });
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if(backtoast!=null&&backtoast.getView().getWindowToken()!=null) {
                System.exit(1);

            } else {
                backtoast = Toast.makeText(this, "Press back to exit", Toast.LENGTH_SHORT);
                backtoast.show();
            }
        } else {
            //other stuff...
            System.exit(1);
        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            finishAffinity();
//        }
    }
}
