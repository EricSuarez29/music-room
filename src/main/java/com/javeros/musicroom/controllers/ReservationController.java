package com.javeros.musicroom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javeros.musicroom.models.Customer;
import com.javeros.musicroom.models.Reservation;
import com.javeros.musicroom.models.Schedule;
import com.javeros.musicroom.repository.ICustomerRepository;
import com.javeros.musicroom.repository.IReservationRepository;
import com.javeros.musicroom.repository.IScheduleRepository;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
	
	private final IReservationRepository repository;
	private final IScheduleRepository scheduleRepository;
	private final ICustomerRepository customerRepository;
	
	@Autowired
	public ReservationController(
			IReservationRepository respository, 
			IScheduleRepository scheduleRepository,
			ICustomerRepository customerRepository) {
		this.repository = respository;
		this.scheduleRepository = scheduleRepository;
		this.customerRepository = customerRepository;
	}
	
	@ModelAttribute("customers")
	public List<Customer> getCustomers(){
		return customerRepository.findByStatus(1);
	}
	
	@ModelAttribute("schedules")
	public List<Schedule> getSchedules(){
		return scheduleRepository.findAll();
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
