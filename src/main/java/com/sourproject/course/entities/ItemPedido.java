package com.sourproject.course.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sourproject.course.entities.pk.ItemPedidoPK;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id;
	
	private Integer quantity;
	private Double price;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantity, Double price) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantity = quantity;
		this.price = price;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}	
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}	
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
