package com.javeros.musicroom.models;

import java.io.Serializable;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 45, nullable = false)
	private String name;
	
	@Column(length = 45)
	private String lastName;
	
	@Column(length = 10)
	private String phone;
	
	@Column(name = "create_at")
	private LocalDate createAt;
	
	private Integer status; //Estatus del cliente
	
	@JoinColumn(name = "user_id")
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Customer() {}

	public Customer(Long id, String name, String lastName, String phone, LocalDate createAt, User user) 
	{
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.createAt = createAt;
		this.user = user;
	}
	
	@PrePersist
	public void init() {
		this.createAt = LocalDate.now();
		this.status = 1;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	private static final long serialVersionUID = 1L;
}
