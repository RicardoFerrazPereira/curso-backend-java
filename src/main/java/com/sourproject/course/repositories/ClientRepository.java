package com.sourproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourproject.course.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
