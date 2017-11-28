package com.example.azer.ocrwithloginandregistration.Model;

/**
 * Created by azeR on 10/10/2017.
 */

public class User {
    private int id;
    private String name;
    private String email;
    private String phoneno;
    private String dateofbirth;
    private String address;

    public User(int id, String name, String email, String phoneno, String dateofbirth, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
        this.dateofbirth = dateofbirth;
        this.address = address;
    }

    public User(String name, String email, String phoneno, String dateofbirth, String address) {
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
        this.dateofbirth = dateofbirth;
        this.address = address;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
