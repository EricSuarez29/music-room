package com.javeros.musicroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.javeros.musicroom.models.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {

	
	
}
