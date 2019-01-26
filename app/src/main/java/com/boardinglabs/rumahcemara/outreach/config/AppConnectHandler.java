package com.boardinglabs.rumahcemara.outreach.config;

import android.content.Context;
import android.util.Log;

import com.boardinglabs.rumahcemara.outreach.ChatActivity;

import centrifuge.Client;
import centrifuge.ConnectEvent;
import centrifuge.ConnectHandler;

public class AppConnectHandler implements ConnectHandler {
    protected ChatActivity context;

    public AppConnectHandler(Context context) {
        this.context = (ChatActivity) context;
    }

    @Override
    public void onConnect(Client client, final ConnectEvent event) {
        context.runOnUiThread(() -> Log.d("muhtar", "Connected with client ID " + event.getClientID()));
    }
}