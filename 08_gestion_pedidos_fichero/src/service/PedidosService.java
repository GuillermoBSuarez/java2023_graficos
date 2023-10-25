package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import model.Pedido;

public class PedidosService {

	String dir = "c:\\temp\\pedidos.txt";
	Path path;

	// CONSTRUCTOR
	public PedidosService() {
		File file = new File(dir);
		if (!file.exists()) {				// Si el fichero no existe...
			try { file.createNewFile(); }	// ... lo creamos.
			catch (IOException e) { e.printStackTrace(); }
		}
		path = Path.of(dir); // Creamos aquí el path para no tener que crearlo en cada método.
	}
	
	private Stream<Pedido> getPedidos(){					// Para aligerar código en los métodos de lectura,
		try{												// quitándoles también el try-catch
			return Files.lines(path)						// Stream<String>
					.map( s -> new Pedido(
							s.split("[,-]")[0],
							LocalDate.parse(s.split(",")[1]),
							Double.parseDouble(s.split(",")[2]))); //Stream<Pedido>
		} catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	} 

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

	public Pedido pedidoMasReciente() {
		return getPedidos()
			.max((a, b) -> a.getFechaPedido().compareTo(b.getFechaPedido()))
			.orElse(null);
	}

	public List<Pedido> pedidosPrecio(double precioMax) {
		return getPedidos()
			.filter( p -> p.getPrecio()<=precioMax )
			.toList();
	}

	public List<Pedido> anteriores(int meses) {
		return getPedidos()
			.filter( p -> p.getFechaPedido().isBefore(LocalDate.now().minusMonths(meses)) )
			.toList();	}
}