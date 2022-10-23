package com.shan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shan.hibernate.demo.entity.Instructor;
import com.shan.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
//			Instructor tempInstructor = new Instructor("Chad","Darby","john@gmail.com");
//			
//			InstructorDetail tempInstructorDetail = 
//					new InstructorDetail(
//							"http://www.luv2code.com/youtube",
//							"Luv 2 code!!!");

			Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youbute.com",
							"Guitar!");
			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + tempInstructor);
			// Note: this will also save the details object
			// because of CascadeType.ALL
			session.save(tempInstructor);
			
			session.getTransaction().commit();
		
		} finally {
			factory.close();
		}
						
	}

}
