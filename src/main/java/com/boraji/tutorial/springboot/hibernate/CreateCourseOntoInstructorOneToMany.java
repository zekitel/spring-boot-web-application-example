package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Course;
import com.boraji.tutorial.springboot.entity.Instructor;
import com.boraji.tutorial.springboot.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseOntoInstructorOneToMany {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernateRelationOneToMany.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Course tempCourse=new Course("book1");
            Course tempCourse2=new Course("book2");
            session.beginTransaction();
            Instructor instructor= (Instructor) session.get(Instructor.class,1);
            instructor.addCourse(tempCourse);
            instructor.addCourse(tempCourse2);
            session.save(tempCourse);
            session.save(tempCourse2);

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
