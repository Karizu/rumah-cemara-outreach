package com.boardinglabs.rumahcemara.outreach.helper;

import com.boardinglabs.rumahcemara.outreach.models.Register;
import com.boardinglabs.rumahcemara.outreach.models.User;
import com.boardinglabs.rumahcemara.outreach.models.UserDevice;
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