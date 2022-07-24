package com.sourproject.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourproject.course.entities.Pedido;
import com.sourproject.course.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repository;
	
	public List<Pedido> findAll() {
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}
	

}
