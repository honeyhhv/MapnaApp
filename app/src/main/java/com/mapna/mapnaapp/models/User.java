package com.mapna.mapnaapp.models;

/**
 * Created by variani_h on 11/13/2016.
 */

public class User {

    private String PersonelId;
    private String Firstname;
    private String Lastname;
    private String Username;
    private String Password ;
    private String Company;
    private String Management;
    private String Department;
    private String Title;

    public User() {
    }

    public User(String personelId, String firstname, String lastname, String username, String password, String company, String management, String department, String title) {
        PersonelId = personelId;
        Firstname = firstname;
        Lastname = lastname;
        Username = username;
        Password = password;
        Company = company;
        Management = management;
        Department = department;
        Title = title;
    }

    public String getPersonelId() {
        return PersonelId;
    }

    public void setPersonelId(String personelId) {
        PersonelId = personelId;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getManagement() {
        return Management;
    }

    public void setManagement(String management) {
        Management = management;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
