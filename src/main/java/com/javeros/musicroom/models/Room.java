package com.javeros.musicroom.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Room implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45, nullable = false)
	private String name;

	@Column(length = 35, nullable = false)
	private String type;

	private String description;
	
	@Column(name = "price_hour", nullable = false)
	private Double priceHour;
	
	private Integer status;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RoomArticle> roomArticles;
	
	@JoinColumn(name = "sucursal_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private BranchOffice sucursal;

	public Room(Long id, String name, String type, String description, Double priceHour, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.priceHour = priceHour;
		this.status = status;
	}

	public Room() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPriceHour() {
		return priceHour;
	}

	public void setPriceHour(Double priceHour) {
		this.priceHour = priceHour;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoomArticle> getRoomArticles() {
		return roomArticles;
	}

	public void setRoomArticles(List<RoomArticle> roomArticles) {
		this.roomArticles = roomArticles;
	}

	public BranchOffice getSucursal() {
		return sucursal;
	}

	public void setSucursal(BranchOffice sucursal) {
		this.sucursal = sucursal;
	}

	private static final long serialVersionUID = 1L;
}
