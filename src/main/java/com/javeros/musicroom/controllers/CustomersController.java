package com.javeros.musicroom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomersController 
{
	@GetMapping
	public String showListCustomers(Model model)
	{
		model.addAttribute("title", "Clientes");
		return "customers/customers-list";
	}
	
	@GetMapping("/form")
	public String showFormCustomers(Model model)
	{
		model.addAttribute("title", "Clientes");
		return "customers/customers-form";
	}
	

}
