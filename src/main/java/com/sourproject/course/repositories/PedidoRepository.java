package com.sourproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourproject.course.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>  {

}
