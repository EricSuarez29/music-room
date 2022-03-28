package com.javeros.musicroom.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeros.musicroom.models.Reservation;
import com.javeros.musicroom.repository.IReservationRepository;

@RestController
@RequestMapping("api/reservation")
public class ReservationResource {
	
	private final IReservationRepository repository;
	
	@Autowired
	public ReservationResource(IReservationRepository respository) {
		this.repository = respository;
	}
	
	@PostMapping
	public ResponseEntity<Reservation> createReservationApi(@RequestBody Reservation reservation){
		Reservation res = repository.save(reservation);
		return ResponseEntity.ok(res);
	}
	
	@GetMapping
	public ResponseEntity<List<Reservation>> listReservation(){
		List<Reservation> list = repository.findByStatus(1);
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> removeReservation(@PathVariable("id") Long id){
		repository.setStatusZero(id);
		return ResponseEntity.ok(null);
	}
}
