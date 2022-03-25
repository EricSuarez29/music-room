package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.repository.ICustomerRepository;
import com.javeros.musicroom.repository.IReservationRepository;

@Controller
@RequestMapping("/customers")
public class CustomersController 
{
	private final ICustomerRepository repository;
	
	@Autowired
	public CustomersController(ICustomerRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping
	public String showListCustomers(Model model)
	{
		model.addAttribute("title", "Clientes");
		model.addAttribute("list", repository.findAll());
		return "customers/customers-list";
	}
	
	@GetMapping("/form")
	public String showFormCustomers(Model model)
	{
		model.addAttribute("title", "Clientes");
		return "customers/customers-form";
	}
	

}
