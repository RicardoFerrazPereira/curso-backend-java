package com.sourproject.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourproject.course.entities.Produto;
import com.sourproject.course.services.ProdutoService;



@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
