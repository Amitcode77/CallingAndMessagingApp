package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class callpage extends AppCompatActivity {

    EditText number;
    Button dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_callpage);
        number = (EditText) findViewById (R.id.number);
        dial = (Button) findViewById (R.id.dial);



        dial.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String numArr = number.getText ().toString ();
                if (ContextCompat.checkSelfPermission (callpage.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions (callpage.this,new String[]{Manifest.permission.CALL_PHONE},0);
                }
                else {
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ numArr));
                    startActivity (i);
                }

            }
        });
    }
}
