package com.boraji.tutorial.springboot.entity;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
    private String firstName;

    @NotNull
    @Size(min = 3,message = "3 den büyük olmalı")
    private String lastName;

    @Min(value = 0, message = "must be greater than  or equal to 0")
    @Max(value = 10, message = "must be less  than or equal to 0")
    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    private int freePasses;

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
}
