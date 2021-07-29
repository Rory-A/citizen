package com.example;

public class Person {
    private String firstname;
    private String surname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;
    private String countrycode;
    private String gender;
    private String dateofbirth;

    public Person (
                String firstname, 
                String surname, 
                String address1, 
                String address2, 
                String city, 
                String state, 
                String postcode, 
                String countrycode, 
                String gender, 
                String dateofbirth) {
        super();
        this.firstname = firstname;
        this.surname = surname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.countrycode = countrycode;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
    }

    public Person() {
	}

    public String getFirstname() {
        return this.firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getAddress1() {
        return this.address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getCountrycode() {
        return this.countrycode;
    }

    public String getGender() {
        return this.gender;
    }

    public String getDateofbirth() {
        return this.dateofbirth;
    }

    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
