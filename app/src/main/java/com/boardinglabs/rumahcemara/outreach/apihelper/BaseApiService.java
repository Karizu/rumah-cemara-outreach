package com.boardinglabs.rumahcemara.outreach.apihelper;

import com.boardinglabs.rumahcemara.outreach.models.Appointment;
import com.boardinglabs.rumahcemara.outreach.models.ChatHistory;
import com.boardinglabs.rumahcemara.outreach.models.Dashboard;
import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.boardinglabs.rumahcemara.outreach.models.GenerateToken;
import com.boardinglabs.rumahcemara.outreach.models.Group;
import com.boardinglabs.rumahcemara.outreach.models.Location;
import com.boardinglabs.rumahcemara.outreach.models.response.AppointmentDataResponse;
import com.boardinglabs.rumahcemara.outreach.models.response.MemberDataResponse;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("forgot")
    Call<ResponseBody> forgotPassword(@Field("email") String email);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> registerRequest(@Field("username") String username,
                                       @Field("email") String email,
                                       @Field("password") String password);

    @FormUrlEncoded
    @PUT("profile")
    Call<ResponseBody> updateWorker(@Field("fullname") String fullname,
                                    @Field("phone_number") String phone_number,
                                    @Header("Authorization") String token);

    @Multipart
    @POST("profile")
    Call<ResponseBody> updateWorkerImg(@Part("fullname") RequestBody fullname,
                                       @Part("phone_number") RequestBody phone_number,
                                       @Part MultipartBody.Part file,
                                       @Part("_method") RequestBody method,
                                       @Header("Authorization") String token);

    @POST("profile")
    Call<ApiResponse> updateProfileData(@Body RequestBody profile, @Header("Authorization") String token);

    @FormUrlEncoded
    @POST("userDevice")
    Call<ResponseBody> getUserDevice(@Field("user_id") String userId,
                                     @Field("type") String type,
                                     @Field("vendor") String vendor,
                                     @Field("version") String version,
                                     @Field("os") String os,
                                     @Field("token") String token,
                                     @Header("Authorization") String authorization);

    @FormUrlEncoded
    @POST("message")
    Call<ResponseBody> sendChat(@Field("service_transaction_id") String serviceTransId,
                                @Field("channel") String channel,
                                @Field("from_id") String fromId,
                                @Field("from_name") String fromName,
                                @Field("message_type") String messageType,
                                @Field("message") String message,
                                @Field("to_id") String toId,
                                @Header("Authorization") String authorization);

    @GET("generateToken")
    Call<GenerateToken> generateToken(@Query("user_id") String userId,
                                      @Header("Authorization") String authorization);

    @GET("messageHistory")
    Call<ChatHistory> chatHistory(@Query("channel") String channel,
                                  @Header("Authorization") String authorization);

    @GET("user/{user_id}")
    Call<ApiResponse<GeneralDataProfile>> getProfileDetail(@Path("user_id") String user_id, @Header("Authorization") String token);

    @PUT("profile")
    Call<ResponseBody> updateProfile(@Body RequestBody body, @Header("Authorization") String token);

    @GET("client")
    Call<ApiResponse<List<MemberDataResponse>>> getClient(@Query("search") String search, @Query("limit") int limit, @Query("offset") String offset, @Header("Authorization") String token);

    @GET("serviceTransaction")
    Call<ApiResponse<List<AppointmentDataResponse>>> getRequestService(@Query("search") String search, @Query("limit") int limit, @Query("offset") String offset, @Query("worker_id") String worker_id, @Query("status") int status, @Header("Authorization") String token);

    @GET("serviceTransaction")
    Call<ApiResponse<List<AppointmentDataResponse>>> getAppointment(@Query("search") String search, @Query("limit") int limit, @Query("offset") String offset, @Query("worker_id") String worker_id, @Query("status") int status, @Query("service_type_id") String service_type_id, @Header("Authorization") String token);

    @FormUrlEncoded
    @POST("serviceTransaction/{service_id}/status")
    Call<ResponseBody> updateStatus(@Path("service_id") String service_id, @Field("status") int status, @Header("Authorization") String token);

    @GET("serviceTransaction/myHistory")
    Call<ApiResponse<List<AppointmentDataResponse>>> getAppointmentHistory(@Query("worker_id") String worker_id, @Header("Authorization") String token);

    @GET("serviceTransaction")
    Call<ApiResponse<List<AppointmentDataResponse>>> getRequestServicePerId(@Query("search") String search, @Query("limit") int limit, @Query("offset") String offset, @Query("worker_id") String worker_id, @Query("status") int status, @Query("user_id") String user_id, @Header("Authorization") String token);

    @Multipart
    @PUT("profile")
    Call<ResponseBody> updateProfileWorker(@PartMap Map<String, RequestBody> map, @Part MultipartBody.Part image, @Header("Authorization") String token);

    @GET("serviceTransaction/{service_transaction_id}")
    Call<ApiResponse<Appointment>> getDetailAppointment(@Path("service_transaction_id") String service_transaction_id, @Header("Authorization") String token);

    @GET("dashboardMobile")
    Call<ApiResponse<Dashboard>> getDashboardData(@Query("group_id") String group_id, @Query("worker_id") String worker_id, @Query("month") String month, @Query("start_date") String start_date, @Query("end_date") String end_date, @Header("Authorization") String token);

    @GET("group")
    Call<ApiResponse<List<Group>>> getGroup();

    @POST("userLocation")
    Call<ApiResponse> createLocation(@Body RequestBody location, @Header("Authorization") String token);

    @POST("userLocation/{user_location_id}")
    Call<ApiResponse> updateLocation(@Path("user_location_id") String user_location_id, @Body RequestBody location, @Header("Authorization") String token);

    @GET("userLocation/{user_id}")
    Call<ApiResponse<Location>> getLocation(@Path("user_id") String user_id, @Header("Authorization") String token);

    @POST("recover")
    @FormUrlEncoded
    Call<ApiResponse> postRecoverPassword (@Field("email") String email, @Field("number") String number, @Field("password") String password);

    @POST("user/{user_id}")
    Call<ApiResponse> updateStatusWorker(@Path("user_id") String user_id, @Body RequestBody user, @Header("Authorization") String token);


}
