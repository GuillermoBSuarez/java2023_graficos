package presentacion;

import javax.swing.JFrame;

public class MyWindow extends JFrame {
	public MyWindow() {
		
		// Como hereda de JFrame, no hace falta crear un objeto JFrame para usar
		// sus métodos, ya están en la clase. Llamamos a la clase padre
		// con el parámetro para el título de la ventana.
		super("Primera ventana");
		// Por defecto, cerrar ventana no la cierra, sólo la oculta. Se puede cambiar ese comportamiento.
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// x e y son la esquina superior izquierda de la ventana.
		// Los siguientes, su tamaño.
		this.setBounds(10, 10, 500, 300);
		
		// Hacer visible.
		this.setVisible(true);
		
		// Siendo java, aún es necesario un main que muestre la ventana.
		// En una nueva clase.
	}

}
