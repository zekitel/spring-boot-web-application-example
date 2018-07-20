package com.boraji.tutorial.springboot.entity;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private LinkedHashMap<String,String> countryOptions;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student(){
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR","Brazil");
        countryOptions.put("FR","France");
        countryOptions.put("DE","Germany");
        countryOptions.put("IN","India");
        countryOptions.put("TR","Turkey");

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }
}
