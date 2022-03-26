package com.javeros.musicroom.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.javeros.musicroom.models.Room;

import java.util.*;

public interface IRoomRepository extends JpaRepository<Room, Long> {

	@Modifying
	@Transactional
	@Query(value="UPDATE room SET status =0 WHERE id =?1", nativeQuery=true)
	int setStatusZero(Long id);
	
	List <Room> findByStatus(Integer id);
}
