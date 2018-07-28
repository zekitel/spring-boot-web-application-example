package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Instructor;
import com.boraji.tutorial.springboot.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernateRelationOneToOne.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            // In this code, when we delete the instuctorDetail, the corresponding instructor will not be removed
            //But other functions cascades, look at InstructorDetail class
            session.beginTransaction();
            InstructorDetail instructorDetail= (InstructorDetail) session.get(InstructorDetail.class,6);
            //we break the bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

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
