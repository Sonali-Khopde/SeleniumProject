package com.training.bean;

public class SalesBean_UNF_81 {
	private String orderId;
	private String customer;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phone;
	private String product;
	private String model;

	public SalesBean_UNF_81() {
		super();
	}

	public SalesBean_UNF_81(String orderId, String customer, String firstName, String lastName, String emailId,
			String phone, String product, String model) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phone = phone;
		this.product = product;
		this.model = model;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	/*
	 * @Override public String toString() { return "LoginBean [userName=" + userName
	 * + ", password=" + password + "]"; }
	 */

}
