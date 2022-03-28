package com.javeros.musicroom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.BranchOffice;
import com.javeros.musicroom.models.Room;
import com.javeros.musicroom.repository.IRoomRepository;
import com.javeros.musicroom.repository.ISucursalesRepository;

@Controller
@RequestMapping("/rooms")
public class RoomsController {
	
	private final IRoomRepository roomRepository;
	private final ISucursalesRepository branchRepository;
	
	@Autowired
	public RoomsController(IRoomRepository roomRepository, ISucursalesRepository branchRepository) {
		this.roomRepository = roomRepository;
		this.branchRepository = branchRepository;
	}
	
	@ModelAttribute("branchoffices")
	public List<BranchOffice> branchOffices(){
		List<BranchOffice> list = branchRepository.findAll();
		return list;
	}
	
    @GetMapping
	public String showListSalas(Model model) {
		model.addAttribute("title", "Salas");
		model.addAttribute("list", roomRepository.findByStatus(1));
		return"rooms/rooms-list";
	}
    
    @PostMapping
    public String createRoom(Room room) {
    	
    	roomRepository.save(room);
    	return "redirect:/rooms";
    }
	
    
	@GetMapping("/form")
	public String showFormReservations(Room room,Model model) {
		model.addAttribute("title", "Salas");
		return "rooms/rooms-form";
	}
    
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") long id) {
		
		roomRepository.setStatusZero(id);
		return "redirect:/rooms";
	}
    
}
