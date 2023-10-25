package presentación;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculadora extends JFrame {
	public Calculadora() {
		super("Calculadora");
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setBounds(100, 100, 425, 425);
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		this.setLayout(null);
		
		JLabel lbl1 = new JLabel("Número 1: ");
		lbl1.setBounds(10, 20, 100, 100);
		this.add(lbl1);
		
		JLabel lbl2 = new JLabel("Número 2: ");
		lbl2.setBounds(10, 100, 100, 100);
		this.add(lbl2);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(100, 50, 150, 40);
		this.add(txt1);
		
		JTextField txt2 = new JTextField();
		txt2.setBounds(100, 130, 150, 40);
		this.add(txt2);
		
		JButton bSum = new JButton("Sumar");
		bSum.setBounds(10, 250, 100, 40);
		this.add(bSum);
		
		JButton bMult = new JButton("Multiplicar");
		bMult.setBounds(130, 250, 150, 40);
		this.add(bMult);
		
		JLabel lblResul = new JLabel("");
		lblResul.setBounds(125, 300, 100, 100);
		this.add(lblResul);
		
		JButton bSalir = new JButton("Salir");
		bSalir.setBounds(300, 250, 100, 40);
		this.add(bSalir);
		
		// EVENTOS
		bSum.addActionListener( a -> lblResul.setText(
				Integer.parseInt(txt1.getText()) + Integer.parseInt(txt2.getText())+"") );
		/* addActionListener es un método de la clase JTextField 
		 https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JTextField.html#addActionListener(java.awt.event.ActionListener)
		 que tiene de parámetro la interfaz ActionListener:
		 https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/event/ActionListener.html
		 que sólo tiene un método void, así que podemos implementarla con una función lambda. */
		
		/* CON TRY CATCH POR SI SE INTRODUCEN TEXTOS
		bSum.addActionListener( a -> {
			try {
				lblResul.setText(
						Integer.parseInt(txt1.getText()) + Integer.parseInt(txt2.getText())+""); 
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Numérico solo");
			}
		});
		*/

		lblResul.setText(
				Integer.parseInt(txt1.getText()) + Integer.parseInt(txt2.getText())+"");
		
		
		bMult.addActionListener( a -> lblResul.setText(
				Integer.parseInt(txt1.getText()) * Integer.parseInt(txt2.getText())+""));
		// El +"" es un "truco" para convertir el resultado -que es int- a String, que es lo que
		// espera setText.
		
		txt1.addFocusListener(new FocusListener() {
			/* addFocusListener, método de JTextField:
			 https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/Component.html#addFocusListener(java.awt.event.FocusListener)
			 Implementa la interfaz FocusListener:
			 https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/event/FocusListener.html
			 Tiene dos métodos, que hay que sobreescribir, así que no se puede usar una lambda sino que hay
			 que crear un objeto que la implemente, lo hacemos con una función anónima. */
			
			@Override
			public void focusLost(FocusEvent e) { }
			// De momento no queremos hacer nada al perderse el foco del txt1.
			
			@Override
			public void focusGained(FocusEvent e) { txt1.setText(""); }
		});
		
		txt2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) { }
			
			@Override
			public void focusGained(FocusEvent e) { txt2.setText(""); }
		});
		
		bSalir.addActionListener( a -> {
			int resp = JOptionPane.showConfirmDialog( this,							// Objeto propietario de la ventana de confirmación.
													  "¿Pero seguro, seguro?",		// Mensaje
													  "Confirmación",				// Título de la ventana de confirmación.
													  JOptionPane.YES_NO_OPTION);	// Combinación de opciones, una constante. Hay varias posibles.
			if (resp == JOptionPane.YES_OPTION) { this.dispose(); }
			});
	}
}