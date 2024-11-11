package com.mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity


public class Mobile {
	
	
	   @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int id;
	    
	  
	    private String mobileName;


		public Mobile() {
			super();
			// TODO Auto-generated constructor stub
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getMobileName() {
			return mobileName;
		}


		public void setMobileName(String mobileName) {
			this.mobileName = mobileName;
		}
	 
	    
	    
	    
	}
	
