package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.repository.IReservationRepository;
import com.javeros.musicroom.repository.IRoomRepository;

@Controller
@RequestMapping("/rooms")
public class RoomsController {
	
private final IRoomRepository repository;
	
	
	@Autowired
	public RoomsController(IRoomRepository respository) {
		this.repository = respository;
	}
	
    @GetMapping
	public String showListSalas(Model model) {
		
		model.addAttribute("title", "Salas");
		model.addAttribute("list", repository.findAll());
		
		return"rooms/rooms-list";
	}
	
    
	@GetMapping("/form")
	public String showFormReservations(Model model) {
		model.addAttribute("title", "Salas");
		return "rooms/rooms-form";
	}
    
    
    
}
