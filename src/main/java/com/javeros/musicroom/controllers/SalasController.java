package com.javeros.musicroom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salas")
public class SalasController {
	
    @GetMapping
	public String showListSalas(Model model) {
		
		model.addAttribute("title", "Salas");
		
		return"salas/salas-list";
	}
	
    
	@GetMapping("/form")
	public String showFormReservations(Model model) {
		model.addAttribute("title", "Salas");
		return "salas/salas-form";
	}
    
    
    
}
