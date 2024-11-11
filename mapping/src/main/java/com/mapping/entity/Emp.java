package com.mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity


public class Emp {

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int id;
	    
	  
	    private String empName;
	  
	    
	    @OneToOne
	    private Mobile mobile;

	    
	    
	    

		public Emp() {
			super();
			// TODO Auto-generated constructor stub
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getEmpName() {
			return empName;
		}


		public void setEmpName(String empName) {
			this.empName = empName;
		}
	    
	 
	    
	     
	}
 

