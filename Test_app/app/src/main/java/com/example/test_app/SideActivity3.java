package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class SideActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side3);
    }

    public void backTmain(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void DisplayArray(View v){
        TextView t = findViewById(R.id.ArrayView);
        OddArray o = new OddArray();
        EditText e = findViewById(R.id.ArraySize);

        String s1 = e.getText().toString();
        int arrayLength = Integer.parseInt(s1);

        int[] arr = o.RandomArray(arrayLength); //výpis array
        String s2 = Arrays.toString(arr);
        t.setText(s2);

        TextView t2 = findViewById(R.id.ResultO); //výpis výsledku
        int result = o.ArrayOddNumberSum(arr);
        String s3 = Integer.toString(result);
        t2.setText(s3);

    }

}