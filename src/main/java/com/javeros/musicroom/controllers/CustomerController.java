package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.Customer;
import com.javeros.musicroom.repository.ICustomerRepository;

@Controller
@RequestMapping("/customers")
public class CustomerController 
{
	private final ICustomerRepository customerRepository;
	
	@Autowired
	public CustomerController(ICustomerRepository repository) 
	{
		this.customerRepository = repository;
	}
	
	
	@GetMapping
	public String showListCustomer(Customer customer, Model model)
	{
		model.addAttribute("title", "Clientes");
		model.addAttribute("list", customerRepository.findByStatus(1));
		
		return "customers/customers-list";
	}
	
	@PostMapping
	public String registerCustomer(Customer customer)
	{
		customerRepository.save(customer);
		
		return "redirect:/customers";
		
	}
	
	@GetMapping("/edit/{id}") 
	public String getcustomerToEdit (@PathVariable("id") Long id, Model model) 
	{
		Customer customer = customerRepository.getById(id); 
		model.addAttribute("customer", customer); 
		return "customers/customers-form";
	}
	
	@GetMapping("/form")
	public String showFormCustomer(Customer customer, Model model)
	{
		model.addAttribute("title", "Clientes");
		return "customers/customers-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") long id)
	{
		customerRepository.setStatusZero(id);
		return "redirect:/customers";
	}
	

}


