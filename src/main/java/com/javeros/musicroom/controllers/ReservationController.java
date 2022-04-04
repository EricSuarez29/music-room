package com.javeros.musicroom.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.Customer;
import com.javeros.musicroom.models.Reservation;
import com.javeros.musicroom.repository.ICustomerRepository;
import com.javeros.musicroom.repository.IReservationRepository;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
	
	private final IReservationRepository repository;
	private final ICustomerRepository customerRepository;
	
	@Autowired
	public ReservationController(
			IReservationRepository respository, 
			ICustomerRepository customerRepository) {
		this.repository = respository;
		this.customerRepository = customerRepository;
	}
	
	@ModelAttribute("customers")
	public List<Customer> getCustomers(){
		return customerRepository.findByStatus(1);
	}
	
	@GetMapping
	public String showListReservations(Model model, @PathParam("status") Integer status) {
		model.addAttribute("title", "Reservaciones");
		List<Reservation> list = null;

		if(status == null) {
			list = repository.findByStatus(1);
		} else {
			list = repository.findByStatus(status);
		}

		model.addAttribute("list", list);
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
		repository.setStatusZero(id);
		return "redirect:/reservations";
	}
	
	@GetMapping("/atend/{id}")
	public String atendById(@PathVariable("id") Long id) {
		repository.atendById(id);
		return "redirect:/reservations";
	}
	
}
