package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.BranchOffice;
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
		model.addAttribute("list", repository.findByStatus(1));
		
		return"sucursales/sucursal-list";
	}
    
    @PostMapping
	public String createSucursal(BranchOffice branchOffice) {
    	repository.save(branchOffice);
    	return "redirect:/branch-offices";
    }
    
	@GetMapping("/form")
	public String showFormReservations(BranchOffice branchOffice,Model model) {
		model.addAttribute("title", "Sucursales");
		return"sucursales/sucursal-form";
	}
    
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		//repository.deleteById(id);
		repository.setStatusZero(id);
		return "redirect:/branch-offices";
	}
	
	@GetMapping("/edit/{id}")
	public String getBranchOfficeToEdit(@PathVariable("id") Long id, Model model) {
		BranchOffice branchOffice = repository.getById(id);
		model.addAttribute("branchOffice", branchOffice);
		return "sucursales/sucursal-form";
	}
    
}