package com.sourproject.course.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourproject.course.entities.Client;

@RestController
@RequestMapping("/clients")
public class ClientResource {
	
	@GetMapping
	public ResponseEntity<Client> findAll() {
		Client u = new Client(1L, "Maria", "maria@gmail.com", "1234567", "12345");
		return ResponseEntity.ok().body(u);
	}

}
