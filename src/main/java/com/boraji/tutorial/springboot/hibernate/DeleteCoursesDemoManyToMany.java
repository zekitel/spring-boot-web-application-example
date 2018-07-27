package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemoManyToMany {
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
            Course tempCourse = (Course) session.get(Course.class,11);
            session.delete(tempCourse);

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
