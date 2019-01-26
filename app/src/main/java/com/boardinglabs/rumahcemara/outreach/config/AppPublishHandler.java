package com.boardinglabs.rumahcemara.outreach.config;

import android.content.Context;
import android.util.Log;

import com.boardinglabs.rumahcemara.outreach.ChatActivity;

import centrifuge.PublishEvent;
import centrifuge.PublishHandler;
import centrifuge.Subscription;

public class AppPublishHandler implements PublishHandler {
    protected ChatActivity context;

    public AppPublishHandler(Context context) {
        this.context = (ChatActivity) context;
    }

    @Override
    public void onPublish(final Subscription sub, final PublishEvent event) {
        context.runOnUiThread(() -> {
            String data = new String(event.getData());
            Log.d("muhtar", "New publication from channel " + sub.channel() + ": " + data);
        });
    }
}
