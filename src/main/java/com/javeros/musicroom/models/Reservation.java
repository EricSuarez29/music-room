package com.javeros.musicroom.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Reservation implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	private String message;
	
	private Integer status;
	
	@ManyToMany
	@JoinTable(
			name = "reservation_schedule",
			joinColumns = @JoinColumn(name = "reservation_id"),
			inverseJoinColumns = @JoinColumn(name = "schedule_id")
			)
	private List<Schedule> schedules;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	@PrePersist
	public void init() {
		this.status = 1;
	}
	
	public Reservation() {
	}

	public Reservation(Long id, LocalDate date, String message, Integer status, List<Schedule> horario,
			Customer customer, Room room) {
		this.id = id;
		this.date = date;
		this.message = message;
		this.status = status;
		this.schedules = horario;
		this.customer = customer;
		this.room = room;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	private static final long serialVersionUID = 1L;
}
