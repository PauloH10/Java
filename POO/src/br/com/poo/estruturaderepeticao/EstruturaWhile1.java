package br.com.poo.estruturaderepeticao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstruturaWhile1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtInicial;
	private JTextField txtFinal;
	
	String dados = "";
	int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstruturaWhile1 frame = new EstruturaWhile1();
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
	public EstruturaWhile1() {
		setResizable(false);
		setBackground(new Color(0, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número Inicial");
		lblNewLabel.setBounds(10, 28, 291, 60);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(lblNewLabel);
		
		txtInicial = new JTextField();
		txtInicial.setBounds(173, 46, 86, 20);
		contentPane.add(txtInicial);
		txtInicial.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Número Final");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(10, 68, 143, 93);
		contentPane.add(lblNewLabel_1);
		
		txtFinal = new JTextField();
		txtFinal.setBounds(173, 99, 86, 20);
		contentPane.add(txtFinal);
		txtFinal.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 213, 169, 145);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				i = Integer.parseInt(txtInicial.getText());
				
				while(i <= Integer.parseInt(txtFinal.getText())) {
					dados += i +"\n";
					i++;
				}
				txtResultado.setText(dados);
				lblNewLabel.setText("");
				txtInicial.setText("");
				dados = "";
			}
		});
		btnExecutar.setBounds(45, 154, 214, 23);
		contentPane.add(btnExecutar);
	}
}
