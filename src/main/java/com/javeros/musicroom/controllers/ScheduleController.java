package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.repository.IReservationRepository;
import com.javeros.musicroom.repository.IScheduleRepository;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	
	private final IScheduleRepository repository;
	
	
	@Autowired
	public ScheduleController(IScheduleRepository respository) {
		this.repository = respository;
	}

	@GetMapping
	public String showListSchedule(Model model) {
		model.addAttribute("title", "Horarios");
		model.addAttribute("list", repository.findAll());
		return "schedule/schedule-list";
	}
	
	@GetMapping("/form")
	public String showFormReservations(Model model) {
		model.addAttribute("title", "Horarios");
		return "schedule/schedule-form";
	}
}
