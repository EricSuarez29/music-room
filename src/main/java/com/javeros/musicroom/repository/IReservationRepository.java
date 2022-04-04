package com.javeros.musicroom.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.javeros.musicroom.models.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Reservation SET status = 0 WHERE id = ?1", nativeQuery = true)
	int setStatusZero(Long id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Reservation SET status = 2 WHERE id = ?1", nativeQuery = true)
	int atendById(Long id);
	
	List<Reservation> findByStatus(Integer id);
}
