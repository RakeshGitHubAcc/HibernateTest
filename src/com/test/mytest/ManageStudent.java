package com.test.mytest;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageStudent {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		ManageStudent manageStudent = new ManageStudent();
		/* Let us have one address object */
		Address address = manageStudent.addAddress("Kondapur", "Hyderabad",
				1,1,1,"700102");
		/* Add few employee records in database */
		Integer studentID1 = manageStudent.addEmployee("Rakesh3", 28,address);
		Integer studentID2 = manageStudent.addEmployee("Rajesh3", 25,address);
		Integer studentID3 = manageStudent.addEmployee("John3", 26,address);
		/* List down all the employees */
		manageStudent.listStudents();
		/* Update employee's records */
		manageStudent.updateStudent(3, 27);
		/* Delete an employee from the database */
		manageStudent.deleteEmployee(3);
		/* List down all the employees */
		manageStudent.listStudents();

	}

	/* Method to add an address record in the database */
	public Address addAddress(String addressLine1, String addressLine2,
			int district, int state, int country, String zipcode) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer addressID = null;
		Address address = null;
		try {
			tx = session.beginTransaction();
			address = new Address(addressLine1, addressLine2, district, state,
					country, zipcode);
			addressID = (Integer) session.save(address);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return address;
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String name, int age,Address address) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer studentID = null;
		try {
			tx = session.beginTransaction();
			Student student = new Student(name, age,address);
			studentID = (Integer) session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return studentID;
	}

	/* Method to READ all the employees */
	public void listStudents() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List students = session.createQuery("FROM Student").list();
			for (Iterator iterator = students.iterator(); iterator.hasNext();) {
				Student student = (Student) iterator.next();
				System.out.print("Name: " + student.getName());
				System.out.print("\t");
				System.out.print("Age: " + student.getAge());
				System.out.println();
				Address addr = student.getAddress();
		        System.out.println("Address ");
		        System.out.println("\tAddressLine1: " +  addr.getAddressLine1());
		        System.out.println("\tAddressLine2: " +  addr.getAddressLine2());
		        System.out.println("\tDistrict: " +  addr.getDistrict());
		        System.out.println("\tState: " +  addr.getState());
		        System.out.println("\tCountry: " +  addr.getCountry());
		        System.out.println("\tZipCode: " +  addr.getZipcode());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateStudent(Integer id, int age) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = (Student) session.get(Student.class, id);
			student.setAge(age);
			session.update(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = (Student) session.get(Student.class, id);
			session.delete(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
