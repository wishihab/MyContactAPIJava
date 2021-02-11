package com.wishihab.mycontactapijava.dataset;

public class CMainUser{

    private String name;
    private final String age;
    private final String gender;
    private final String location;
    private final String email;
    private final String phone;
    private final String cell;
    private final String picturelarge;
    private final String picturethum;

    public CMainUser(String name, String age, String gender, String location, String email, String phone, String cell, String picturelarge, String picturethum) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.cell = cell;
        this.picturelarge = picturelarge;
        this.picturethum = picturethum;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }


    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public String getPicturelarge() {
        return picturelarge;
    }

    public String getPicturethum() {
        return picturethum;
    }


}
