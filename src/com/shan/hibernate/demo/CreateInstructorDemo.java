package com.shan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shan.hibernate.demo.entity.Course;
import com.shan.hibernate.demo.entity.Instructor;
import com.shan.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor = new Instructor("Susan","Public","susan.public@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youbute.com",
							"Video Games");
			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + tempInstructor);
			// Note: this will also save the details object
			// because of CascadeType.ALL
			session.save(tempInstructor);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
						
	}

}
