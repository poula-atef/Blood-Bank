package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class user_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String pass=getIntent().getExtras().getString("password");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
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
        final Button edit=(Button)findViewById(R.id.Edit1);
        TextView logout=(TextView)findViewById(R.id.textView2);
        TextView active=(TextView)findViewById(R.id.textView3);
        final String act=getIntent().getExtras().getString("active");
        if(act.equals("1"))
        {
            active.setText("active");
        }
        else
        {
            active.setText("Non-active");
        }
        logout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //;;;;;;;;;;;;;;;;;;;;;;;;;;
                Intent i=new Intent(user_profile.this, login.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("EXIT", true);
                startActivity(i);
                finish();

            }
        });
        edit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i=new Intent(user_profile.this, com.example.bloodbank.edit.class);
                i.putExtra("username", name.getText().toString());
                i.putExtra("age",age.getText().toString());
                i.putExtra("phone", phone.getText().toString());
                i.putExtra("location", location.getText().toString());
                i.putExtra("blood_type",blood.getText().toString());
                i.putExtra("password",pass);
                i.putExtra("active",act);
                startActivity(i);

            }
        });


    }
    public void onBackPressed()
    {
        Toast.makeText(getApplicationContext(), "If you want to logout ,press LogOut", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;

    }
}
