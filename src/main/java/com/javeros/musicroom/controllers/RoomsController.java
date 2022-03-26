package com.javeros.musicroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.Room;
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
		model.addAttribute("list", repository.findByStatus(1));
		
		return"rooms/rooms-list";
	}
    
    @PostMapping
    public String createRoom(Room room) {
    	
    	repository.save(room);
    	return "redirect:/rooms";
    }
	
    
	@GetMapping("/form")
	public String showFormReservations(Room room,Model model) {
		model.addAttribute("title", "Salas");
		return "rooms/rooms-form";
	}
    
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") long id) {
		
		repository.setStatusZero(id);
		return "redirect:/rooms";
	}
    
    
}
