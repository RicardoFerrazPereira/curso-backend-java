package com.sourproject.course.entities.enums;

public enum PedidoStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private PedidoStatus(int code) {
		this.code = code;
	}
	
	// Método publico para acessar o "code"
	public int getCode() {
		return code;
	}
	
	// Converter um valor numérico para um tipo ENUMERADO
	// Método estático vai funcionar sem precisar instanciar
	public static PedidoStatus valueOf(int code) {
		for (PedidoStatus value : PedidoStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código do Status do Pedido Inválido");
	}
}
