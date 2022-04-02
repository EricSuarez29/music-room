package com.javeros.musicroom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeros.musicroom.models.Reservation;
import com.javeros.musicroom.models.Room;
import com.javeros.musicroom.repository.IRoomRepository;

@Controller
@RequestMapping("/test")
public class IndexController {
	
	private final IRoomRepository roomRepository;
	
	@Autowired
	public IndexController(IRoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@GetMapping
	public String showIndex(Model model) {
		model.addAttribute("title", "Music Room");
		return "main";
	}
	
	@GetMapping("/rooms")
	public String showRooms(Model model) {
		model.addAttribute("title", "Salas");
		List<Room> list = roomRepository.findByStatus(1);
		model.addAttribute("list", list);
		return "rooms/rooms";
	}
	
	@GetMapping("/reserve/{idRoom}")
	public String showReserve(@PathVariable("idRoom") Long idRoom, Model model, Reservation reservation) {
		model.addAttribute("title", "Reservar");
		Room room = roomRepository.findById(idRoom).get();
		model.addAttribute("room", room);
		return "reservation/reservation";
	}
}
