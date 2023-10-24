package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow extends JFrame {
	public MyWindow() {
		
		// Como hereda de JFrame, no hace falta crear un objeto JFrame para usar
		// sus métodos, ya están en la clase. Llamamos a la clase padre
		// con el parámetro para el título de la ventana.
		super("Primera ventana");
		// Por defecto, cerrar ventana no la cierra, sólo la oculta. Se puede cambiar ese comportamiento.
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// x e y son la esquina superior izquierda de la ventana.
		// Los siguientes, su tamaño.
		this.setBounds(10, 10, 500, 300);
		
		// Llamada a método que carga controles en ventana
		initComponents();
		
		// Hacer visible.
		this.setVisible(true);
		
		// Siendo java, aún es necesario un main que muestre la ventana.
		// En una nueva clase.
	}

	private void initComponents() {
		// Anulamos el gestor de organización por defecto para que no maximice el botón a la ventana.
		this.setLayout(null);

		JButton jb1 = new JButton("Pulsar aquí");
		jb1.setBounds(100, 50, 150, 40);
		this.add(jb1);								// Añadir a la ventana
	}
}