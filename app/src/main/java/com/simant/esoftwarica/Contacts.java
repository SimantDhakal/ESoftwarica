package com.simant.esoftwarica;

public class Contacts {

    private String name;
    private String roll;
    private String address;
    private String gender;
    private int image;
    private int delete;

    public Contacts(String name, String roll, String address, String gender, int image, int delete) {
        this.name = name;
        this.roll = roll;
        this.address = address;
        this.gender = gender;
        this.image = image;
        this.delete = delete;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
