package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        final EditText name=(EditText)findViewById(R.id.editText1);
        final EditText age=(EditText)findViewById(R.id.editText4);
        final EditText phone=(EditText)findViewById(R.id.editText2);
        final Spinner location=(Spinner)findViewById(R.id.spinner2);
        final Spinner blood_type=(Spinner)findViewById(R.id.spinner1);
        final EditText pass=(EditText)findViewById(R.id.editText5);
        final EditText repass=(EditText)findViewById(R.id.editText6);
        final Button b=(Button)findViewById(R.id.Edit1);
        final DataBase db=new DataBase(this);
        final String[] loc=getResources().getStringArray(R.array.cities);
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                boolean exist=false;
                if(name.getText().toString().equals(" ")||age.getText().toString().equals(" ")
                        ||phone.getText().toString().equals(" ")||location.getSelectedItem().toString().equals(" ")
                        ||blood_type.getSelectedItem().toString().equals(" ")||pass.getText().toString().equals(" ")
                        ||repass.getText().toString().equals(" ")||name.getText().toString().equals("")||
                        age.getText().toString().equals("")
                        ||phone.getText().toString().equals("")||location.getSelectedItem().toString().equals("")
                        ||blood_type.getSelectedItem().toString().equals("")||pass.getText().toString().equals("")
                        ||repass.getText().toString().equals("")||blood_type.getSelectedItem().toString().equals("Blood")||
                        location.getSelectedItem().toString().equals("Governorate")){
                    Toast.makeText(getApplicationContext(), "Fill all cells", Toast.LENGTH_LONG).show();
                }
                else{
                    if(pass.getText().toString().equals(repass.getText().toString())){
                        user u=new user(name.getText().toString(),age.getText().toString(),phone.getText().toString(),location.getSelectedItem().toString(),blood_type.getSelectedItem().toString(),pass.getText().toString(),"1");
                        if(!db.repeat(name.getText().toString()))
                        {
                            if(db.createnewuser(u))

                                for(int i=0;i<27;i++)
                                    if(loc[i].toLowerCase().equals(location.getSelectedItem().toString().toLowerCase())){
                                        exist=true;
                                        break;
                                    }
                            if(exist){
                                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
                                Intent i=new Intent(signup.this, user_profile.class);
                                i.putExtra("username", name.getText().toString());
                                i.putExtra("age",age.getText().toString());
                                i.putExtra("phone", phone.getText().toString());
                                i.putExtra("location", location.getSelectedItem().toString());
                                i.putExtra("blood_type",blood_type.getSelectedItem().toString());
                                i.putExtra("password", pass.getText().toString());
                                i.putExtra("active", "1");
                                startActivity(i);
                            }
                            else
                                Toast.makeText(getApplicationContext(), "Governorate like Cairo, Giza...est", Toast.LENGTH_LONG).show();

                        }
                        else
                            Toast.makeText(getApplicationContext(), "This user name is already exist !!", Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(), "password cells isn't the same", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity3, menu);
        return true;

    }
}
