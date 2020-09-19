package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button call,sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        call = (Button) findViewById (R.id.call);
        sms = (Button) findViewById (R.id.sms);

        sms.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent gotosms = new Intent ();
                gotosms.setClass (MainActivity.this,smspage.class);
                startActivity (gotosms);
            }
        });


        call.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent gotocall = new Intent ();
                gotocall.setClass (MainActivity.this,callpage.class);
                startActivity (gotocall);
            }
        });

    }
}
