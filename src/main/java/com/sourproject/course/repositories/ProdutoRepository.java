package com.sourproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourproject.course.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
