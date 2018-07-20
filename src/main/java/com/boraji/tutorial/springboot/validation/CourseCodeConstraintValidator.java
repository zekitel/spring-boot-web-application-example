package com.boraji.tutorial.springboot.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {


    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {
        boolean result;

        if (theCode !=null){
            result = theCode.startsWith(coursePrefix);
        }
        else{
            return true;
        }
        return result;
    }
}
