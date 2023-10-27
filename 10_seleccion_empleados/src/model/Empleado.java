package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data				// Más completo que @Getter y @Setter, pues los incluye además de toString()

public class Empleado {
	private String nombre;
	private String email;
	private double salario;
	private String departamento;
}