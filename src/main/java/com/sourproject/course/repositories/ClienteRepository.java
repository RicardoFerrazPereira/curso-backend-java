package com.sourproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourproject.course.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
