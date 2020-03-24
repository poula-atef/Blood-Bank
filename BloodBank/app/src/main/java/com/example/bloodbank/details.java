package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        ImageView iv1=(ImageView)findViewById(R.id.imageView1);
        ImageView iv2=(ImageView)findViewById(R.id.imageView2);
        TextView tv2=(TextView)findViewById(R.id.textView2);
        TextView tv1=(TextView)findViewById(R.id.textView1);
        ImageView iv3=(ImageView)findViewById(R.id.imageView3);
        TextView tv3=(TextView)findViewById(R.id.textView3);

        iv2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(details.this, before.class);
                startActivity(i);
            }
        });

        iv1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(details.this, after.class);
                startActivity(i);
            }
        });
        tv1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(details.this, before.class);
                startActivity(i);
            }
        });
        tv2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(details.this, after.class);
                startActivity(i);
            }
        });
        tv3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(details.this, requirements.class);
                startActivity(i);
            }
        });

        iv3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(details.this, requirements.class);
                startActivity(i);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity7, menu);
        return true;

    }
}
