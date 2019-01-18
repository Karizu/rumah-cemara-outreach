package com.example.pro.rumahcemara.apihelper;

import com.example.pro.rumahcemara.models.Password;
import com.example.pro.rumahcemara.models.Profile;
import com.rezkyatinnov.kyandroid.reztrofit.RestCallback;
import com.rezkyatinnov.kyandroid.reztrofit.Reztrofit;

import okhttp3.RequestBody;

public class PrivacyHelper {

    public static void updateProfile(RequestBody profile, RestCallback<ApiResponse<Profile>> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().updateProfile(profile).enqueue(callback);
    }

    public static void chagePassword(String userId, Password password, RestCallback<ApiResponse> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().changePassword(userId, password).enqueue(callback);
    }

    public static void updateUser(String userId, RestCallback<ApiResponse> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().updateUser(userId).enqueue(callback);
    }
}