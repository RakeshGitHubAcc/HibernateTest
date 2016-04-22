package com.test.mytest;

public class Address {
	private int id;
	private String addressLine1;
	private String addressLine2;
	private int district;
	private int state;
	private int country;
	private String zipcode;

	public Address() {
	}

	public Address(String addressLine1, String addressLine2, int district,
			int state, int country, String zipcode) {
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.district=district;
		this.state = state;
		this.country=country;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
