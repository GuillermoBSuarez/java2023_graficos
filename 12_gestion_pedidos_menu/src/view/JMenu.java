package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidosService;
import view.adapters.ListaPedidosModel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JMenu extends JFrame {
	
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

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	PedidosService ps = new PedidosService();


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
		setBounds(100, 100, 323, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo pedido");
		btnNuevo.setBounds(10, 74, 138, 23);
		contentPane.add(btnNuevo);
		JButton btnReciente = new JButton("Último pedido");
		btnReciente.setBounds(10, 108, 138, 23);
		contentPane.add(btnReciente);
		JButton btnTodos = new JButton("Listar pedidos");
		btnTodos.setBounds(10, 142, 138, 23);
		contentPane.add(btnTodos);
		JButton btnBorrar = new JButton("Borrar pedido");
		btnBorrar.setBounds(10, 176, 138, 23);
		contentPane.add(btnBorrar);
		btnBorrar.setEnabled(false);
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 227, 99, 23);
		contentPane.add(btnSalir);
		JScrollPane scrollPane = new JScrollPane();
		JList<Pedido> lstPedidos = new JList();
		scrollPane.setViewportView(lstPedidos);
		scrollPane.setBounds(158, 79, 138, 171);
		contentPane.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		contentPane.add(menuBar);
		
		javax.swing.JMenu menuPedidos = new javax.swing.JMenu("Pedidos");
		menuBar.add(menuPedidos);
		
		JMenuItem itemPedidosNuevo = new JMenuItem("Nuevo");
		itemPedidosNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JNuevoPedido();
			}
		});
		menuPedidos.add(itemPedidosNuevo);
		
		JMenuItem itemPedidosReciente = new JMenuItem("Reciente");
		itemPedidosReciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JReciente();
			}
		});
		menuPedidos.add(itemPedidosReciente);
		
		JMenuItem itemPedidosTodos = new JMenuItem("Mostrar todos");
		itemPedidosTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPedidosModel model = new ListaPedidosModel();
				lstPedidos.setModel(model);
			}
		});
		menuPedidos.add(itemPedidosTodos);
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnReciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		lstPedidos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnBorrar.setEnabled(true);
			}
		});
		
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instanciamos el modelo de datos:
				ListaPedidosModel model = new ListaPedidosModel();
				// Se lo asignamos al list:
				lstPedidos.setModel(model);
					// Con esto se muestra el resultado del método .toString() de la clase Pedido,
					// que es un hash a la dirección de memoria del objeto.
					// Para ver el producto tenemos que sobreescribir ese método
					// en la clase Pedido.
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ps.borrarPedido(lstPedidos.getSelectedValue());
				lstPedidos.setModel(new ListaPedidosModel());		// Para recargar la lista sin el borrado
				btnBorrar.setEnabled(false);						// Deshabilitamos el botón de borrar para evitar errores
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { JMenu.this.dispose(); }
		});
	}
}
