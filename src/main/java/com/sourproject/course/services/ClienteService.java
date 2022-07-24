package com.sourproject.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourproject.course.entities.Cliente;
import com.sourproject.course.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Cliente update(Long id, Cliente obj) {
		Cliente entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	public void updateData(Cliente entity, Cliente obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
