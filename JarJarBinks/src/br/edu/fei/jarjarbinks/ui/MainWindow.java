package br.edu.fei.jarjarbinks.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Bit;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JPanel contentPane;
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
	private JTextField txtLastInst;
	private JTextField txtSP;
	
	public void setPC(String val){
		this.txtPC.setText(val);
	}

	public void setPSW(String val){
		this.txtPSW.setText(val);
	}
	
	public void setMBR(String val){
		this.txtMBR.setText(val);
	}
	
	public void setMAR(String val){
		this.txtMAR.setText(val);
	}
	
	public void setMDR(String val){
		this.txtMDR.setText(val);
	}
	public void setR1(String val){
		this.txtR1.setText(val);
	}
	
	public void setR2(String val){
		this.txtR2.setText(val);
	}
	
	public void setR3(String val){
		this.txtR3.setText(val);
	}
	
	public void setR4(String val){
		this.txtR4.setText(val);
	}
	public void setACC(String val){
		this.txtACC.setText(val);
	}

	public void setB(String val){
		this.txtB.setText(val);
	}

	public void setLastInst(String val){
		this.txtLastInst.setText(val);
	}
	
	public void setSP(String val){
		this.txtSP.setText(val);
	}
	
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
					
					frame.tabelaRam = new String[16][17];
					
					for(int i=0;i<16;i++){
						frame.tabelaRam[i][0] = Integer.toHexString(i).toUpperCase()+"0";
					}
					
					
					frame.tabelaCodeSegment = new String[65280][2];
					for(int i=0;i+255<65280;i++){
						frame.tabelaCodeSegment[i][0] = String.format("%04X", (i)+256);//Integer.toHexString(i+256).toUpperCase();
					}

					// Testes Imediato
					frame.tabelaCodeSegment[0][1] = "0001 0001 0000 0000";
					frame.tabelaCodeSegment[1][1] = "0000 0000 0110 1010";
					frame.tabelaCodeSegment[2][1] = "0000 0000 0101 1011";

					frame.tabelaCodeSegment[3][1] = "0001 0000 0000 0001";
					frame.tabelaCodeSegment[4][1] = "0000 0000 0111 1001";
					
					
					// Testes Direto
					//RR
					frame.tabelaCodeSegment[5][1] = "0001 0100 0001 0011";

					// MR
					frame.tabelaCodeSegment[6][1] = "0001 0110 0000 0010";
					frame.tabelaCodeSegment[7][1] = "0000 0000 0110 1010";
					
					//MM
					frame.tabelaCodeSegment[8][1] = "0001 0111 0000 0000";
					frame.tabelaCodeSegment[9][1] = "0000 0000 1111 1111";
					frame.tabelaCodeSegment[10][1] = "0000 0000 0110 1010";

					//RM
					frame.tabelaCodeSegment[11][1] = "0001 0101 0011 0000";
					frame.tabelaCodeSegment[12][1] = "0000 0000 1011 1111";
					
					// Testes Indireto
					frame.tabelaCodeSegment[13][1] = "0001 0000 0000 0000";
					frame.tabelaCodeSegment[14][1] = "0000 0000 0110 1010";
					
					//RR
					frame.tabelaCodeSegment[15][1] = "0001 1000 0000 0000";
					
					frame.tabelaCodeSegment[16][1] = "0001 0000 0000 0100";
					frame.tabelaCodeSegment[17][1] = "0000 0000 0000 1001";

					//ADD
					frame.tabelaCodeSegment[18][1] = "0010 0000 0000 0000";
					frame.tabelaCodeSegment[19][1] = "0000 0000 0000 0001";
					
					//SUB
					frame.tabelaCodeSegment[20][1] = "0011 0000 0000 0000";
					frame.tabelaCodeSegment[21][1] = "0000 0000 0000 0111";
					
					//PUSH
					frame.tabelaCodeSegment[22][1] = "1001 0000 0000 0000";
					frame.tabelaCodeSegment[23][1] = "0000 0000 1010 0110";
					
					frame.tabelaCodeSegment[24][1] = "1001 0000 0000 0000";
					frame.tabelaCodeSegment[25][1] = "0000 0000 1111 0110";
					
					frame.tabelaCodeSegment[26][1] = "1001 0100 0001 0000";
					
					frame.tabelaCodeSegment[27][1] = "1001 0110 0000 0000";
					frame.tabelaCodeSegment[28][1] = "0000 0000 0110 1010";

					//POP
					frame.tabelaCodeSegment[29][1] = "1010 0001 0000 0000";
					frame.tabelaCodeSegment[30][1] = "0000 0000 1111 1110";
					
					frame.tabelaCodeSegment[31][1] = "1010 0000 0000 0000";
					
					//PUSH TIL OVERFLOW
					frame.tabelaCodeSegment[32][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[33][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[34][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[35][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[36][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[37][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[38][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[39][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[40][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[41][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[42][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[43][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[44][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[45][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[46][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[47][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[48][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[49][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[50][1] = "1001 0100 0001 0000";

					
					//JZ
					frame.tabelaCodeSegment[51][1] = "0111 0000 0000 0000";
					frame.tabelaCodeSegment[52][1] = "0000 0001 0000 0110";

					//MOV ACME,00
					frame.tabelaCodeSegment[53][1] = "0001 0000 0000 0100";
					frame.tabelaCodeSegment[54][1] = "0000 0000 0000 0000";
					
					//JZ
					frame.tabelaCodeSegment[55][1] = "0111 0000 0000 0000";
					frame.tabelaCodeSegment[56][1] = "0000 0001 0011 1100";
					
					//PUSH TRASH
					frame.tabelaCodeSegment[57][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[58][1] = "1001 0100 0001 0000";
					frame.tabelaCodeSegment[59][1] = "1001 0100 0001 0000";
					
					//MOV ACME,DONATELLO
					frame.tabelaCodeSegment[60][1] = "0001 0100 0010 0100";
					
					//AND
					frame.tabelaCodeSegment[61][1] = "0100 0100 0001 0000";
					
					//OR
					frame.tabelaCodeSegment[62][1] = "0101 0100 0001 0000";
					
					//NOT
					frame.tabelaCodeSegment[63][1] = "0110 0100 0100 0000";
					

					
					frame.fixTables();
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
		lblCodesegment.setBounds(490, 81, 96, 14);
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
		lblAmericab.setBounds(202, 130, 80, 14);
		contentPane.add(lblAmericab);
		
		JLabel lblAcmeacc = new JLabel("ACME(ACC)");
		lblAcmeacc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcmeacc.setBounds(202, 105, 80, 14);
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
		txtACC.setBounds(300, 102, 77, 20);
		contentPane.add(txtACC);
		
		txtB = new JTextField();
		txtB.setEditable(false);
		txtB.setColumns(10);
		txtB.setBounds(300, 127, 77, 20);
		contentPane.add(txtB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dialog", Font.PLAIN, 8));
		scrollPane.setBounds(10, 416, 367, 279);
		contentPane.add(scrollPane);
		
		txtMemoria = new JTable();
		txtMemoria.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		scrollPane.setViewportView(txtMemoria);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setBounds(420, 103, 240, 594);
		contentPane.add(scrollPane_1);
		
		txtCodeSegment = new JTable();
		scrollPane_1.setViewportView(txtCodeSegment);
		
		JLabel lblPsw = new JLabel("PSW");
		lblPsw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPsw.setBounds(0, 212, 39, 14);
		contentPane.add(lblPsw);
		
		txtPSW = new JTextField();
		txtPSW.setEditable(false);
		txtPSW.setColumns(10);
		txtPSW.setBounds(44, 209, 145, 20);
		contentPane.add(txtPSW);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPc.setBounds(99, 257, 33, 14);
		contentPane.add(lblPc);
		
		txtPC = new JTextField();
		txtPC.setEditable(false);
		txtPC.setColumns(10);
		txtPC.setBounds(137, 254, 52, 20);
		contentPane.add(txtPC);
		
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMbr.setBounds(99, 288, 33, 14);
		contentPane.add(lblMbr);
		
		txtMBR = new JTextField();
		txtMBR.setEditable(false);
		txtMBR.setColumns(10);
		txtMBR.setBounds(137, 285, 52, 20);
		contentPane.add(txtMBR);
		
		JLabel lblMar = new JLabel("MAR");
		lblMar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMar.setBounds(99, 317, 33, 14);
		contentPane.add(lblMar);
		
		txtMAR = new JTextField();
		txtMAR.setEditable(false);
		txtMAR.setColumns(10);
		txtMAR.setBounds(137, 314, 52, 20);
		contentPane.add(txtMAR);
		
		JLabel lblMdr = new JLabel("MDR");
		lblMdr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMdr.setBounds(99, 346, 33, 14);
		contentPane.add(lblMdr);
		
		txtMDR = new JTextField();
		txtMDR.setEditable(false);
		txtMDR.setColumns(10);
		txtMDR.setBounds(137, 343, 52, 20);
		contentPane.add(txtMDR);
		
		JLabel panel_1 = new JLabel(new ImageIcon("C:\\dev\\jajar.jpg"));
		panel_1.setBounds(178, 196, 266, 188);
		contentPane.add(panel_1);
		
		JButton btnProximo = new JButton("Mesa Execute!");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					CPU.run();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnProximo.setBounds(202, 155, 125, 39);
		contentPane.add(btnProximo);
		
		JLabel lblLastInstruction = new JLabel("Last Instruction:");
		lblLastInstruction.setBounds(10, 388, 101, 16);
		contentPane.add(lblLastInstruction);
		
		txtLastInst = new JTextField();
		txtLastInst.setEditable(false);
		txtLastInst.setColumns(10);
		txtLastInst.setBounds(116, 384, 261, 20);
		contentPane.add(txtLastInst);
		
		JLabel lblTrap = new JLabel("Trap:");
		lblTrap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrap.setBounds(0, 346, 39, 14);
		contentPane.add(lblTrap);
		
		JLabel lblSp = new JLabel("SP");
		lblSp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSp.setBounds(0, 257, 39, 14);
		contentPane.add(lblSp);
		
		txtSP = new JTextField();
		txtSP.setEditable(false);
		txtSP.setColumns(10);
		txtSP.setBounds(44, 254, 52, 20);
		contentPane.add(txtSP);
		
		JCheckBox cmbTrap = new JCheckBox("");
		cmbTrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CPU.psw.setTrap(CPU.psw.getTrap().getBit()==0?new Bit(true):new Bit(false));
			}
		});
		cmbTrap.setBounds(57, 343, 39, 24);
		contentPane.add(cmbTrap);
		
		JButton btnNewButton = new JButton("R");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CPU.pc.setWord(new Word(0x0100));
				} catch (InvalidVarSize e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(332, 155, 45, 39);
		contentPane.add(btnNewButton);
	}
	
	public void fixTables(){
		txtCodeSegment.setModel(new DefaultTableModel(
				tabelaCodeSegment,
				new String[] {
					"Endere\u00E7o", "Valor"
				}
			));
		txtCodeSegment.getColumnModel().getColumn(0).setPreferredWidth(60);
		txtCodeSegment.getColumnModel().getColumn(1).setPreferredWidth(180);
		
		txtMemoria.setEnabled(false);
		txtMemoria.setModel(new DefaultTableModel(
			tabelaRam,
			new String[] {
				" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
			}
		));
		
		txtCodeSegment.setSelectionBackground(Color.RED);
		
		for(int i=0; i<17;i++){
			txtMemoria.getColumnModel().getColumn(i).setPreferredWidth(25);
			
		}
	}
}

