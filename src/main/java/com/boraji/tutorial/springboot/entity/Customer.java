package com.boraji.tutorial.springboot.entity;


import com.boraji.tutorial.springboot.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull
    @Size(min = 3,message = "3 den büyük olmalı")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}")
    private String postalCode;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than  or equal to 0")
    @Max(value = 10, message = "must be less  than or equal to 0")
    private Integer freePasses;

    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
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
}
