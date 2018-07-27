package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Course;
import com.boraji.tutorial.springboot.entity.Instructor;
import com.boraji.tutorial.springboot.entity.InstructorDetail;
import com.boraji.tutorial.springboot.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernateRelationOneToManyUni.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Review.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            Course tempCourse = (Course) session.get(Course.class,10);
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());




            //Instructor instructor= (Instructor) session.get(Instructor.class,1);





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
