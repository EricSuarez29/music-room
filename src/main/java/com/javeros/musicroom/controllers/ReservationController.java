package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.Reservation;
import com.javeros.musicroom.repository.IReservationRepository;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
	
	private final IReservationRepository repository;
	
	
	@Autowired
	public ReservationController(IReservationRepository respository) {
		this.repository = respository;
	}

	@GetMapping
	public String showListReservations(Model model) {
		model.addAttribute("title", "Reservaciones");
		model.addAttribute("list", repository.findByStatus(1));
		return "reservation/reservation-list";
	}
	
	@PostMapping
	public String createReservation(Reservation reservation) {
		repository.save(reservation);
		return "redirect:/reservations";
	}
	
	@GetMapping("/form")
	public String showFormReservations(Reservation reservation, Model model) {
		model.addAttribute("title", "Reservación");
		return "reservation/reservation-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		//repository.deleteById(id);
		repository.setStatusZero(id);
		return "redirect:/reservations";
	}
	
}
