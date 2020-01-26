package com.jgonzalbo.bolsavalores.models;

public class Value {
	
	private String name;
	private String price;
	private String currency;
	private String day_change;
	private String eps;
	private String shares;
	private String pe;
	
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getShares() {
		return shares;
	}
	public void setShares(String shares) {
		this.shares = shares;
	}
	public String getPe() {
		return pe;
	}
	public void setPe(String pe) {
		this.pe = pe;
	}
	public String getDay_change() {
		return day_change;
	}
	public void setDay_change(String day_change) {
		this.day_change = day_change;
	}
	@Override
	public String toString() {
		return "Value [name=" + name + ", price=" + price + ", currency=" + currency + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
