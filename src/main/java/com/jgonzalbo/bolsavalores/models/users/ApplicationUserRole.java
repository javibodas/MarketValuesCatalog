package com.jgonzalbo.bolsavalores.models.users;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="table_role")
public class ApplicationUserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int objid;
	
	private String role;
	
	@ManyToMany(mappedBy = "roles")
	Set<ApplicationUser> users;

	public int getObjid() {
		return objid;
	}

	public void setObjid(int objid) {
		this.objid = objid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ApplicationUserRole [objid=" + objid + ", role=" + role + "]";
	}
	
}
