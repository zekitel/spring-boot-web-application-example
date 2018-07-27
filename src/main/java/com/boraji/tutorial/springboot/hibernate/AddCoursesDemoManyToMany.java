package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesDemoManyToMany {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernateRelationManyToMany.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Review.class)
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            Student tempStudent = (Student) session.get(Student.class,2);
            Course tempCourse1=new Course("course11");
            Course tempCourse2=new Course("course22");
            Course tempCourse3=new Course("course33");
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            tempCourse3.addStudent(tempStudent);
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.save(tempCourse3);
            session.getTransaction().commit();
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        finally{
            factory.close();
        }

    }
}
