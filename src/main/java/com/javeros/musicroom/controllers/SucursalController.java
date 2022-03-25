package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.repository.IReservationRepository;
import com.javeros.musicroom.repository.ISucursalesRepository;

@Controller
@RequestMapping("/branch-offices")
public class SucursalController {
	
	private final ISucursalesRepository repository;
	
	
	@Autowired
	public SucursalController(ISucursalesRepository respository) {
		this.repository = respository;
	}
	
    @GetMapping
	public String showListSalas(Model model) {
		
		model.addAttribute("title", "Sucursales");
		model.addAttribute("list", repository.findAll());
		
		return"sucursales/sucursal-list";
	}
	
    
	@GetMapping("/form")
	public String showFormReservations(Model model) {
		model.addAttribute("title", "Sucursales");
		return"sucursales/sucursal-form";
	}
    
    
}