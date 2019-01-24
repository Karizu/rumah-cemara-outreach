package com.boardinglabs.rumahcemara.outreach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.centrifugal.centrifuge.android.Centrifugo;
import com.centrifugal.centrifuge.android.credentials.Token;
import com.centrifugal.centrifuge.android.credentials.User;
import com.centrifugal.centrifuge.android.listener.ConnectionListener;
import com.centrifugal.centrifuge.android.listener.JoinLeaveListener;
import com.centrifugal.centrifuge.android.listener.SubscriptionListener;
import com.centrifugal.centrifuge.android.message.presence.JoinMessage;
import com.centrifugal.centrifuge.android.message.presence.LeftMessage;
import com.centrifugal.centrifuge.android.subscription.SubscriptionRequest;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    public void setUpCentrifugo() {
        String centrifugoAddress = "wss://centrifugo.herokuapp.com/connection/websocket";
        String userId = "...";
        String userToken = "..."; //nullable
        String token = "...";
        String tokenTimestamp = "...";
        Centrifugo centrifugo = new Centrifugo.Builder(centrifugoAddress)
                .setUser(new User(userId, userToken))
                .setToken(new Token(token, tokenTimestamp))
                .build();
        centrifugo.connect();

        String channel = "my-channel";
        centrifugo.subscribe(new SubscriptionRequest(channel));

        centrifugo.setConnectionListener(new ConnectionListener() {

            @Override
            public void onWebSocketOpen() {
            }

            @Override
            public void onConnected() {
            }

            @Override
            public void onDisconnected(final int code, final String reason, final boolean remote) {
            }

        });

        centrifugo.setSubscriptionListener(new SubscriptionListener() {

            @Override
            public void onSubscribed(final String channelName) {
            }

            @Override
            public void onUnsubscribed(final String channelName) {
            }

            @Override
            public void onSubscriptionError(final String channelName, final String error) {
            }

        });

        centrifugo.setDataMessageListener(message -> {
        });

        centrifugo.setJoinLeaveListener(new JoinLeaveListener() {

            @Override
            public void onJoin(final JoinMessage joinMessage) {
                Log.d("muhtar", "user " + joinMessage.getUser());
                Log.d("muhtar", "channel " + joinMessage.getChannel());
            }

            @Override
            public void onLeave(final LeftMessage leftMessage) {
                Log.d("muhtar", "user " + leftMessage.getUser());
                Log.d("muhtar", "channel " + leftMessage.getChannel());
            }
        });

        centrifugo.requestHistory("my-channel");
    }
}
