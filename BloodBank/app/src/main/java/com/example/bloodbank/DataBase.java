package com.example.bloodbank;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static String databasename="blood_bank";
    SQLiteDatabase blood_bank;

    public DataBase (Context context){
        super(context,databasename,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(name text Primary key not null,age text not null," +
                "phone text not null,location text not null,blood_type text not null," +
                "password text not null,active text default 1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("drop table if Exists user");
        onCreate(db);
    }

    public boolean createnewuser(user u){
        blood_bank=this.getWritableDatabase();
        ContentValues row=new ContentValues();
        row.put("name",u.getName());
        row.put("age", u.getAge());
        row.put("phone", u.getPhone());
        row.put("location", u.getLocation());
        row.put("blood_type", u.getBlood_type());
        row.put("password", u.getPassword());
        row.put("active", u.getActive());
        long result=blood_bank.insert("users",null, row);
        if(result==-1)
            return false;
        else
            return true;
    }



    public void del(String name){
        blood_bank=this.getWritableDatabase();
        blood_bank.delete("users", "name = ?", new String[]{name});
    }

    public boolean find(String name,String password){
        blood_bank=this.getReadableDatabase();
        String s="Select * from users where name = '"+name+"' and password = '"+password+"'";
        Cursor cursor=blood_bank.rawQuery(s,null);
        if(cursor.getCount()==0)
            return false;
        else{
            return true;
        }
    }

    public user finduser(String name){
        blood_bank=this.getReadableDatabase();
        user u = null;
        String s="Select * from users";
        Cursor cursor=blood_bank.rawQuery(s,null);
        while(cursor.moveToNext())
            if(cursor.getString(0).equals(name))
                u=new user(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),cursor.getString(6));
        return u;
    }

    public boolean repeat(String name){
        blood_bank=this.getReadableDatabase();
        Cursor cursor=blood_bank.rawQuery("Select * from users",null);
        if(cursor.getCount()==0)
            return false;
        else{
            while(cursor.moveToNext()){
                if(cursor.getString(0).equals(name))
                    return true;
            }
        }
        return false;
    }

    public ArrayList<String> type(String blood){
        blood_bank=this.getReadableDatabase();
        Cursor cursor=blood_bank.rawQuery("Select * from users",null);
        ArrayList<String>arr=new ArrayList<String>();
        while(cursor.moveToNext())
            if(cursor.getString(4).equals(blood)&&cursor.getString(6).equals("1"))
                arr.add(cursor.getString(0));

        return arr;
    }
    public ArrayList<String> add(ArrayList<String> subarr,String blood,ArrayList<String> arr){
        subarr=type(blood);
        for(int i=0;i<subarr.size();i++)
            arr.add(subarr.get(i));
        subarr.clear();
        return arr;
    }


    public ArrayList<String>search(String blood){
        ArrayList<String>arr=new ArrayList<String>();
        ArrayList<String>subarr=new ArrayList<String>();

        if(blood.equals("A+"))
        {
            arr=add(subarr,"A+",arr);

            arr=add(subarr,"A-",arr);

            arr=add(subarr,"O+",arr);

            arr=add(subarr,"O-",arr);
        }


        else if(blood.equals("B+"))
        {
            arr=add(subarr,"B+",arr);


            arr=add(subarr,"B-",arr);

            arr=add(subarr,"O+",arr);

            arr=add(subarr,"O-",arr);

        }


        else if(blood.equals("O+"))
        {
            arr=add(subarr,"O+",arr);

            arr=add(subarr,"O-",arr);
        }


        else if(blood.equals("AB+"))
        {
            arr=add(subarr,"AB+",arr);

            arr=add(subarr,"AB-",arr);


            arr=add(subarr,"B+",arr);

            arr=add(subarr,"B-",arr);


            arr=add(subarr,"O+",arr);

            arr=add(subarr,"O-",arr);

            arr=add(subarr,"A+",arr);

            arr=add(subarr,"A-",arr);
        }


        else if(blood.equals("A-"))
        {
            arr=add(subarr,"A-",arr);

            arr=add(subarr,"O-",arr);
        }


        else if(blood.equals("B-"))
        {
            arr=add(subarr,"B-",arr);

            arr=add(subarr,"O-",arr);
        }


        else if(blood.equals("O-"))
        {
            arr=add(subarr,"O-",arr);
        }


        else if(blood.equals("AB-"))
        {

            arr=add(subarr,"AB-",arr);

            arr=add(subarr,"B-",arr);

            arr=add(subarr,"O-",arr);

            arr=add(subarr,"A-",arr);
        }

        return arr;
    }

    public void update(user u){
        del(u.getName());
        createnewuser(u);
    }
}
