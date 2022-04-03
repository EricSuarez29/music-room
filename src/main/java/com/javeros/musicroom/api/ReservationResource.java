package com.javeros.musicroom.api;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javeros.musicroom.models.Reservation;
import com.javeros.musicroom.models.Schedule;
import com.javeros.musicroom.repository.IReservationRepository;
import com.javeros.musicroom.repository.IScheduleRepository;

@RestController
@RequestMapping("api/reservation")
public class ReservationResource {
	
	private final IReservationRepository repository;
	private final IScheduleRepository scheduleRepository;
	
	@Autowired
	public ReservationResource(IReservationRepository respository, IScheduleRepository scheduleRepository) {
		this.repository = respository;
		this.scheduleRepository = scheduleRepository;
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
	
	@GetMapping("/schedule")
	public ResponseEntity<List<Schedule>> getSchedules(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
		List<Schedule> list = scheduleRepository.findAvailableSchedules(date);
		list.stream().map(Schedule::getStart).forEach(System.out::println);
		return ResponseEntity.ok(list);
	}
}
