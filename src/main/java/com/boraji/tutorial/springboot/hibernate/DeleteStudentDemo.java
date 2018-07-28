package com.boraji.tutorial.springboot.hibernate;

import com.boraji.tutorial.springboot.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            //tek obje olarak okuma
            Student temp2= (Student) session.get(Student.class,4);
            session.delete(temp2);

            session.createQuery("delete from Student where id=3").executeUpdate();


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
