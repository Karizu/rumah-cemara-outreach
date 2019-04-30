package com.boardinglabs.rumahcemara.outreach.config;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.boardinglabs.rumahcemara.outreach.MainActivity;
import com.boardinglabs.rumahcemara.outreach.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("muhtar", "new token " + s);
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("firebase-token", s).apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        /*Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "From: " + remoteMessage.getData().size()); // for the data size

        final Map<String, String> data = remoteMessage.getData();

        String title = data.get("title");
        String body = data.get("body");

        if(!title.equals("") && !body.equals("")){
            sendMyNotification(title, body, data); //send notification to user
        }*/

        super.onMessageReceived(remoteMessage);

        SessionManagement sessionManagement = new SessionManagement(this);

        String id = remoteMessage.getData().get("id");
        String title = remoteMessage.getData().get("title");
        String body = remoteMessage.getData().get("body");
        String type = remoteMessage.getData().get("type");

        Log.d("FirebaseMessaging", "notif " + remoteMessage.getData());
        Log.d("FirebaseMessaging", "Status notifikasi " + sessionManagement.getNotification());

        if (sessionManagement.getNotification() == 1) {
            showNotification(title, body, type, id);
        }
    }

    private void showNotification(String title, String body, String type, String id) {
        Intent intent;
        Log.d("karizu", type);
        if(type.equals("chat")){
            intent = new Intent(this, MainActivity.class);
            intent.putExtra("fragment", "MyListFragment");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        } else {
            intent = new Intent(this, MainActivity.class);
//            intent.putExtra("fragment", type);
            intent.putExtra("fragment", "MyListFragment");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "appointment";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "Rumah Cemara", manager.IMPORTANCE_MAX);

            notificationChannel.setDescription("appointment channel");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
            notificationChannel.enableVibration(true);

            manager.createNotificationChannel(notificationChannel);
        }


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.logo_header)
                .setContentIntent(pendingIntent)
                .setSound(soundUri)
                .setContentInfo("Appointment");

        manager.notify(0, builder.build());
    }



    public static String getToken(Context context) {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString("firebase-token", "empty");
    }


    private void sendMyNotification(String title, String body, Map<String, String> data) {

        Log.d(TAG, "id: " + data.get("id"));
        Log.d(TAG, "type: " + data.get("type"));
        NotificationCompat.Builder notificationBuilder;

        String eventId = data.get("id");
        String type = data.get("type");

        switch (type){

            case "event":
                //On click of notification it redirect to this Activity
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("EVENT_ID", eventId);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0 /* request code */, intent,PendingIntent.FLAG_UPDATE_CURRENT);

                long[] pattern = {500,500,500,500,500};

                Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    prepareChannel(this, "event_notification", NotificationManagerCompat.IMPORTANCE_LOW);
                    notificationBuilder = new NotificationCompat.Builder(this, "event_notification")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(title)
                            .setContentText(body)
                            .setAutoCancel(true)
                            .setVibrate(pattern)
                            .setLights(Color.BLUE,1,1)
                            .setSound(soundUri)
                            .setContentIntent(pendingIntent);
                } else {
                    notificationBuilder = new NotificationCompat.Builder(this)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(title)
                            .setContentText(body)
                            .setAutoCancel(true)
                            .setVibrate(pattern)
                            .setLights(Color.BLUE,1,1)
                            .setSound(soundUri)
                            .setContentIntent(pendingIntent);
                }
                notificationManager.notify(0, notificationBuilder.build());

                break;

        }
    }

    @TargetApi(26)
    private static void prepareChannel(Context context, String id, int importance) {
        final String appName = context.getString(R.string.app_name);
        String description = " ";
        final NotificationManager nm = (NotificationManager) context.getSystemService(Activity.NOTIFICATION_SERVICE);

        if(nm != null) {
            NotificationChannel nChannel = nm.getNotificationChannel(id);

            if (nChannel == null) {
                nChannel = new NotificationChannel(id, appName, importance);
                nChannel.setDescription(description);
                nm.createNotificationChannel(nChannel);
            }
        }
    }

}

