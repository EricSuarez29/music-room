package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.BranchOffice;
import com.javeros.musicroom.models.Schedule;
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
	
	@PostMapping
	public String createSchedule(Schedule schedule) {
    	repository.save(schedule);
    	return"redirect:/schedule";
    }
	
	@GetMapping("/form")
	public String showFormReservations(Schedule schedule,Model model) {
		model.addAttribute("title", "Horarios");
		return "schedule/schedule-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/schedule";
	}
	
	@GetMapping("/edit/{id}")
	public String getScheduleToEdit(@PathVariable("id") Long id, Model model) {
		Schedule schedule = repository.getById(id);
		model.addAttribute("schedule", schedule);
		return "schedule/schedule-form";
	}
}
