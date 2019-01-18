package com.example.pro.rumahcemara.apihelper;

import com.example.pro.rumahcemara.models.Register;
import com.example.pro.rumahcemara.models.User;
import com.example.pro.rumahcemara.models.UserDevice;
import com.rezkyatinnov.kyandroid.reztrofit.RestCallback;
import com.rezkyatinnov.kyandroid.reztrofit.Reztrofit;


public class AuthHelper {
    public static void login(User user, RestCallback<ApiResponse<User>> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().login(user).enqueue(callback);
    }

    public static void register(Register register, RestCallback<ApiResponse> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().postRegister(register).enqueue(callback);
    }

    public static void forgotPassword(User user, RestCallback<ApiResponse<User>> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().forgotPassword(user).enqueue(callback);
    }

    public static void registerUserDevice(UserDevice userDevice, RestCallback<ApiResponse> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().registerUserDevice(userDevice).enqueue(callback);
    }
}