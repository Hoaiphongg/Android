package com.example.daxemgroupandoirdassigment.Class;

public class Users {
    private String Email;
    private String Password;
    private String FullName;
    private String Phone;
    private String Roll;

    public Users(){

    }

    public Users(String email, String password, String fullName, String phone, String roll) {
        Email = email;
        Password = password;
        FullName = fullName;
        Phone = phone;
        Roll = roll;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }
}
