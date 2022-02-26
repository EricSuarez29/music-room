package com.javeros.musicroom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomsController {
	
    @GetMapping
	public String showListSalas(Model model) {
		
		model.addAttribute("title", "Salas");
		
		return"rooms/rooms-list";
	}
	
    
	@GetMapping("/form")
	public String showFormReservations(Model model) {
		model.addAttribute("title", "Salas");
		return "rooms/rooms-form";
	}
    
    
    
}
