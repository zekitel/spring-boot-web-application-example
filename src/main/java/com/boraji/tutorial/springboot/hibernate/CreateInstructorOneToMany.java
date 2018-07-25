package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Course;
import com.boraji.tutorial.springboot.entity.Instructor;
import com.boraji.tutorial.springboot.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorOneToMany {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernateRelationOneToMany.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Instructor instructor =new Instructor("Susan","asdas","email");
            InstructorDetail instructorDetail= new InstructorDetail("www","football");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            session.save(instructor);


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
