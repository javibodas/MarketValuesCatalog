package com.jgonzalbo.bolsavalores.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_country")
public class Country {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int objid;
	
	private String country;

	public int getObjid() {
		return objid;
	}

	public void setObjid(int objid) {
		this.objid = objid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
