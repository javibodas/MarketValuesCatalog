package com.jgonzalbo.bolsavalores.models.users;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="table_user")
public class ApplicationUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int objid;
	
	private String name;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "user_name", nullable = false)
	private String username;
	
	private String password;
	
	private String email;
	
	@Column(name = "create_date", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate createDate;
	
	@Column(name = "last_login_dt", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate lastLoginDt;
	
	private int status;
	
	@ManyToMany
    @JoinTable(name = "table_user2role",
            joinColumns = { @JoinColumn(name = "user_objid") },
            inverseJoinColumns = { @JoinColumn(name = "role_objid") })
    private Set<ApplicationUserRole> roles = new HashSet<>();

	public int getObjid() {
		return objid;
	}

	public void setObjid(int objid) {
		this.objid = objid;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getLastLoginDt() {
		return lastLoginDt;
	}

	public void setLastLoginDt(LocalDate lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Set<ApplicationUserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<ApplicationUserRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "ApplicationUser [objid=" + objid + ", name=" + name + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", createDate=" + createDate
				+ ", lastLoginDt=" + lastLoginDt + ", status=" + status + "]";
	}
	

}
