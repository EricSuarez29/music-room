package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("list", repository.findAll());
		return "reservation/reservation-list";
	}
	
	@GetMapping("/form")
	public String showFormReservations(Model model) {
		model.addAttribute("title", "Reservación");
		return "reservation/reservation-form";
	}
}
