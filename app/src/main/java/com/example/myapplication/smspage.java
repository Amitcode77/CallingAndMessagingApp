package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class smspage extends AppCompatActivity {

    EditText num,message;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_smspage);
        num = (EditText) findViewById (R.id.num);
        message= (EditText) findViewById (R.id.message);
        send = (Button) findViewById (R.id.send);


        send.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                final String number = num.getText ().toString ();
                final String sms = message.getText ().toString ();
                if(ContextCompat.checkSelfPermission (smspage.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                {

                    ActivityCompat.requestPermissions (smspage.this,new String[]{Manifest.permission.SEND_SMS},0);
                }
                else
                    {
                    SmsManager smsManager = SmsManager.getDefault ();
                    smsManager.sendTextMessage (number,null,sms,null,null);
                    Toast.makeText (smspage.this, "Send message Succeccfully!", Toast.LENGTH_SHORT).show ();
                    }
            }
        });
    }
}
