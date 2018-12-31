package com.home.hibernate.crud.operations.service.impl;

import com.home.hibernate.crud.operations.entity.Student;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;


public class DbOperations {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    public static final Logger logger = Logger.getLogger(DbOperations.class);

        // This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

        // Method 1: This Method Used To Create A New Student Record In The Database Table
    public static void createRecord() {
        int count = 0;
        Student studentObj = null;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            // Creating Transaction Entities
            for(int j = 101; j <= 109; j++) {
                count = count + 1;
                studentObj = new Student();
                studentObj.setRollNumber(j);
                studentObj.setStudentName("Editor " + j);
                studentObj.setCourse("Bachelor Of Technology");
                sessionObj.save(studentObj);
            }

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            logger.info("\nSuccessfully Created '" + count + "' Records In The Database!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }

        // Method 2: This Method Is Used To Display The Records From The Database Table

    public static List<Student> displayRecords() {
        List<Student> students = new ArrayList<>();
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();

            students = sessionObj.createQuery("FROM Student").list();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
        return students;
    }

        // Method 3: This Method Is Used To Update A Record In The Database Table
    public static void updateRecord(int student_id) {
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            // Creating Transaction Entity
            Student stuObj = (Student) sessionObj.get(Student.class, student_id);
            stuObj.setStudentName("Java Code Geek");
            stuObj.setCourse("Masters Of Technology");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            logger.info("\nStudent With Id?= " + student_id + " Is Successfully Updated In The Database!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }

        // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
    public static void deleteRecord(Integer student_id) {
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            Student studObj = findRecordById(student_id);
            sessionObj.delete(studObj);
           // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            logger.info("\nStudent With Id?= " + student_id + " Is Successfully Deleted From The Database!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }

        // Method 4(b): This Method To Find Particular Record In The Database Table
    public static Student findRecordById(Integer find_student_id) {
        Student findStudentObj = null;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            findStudentObj = (Student) sessionObj.load(Student.class, find_student_id);
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findStudentObj;
    }

        // Method 5: This Method Is Used To Delete All Records From The Database Table
    public static void deleteAllRecords() {
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            Query queryObj = sessionObj.createQuery("DELETE FROM Student");
            queryObj.executeUpdate();

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            logger.info("\nSuccessfully Deleted All Records From The Database Table!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}

