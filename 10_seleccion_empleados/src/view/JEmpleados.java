package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adaptars.ComboDepartamentosModel;
import view.adaptars.TablaEmpleadosModel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class e2 extends JEmpleados {
//	public Object print() {}
	public String print(int m) {}
//	public void print() {}

}
public class JEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblEmpleados;

	public Object print(int s) {}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEmpleados frame = new JEmpleados();
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
	public JEmpleados() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 127, 351, 64);
		contentPane.add(scrollPane);
		
		tblEmpleados = new JTable();
		scrollPane.setViewportView(tblEmpleados);
		
		JComboBox cmbDptos = new JComboBox();
		cmbDptos.setModel( new ComboDepartamentosModel() );
		cmbDptos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Instanciamos el modelo de datos:
				tblEmpleados.setModel( new TablaEmpleadosModel(cmbDptos.getSelectedItem().toString()) );
			}
		});
		cmbDptos.setBounds(156, 44, 133, 22);
		contentPane.add(cmbDptos);
	}
}
