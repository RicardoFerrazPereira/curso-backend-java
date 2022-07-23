package com.sourproject.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sourproject.course.entities.Client;
import com.sourproject.course.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Client u1 = new Client(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Client u2 = new Client(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		clientRepository.saveAll(Arrays.asList(u1, u2));
	}

}
