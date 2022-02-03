package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SideActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side2);
    }

    public void backTmain(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public int add(int x, int y){
        int i = x + y;
        return i;
    }

    public void Badder(View v) {
        EditText t1=findViewById(R.id.NumberX);
        EditText t2=findViewById(R.id.NumberY);
        String e1=t1.getText().toString();
        String e2=t2.getText().toString();
        int x = Integer.parseInt(e1);
        int y = Integer.parseInt(e2);
        int r = add(x,y);
        String result = Integer.toString(r);
        ((TextView)findViewById(R.id.Result)).setText(result);

    }
}