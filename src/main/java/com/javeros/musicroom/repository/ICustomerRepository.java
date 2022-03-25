package com.javeros.musicroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeros.musicroom.models.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Long>
{
}
