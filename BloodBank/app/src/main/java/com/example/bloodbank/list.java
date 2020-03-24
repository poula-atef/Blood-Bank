package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final DataBase db=new DataBase(getApplicationContext());
        final ListView lv=(ListView)findViewById(R.id.listView1);
        ArrayList<String> list=getIntent().getStringArrayListExtra("arr");
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                TextView tv=(TextView)arg1;
                Intent i=new Intent(com.example.bloodbank.list.this, search_profile.class);
                i.putExtra("username",db.finduser(tv.getText().toString()).getName());
                i.putExtra("age",db.finduser(tv.getText().toString()).getAge());
                i.putExtra("phone", db.finduser(tv.getText().toString()).getPhone());
                i.putExtra("location", db.finduser(tv.getText().toString()).getLocation());
                i.putExtra("blood_type",db.finduser(tv.getText().toString()).getBlood_type());
                i.putExtra("password", db.finduser(tv.getText().toString()).getPassword());
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity6, menu);
        return true;

    }
}
