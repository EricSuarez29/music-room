package com.javeros.musicroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeros.musicroom.models.Schedule;


public interface IScheduleRepository extends JpaRepository<Schedule, Long>{
	
}