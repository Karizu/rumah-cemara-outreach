package com.boardinglabs.rumahcemara.outreach;

import android.content.Intent;
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
import com.boardinglabs.rumahcemara.outreach.models.GenerateToken;
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
    private String serviceId;
    private String workerId;
    private String providerId;
    private String toId;
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
        userToken = "";

        generateToken();

        Intent intent = getIntent();
        serviceId = intent.getStringExtra("serviceId");
        workerId = intent.getStringExtra("workerId");
        providerId = intent.getStringExtra("providerId");

        if (workerId == null) {
            toId = providerId;
        } else {
            toId = workerId;
        }

        btnSend.setOnClickListener(view -> sendChat());
    }

    private void generateToken() {
        SessionManagement session = new SessionManagement(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        String tokenId = user.get(SessionManagement.KEY_IMG_TOKEN);
        String userId = user.get(SessionManagement.KEY_ID);

        BaseApiService mApiService = UtilsApi.getAPIService();
        mApiService.generateToken(userId, "Bearer "+tokenId)
                .enqueue(new Callback<GenerateToken>() {
                    @Override
                    public void onResponse(Call<GenerateToken> call, Response<GenerateToken> response) {
                        token = response.body().getData().getToken();
                        tokenTimestamp = response.body().getData().getTimestamp().toString();
                        connectToCentrifugo(token, tokenTimestamp, userId);
                    }

                    @Override
                    public void onFailure(Call<GenerateToken> call, Throwable t) {
                        Log.d("generate", "onfailure " + t.getLocalizedMessage());
                    }
                });
    }

    private void connectToCentrifugo(String token, String tokenTimestamp, String userId) {
        centrifugo = new Centrifugo.Builder(centrifugoAddress)
                .setUser(new User(userId, userToken))
                .setToken(new Token(token, tokenTimestamp))
                .build();
        centrifugo.connect();
        centrifugo.subscribe(new SubscriptionRequest(serviceId));

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
            String userId = user.get(SessionManagement.KEY_ID);
            String name = user.get(SessionManagement.KEY_NAME);

            BaseApiService mApiService = UtilsApi.getAPIService();
            mApiService.sendChat(serviceId, serviceId,
                    userId, name, "text",
                    textMessage.getText().toString(), toId, "Bearer "+tokenId)
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
