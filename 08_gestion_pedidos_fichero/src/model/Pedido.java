package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pedido {
	private String producto;
	private LocalDate fechaPedido;
	private double precio;
	@Override
	public String toString() { return producto; }
}