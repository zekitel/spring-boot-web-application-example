package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Instructor;
import com.boraji.tutorial.springboot.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemoOneToOne {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernateRelationOneToOne.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com","Football");
            Instructor instructor = new Instructor("furkan","tel","email");
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
