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
import javax.persistence.Table;

@Entity
@Table
public class Reservation implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Double length;
	
	@Column(nullable = false)
	private LocalDate date;
	
	private String message;
	
	@ManyToMany
	@JoinTable(
			name = "reservation_horario",
			joinColumns = @JoinColumn(name = "reservation_id"),
			inverseJoinColumns = @JoinColumn(name = "horario_id")
			)
	private List<Horario> horario;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Reservation() {
	}

	public Reservation(Long id, Double length, LocalDate date, String message, List<Horario> horario) {
		this.id = id;
		this.length = length;
		this.date = date;
		this.message = message;
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
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

	public List<Horario> getHorario() {
		return horario;
	}
	
	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}

	private static final long serialVersionUID = 1L;
}
