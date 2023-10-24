package presentación;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculadora extends JFrame {
	public Calculadora() {
		super("Calculadora");
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setBounds(100, 100, 320, 400);
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
	}
}
