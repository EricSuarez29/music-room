package com.javeros.musicroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeros.musicroom.models.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{
	
}
