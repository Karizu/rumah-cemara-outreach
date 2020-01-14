package com.boardinglabs.rumahcemara.outreach.helper;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    private static <T> T builder(Class<T> endpoint) {
        return new Retrofit.Builder()
                .baseUrl(UtilsApi.BASE_URL_API)
                .client(UtilsApi.client())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(endpoint);
    }

    public static BaseApiService baseApiService() {
        return builder(BaseApiService.class);
    }
}