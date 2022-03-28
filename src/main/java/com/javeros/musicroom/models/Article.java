package com.javeros.musicroom.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table
public class Article implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45, nullable = false)
	private String name;
	
	@Column(length = 45)
	private String model;
	
	@Column(length = 45)
	private String branch;
	
	private Integer status;
	
	@PrePersist
	public void init() {
		this.status = 1;
	}
	
	public Article() {
	}

	public Article(Long id, String name, String model, String branch, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.branch = branch;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private static final long serialVersionUID = 1L;
}
