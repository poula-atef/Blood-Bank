package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
        setContentView(R.layout.choose);
        ImageView iv1=(ImageView)findViewById(R.id.imageView1);
        ImageView iv2=(ImageView)findViewById(R.id.imageView2);
        TextView tv1=(TextView)findViewById(R.id.Name);
        TextView tv2=(TextView)findViewById(R.id.textView2);
        ImageView iv3=(ImageView)findViewById(R.id.imageView3);
        TextView tv3=(TextView)findViewById(R.id.TextView01);

        iv2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(choose.this, login.class);
                startActivity(i);
            }
        });

        iv1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(choose.this, search.class);
                startActivity(i);
            }
        });
        tv1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(choose.this, login.class);
                startActivity(i);
            }
        });
        tv2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(choose.this, search.class);
                startActivity(i);
            }
        });
        tv3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(choose.this, details.class);
                startActivity(i);
            }
        });

        iv3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i =new Intent(choose.this, details.class);
                startActivity(i);
            }
        });



    }
    private boolean press=false;
    @Override
    public void onBackPressed() {
        if(press==true){
            Intent i=new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            System.exit(0);
        }
        press=true;
        Toast.makeText(getApplicationContext(),"Press again to Exit ",Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                press=false;

            }
        }, 2000);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity1, menu);
        return true;

    }
}
