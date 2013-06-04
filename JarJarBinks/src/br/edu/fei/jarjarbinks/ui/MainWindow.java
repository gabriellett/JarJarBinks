package br.edu.fei.jarjarbinks.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import br.edu.fei.jarjarbinks.util.Conversor;

public class MainWindow extends JFrame {

	public static MainWindow frame;

	/** Serial */
	private static final long serialVersionUID = 1L;
	
	private CPU cpu;
	
	private JPanel contentPane;
	private JTextField txtR1;
	private JTextField txtR2;
	private JTextField txtR3;
	private JTextField txtR4;
	private JTextField txtACC;
	private JTextField txtB;
	private JTable tblMemory;
	private JTable tblCodeSegment;
	private String arrRAM[][];
	private String arrCodeSegment[][];
	private JTextField txtPSW;
	private JTextField txtPC;
	private JTextField txtMBR;
	private JTextField txtMAR;
	private JTextField txtMDR;
	private JTextField txtLastInst;
	private JTextField txtSP;
	private JScrollPane codeSegPanel;
	private JTextField txtSleepTime;
	
	public boolean existsCodeLine(int line){
		return this.tblCodeSegment.getModel().getValueAt(line,1)!=null;
	}
	
	public void setMemoryWord(Word word, int address){
		
		this.tblMemory.getModel().setValueAt(String.format("%02X", word.toInt()), address/16,(address%16)+1);
		
		this.tblMemory.revalidate();
		this.tblMemory.repaint();
		
	}

	public Word getWordFromCodeSegment(int line) throws InvalidVarSize{
		
		int a = Integer.valueOf(((String)MainWindow.frame.tblCodeSegment.getModel().getValueAt(line,1)).replaceAll(" ", ""),2);
		System.out.println("CS "+(256+line)+" ["+String.format("%04X", 256+line)+"]:"+Conversor.fillOpcodeZero(Integer.toBinaryString(a))+"|"+String.format("%05d", a)+"|"+String.format("%04X", a));
		return new Word(a);
	}
	
	public Integer getTxtSleep(){
		try{
			return Integer.valueOf(this.txtSleepTime.getText());
		}catch(NumberFormatException nfe ){
			this.txtSleepTime.setText(String.valueOf(1));
			return 1;
		}
 	}
	
	public void setPC(int val){
		this.txtPC.setText(String.format("%04X", val));
		

		this.tblCodeSegment.scrollRectToVisible(MainWindow.frame.tblCodeSegment.getCellRect((val-250),0, true)); 
		this.tblCodeSegment.setRowSelectionInterval((val-256), (val-256));
		this.tblCodeSegment.revalidate();
		this.tblCodeSegment.repaint();

		System.out.println("PC  set to:"+String.format("%04X", val));
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
		return arrCodeSegment;
	}

