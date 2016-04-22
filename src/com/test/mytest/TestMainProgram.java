package com.test.mytest;

import java.util.Date;

import org.hibernate.Session;

import com.test.utilities.HibernateUtilities;

public class TestMainProgram {
	public static void main(String[] args) {
		System.out.println("Hibernate Session testing");
		Session session = HibernateUtilities.getSessionFactory().openSession();

		// store data to table
		session.beginTransaction();
		User user = new User();
		user.setName("Rakesh");
		user.getUserHistory().add(
				new UserHistory(new Date(), "set User name  to Rakesh"));
		user.getProteinData().setTotal(10);
		user.getProteinData().setGoal(5);
		user.getUserHistory().add(
				new UserHistory(new Date(), "set the goal to 5"));
		user.setGoalAlert(new GoalAlert("Congratulations!!!"));
		session.save(user);
		session.getTransaction().commit();

		// get data back from table
		session.beginTransaction();
		User loadedUser = session.get(User.class, 1);
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		session.getTransaction().commit();

		// update data while fetching
		session.beginTransaction();
		User storedUser = session.get(User.class, 1);
		System.out.println(storedUser.getProteinData().getTotal());
		storedUser.getProteinData().setTotal(
				storedUser.getProteinData().getTotal() + 50);
		for (UserHistory userHistory : storedUser.getUserHistory()) {
			System.out.println(userHistory.getEntryTime().toString() + " "
					+ userHistory.getEntry());
		}
		storedUser.getUserHistory().add(
				new UserHistory(new Date(), "Added 50 to total"));
		session.getTransaction().commit();

		session.close();
	}

}
