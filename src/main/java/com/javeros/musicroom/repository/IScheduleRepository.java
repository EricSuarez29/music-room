package com.javeros.musicroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeros.musicroom.models.Horario;


public interface IScheduleRepository extends JpaRepository<Horario, Long>{
	
}
