package com.wishihab.mycontactapijava.dataset;

public class CRandomUser {

    private String name;
    private String age;
    private String gender;
    private String location;
    private String email;
    private String phone;
    private String cell;
    private String picturelarge;
    private String picturethum;

    public CRandomUser(String name, String age, String gender, String location, String email, String phone, String cell, String picturelarge, String picturethum) {

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

    public void setAge(String age) {
        this.age = age;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }


    public String getPicturelarge() {
        return picturelarge;
    }

    public void setPicturelarge(String picturelarge) {
        this.picturelarge = picturelarge;
    }

    public String getPicturethum() {
        return picturethum;
    }

    public void setPicturethum(String picturethum) {
        this.picturethum = picturethum;
    }

}
