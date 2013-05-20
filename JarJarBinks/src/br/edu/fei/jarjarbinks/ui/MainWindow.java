package br.edu.fei.jarjarbinks.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.fei.jarjarbinks.CPU;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtR1;
	private JTextField txtR2;
	private JTextField txtR3;
	private JTextField txtR4;
	private JTextField txtACC;
	private JTextField txtB;
	public JTable txtMemoria;
	public JTable txtCodeSegment;
	private String tabelaRam[][];
	private String tabelaCodeSegment[][];
	private JTextField txtPSW;
	private JTextField txtPC;
	private JTextField txtMBR;
	private JTextField txtMAR;
	private JTextField txtMDR;
	public static MainWindow frame;
	
	/**
	 * @return the tabelaCodeSegment
	 */
	public String[][] getTabelaCodeSegment() {
		return tabelaCodeSegment;
	}

	/**
	 * @param tabelaCodeSegment the tabelaCodeSegment to set
	 */
	public void setTabelaCodeSegment(String[][] tabelaCodeSegment) {
		this.tabelaCodeSegment = tabelaCodeSegment;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow();
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
	public MainWindow() {
		tabelaRam = new String[16][17];
				
		for(int i=0;i<16;i++){
			tabelaRam[i][0] = Integer.toHexString(i).toUpperCase()+"0";
		}
		
		
		tabelaCodeSegment = new String[65280][2];
		for(int i=0;i<65280;i++){
			tabelaCodeSegment[i][0] = String.format("%04X", i+256);//Integer.toHexString(i+256).toUpperCase();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 808, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JarJarBinks");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 0, 456, 69);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		panel.add(lblNewLabel);
		
		JLabel lblRegistradores = new JLabel("Registradores");
		lblRegistradores.setBounds(160, 80, 116, 14);
		contentPane.add(lblRegistradores);
		
		JLabel lblCodesegment = new JLabel("CodeSegment");
		lblCodesegment.setBounds(524, 81, 96, 14);
		contentPane.add(lblCodesegment);
		
		JLabel label = new JLabel("Michelangelo(R1)");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 105, 103, 14);
		contentPane.add(label);
		
		JLabel lblDonatellor = new JLabel("Donatello(R2)");
		lblDonatellor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDonatellor.setBounds(10, 130, 103, 14);
		contentPane.add(lblDonatellor);
		
		JLabel lblLeonardor = new JLabel("Leonardo(R4)");
		lblLeonardor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeonardor.setBounds(10, 180, 103, 14);
		contentPane.add(lblLeonardor);
		
		JLabel lblRafaelr = new JLabel("Rafael(R2)");
		lblRafaelr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRafaelr.setBounds(10, 155, 103, 14);
		contentPane.add(lblRafaelr);
		
		JLabel lblAmericab = new JLabel("AMERICA(B)");
		lblAmericab.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmericab.setBounds(212, 130, 80, 14);
		contentPane.add(lblAmericab);
		
		JLabel lblAcmeacc = new JLabel("ACME(ACC)");
		lblAcmeacc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcmeacc.setBounds(212, 105, 80, 14);
		contentPane.add(lblAcmeacc);
		
		txtR1 = new JTextField();
		txtR1.setEditable(false);
		txtR1.setBounds(116, 102, 73, 20);
		contentPane.add(txtR1);
		txtR1.setColumns(10);
		
		txtR2 = new JTextField();
		txtR2.setEditable(false);
		txtR2.setColumns(10);
		txtR2.setBounds(116, 127, 73, 20);
		contentPane.add(txtR2);
		
		txtR3 = new JTextField();
		txtR3.setEditable(false);
		txtR3.setColumns(10);
		txtR3.setBounds(116, 152, 73, 20);
		contentPane.add(txtR3);
		
		txtR4 = new JTextField();
		txtR4.setEditable(false);
		txtR4.setColumns(10);
		txtR4.setBounds(116, 177, 73, 20);
		contentPane.add(txtR4);
		
		txtACC = new JTextField();
		txtACC.setEditable(false);
		txtACC.setColumns(10);
		txtACC.setBounds(310, 102, 77, 20);
		contentPane.add(txtACC);
		
		txtB = new JTextField();
		txtB.setEditable(false);
		txtB.setColumns(10);
		txtB.setBounds(310, 127, 77, 20);
		contentPane.add(txtB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 416, 367, 279);
		contentPane.add(scrollPane);
		
		txtMemoria = new JTable();
		txtMemoria.setEnabled(false);
		txtMemoria.setModel(new DefaultTableModel(
			tabelaRam,
			new String[] {
				" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
			}
		));
		
		txtMemoria.getColumnModel().getColumn(0).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(1).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(2).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(3).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(4).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(5).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(6).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(7).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(8).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(9).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(10).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(11).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(12).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(13).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(14).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(15).setPreferredWidth(25);
		txtMemoria.getColumnModel().getColumn(16).setPreferredWidth(25);
		scrollPane.setViewportView(txtMemoria);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(453, 101, 220, 594);
		contentPane.add(scrollPane_1);
		
		txtCodeSegment = new JTable();
		txtCodeSegment.setModel(new DefaultTableModel(
			tabelaCodeSegment,
			new String[] {
				"Endere\u00E7o", "Valor"
			}
		));
		txtCodeSegment.getColumnModel().getColumn(0).setPreferredWidth(60);
		txtCodeSegment.getColumnModel().getColumn(1).setPreferredWidth(160);
		scrollPane_1.setViewportView(txtCodeSegment);
		
		JButton btnProxPasso = new JButton("Iniciar / Proximo");
		btnProxPasso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CPU.execute();
			}
		});
		btnProxPasso.setBounds(211, 155, 176, 39);
		contentPane.add(btnProxPasso);
		
		JLabel lblPsw = new JLabel("PSW");
		lblPsw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPsw.setBounds(10, 228, 103, 14);
		contentPane.add(lblPsw);
		
		txtPSW = new JTextField();
		txtPSW.setEditable(false);
		txtPSW.setColumns(10);
		txtPSW.setBounds(116, 225, 73, 20);
		contentPane.add(txtPSW);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPc.setBounds(10, 257, 103, 14);
		contentPane.add(lblPc);
		
		txtPC = new JTextField();
		txtPC.setEditable(false);
		txtPC.setColumns(10);
		txtPC.setBounds(116, 254, 73, 20);
		contentPane.add(txtPC);
		
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMbr.setBounds(10, 288, 103, 14);
		contentPane.add(lblMbr);
		
		txtMBR = new JTextField();
		txtMBR.setEditable(false);
		txtMBR.setColumns(10);
		txtMBR.setBounds(116, 285, 73, 20);
		contentPane.add(txtMBR);
		
		JLabel lblMar = new JLabel("MAR");
		lblMar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMar.setBounds(10, 317, 103, 14);
		contentPane.add(lblMar);
		
		txtMAR = new JTextField();
		txtMAR.setEditable(false);
		txtMAR.setColumns(10);
		txtMAR.setBounds(116, 314, 73, 20);
		contentPane.add(txtMAR);
		
		JLabel lblMdr = new JLabel("MDR");
		lblMdr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMdr.setBounds(10, 346, 103, 14);
		contentPane.add(lblMdr);
		
		txtMDR = new JTextField();
		txtMDR.setEditable(false);
		txtMDR.setColumns(10);
		txtMDR.setBounds(116, 343, 73, 20);
		contentPane.add(txtMDR);
	}
	
}
