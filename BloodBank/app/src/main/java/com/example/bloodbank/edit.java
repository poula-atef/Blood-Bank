package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class edit extends AppCompatActivity {
    final DataBase db=new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        final Button update=(Button)findViewById(R.id.Edit);
        Button delete=(Button)findViewById(R.id.button2);
        final EditText nam=(EditText)findViewById(R.id.editText1);
        nam.setText(getIntent().getExtras().getString("username"));
        final EditText age=(EditText)findViewById(R.id.editText4);
        age.setText(getIntent().getExtras().getString("age"));
        final EditText phone=(EditText)findViewById(R.id.editText2);
        phone.setText(getIntent().getExtras().getString("phone"));
        final Switch s=(Switch)findViewById(R.id.switch1);
        String[] bl=getResources().getStringArray(R.array.blood);
        String[] gov=getResources().getStringArray(R.array.cities);
        int loc=0,blo=0;
        for(int j=0;j<27;j++)
            if(gov[j].equals(getIntent().getExtras().getString("location"))){
                loc=j;
                break;
            }
        for(int j=0;j<8;j++)
            if(bl[j].equals(getIntent().getExtras().getString("blood_type"))){
                blo=j;
                break;
            }

        final Spinner location=(Spinner)findViewById(R.id.spinner2);
        location.setSelection(loc);
        final Spinner blood=(Spinner)findViewById(R.id.spinner1);
        blood.setSelection(blo);

        final EditText pass=(EditText)findViewById(R.id.editText5);
        pass.setText(getIntent().getExtras().getString("password"));
        //radwa
        //change delete else of save
        update.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(edit.this);
                builder.setMessage("Are you sure about these updates?");
                builder.setCancelable(true);
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.cancel();
                        user u;
                        if(s.isChecked())
                            u=new user(nam.getText().toString(),age.getText().toString(),phone.getText().toString(),location.getSelectedItem().toString(),blood.getSelectedItem().toString(),pass.getText().toString(),"1");
                        else
                            u=new user(nam.getText().toString(),age.getText().toString(),phone.getText().toString(),location.getSelectedItem().toString(),blood.getSelectedItem().toString(),pass.getText().toString(),"0");
                        db.update(u);
                        Intent i=new Intent(edit.this, user_profile.class);
                        i.putExtra("username",db.finduser(nam.getText().toString()).getName());
                        i.putExtra("age",db.finduser(nam.getText().toString()).getAge());
                        i.putExtra("phone", db.finduser(nam.getText().toString()).getPhone());
                        i.putExtra("location", db.finduser(nam.getText().toString()).getLocation());
                        i.putExtra("blood_type",db.finduser(nam.getText().toString()).getBlood_type());
                        i.putExtra("password", db.finduser(nam.getText().toString()).getPassword());
                        i.putExtra("active", db.finduser(nam.getText().toString()).getActive());
                        startActivity(i);
                        Toast.makeText(getApplicationContext(),"User Updated",Toast.LENGTH_LONG).show();
                    }



                });
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
                AlertDialog alert=builder.create();
                alert.show();

            }
        });
        //radwa
        //confirmation screen
        delete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(edit.this);
                builder.setMessage("Are you sure that you want to delete account?");
                builder.setCancelable(true);
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.cancel();
                        if(db.find(nam.getText().toString(), pass.getText().toString())){
                            Intent i=new Intent(edit.this, login.class);
                            db.del(nam.getText().toString());
                            startActivity(i);
                            Toast.makeText(getApplicationContext(),"User Deleted",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"This user isn't exist !!",Toast.LENGTH_LONG).show();
                    }


                });
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }


        });
        if(getIntent().getExtras().getString("active").equals("1"))
            s.setChecked(true);
        else
            s.setChecked(false);
    }
    //radwa
    @Override
    public void onBackPressed() {
        final EditText nam=(EditText)findViewById(R.id.editText1);
        nam.setText(getIntent().getExtras().getString("username"));
        Intent i=new Intent(edit.this, user_profile.class);
        i.putExtra("username",db.finduser(nam.getText().toString()).getName());
        i.putExtra("age",db.finduser(nam.getText().toString()).getAge());
        i.putExtra("phone", db.finduser(nam.getText().toString()).getPhone());
        i.putExtra("location", db.finduser(nam.getText().toString()).getLocation());
        i.putExtra("blood_type",db.finduser(nam.getText().toString()).getBlood_type());
        i.putExtra("password", db.finduser(nam.getText().toString()).getPassword());
        i.putExtra("active", db.finduser(nam.getText().toString()).getActive());
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity4, menu);
        return true;

    }
}
