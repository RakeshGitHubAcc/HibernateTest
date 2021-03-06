package com.test.mytest;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private ProteinData proteinData=new ProteinData();
	private Set<UserHistory> userHistory=new HashSet<UserHistory>();
	private GoalAlert goalAlert;
	
	
	public GoalAlert getGoalAlert() {
		return goalAlert;
	}
	public void setGoalAlert(GoalAlert goalAlert) {
		this.goalAlert = goalAlert;
	}
	public User() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}
	public Set<UserHistory> getUserHistory() {
		return userHistory;
	}
	public void setUserHistory(Set<UserHistory> userHistory) {
		this.userHistory = userHistory;
	}
	
}
