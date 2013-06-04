package br.edu.fei.jarjarbinks.ui;

import java.awt.Font;

import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameLog extends JFrame {

	public static FrameLog frame;
	private JPanel contentPane;
	private JTextArea txtInstructionLog;

	public void addInstruction(String text){
		this.txtInstructionLog.append("\n"+text);
	}
	
	/**
	 * Create the frame.
	 */
	public FrameLog() {
		setTitle("Instruction Log");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 309, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameLog.frame.setVisible(false);
				FrameLog.frame.dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JLabel lblLogDeComandos = new JLabel("Instruction Log");
		lblLogDeComandos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogDeComandos.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogDeComandos.setBounds(10, 32, 287, 30);
		contentPane.add(lblLogDeComandos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 287, 284);
		contentPane.add(scrollPane);
		
		txtInstructionLog = new JTextArea();
		scrollPane.setViewportView(txtInstructionLog);
		txtInstructionLog.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		DefaultCaret caret = (DefaultCaret)txtInstructionLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
