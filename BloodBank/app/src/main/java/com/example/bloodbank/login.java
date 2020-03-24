package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //llllllllllllllllllllllllllllllllllllll
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button login=(Button)findViewById(R.id.button2);
        TextView signup=(TextView)findViewById(R.id.textView2);
        final EditText name=(EditText)findViewById(R.id.editText1);
        final EditText password=(EditText)findViewById(R.id.editText2);
        signup.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i=new Intent(com.example.bloodbank.login.this, com.example.bloodbank.signup.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                DataBase db=new DataBase(getApplicationContext());
                if(name.getText().toString().equals("")&&password.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "fill all cells !!", Toast.LENGTH_LONG).show();
                else{
                    if(db.find(name.getText().toString(), password.getText().toString())){
                        Intent i=new Intent(com.example.bloodbank.login.this, user_profile.class);
                        i.putExtra("username",db.finduser(name.getText().toString()).getName());
                        i.putExtra("age",db.finduser(name.getText().toString()).getAge());
                        i.putExtra("phone", db.finduser(name.getText().toString()).getPhone());
                        i.putExtra("location", db.finduser(name.getText().toString()).getLocation());
                        i.putExtra("blood_type",db.finduser(name.getText().toString()).getBlood_type());
                        i.putExtra("password", db.finduser(name.getText().toString()).getPassword());
                        i.putExtra("active",db.finduser(name.getText().toString()).getActive());
                        startActivity(i);
                    }
                    else
                        Toast.makeText(getApplicationContext(), "User isn't exist !!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(com.example.bloodbank.login.this, choose.class);
        startActivity(i);
    }
}
