package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yieldlove.adIntegration.Yieldlove;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Yieldlove.setApplicationName("appDfpTest");
    }


    /*public void copyText(View v) {
        EditText t=findViewById(R.id.source1);
        String input=t.getText().toString();
        ((TextView)findViewById(R.id.output1)).setText(input);
    }*/

    public void launchSettings(View v) {
        Intent i=new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    public void Side2(View v) {
        Intent i=new Intent(this, SideActivity.class);
        startActivity(i);
    }

    public void Side3(View v) {
        Intent i=new Intent(this, SideActivity2.class);
        startActivity(i);
    }

}