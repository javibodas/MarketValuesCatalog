 package com.jgonzalbo.bolsavalores.models;

public class Value {
	
	private String id;
	private String name;
	private String price;
	private String currency;
	private String day_change;
	private String eps;
	private String shares;
	private String pe;
	private String country;
	private String day_performance;
	private String week_performance;
	private String month_performance;
	private String year_performance;
	private String market_cap;
	private String employs;
	private String industry;
	private String sector;
	
	public Value() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
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
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDay_performance() {
		return day_performance;
	}

	public void setDay_performance(String day_performance) {
		this.day_performance = day_performance;
	}

	public String getWeek_performance() {
		return week_performance;
	}

	public void setWeek_performance(String week_performance) {
		this.week_performance = week_performance;
	}

	public String getMonth_performance() {
		return month_performance;
	}

	public void setMonth_performance(String month_performance) {
		this.month_performance = month_performance;
	}

	public String getYear_performance() {
		return year_performance;
	}

	public void setYear_performance(String year_performance) {
		this.year_performance = year_performance;
	}

	public String getMarket_cap() {
		return market_cap;
	}

	public void setMarket_cap(String market_cap) {
		this.market_cap = market_cap;
	}

	public String getEmploys() {
		return employs;
	}

	public void setEmploys(String employs) {
		this.employs = employs;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	@Override
	public String toString() {
		return "Value [id=" + id + ", name=" + name + ", price=" + price + ", currency=" + currency + ", day_change="
				+ day_change + ", eps=" + eps + ", shares=" + shares + ", pe=" + pe + ", country=" + country
				+ ", day_performance=" + day_performance + ", week_performance=" + week_performance
				+ ", month_performance=" + month_performance + ", year_performance=" + year_performance
				+ ", market_cap=" + market_cap + ", employs=" + employs + ", industry=" + industry + ", sector="
				+ sector + "]";
	}
	

}
