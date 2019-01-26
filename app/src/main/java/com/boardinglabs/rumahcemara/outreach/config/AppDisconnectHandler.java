package com.boardinglabs.rumahcemara.outreach.config;

import android.content.Context;
import android.util.Log;

import com.boardinglabs.rumahcemara.outreach.ChatActivity;

import centrifuge.Client;
import centrifuge.DisconnectEvent;
import centrifuge.DisconnectHandler;

public class AppDisconnectHandler implements DisconnectHandler {
    protected ChatActivity context;

    public AppDisconnectHandler(Context context) {
        this.context = (ChatActivity) context;
    }

    @Override
    public void onDisconnect(Client client, final DisconnectEvent event) {
        context.runOnUiThread(() -> Log.d("muhtar", "Disconnected " + event.getReason()));
    }
}