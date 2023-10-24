package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyWindow extends JFrame {
	public MyWindow() {
		super("Primera ventana");
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(10, 10, 500, 300);
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		this.setLayout(null);

		JButton jb1 = new JButton("Pulsar aquí");
		jb1.setBounds(100, 50, 150, 40);
		JLabel jl1 = new JLabel();
		jl1.setBounds(120, 120, 200, 30);
		this.add(jb1);
		this.add(jl1);
		
		// EVENTOS
		// Creamos la clase manejadora y se lo asignamos al manejador, el botón:
		// 		ActionListener al = a -> jl1.setText("Pulsado");
		// 		jb1.addActionListener(al);
		// O en un solo paso, puesto que la lambda ya es la implementación de una interfaz funcional.
		jb1.addActionListener( a -> jl1.setText("CLICADO") );
	}
}