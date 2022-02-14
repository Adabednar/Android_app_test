package com.example.test_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SettingsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        try {
            httpRequest();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private final OkHttpClient client = new OkHttpClient();
    private static final String TAG = "LogTest";

    public static JsonObject json;
    public static String key1 = "adSlots";

    public void httpRequest () throws IOException {

        Request request = new Request.Builder()
                    .url("https://cdn.stroeerdigitalgroup.de/sdk/live/t-online/config.json")
                    .build();

        client.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    JsonElement jsonElement = JsonParser.parseString(response.body().string());
                    json = jsonElement.getAsJsonObject();
                }
            }
        });
    }


    public String getKeyValues(JsonObject json, String key1, String key2, Integer parameter) {
        JsonObject adSlots = json.get(key1).getAsJsonObject();
        JsonObject adSlot = adSlots.get(key2).getAsJsonObject();
        String [] p3 = adSlot.keySet().toArray(new String[adSlot.size()]);
        JsonObject keyValues = adSlot.get(p3[parameter]).getAsJsonObject();
        String [] p4 = keyValues.keySet().toArray(new String[keyValues.size()]);
        String output = "";
        for (int i=0; i<p4.length; i++) {
            String value = keyValues.get(p4[i]).getAsString();
            if (i == 0) {
                output = p4[i] + " : " + value;
            } else {
                output = output + "\n" + p4[i] + " : " + value;
            }
        }
        return output;
    }

    public String getAdSlots(JsonObject json, String key1){
        JsonObject adSlots = json.get(key1).getAsJsonObject();
        String[] slots = adSlots.keySet().toArray(new String[adSlots.size()]);
        String output = "";
        for (int i=0; i<slots.length; i++) {
            if (i == 0) {
                output = slots[i];
            } else {
                output = output + ", " + slots[i];
            }
        }
        return output;
    }

    public void showAdSlots(View V) {
        TextView t = findViewById(R.id.adSlotsDisplay);
        String output = getAdSlots(json, key1);
        t.setText(output);
    }

    public void showKeyValues(View v) {
        TextView t = findViewById(R.id.keyValues);
        EditText e = findViewById(R.id.AdSlot);
        boolean wrong = false;
        int p = 3;

        String key2 = e.getText().toString();

        JsonObject adslots = json.get(key1).getAsJsonObject();
        String[] slots = adslots.keySet().toArray(new String[adslots.size()]);

        for (int i=0; i<slots.length; i++)
        if (key2.equals(slots[i])) {
            String set = getKeyValues(json, key1, key2, p);
            t.setText(set);
            t.setTextColor(Color.BLACK);
            wrong = false;
            break;
        } else {
            wrong = true;
        }

        if (wrong) {
            String wr = "Wrong Input!";
            t.setText(wr);
            t.setTextColor(Color.RED);
        }
    }




    public void backTmain(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}