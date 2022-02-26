package com.javeros.musicroom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

	@GetMapping
	public String showListReservations(Model model) {
		model.addAttribute("title", "Reservaciones");
		return "reservation/reservation-list";
	}
	
	@GetMapping("/form")
	public String showFormReservations(Model model) {
		model.addAttribute("title", "Reservación");
		return "reservation/reservation-form";
	}
}
