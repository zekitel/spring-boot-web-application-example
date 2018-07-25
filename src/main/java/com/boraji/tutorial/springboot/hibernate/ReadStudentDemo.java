package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudentDemo {
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

            //list halinde okuma
            List<Student> theStudents = session.createQuery("from Student s where s.lastName='tel'").list();

            System.out.println(theStudents);
            System.out.println(temp2);

        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        finally{
            factory.close();
        }

    }
}
