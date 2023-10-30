package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidosService;

public class JReciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	PedidosService ps = new PedidosService();

	/**
	 * Create the frame.
	 */
	public JReciente() {
		setTitle("Último pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProducto.setBounds(56, 39, 74, 14);
		contentPane.add(lblProducto);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(56, 73, 74, 14);
		contentPane.add(lblFecha);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(56, 109, 74, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblProductoValor = new JLabel("");
		lblProductoValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductoValor.setBounds(140, 39, 74, 14);
		contentPane.add(lblProductoValor);
		
		JLabel lblFechaValor = new JLabel("");
		lblFechaValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaValor.setBounds(140, 73, 74, 14);
		contentPane.add(lblFechaValor);
		
		JLabel lblPrecioValor = new JLabel("");
		lblPrecioValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioValor.setBounds(140, 109, 74, 14);
		contentPane.add(lblPrecioValor);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { JReciente.this.dispose(); }
		});
		btnSalir.setBounds(116, 227, 89, 23);
		contentPane.add(btnSalir);
		
		// CARGAR EL MÁS RECIENTE
		Pedido reciente = ps.pedidoMasReciente();
		lblProductoValor.setText(reciente.getProducto());
		lblFechaValor.setText(reciente.getFechaPedido().toString());
		lblPrecioValor.setText(reciente.getPrecio()+"");
		
		this.setVisible(true);
	}

}
