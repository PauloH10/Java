package br.com.poo.imagens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Padaria extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField txtValorUnitario;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtCodigoProduto;
	private JTextField txtQuantidade;
	private JTextField txtTotalItem;
	private JTextField txtSubTotal;
	private JTextArea txtNota;
	private String 	cabecalho;
	private int item;
	private double valorPagar;
	private JLabel lblValorPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Padaria frame = new Padaria();
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
	public Padaria() {
		valorPagar = 0.0;
		item =1;
		
		cabecalho = "\t\t\t   Bom pão"+
				"\n\t\t Av. Paulo Souza, 5987 - Vila Mariana"+
				"\n\t\tCEP :  02314-234 - Salvador - BA"+
				"\n\t\tCNPJ:  12.354.534/2656.-56"+
				"\n\t\tIE:    437.65345.3566"+
				"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
				"\n\t\t\t   CUPOM FISCAL"+
				"\n\nItem\tCodigo\tDescricao\t\tQTD\tVL.Unit.\t\tVL.Total"+
				"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
	
		
		String[][] produtos = {
				
				{"2023","Pão Francês","13.00","17032023"},
				{"2024","Pão de Leite","15.00","14032024"},
				{"2025","Torta de Frango","50.00","17032025"},
				{"2026","Leite Integral","5.00","17032026"},
				{"2027","Manteiga","5.00","17032027"},
				{"2028","Bolo","20.00","17032028"},
				{"2029","Bauru","12.00","17032029"},
				{"2030","Suco Laranja","7.00","17032030"},
				
				
		};
		
		
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEsquerdo = new JPanel();
		pnlEsquerdo.setBackground(Color.LIGHT_GRAY);
		pnlEsquerdo.setBounds(0, 0, 800, 700);
		contentPane.add(pnlEsquerdo);
		pnlEsquerdo.setLayout(null);
		
		JLabel PãoBom = new JLabel("New label");
		PãoBom.setIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/imagens/logodepadaria.png")));
		PãoBom.setBounds(111, 0, 1211, 338);
		pnlEsquerdo.add(PãoBom);
		
		JLabel lblCodigoproduto = new JLabel("Código do produto:");
		lblCodigoproduto.setBounds(55, 335, 256, 70);
		pnlEsquerdo.add(lblCodigoproduto);
		lblCodigoproduto.setFont(new Font("Arial", Font.BOLD, 21));
		
		JLabel lblCodigoBarras = new JLabel("Código de Barras:");
		lblCodigoBarras.setFont(new Font("Arial", Font.BOLD, 21));
		lblCodigoBarras.setBounds(456, 349, 256, 50);
		pnlEsquerdo.add(lblCodigoBarras);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setBackground(Color.LIGHT_GRAY);
		txtValorUnitario.setBounds(55, 568, 138, 26);
		pnlEsquerdo.add(txtValorUnitario);
		txtValorUnitario.setColumns(10);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBackground(Color.LIGHT_GRAY);
		txtCodigoBarras.setColumns(10);
		txtCodigoBarras.setBounds(456, 403, 189, 26);
		pnlEsquerdo.add(txtCodigoBarras);
		
		txtDescricao = new JTextField();
		txtDescricao.setBackground(Color.LIGHT_GRAY);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(55, 488, 590, 26);
		pnlEsquerdo.add(txtDescricao);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 21));
		lblDescricao.setBounds(55, 420, 256, 70);
		pnlEsquerdo.add(lblDescricao);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitario");
		lblValorUnitario.setFont(new Font("Arial", Font.BOLD, 21));
		lblValorUnitario.setBounds(55, 513, 155, 70);
		pnlEsquerdo.add(lblValorUnitario);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 21));
		lblQuantidade.setBounds(291, 513, 122, 70);
		pnlEsquerdo.add(lblQuantidade);
		
		JLabel lblTotalItem = new JLabel("Total item");
		lblTotalItem.setFont(new Font("Arial", Font.BOLD, 21));
		lblTotalItem.setBounds(523, 513, 122, 70);
		pnlEsquerdo.add(lblTotalItem);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				for (int linha = 0 ; linha < produtos.length ; linha ++) {
					
					for (int coluna = 0 ; coluna < produtos[0].length; coluna++) {
						if	(txtCodigoProduto.getText().equals (produtos [linha] [0])) {
							 txtCodigoBarras.setText(produtos[linha][3]);
							 txtDescricao.setText(produtos [linha] [1]);
							 txtValorUnitario.setText(produtos [linha] [2]);
							 break;
							 
					}
				}
				}
				
			}
		}
		);
		txtCodigoProduto.setBackground(Color.LIGHT_GRAY);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBounds(55, 403, 189, 26);
		pnlEsquerdo.add(txtCodigoProduto);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				txtTotalItem.setText(""+
						Double.parseDouble(txtQuantidade.getText())*
						Double.parseDouble(txtValorUnitario.getText())
						);
				txtSubTotal.setText("R$"+
						Double.parseDouble(txtQuantidade.getText())*
						Double.parseDouble(txtValorUnitario.getText())
						); 
				
			}
		});
		txtQuantidade.setBackground(Color.LIGHT_GRAY);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(291, 568, 138, 26);
		pnlEsquerdo.add(txtQuantidade);
		
		txtTotalItem = new JTextField();
		txtTotalItem.setBackground(Color.LIGHT_GRAY);
		txtTotalItem.setColumns(10);
		txtTotalItem.setBounds(507, 568, 138, 26);
		pnlEsquerdo.add(txtTotalItem);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setFont(new Font("Arial", Font.BOLD, 21));
		lblSubtotal.setBounds(55, 591, 155, 70);
		pnlEsquerdo.add(lblSubtotal);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBackground(Color.LIGHT_GRAY);
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(171, 635, 222, 54);
		pnlEsquerdo.add(txtSubTotal);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cabecalho+="\n"+item+"\t"+txtCodigoProduto.getText()+
						   	   "\t"+txtDescricao.getText()+
						   	   "\t\t"+txtQuantidade.getText()+
						   	   "\t"+txtValorUnitario.getText()+
						   	   "\t"+txtTotalItem.getText();
			
				txtNota.setText(cabecalho);
				item++;
				
				valorPagar += Double.parseDouble(txtTotalItem.getText());
				lblValorPagar.setText("R$"+valorPagar);
				
			}
		});
		btnIncluir.setBounds(456, 643, 155, 38);
		pnlEsquerdo.add(btnIncluir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 440, 590, 2);
		pnlEsquerdo.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(55, 440, 590, 2);
		pnlEsquerdo.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(55, 475, 590, 2);
		pnlEsquerdo.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(55, 525, 590, 2);
		pnlEsquerdo.add(separator_1_1_1);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(55, 607, 590, 2);
		pnlEsquerdo.add(separator_1_1_1_1);
		
		JPanel pnlDireito = new JPanel();
		pnlDireito.setBackground(Color.DARK_GRAY);
		pnlDireito.setBounds(800, 0, 774, 700);
		contentPane.add(pnlDireito);
		pnlDireito.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 774, 700);
		pnlDireito.add(scrollPane);
		
		txtNota = new JTextArea();
		scrollPane.setViewportView(txtNota);
		txtNota.setText(cabecalho);
		
		JPanel pnlBaixo = new JPanel();
		pnlBaixo.setBackground(Color.YELLOW);
		pnlBaixo.setBounds(0, 700, 1584, 150);
		contentPane.add(pnlBaixo);
		pnlBaixo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor a Pagar:");
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 41));
		lblNewLabel.setBounds(798, 0, 342, 150);
		pnlBaixo.add(lblNewLabel);
		
		lblValorPagar = new JLabel("New label");
		lblValorPagar.setForeground(new Color(255, 0, 0));
		lblValorPagar.setFont(new Font("Verdana", Font.BOLD, 39));
		lblValorPagar.setBounds(1150, 0, 424, 150);
		pnlBaixo.add(lblValorPagar);
		lblValorPagar.setText("R$" +valorPagar);
	
	}
}
