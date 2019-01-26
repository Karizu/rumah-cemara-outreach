package com.boardinglabs.rumahcemara.outreach;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

import com.boardinglabs.rumahcemara.outreach.adapter.AdapterChat;
import com.boardinglabs.rumahcemara.outreach.apihelper.BaseApiService;
import com.boardinglabs.rumahcemara.outreach.apihelper.UtilsApi;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.models.Chat;
import com.centrifugal.centrifuge.android.Centrifugo;
import com.centrifugal.centrifuge.android.credentials.Token;
import com.centrifugal.centrifuge.android.credentials.User;
import com.centrifugal.centrifuge.android.listener.ConnectionListener;
import com.centrifugal.centrifuge.android.message.DataMessage;
import com.centrifugal.centrifuge.android.subscription.SubscriptionRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {
    private String userToken;
    private String token;
    private String tokenTimestamp;
    private String centrifugoAddress;
    private String userId;
    private EditText textMessage;
    private Centrifugo centrifugo;
    private RecyclerView recyclerView;
    private AdapterChat adapterChat;
    private ArrayList<Chat> chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chats = new ArrayList<>();

        ImageButton btnSend = findViewById(R.id.btn_send);
        recyclerView = findViewById(R.id.chat_recyclerview);
        textMessage = findViewById(R.id.text_message);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SessionManagement sessionManagement = new SessionManagement(this);

        if (sessionManagement.getLanguage() == 0) {
            textMessage.setHint("Type a message");
        } else {
            textMessage.setHint("Ketik pesan");
        }

        centrifugoAddress = "ws://37.72.172.144:5050/connection/websocket";
        userId = "97464d02-2ecc-4b70-aed0-897fcb3ab460";
        userToken = "";
        token = "2128baa0aa378bafd7e7e86e64ed4babee647307253dc60183212335272e00ef";
        tokenTimestamp = "1548385285";

        connectToCentrifugo();

        btnSend.setOnClickListener(view -> sendChat());
    }

    private void connectToCentrifugo() {
        centrifugo = new Centrifugo.Builder(centrifugoAddress)
                .setUser(new User(userId, userToken))
                .setToken(new Token(token, tokenTimestamp))
                .build();
        centrifugo.connect();
        centrifugo.subscribe(new SubscriptionRequest("f10d9781-4abd-49ea-97af-ba28a956be07"));

        new Thread() {
            @Override
            public void run() {
                super.run();

                centrifugo.setConnectionListener(new ConnectionListener() {
                    @Override
                    public void onWebSocketOpen() {
                        Log.d("centrifugo", "web socket open");
                    }

                    @Override
                    public void onConnected() {
                        Log.d("centrifugo", "on connected");
                    }

                    @Override
                    public void onDisconnected(final int code, final String reason, final boolean remote) {
                        Log.d("centrifugo", "on disconnected");
                    }
                });

                centrifugo.setDataMessageListener(message -> {
                    showMessage(message);
                });
            }
        }.start();

    }

    private void sendChat() {
        if (!textMessage.getText().toString().equals("")) {
            SessionManagement session = new SessionManagement(getApplicationContext());
            HashMap<String, String> user = session.getUserDetails();
            String tokenId = user.get(SessionManagement.KEY_IMG_TOKEN);

            BaseApiService mApiService = UtilsApi.getAPIService();
            mApiService.sendChat("f10d9781-4abd-49ea-97af-ba28a956be07", "f10d9781-4abd-49ea-97af-ba28a956be07",
                    "da727d7a-e920-463a-bf16-04fdf9870a3b", "Admin", "text",
                    textMessage.getText().toString(), "97464d02-2ecc-4b70-aed0-897fcb3ab460", "Bearer "+tokenId)
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            Log.d("centrifugo", "onresponse " + response.message());
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.d("centrifugo", "onfailure " + t.getLocalizedMessage());
                        }
                    });
            textMessage.setText("");
        }

    }

    private void showMessage(final DataMessage message) {
        runOnUiThread(() -> {
            Log.d("centrifugo", "message : " + message.getData());
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(message.getData());
                Chat chat = new Chat(jsonObject.get("message").toString(), jsonObject.get("from_id").toString(),
                        jsonObject.get("created_at").toString());
                chats.add(chat);
                adapterChat = new AdapterChat(this, chats);
                recyclerView.setAdapter(adapterChat);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        });
    }

    private void error(final String error) {
        runOnUiThread(() -> Snackbar
                .make(findViewById(R.id.parentChat), "Error: " + error, Snackbar.LENGTH_LONG)
                .show());
    }

    private void message(final String messageMain, final String message) {
        runOnUiThread(() -> {
            SpannableStringBuilder snackbarText = new SpannableStringBuilder();
            snackbarText.append(messageMain);
            snackbarText.setSpan(new ForegroundColorSpan(0xFF00DD00), 0, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            snackbarText.append(" ").append(message);
            Snackbar.make(findViewById(R.id.parentChat), snackbarText, Snackbar.LENGTH_LONG).show();
        });
    }
}
