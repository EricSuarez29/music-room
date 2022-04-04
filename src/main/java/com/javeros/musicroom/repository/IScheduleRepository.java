package com.javeros.musicroom.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javeros.musicroom.models.Schedule;


public interface IScheduleRepository extends JpaRepository<Schedule, Long>{

	@Query(value = "SELECT * FROM schedule "
			+ "WHERE NOT id IN "
			+ "( SELECT schedule_id FROM reservation_schedule RS "
			+ "INNER JOIN reservation R "
			+ "ON R.id = RS.reservation_id "
			+ "WHERE DATE_FORMAT(R.date, \"%d-%m-%Y\") LIKE DATE_FORMAT(?1, \"%d-%m-%Y\") "
			+ "AND R.room_id = ?2"
			+ ")", nativeQuery = true)
	List<Schedule> findAvailableSchedules(LocalDate date, Long id);
}
