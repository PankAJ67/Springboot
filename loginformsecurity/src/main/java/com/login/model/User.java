package com.login.model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "users")
public class User {

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String name ;
		private String email;
		private String username;
		private String password;
		

	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	
	@ManyToMany(fetch = FetchType.EAGER , cascade=CascadeType.ALL) 
	@JoinTable(name="users_roles" , 
	joinColumns= @JoinColumn(name="user_id",referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="role_id" ,referencedColumnName="id")		
			)
	Set<Role> role;



	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}



	
	
	}

	
	

