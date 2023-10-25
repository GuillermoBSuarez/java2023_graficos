package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import model.Pedido;
import service.PedidosService;

public class PedidosMain {
	/*
	Ventana principal:
		- Botón nuevo pedido -> lleva a nueva ventana
				- Lbl producto y txt
				- Lbl Fecha y txt y lbl indicando formato
				- Lbl Precio y txt
				- Botones Guardar y Salir
		- Botón Reciente -> nueva ventana
				- Lbl Producto y valor
				- lbl Fecha y valor
				- lbl precio y valor
				- Botón salir
		- Botón todos -> abre un textArea y los lista
		- Botón salir
	 */
	
	
	static PedidosService pedidosService=new PedidosService();
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		int opcion;
		do {
			mostrarMenu();
			try {
				opcion=Integer.parseInt(sc.nextLine());//lee la opción elegida
				switch(opcion) { //evaluamos
					case 1:
						grabarPedido();
						break;
					case 2:
						buscarPedidoReciente();
						break;
					case 3:
						mostrarPedidos();
						break;
					case 4:
						mostrarPedidosAnteriores();
						break;
					
					case 5:
						System.out.println("---Adios---");
				}
			}
			catch(NumberFormatException ex) {
				ex.printStackTrace();
				System.out.println("Debes elegir opción correcta");
				opcion=0; //para que vuelva a generar el bucle
			}
		}while(opcion!=5);

	}
	static void mostrarMenu() {
		System.out.println("1.- Nuevo pedido");
		System.out.println("2.- Pedido más reciente");
		System.out.println("3.- Mostrar todos");
		System.out.println("4.- Mostrar pedidos anteriores");
		System.out.println("5.- Salir");
		
	}
	static void grabarPedido()  {
		Scanner sc=new Scanner(System.in);
		//para el parseado de fechas
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String producto;
		LocalDate fecha;
		double precio;
		System.out.println("Introduce producto");
		producto=sc.nextLine();
		System.out.println("Introduce fecha (dia/mes/año)");	
		try {
			fecha=LocalDate.parse(sc.nextLine(),format);
			System.out.println("Introduce precio");
			precio=Double.parseDouble(sc.nextLine());		
			pedidosService.guardarPedido(producto, fecha, precio);
		}
		catch(DateTimeParseException ex) {
			
			System.out.println("La fecha no es válida y el pedido no se guardará");
		}
	}
	static void buscarPedidoReciente() {
		Pedido pedido=pedidosService.pedidoMasReciente();
		System.out.println("Producto: "+pedido.getProducto());
		System.out.println("Fecha: "+pedido.getFechaPedido());
		System.out.println("Precio: "+pedido.getPrecio());
	}
	static void mostrarPedidos() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce precio máximo");
		double precioMax=Double.parseDouble(sc.nextLine());
		List<Pedido> pedidos=pedidosService.pedidosPrecio(precioMax);
		for(Pedido p:pedidos) {
			System.out.println("Producto: "+p.getProducto());
			System.out.println("Fecha: "+p.getFechaPedido());
			System.out.println("Precio: "+p.getPrecio());
			//System.out.println("Pedido "+p); //llama al toString() de Pedido
		}
	}
	static void mostrarPedidosAnteriores() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce meses");
		int meses=Integer.parseInt(sc.nextLine());
		List<Pedido> pedidos=pedidosService.anteriores(meses);
		for(Pedido p:pedidos) {
			System.out.println("Producto: "+p.getProducto());
			System.out.println("Fecha: "+p.getFechaPedido());
			System.out.println("Precio: "+p.getPrecio());
			//System.out.println("Pedido "+p); //llama al toString() de Pedido
		}
	}
	
}
