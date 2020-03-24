package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;

public class front_picture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_picture);

        Timer t=new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                Intent i=new Intent(front_picture.this, choose.class);
                startActivity(i);
                finish();
            }
        }, 2000);

    }
}
