package com.training.bean;

public class ReturnsBean_UNF_084 {
	private String pdtName;
	private String metaTitle;
	private String model;
	private String price;
	private String qty;
	private String category;

	public ReturnsBean_UNF_084() {
	}

	public ReturnsBean_UNF_084(String pdtName, String metaTitle, String model, String price, String qty,
			String category) {
		super();
		this.pdtName = pdtName;
		this.metaTitle = metaTitle;
		this.model = model;
		this.price = price;
		this.qty = qty;
		this.category = category;
	}

	public String getPdtName() {
		return pdtName;
	}

	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/*
	 * @Override public String toString() { return "LoginBean [userName=" + userName
	 * + ", password=" + password + "]"; }
	 */

}
