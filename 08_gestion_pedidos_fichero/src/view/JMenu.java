package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenu frame = new JMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JMenu() {
		setTitle("Gestión de pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo pedido");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNuevo.setBounds(10, 11, 99, 23);
		contentPane.add(btnNuevo);
		
		JButton btnReciente = new JButton("Último pedido");
		btnReciente.setBounds(10, 45, 99, 23);
		contentPane.add(btnReciente);
		
		JButton btnTodos = new JButton("Listar pedidos");
		btnTodos.setBounds(10, 79, 99, 23);
		contentPane.add(btnTodos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 227, 99, 23);
		contentPane.add(btnSalir);
	}
}
