package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating new student object");
            Student student = new Student("zeki","tel","gmail");
            session.beginTransaction();
            System.out.println("Saving");
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Done");

        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        finally{
            factory.close();
        }

    }
}
