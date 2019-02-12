package com.boardinglabs.rumahcemara.outreach.helper;

import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.boardinglabs.rumahcemara.outreach.models.Group;
import com.boardinglabs.rumahcemara.outreach.models.Password;
import com.boardinglabs.rumahcemara.outreach.models.Profile;
import com.boardinglabs.rumahcemara.outreach.models.Register;
import com.boardinglabs.rumahcemara.outreach.models.User;
import com.boardinglabs.rumahcemara.outreach.models.UserDevice;
import com.boardinglabs.rumahcemara.outreach.models.response.MemberDataResponse;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "http://37.72.172.144/rumah-cemara-api/public/api/";

    @POST("login")
    Call<ApiResponse<User>> login(@Body User user);

//    @GET("news")
//    Call<ApiResponse<List<ArticleDataResponse>>> getNews(@Query("limit") int limit, @Query("offset") int offset, @Query("status") int status);
//
//    @GET("article")
//    Call<ApiResponse<List<ArticleDataResponse>>> getArticle(@Query("limit") int limit, @Query("offset") int offset, @Query("status") int status);
//
//    @GET("article/{id}")
//    Call<ApiResponse<List<ArticleDataResponse>>> getArticle(@Path("id") String id);
//
//    @GET("event")
//    Call<ApiResponse<List<ArticleDataResponse>>> getEvent();
//
//    @POST("eventInvitationAction")
//    Call<ApiResponse> approveEventInvitation(@Body CheckInEvent checkInEvent);
//
//    @POST("eventInvitation/checkin")
//    Call<ApiResponse> checkInEvent(@Body CheckInEvent checkInEvent);
//
//    @GET("home")
//    Call<ApiResponse<HomeDataResponse>> getHome();

    @GET("member")
    Call<ApiResponse<List<MemberDataResponse>>> getMember(@Query("limit") int limit, @Query("offset") int offset, @Query("status") int status, @Query("group_id") String groupId);

    @GET("user/{user_id}")
    Call<ApiResponse<GeneralDataProfile>> getProfileDetail(@Path("user_id") String user_id);

//    @GET("area")
//    Call<ApiResponse<List<AreaDataResponse>>> getArea();
//
//    @GET("event")
//    Call<ApiResponse<List<EventDataResponse>>> getAllEvents();
//
//    @GET("event/list")
//    Call<ApiResponse<List<EventCalendarResponse>>> getEvents(@Query("year") int year, @Query("month") int month, @Query("status") int status);
//
//    @GET("event/list")
//    Call<ApiResponse<List<EventCalendarResponse>>> getEventsFilter(@Query("year") int year, @Query("month") int month, @Query("status") int status, @Query("group_id") String groupId);
//
//    @GET("event/{id}")
//    Call<ApiResponse<EventDataResponse>> getEvent(@Path("id") String id);
//
//    @GET("eventMedia/{id}")
//    Call<ApiResponse<List<Media>>> getEventMedia(@Path("id") String id);

    @POST("register")
    Call<ApiResponse> postRegister(@Body Register register);

    @GET("group")
    Call<ApiResponse<List<Group>>> getGroup();

//    @GET("interest")
//    Call<ApiResponse<List<Interest>>> getInterest();

    @POST("forgot")
    Call<ApiResponse<User>> forgotPassword(@Body User user);

    @POST("updateProfile")
    Call<ApiResponse<Profile>> updateProfile(@Body RequestBody profile);

    @POST("user/{userId}")
    Call<ApiResponse> updateUser(@Path("userId") String userId);

//    @GET("notification")
//    Call<ApiResponse<List<Notification>>> getNotification(@Query("user_id") String user_id, @Query("limit") int limit, @Query("offset") int offset);
//
//    @GET("notification")
//    Call<ApiResponse<List<Notification>>> getCountNotification(@Query("user_id") String user_id, @Query("is_read") boolean is_read);
//
//    @PUT("notification/{id}")
////    Call<ApiResponse> putNotificationIsRead(@Path("id") String notificationId);

    @GET("profile")
    Call<ApiResponse<GeneralDataProfile>> getProfile();

    @POST("userDevice")

    Call<ApiResponse> registerUserDevice(@Body UserDevice userDevice);

    @POST("user/{userId}/changePassword")
    Call<ApiResponse> changePassword(@Path("userId") String userId, @Body Password password);

//    @GET("post")
//    Call<ApiResponse<List<DiscussionDataResponse>>> getDiscussionList(@Query("group_id") String groupId, @Query("limit") int limit, @Query("offset") int offset);
//
//    @POST("post/store")
//    Call<ApiResponse> postDiscussion(@Body RequestBody discussion);
//
//    @POST("post/polling")
//    Call<ApiResponse> postPolling(@Body PostPolling polling);
//
//    @GET("post/{post_id}")
//    Call<ApiResponse<DiscussionDataResponse>> getDiscussionDetail(@Path("post_id") String postId);
//
//    @GET("thread")
//    Call<ApiResponse<List<ThreadDataResponse>>> getThreadList(@Query("post_id") String postId, @Query("order_type") String orderType);

    @POST("thread")
    Call<ApiResponse> createThread(@Query("post_id") String postId, @Query("user_id") String userId, @Query("comment") String comment, @Query("type") String type);

    @POST("thread")
    Call<ApiResponse> createThreadWithImage(@Body RequestBody requestBody);

//    @POST("postReport")
//    Call<ApiResponse> createReportPost(@Body ReportPost reportPost);

    @DELETE("post/{post_id}")
    Call<ApiResponse> deletePost(@Path("post_id") String postId);

}