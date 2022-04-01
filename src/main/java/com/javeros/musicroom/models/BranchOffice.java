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
@Table(name = "branch_office")
public class BranchOffice implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45, nullable = false)
	private String name;
	private Double length;
	private Double latitud;
	private Integer status;
	
	@Column(length = 100)
	private String address;
	
	@PrePersist
	public void init() {
		this.status=1;
	}

	public BranchOffice(Long id, String name, Double length, Double latitud, Integer status, String address) {
		this.id = id;
		this.name = name;
		this.length = length;
		this.latitud = latitud;
		this.status = status;
		this.address = address;
	}

	public BranchOffice() {
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

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private static final long serialVersionUID = 1L;
}
