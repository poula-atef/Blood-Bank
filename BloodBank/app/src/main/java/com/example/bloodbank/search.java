package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        Button search=(Button)findViewById(R.id.button2);
        final Spinner blood=(Spinner)findViewById(R.id.spinner1);
        final Spinner location=(Spinner)findViewById(R.id.spinner2);
        final DataBase db=new DataBase(getApplicationContext());
        final ArrayList<String>arr;
        search.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(!blood.getSelectedItem().toString().equals("Blood"))
                {				if(!location.getSelectedItem().toString().equals("Governorate"))
                {Intent i=new Intent(com.example.bloodbank.search.this, list.class);
                    i.putExtra("arr",db.search(blood.getSelectedItem().toString()));
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(), "Choose a your place !!", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Choose a blood type !!", Toast.LENGTH_LONG).show();

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity5, menu);
        return true;

    }
}
