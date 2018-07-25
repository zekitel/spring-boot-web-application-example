package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Instructor;
import com.boraji.tutorial.springboot.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernateRelationOneToOne.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            int theId = 1;
            InstructorDetail instructorDetail = (InstructorDetail) session.get(InstructorDetail.class,theId);





            session.getTransaction().commit();
            System.out.println(instructorDetail);
            System.out.println(instructorDetail.getInstructor());

        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        finally{
            session.close();
            factory.close();
        }

    }
}
