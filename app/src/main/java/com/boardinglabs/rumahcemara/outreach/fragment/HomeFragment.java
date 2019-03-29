package com.boardinglabs.rumahcemara.outreach.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.helper.API;
import com.boardinglabs.rumahcemara.outreach.helper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.fragment.tabfragment.DashboardTabFragment;
import com.boardinglabs.rumahcemara.outreach.fragment.tabfragment.RequestTabFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements LocationListener {
    private int languageId;
    private LoadingDialog loadingDialog;
    String sId, tokenBearer, sIdLocation;
    Switch aSwitchOn;
    int TAG_CODE_PERMISSION_LOCATION;
    private LocationManager locationManager;
    Double latitude, longitude;
    int status;
    TextView setLatitude, setLongitude;
    SessionManagement session;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        SessionManagement sessionManagement = new SessionManagement(getActivity());
        session = new SessionManagement(getActivity());
        languageId = sessionManagement.getLanguage();
        HashMap<String, String> user = sessionManagement.getUserDetails();
        sId = user.get(SessionManagement.KEY_ID);
        tokenBearer = user.get(SessionManagement.KEY_IMG_TOKEN);
        setLatitude = view.findViewById(R.id.tvLatitude);
        setLongitude = view.findViewById(R.id.tvLongitude);
        loadingDialog = new LoadingDialog(Objects.requireNonNull(getActivity()));

        ViewPager viewPager = view.findViewById(R.id.container);
        setupViewPager(viewPager);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("fuck", "need permissions....");
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,},
                    TAG_CODE_PERMISSION_LOCATION);
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(getActivity(), location -> {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        // Logic to handle location object
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                        setLatitude.setText(String.valueOf(latitude));
                        setLongitude.setText(String.valueOf(longitude));
                    }
                });

//        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
//        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        getDetailLocation();

        aSwitchOn = view.findViewById(R.id.switchOn);

        if (session.getStatusOnline() ==  0){
            aSwitchOn.setChecked(false);
        } else if (session.getStatusOnline() == 1){
            aSwitchOn.setChecked(true);
        } else {
            aSwitchOn.setChecked(true);
        }

        aSwitchOn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                session.setStatusOnline(1);
                Log.d("Karizu", "getDetailLocation");
                if (latitude != null){
                    if (!sIdLocation.equals(" ")){
                        status = 1;
                        updateLocation();
                        updateStatus();
                        Log.d("Karizu", "updateLocation");
                    } else {
                        status = 1;
                        createLocation();
                        updateStatus();
                        Log.d("Karizu", "createLocation");
                    }
                } else {
                    aSwitchOn.setChecked(false);
                    Toast.makeText(getActivity(), "Harap tunggu, sedang mencari lokasi anda.", Toast.LENGTH_SHORT).show();
                }
            } else {
                status = 0;
                session.setStatusOnline(0);
                updateStatus();
            }
        });

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());

        if (languageId == 0) {
            adapter.addFragment(new RequestTabFragment(), "Request");
            adapter.addFragment(new DashboardTabFragment(), "Dashboard");
        } else {
            adapter.addFragment(new RequestTabFragment(), "Permintaan");
            adapter.addFragment(new DashboardTabFragment(), "Dashboard");
        }

        viewPager.setAdapter(adapter);

    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void updateStatus(){
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        RequestBody requestBody;
        requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("_method", "PUT")
                .addFormDataPart("status_online", String.valueOf(status))
                .build();

        API.baseApiService().updateStatusWorker(sId, requestBody, "Bearer "+tokenBearer).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                Log.d("Log Response", "RESPONSE:  " + response.toString() + "\n" + "BODY: " + response.body() + "\n" + "RAW: " + response.raw() + "\n" + "MESSAGE: " + response.message());
                loadingDialog.dismiss();
                Toast.makeText(getActivity(), "Your Status is Changed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                loadingDialog.dismiss();
                Log.d("onFailed", t.getMessage());
            }
        });
    }

    private void createLocation(){
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        RequestBody requestBody;
        requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("user_id", sId)
                .addFormDataPart("lat", setLatitude.getText().toString())
                .addFormDataPart("long", setLongitude.getText().toString())
                .addFormDataPart("description", "")
                .build();

        API.baseApiService().createLocation(requestBody, "Bearer "+tokenBearer).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                loadingDialog.dismiss();
                Log.d("createLocation", "createLocation");
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                loadingDialog.dismiss();
                Log.d("onFailed", t.getMessage());
            }
        });
    }

    private void updateLocation(){
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        RequestBody requestBody;
        requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("user_id", sId)
                .addFormDataPart("lat", setLatitude.getText().toString())
                .addFormDataPart("long", setLongitude.getText().toString())
                .addFormDataPart("description", "")
                .addFormDataPart("_method", "PUT")
                .build();

        API.baseApiService().updateLocation(sIdLocation, requestBody, "Bearer "+tokenBearer).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                loadingDialog.dismiss();
                Log.d("updateLocation", "updateLocation");
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                loadingDialog.dismiss();
                Log.d("onFailed", t.getMessage());
            }
        });
    }

    private void getDetailLocation(){
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        API.baseApiService().getLocation(sId, "Bearer "+tokenBearer).enqueue(new Callback<ApiResponse<com.boardinglabs.rumahcemara.outreach.models.Location>>() {
            @Override
            public void onResponse(Call<ApiResponse<com.boardinglabs.rumahcemara.outreach.models.Location>> call, Response<ApiResponse<com.boardinglabs.rumahcemara.outreach.models.Location>> response) {
                loadingDialog.dismiss();
                if (response.body() != null){
                    final ApiResponse<com.boardinglabs.rumahcemara.outreach.models.Location> location = response.body();
                    if (response.body().getData() != null){
                        sIdLocation = location.getData().getId();
                    } else {
                        sIdLocation = " ";
                        Log.d("Karizu", "Masuk Id Location Null");
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<com.boardinglabs.rumahcemara.outreach.models.Location>> call, Throwable t) {
                loadingDialog.dismiss();
                Log.d("onFailed", t.getMessage());
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

}
