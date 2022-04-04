package com.javeros.musicroom.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.javeros.musicroom.models.Customer;

import java.util.*;


public interface ICustomerRepository extends JpaRepository<Customer, Long>
{
	@Modifying
	@Transactional
	@Query(value="UPDATE customer SET status = 0 WHERE id =?1", nativeQuery=true)
	int setStatusZero(Long id);
	
	List<Customer> findByStatus(Integer id);
	
	@Query(value="SELECT * FROM customer WHERE name REGEXP ?1 OR last_name REGEXP ?1 AND status = 1", nativeQuery = true)
	List<Customer> findCustomerByFilter(String filter);
}


