package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;

	/** Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
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
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Número 1");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl1.setBounds(134, 40, 66, 14);
		contentPane.add(lbl1);
		
		txt1 = new JTextField();
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setBounds(120, 65, 86, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setColumns(10);
		txt2.setBounds(234, 65, 86, 20);
		contentPane.add(txt2);
		
		JLabel lblResul = new JLabel("RESULTADO");
		
		JButton bSum = new JButton("Sumar");
		bSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResul.setText(
						Integer.parseInt(txt1.getText()) + Integer.parseInt(txt2.getText()) + "" );
			}
		});
		bSum.setBounds(120, 119, 89, 23);
		contentPane.add(bSum);
		
		JButton bMult = new JButton("Multiplicar");
		bMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResul.setText(
						Integer.parseInt(txt1.getText()) * Integer.parseInt(txt2.getText()) + "" );
			}
		});
		bMult.setBounds(231, 119, 89, 23);
		contentPane.add(bMult);
		
		lblResul.setHorizontalAlignment(SwingConstants.CENTER);
		lblResul.setBounds(175, 170, 86, 14);
		contentPane.add(lblResul);
		
		JButton bSalir = new JButton("Salir");
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog( JCalculadora.this,
														  "¿Pero seguro, seguro?",
														  "Pirarse",
														  JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) { JCalculadora.this.dispose(); }
			}
		});
		bSalir.setBounds(172, 210, 89, 23);
		contentPane.add(bSalir);
		
		JLabel lbl2 = new JLabel("Número 2");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl2.setBounds(244, 40, 66, 14);
		contentPane.add(lbl2);
	}
}
