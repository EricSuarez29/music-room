package com.javeros.musicroom.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.javeros.musicroom.models.BranchOffice;


public interface ISucursalesRepository extends JpaRepository<BranchOffice, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE branch_office SET status = 0 WHERE id = ?1", nativeQuery = true)
	int setStatusZero(long id);
	
	List<BranchOffice> findByStatus(Integer id);
}
