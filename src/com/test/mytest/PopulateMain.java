package com.test.mytest;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import com.test.utilities.HibernateUtilities;

public class PopulateMain {
	public static void main(String args[]) {

		System.out.println("Hibernate sample data insertion starts...");
		populateSampleData();

		System.out.println("Hibernate fetch Data by Query...");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		// normal select
		// Query query=session.createQuery("from User");
		// select with where
		// Query
		// query=session.createQuery("from User user where user.name=:name").setString("name",
		// "Joe");
		// named query
		Query query = session.getNamedQuery("AllUsers");
		List<User> users = query.list();
		System.out.println("display All users....");
		// display users
		for (User user : users) {
			System.out.println(user.getName());
		}
		//Dynamic instantiation
		query = session
				.createQuery("select new com.test.mytest.UserTotal(user.name,user.proteinData.total)"
						+ " from User user");
		List<UserTotal> userTotals=query.list();
		System.out.println("Dynamic instantiation....");
		for(UserTotal userTotal: userTotals){
			System.out.println(userTotal.getName()+" : "+userTotal.getTotal());
		}
		//criteria query
		Criteria criteria=session.createCriteria(User.class).add(Restrictions.or(Restrictions.eq("name", "Joe"),Restrictions.eq("name", "Bob")));
		List<User> criteriaUsers=criteria.list();
		System.out.println("criteria query: display users....");
		for(User user:criteriaUsers){
			System.out.println(user.getName());
			System.out.println(user.getId());	
		}
		
		//Query by example
		User euser=new User();
		//set lower name to user
		euser.setName("joe");
		Example e=Example.create(euser);
		e.ignoreCase();
		Criteria criteriaexample= session.createCriteria(User.class).add(e);
		List<User> qexampleUsers=criteriaexample.list();
		System.out.println("query by example: display users....");
		for(User qexampleUser:qexampleUsers){
			System.out.println(qexampleUser.getName());
			System.out.println(qexampleUser.getId());	
		}
		session.getTransaction().commit();
		session.close();

		HibernateUtilities.getSessionFactory().close();
	}

	private static void populateSampleData() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User joe = createUser("Joe", 500, 50, "Good Job", "You made it!");
		session.save(joe);

		User bob = createUser("Bob", 300, 20, "Great Job");
		session.save(bob);

		User amy = createUser("Amy", 250, 200, "Yes!!!");
		session.save(amy);

		session.getTransaction().commit();
		session.close();

	}

	private static User createUser(String name, int goal, int total,
			String... alerts) {
		User user = new User();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.getUserHistory().add(
				new UserHistory(new Date(), "set Goal to " + goal));
		user.getProteinData().setTotal(total);
		user.getUserHistory().add(
				new UserHistory(new Date(), "set Total to " + total));
		for (String alert : alerts) {
			user.setGoalAlert(new GoalAlert(alert));
		}
		return user;
	}
}
