package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qualtrics_details")
public class QualtricsDetails {
	public QualtricsDetails() {
		super();
	}
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "flowname")
	private String flowname;
	
	@Column(name="flowregion")
	private String flowregion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlowname() {
		return flowname;
	}
	public void setFlowname(String flowname) {
		this.flowname = flowname;
	}
	public String getFlowregion() {
		return flowregion;
	}
	public void setFlowregion(String flowregion) {
		this.flowregion = flowregion;
	}


}
