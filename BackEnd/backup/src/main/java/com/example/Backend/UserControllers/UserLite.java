package com.example.Backend.UserControllers;

public class UserLite {
    private String email;
    private String username;
    private String tag;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zipCode;
    private String state;
    private String country;

    public UserLite(String email,String username, String tag,String firstName,String lastName,String address,String city,String zipCode,String state,String country)
    {
        this.email = email;
        this.username = username;
        this.tag = tag;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
