package com.sourproject.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sourproject.course.entities.enums.PedidoStatus;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	//ENUM 
	//private PedidoStatus pedidoStatus;
	private Integer pedidoStatus;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;	
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itensPedido = new HashSet<>();	
	
	//Relação com Pagamento
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido () {
		
	}

	public Pedido(Long id, Instant moment, PedidoStatus pedidoStatus, Cliente cliente) {
		super();
		this.id = id;
		this.moment = moment;
		setPedidoStatus(pedidoStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	//Converter o número inteiro para 'ordemStatus'
	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if (pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCode();
		}
	}		

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemPedido> getItems() {
		return itensPedido;
	}
	
	// Método Total Pedido
	
	public Double getTotal() {
		double sum = 0.0;
		for (ItemPedido x : itensPedido) {
			sum += x.getSubTotal();
		}
		return sum;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
}
