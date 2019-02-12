package com.boardinglabs.rumahcemara.outreach.helper;

import android.util.Log;

import com.boardinglabs.rumahcemara.outreach.models.ChatMessage;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void save(final ChatMessage chatMessage) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ChatMessage message = realm.copyToRealm(chatMessage);
                Log.d("RealmHelper", message.toString());
            }
        });
    }

    public ArrayList<String> retrieve() {
        ArrayList<String> messages = new ArrayList<>();
        RealmResults<ChatMessage> chatMessages = realm.where(ChatMessage.class).findAll();

        for (ChatMessage cm: chatMessages) {
            messages.add(cm.getMessage());
        }

        return messages;
    }
}