	/**
	 * @param tabelaCodeSegment the tabelaCodeSegment to set
	 */
	public void setTabelaCodeSegment(String[][] tabelaCodeSegment) {
		this.arrCodeSegment = tabelaCodeSegment;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow();

					if(FrameLog.frame ==null){
						FrameLog.frame = new FrameLog();
					}
					if(AboutDialog.frame ==null){
						AboutDialog.frame = new AboutDialog();
					}
					
					frame.arrRAM = new String[16][17];
					
					for(int i=0;i<16;i++){
						frame.arrRAM[i][0] = Integer.toHexString(i).toUpperCase()+"0";
					}
					
					
					frame.arrCodeSegment = new String[65280][2];
					for(int i=0;i+255<65280;i++){
						frame.arrCodeSegment[i][0] = String.format("%04X", (i)+256);//Integer.toHexString(i+256).toUpperCase();
					}

					// Testes Imediato
					frame.arrCodeSegment[0][1] = "0001 0001 0000 0000";
					frame.arrCodeSegment[1][1] = "0000 0000 0110 1010";
					frame.arrCodeSegment[2][1] = "0000 0000 0101 1011";

					frame.arrCodeSegment[3][1] = "0001 0000 0000 0001";
					frame.arrCodeSegment[4][1] = "0000 0000 0111 1001";
					
					
					// Testes Direto
					//RR
					frame.arrCodeSegment[5][1] = "0001 0100 0001 0011";

					// MR
					frame.arrCodeSegment[6][1] = "0001 0110 0000 0010";
					frame.arrCodeSegment[7][1] = "0000 0000 0110 1010";
					
					//MM
					frame.arrCodeSegment[8][1] = "0001 0111 0000 0000";
					frame.arrCodeSegment[9][1] = "0000 0000 1111 1111";
					frame.arrCodeSegment[10][1] = "0000 0000 0110 1010";

					//RM
					frame.arrCodeSegment[11][1] = "0001 0101 0011 0000";
					frame.arrCodeSegment[12][1] = "0000 0000 1011 1111";
					
					// Testes Indireto
					frame.arrCodeSegment[13][1] = "0001 0000 0000 0000";
					frame.arrCodeSegment[14][1] = "0000 0000 0110 1010";
					
					//RR
					frame.arrCodeSegment[15][1] = "0001 1000 0000 0000";
					
					frame.arrCodeSegment[16][1] = "0001 0000 0000 0100";
					frame.arrCodeSegment[17][1] = "0000 0000 0000 1001";

					//ADD
					frame.arrCodeSegment[18][1] = "0010 0000 0000 0000";
					frame.arrCodeSegment[19][1] = "0000 0000 0000 0001";
					
					//SUB
					frame.arrCodeSegment[20][1] = "0011 0000 0000 0000";
					frame.arrCodeSegment[21][1] = "0000 0000 0000 0111";
					
					//PUSH
					frame.arrCodeSegment[22][1] = "1001 0000 0000 0000";
					frame.arrCodeSegment[23][1] = "0000 0000 1010 0110";
					
					frame.arrCodeSegment[24][1] = "1001 0000 0000 0000";
					frame.arrCodeSegment[25][1] = "0000 0000 1111 0110";
					
					frame.arrCodeSegment[26][1] = "1001 0100 0001 0000";
					
					frame.arrCodeSegment[27][1] = "1001 0110 0000 0000";
					frame.arrCodeSegment[28][1] = "0000 0000 0110 1010";

					//POP
					frame.arrCodeSegment[29][1] = "1010 0001 0000 0000";
					frame.arrCodeSegment[30][1] = "0000 0000 1111 1110";
					
					frame.arrCodeSegment[31][1] = "1010 0000 0000 0000";
					
					//PUSH TIL OVERFLOW
					frame.arrCodeSegment[32][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[33][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[34][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[35][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[36][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[37][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[38][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[39][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[40][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[41][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[42][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[43][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[44][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[45][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[46][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[47][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[48][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[49][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[50][1] = "1001 0100 0001 0000";

					
					//JZ
					frame.arrCodeSegment[51][1] = "0111 0000 0000 0000";
					frame.arrCodeSegment[52][1] = "0000 0001 0000 0110";

					//MOV ACME,00
					frame.arrCodeSegment[53][1] = "0001 0000 0000 0100";
					frame.arrCodeSegment[54][1] = "0000 0000 0000 0000";
					
					//JZ
					frame.arrCodeSegment[55][1] = "0111 0000 0000 0000";
					frame.arrCodeSegment[56][1] = "0000 0001 0011 1100";
					
					//PUSH TRASH
					frame.arrCodeSegment[57][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[58][1] = "1001 0100 0001 0000";
					frame.arrCodeSegment[59][1] = "1001 0100 0001 0000";
					
					//MOV ACME,DONATELLO
					frame.arrCodeSegment[60][1] = "0001 0100 0010 0100";
					
					//AND
					frame.arrCodeSegment[61][1] = "0100 0100 0001 0000";
					
					//OR
					frame.arrCodeSegment[62][1] = "0101 0100 0001 0000";
					
					//NOT
					frame.arrCodeSegment[63][1] = "0110 0100 0100 0000";
					

					
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
		setTitle("Jar Jar Binks CPU");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(-2, 22, 682, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jar Jar Binks CPU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 0, 456, 69);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		panel.add(lblNewLabel);
		
		JLabel lblRegistradores = new JLabel("Registers:");
		lblRegistradores.setBounds(158, 102, 116, 14);
		contentPane.add(lblRegistradores);
		
		JLabel lblCodesegment = new JLabel("CodeSegment");
		lblCodesegment.setBounds(488, 103, 96, 14);
		contentPane.add(lblCodesegment);
		
		JLabel label = new JLabel("Michelangelo(R1)");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(8, 127, 103, 14);
		contentPane.add(label);
		
		JLabel lblDonatellor = new JLabel("Donatello(R2)");
		lblDonatellor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDonatellor.setBounds(8, 152, 103, 14);
		contentPane.add(lblDonatellor);
		
		JLabel lblLeonardor = new JLabel("Leonardo(R4)");
		lblLeonardor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeonardor.setBounds(8, 202, 103, 14);
		contentPane.add(lblLeonardor);
		
		JLabel lblRafaelr = new JLabel("Rafael(R2)");
		lblRafaelr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRafaelr.setBounds(8, 177, 103, 14);
		contentPane.add(lblRafaelr);
		
		JLabel lblAmericab = new JLabel("AMERICA(B)");
		lblAmericab.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmericab.setBounds(200, 152, 80, 14);
		contentPane.add(lblAmericab);
		
		JLabel lblAcmeacc = new JLabel("ACME(ACC)");
		lblAcmeacc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcmeacc.setBounds(200, 127, 80, 14);
		contentPane.add(lblAcmeacc);
		
		txtR1 = new JTextField();
		txtR1.setEditable(false);
		txtR1.setBounds(114, 124, 73, 20);
		contentPane.add(txtR1);
		txtR1.setColumns(10);
		
		txtR2 = new JTextField();
		txtR2.setEditable(false);
		txtR2.setColumns(10);
		txtR2.setBounds(114, 149, 73, 20);
		contentPane.add(txtR2);
		
		txtR3 = new JTextField();
		txtR3.setEditable(false);
		txtR3.setColumns(10);
		txtR3.setBounds(114, 174, 73, 20);
		contentPane.add(txtR3);
		
		txtR4 = new JTextField();
		txtR4.setEditable(false);
		txtR4.setColumns(10);
		txtR4.setBounds(114, 199, 73, 20);
		contentPane.add(txtR4);
		
		txtACC = new JTextField();
		txtACC.setEditable(false);
		txtACC.setColumns(10);
		txtACC.setBounds(298, 124, 77, 20);
		contentPane.add(txtACC);
		
		txtB = new JTextField();
		txtB.setEditable(false);
		txtB.setColumns(10);
		txtB.setBounds(298, 149, 77, 20);
		contentPane.add(txtB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dialog", Font.PLAIN, 8));
		scrollPane.setBounds(9, 449, 367, 279);
		contentPane.add(scrollPane);
		
		tblMemory = new JTable();
		tblMemory.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		scrollPane.setViewportView(tblMemory);
		
		codeSegPanel = new JScrollPane();
		codeSegPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		codeSegPanel.setBounds(420, 134, 240, 594);
		contentPane.add(codeSegPanel);
		
		tblCodeSegment = new JTable();
		codeSegPanel.setViewportView(tblCodeSegment);
		
		JLabel lblPsw = new JLabel("PSW");
		lblPsw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPsw.setBounds(0, 243, 39, 14);
		contentPane.add(lblPsw);
		
		txtPSW = new JTextField();
		txtPSW.setEditable(false);
		txtPSW.setColumns(10);
		txtPSW.setBounds(44, 240, 145, 20);
		contentPane.add(txtPSW);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPc.setBounds(99, 288, 33, 14);
		contentPane.add(lblPc);
		
		txtPC = new JTextField();
		txtPC.setEditable(false);
		txtPC.setColumns(10);
		txtPC.setBounds(137, 285, 52, 20);
		contentPane.add(txtPC);
		
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMbr.setBounds(99, 319, 33, 14);
		contentPane.add(lblMbr);
		
		txtMBR = new JTextField();
		txtMBR.setEditable(false);
		txtMBR.setColumns(10);
		txtMBR.setBounds(137, 316, 52, 20);
		contentPane.add(txtMBR);
		
		JLabel lblMar = new JLabel("MAR");
		lblMar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMar.setBounds(99, 348, 33, 14);
		contentPane.add(lblMar);
		
		txtMAR = new JTextField();
		txtMAR.setEditable(false);
		txtMAR.setColumns(10);
		txtMAR.setBounds(137, 345, 52, 20);
		contentPane.add(txtMAR);
		
		JLabel lblMdr = new JLabel("MDR");
		lblMdr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMdr.setBounds(99, 377, 33, 14);
		contentPane.add(lblMdr);
		
		txtMDR = new JTextField();
		txtMDR.setEditable(false);
		txtMDR.setColumns(10);
		txtMDR.setBounds(137, 374, 52, 20);
		contentPane.add(txtMDR);
		
		
		JLabel panel_1 = new JLabel(new ImageIcon(getClass().getResource("jarjar.jpg")));
		panel_1.setBounds(178, 227, 266, 188);
		contentPane.add(panel_1);
		
		JButton btnProximo = new JButton("Mesa Execute!");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					cpu = new CPU();
					cpu.start();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnProximo.setBounds(200, 177, 125, 39);
		contentPane.add(btnProximo);
		
		JLabel lblLastInstruction = new JLabel("Last Instruction:");
		lblLastInstruction.setBounds(10, 419, 101, 16);
		contentPane.add(lblLastInstruction);
		
		txtLastInst = new JTextField();
		txtLastInst.setEditable(false);
		txtLastInst.setColumns(10);
		txtLastInst.setBounds(116, 415, 261, 20);
		contentPane.add(txtLastInst);
		
		JLabel lblTrap = new JLabel("Trap:");
		lblTrap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrap.setBounds(0, 377, 39, 14);
		contentPane.add(lblTrap);
		
		JLabel lblSp = new JLabel("SP");
		lblSp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSp.setBounds(0, 288, 39, 14);
		contentPane.add(lblSp);
		
		txtSP = new JTextField();
		txtSP.setEditable(false);
		txtSP.setColumns(10);
		txtSP.setBounds(44, 285, 52, 20);
		contentPane.add(txtSP);
		
		JCheckBox cmbTrap = new JCheckBox("");
		cmbTrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CPU.psw.setTrap(CPU.psw.getTrap().getBit()==0?new Bit(true):new Bit(false));
			}
		});
		cmbTrap.setBounds(57, 374, 39, 24);
		contentPane.add(cmbTrap);
		
		JButton btnNewButton = new JButton("R");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CPU.pc.setWord(new Word(0x0100));
					CPU.initialize();
				} catch (InvalidVarSize e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(332, 178, 45, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblSleepTime = new JLabel("Sleep Time:");
		lblSleepTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblSleepTime.setBounds(10, 318, 86, 16);
		contentPane.add(lblSleepTime);
		
		txtSleepTime = new JTextField();
		txtSleepTime.setBounds(10, 345, 86, 20);
		contentPane.add(txtSleepTime);
		txtSleepTime.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 682, 23);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmMesaExit = new JMenuItem("Mesa Exit :(");
		mntmMesaExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(frame, "Do you really want to terminate Jar Jar Binks CPU? :(", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        if (answer == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
			}
		});
		mnFile.add(mntmMesaExit);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		JMenuItem mntmInstructionLog = new JMenuItem("Instruction Log");
		mntmInstructionLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameLog.frame.setVisible(true);
			}
		});
		mnTools.add(mntmInstructionLog);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog.frame.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(frame, "Do you really want to terminate Jar Jar Binks CPU? :(", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        if (answer == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    }
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
	}
	
	public void fixTables(){
		tblCodeSegment.setModel(new DefaultTableModel(
				arrCodeSegment,
				new String[] {
					"Endere\u00E7o", "Valor"
				}
			));
		tblCodeSegment.getColumnModel().getColumn(0).setPreferredWidth(60);
		tblCodeSegment.getColumnModel().getColumn(1).setPreferredWidth(180);
		
		tblMemory.setEnabled(false);
		tblMemory.setModel(new DefaultTableModel(
			arrRAM,
			new String[] {
				" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
			}
		));
		
		tblCodeSegment.setSelectionBackground(Color.RED);
		
		for(int i=0; i<17;i++){
			tblMemory.getColumnModel().getColumn(i).setPreferredWidth(25);
			
		}
	}
}

