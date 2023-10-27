package service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Empleado;

public class EmpleadosService {

	private Stream<Empleado> getEmpleados(){
		String ruta="c:\\temp\\empleados.json";
		Gson gson=new Gson();
		try( FileReader fr = new FileReader(ruta); ) {
			Empleado[] empleados = gson.fromJson(fr, Empleado[].class);
			return Arrays.stream(empleados);
		} catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	public List<Empleado> empleados(){
		return getEmpleados() //Stream<Empleado>
				.collect(Collectors.toList());
	} 

	/*
	public void guardarPedido(String producto, LocalDate fechaPedido, double precio) {
		try {
			Files.writeString(
					path,
					( producto + "," +
					  fechaPedido + "," +
					  precio
					) + System.lineSeparator(),		// Constante que añade un salto de línea en cualquier lenguaje.
					StandardOpenOption.APPEND);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// throws IOException en la declaración de la función nos evitaría tener que
		// poner el try-catch,
		// pero enviaría las posibles excepciones al main, que debería incluir su
		// gestión,
		// y "bastante tiene" ya el pobre.
	}

	public Empleado pedidoMasReciente() {
		return getPedidos()
			.max((a, b) -> a.getFechaPedido().compareTo(b.getFechaPedido()))
			.orElse(null);
	}

	public List<Empleado> pedidosPrecio(double precioMax) {
		return getPedidos()
			.filter( p -> p.getPrecio()<=precioMax )
			.toList();
	}

	public List<Empleado> anteriores(int meses) {
		return getPedidos()
			.filter( p -> p.getFechaPedido().isBefore(LocalDate.now().minusMonths(meses)) )
			.toList();	}
	
	public List<Empleado> todos() {
		return getPedidos().toList();
	}
	
	public void borrarPedido(Empleado pedido) {
		List<String> pedidosSinPedido = getPedidos()								// Stream<Pedido>
				.filter( p -> !(p.getProducto().equals(pedido.getProducto())
						  	 && p.getFechaPedido().equals(pedido.getFechaPedido())
						  	 && p.getPrecio() == (pedido.getPrecio()) ) )			// Stream<Pedido>
				.map( p -> p.getProducto() + ","
						 + p.getFechaPedido() + ","
						 + p.getPrecio() )											// Stream<String>
				.collect(Collectors.toList());										// List<String>
			 // .toList(); 		Sólo a partir de java 17
		try { Files.write( path, pedidosSinPedido ); }
		catch (IOException ex) { ex.printStackTrace(); }			
	}*/
}	