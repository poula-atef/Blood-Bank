package com.example.bloodbank;

public class user {
    private String name,age,phone,location,blood_type,password,active;
    public user(){
    }
    public user(String name,String age,String phone,String location,String blood_type,String password,String active){
        this.name=name;
        this.age=age;
        this.location=location;
        this.phone=phone;
        this.blood_type=blood_type;
        this.password=password;
        this.active=active;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getBlood_type() {
        return blood_type;
    }
    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setActive(String active){
        this.active=active;
    }
    public String getActive(){
        return active;
    }

}
