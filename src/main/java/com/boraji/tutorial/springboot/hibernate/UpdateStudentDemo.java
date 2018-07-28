package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            //tek obje olarak okuma
            Student temp2= (Student) session.get(Student.class,2);
            temp2.setFirstName("seyma");
            temp2.setLastName("özer");

            //tüm objeleri update etme
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            System.out.println(temp2);
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
