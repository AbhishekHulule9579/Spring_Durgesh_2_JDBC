package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        create new student
//        Student student=new Student();
//        student.setId(4);
//        student.setName("Kishor Borude");
//        student.setCity("Shirgonda");
//        
//        int result=studentDao.insert(student);
//        System.out.println("Student added .."+result);
//        
        
//        update student 
//        Student student=new Student();
//        student.setId(1);
//        student.setName("Abhi");
//        student.setCity("A.nagar");
//        int result = studentDao.change(student);
//        System.out.println("Data changed "+result);
//        
        //delete student
//        int result = studentDao.deletes(4);
//        System.out.println("Data deleted "+result);
//
        //get single student
//        Student student = studentDao.getStudent(1);
//        System.out.println(student);
        // get all student
        List<Student>students=studentDao.getAllStudents();
        for(Student s:students) {
        	System.out.println(s);
        }
    }
}
