package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class search_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_profile);
        final String pass=getIntent().getExtras().getString("password");
        final TextView name=(TextView)findViewById(R.id.Name);
        name.setText(getIntent().getExtras().getString("username"));
        final TextView blood=(TextView)findViewById(R.id.blood);
        blood.setText(getIntent().getExtras().getString("blood_type"));
        final TextView age=(TextView)findViewById(R.id.age);
        age.setText(getIntent().getExtras().getString("age"));
        final TextView location=(TextView)findViewById(R.id.location);
        location.setText(getIntent().getExtras().getString("location"));
        final TextView phone=(TextView)findViewById(R.id.phone);
        phone.setText(getIntent().getExtras().getString("phone"));
        final ImageView call=(ImageView)findViewById(R.id.imageView6);
        call.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+phone.getText().toString()));
                startActivity(i);
            }
        });

        final ImageView msg=(ImageView)findViewById(R.id.imageView7);
        msg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.putExtra("address", phone.getText().toString());
                i.putExtra("sms_body","this is message body" );
                i.setType("vnd.android-dir/mms-sms");
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile2, menu);
        return true;

    }
}
