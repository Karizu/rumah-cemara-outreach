package com.example.pro.rumahcemara.apihelper;

import com.example.pro.rumahcemara.models.GeneralDataProfile;
import com.example.pro.rumahcemara.models.response.MemberDataResponse;
import com.rezkyatinnov.kyandroid.reztrofit.RestCallback;
import com.rezkyatinnov.kyandroid.reztrofit.Reztrofit;

import java.util.List;

public class MemberHelper {
    public static void getMember(int limit, int offset, String groupId, RestCallback<ApiResponse<List<MemberDataResponse>>> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().getMember(limit, offset, 1, groupId).enqueue(callback);
    }

    public static void getProfile(RestCallback<ApiResponse<GeneralDataProfile>> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().getProfile().enqueue(callback);
    }

    public static void getProfileDetail(String userId, RestCallback<ApiResponse<GeneralDataProfile>> callback){
        Reztrofit<ApiInterface> service = Reztrofit.getInstance();
        service.getEndpoint().getProfileDetail(userId).enqueue(callback);
    }
}