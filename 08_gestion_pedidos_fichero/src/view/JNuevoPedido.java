package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import service.PedidosService;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JNuevoPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProducto;
	private JTextField txtFecha;
	private JTextField txtPrecio;
	PedidosService ps = new PedidosService();

	/**
	 * Create the frame.
	 */
	public JNuevoPedido() {
		setTitle("Nuevo pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProducto.setBounds(59, 40, 74, 14);
		contentPane.add(lblProducto);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(59, 74, 74, 14);
		contentPane.add(lblFecha);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(59, 110, 74, 14);
		contentPane.add(lblPrecio);
		
		txtProducto = new JTextField();
		txtProducto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtProducto.selectAll();							// Se selecciona el texto al recibir el foco.
			}
		});
		txtProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtProducto.setBounds(143, 37, 104, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtFecha.selectAll();							// Se selecciona el texto al recibir el foco.
			}
		});
		txtFecha.setToolTipText("");
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setColumns(10);
		txtFecha.setBounds(143, 71, 104, 20);
		contentPane.add(txtFecha);
		
		txtPrecio = new JTextField();
		txtPrecio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPrecio.selectAll();							// Se selecciona el texto al recibir el foco.
			}
		});
		txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(143, 107, 104, 20);
		contentPane.add(txtPrecio);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ps.guardarPedido( txtProducto.getText(),
								  LocalDate.parse(txtFecha.getText()),
								  Double.parseDouble(txtPrecio.getText()) );
				txtProducto.setText("");
				txtFecha.setText("");
				txtPrecio.setText("");
				txtProducto.requestFocus();
			}
		});
		btnGuardar.setBounds(116, 162, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { JNuevoPedido.this.dispose(); }
		});
		btnSalir.setBounds(116, 227, 89, 23);
		contentPane.add(btnSalir);
		
		this.setVisible(true);
	}
}
