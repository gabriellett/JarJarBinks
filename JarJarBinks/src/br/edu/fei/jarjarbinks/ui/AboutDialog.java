package br.edu.fei.jarjarbinks.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.util.ClassUtils;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class AboutDialog extends JDialog {

	/** Generated Serial */
	private static final long serialVersionUID = -7986276477013464798L;
	private final JPanel contentPanel = new JPanel();
	public static AboutDialog frame;

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setTitle("About");
		setBounds(100, 100, 900, 423);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAboutJarJar = new JLabel("About Jar Jar Binks CPU");
			lblAboutJarJar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAboutJarJar.setBounds(10, 11, 198, 33);
			contentPanel.add(lblAboutJarJar);
		}
		{
			JLabel lblCreators = new JLabel("Authors:");
			lblCreators.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCreators.setBounds(10, 55, 198, 14);
			contentPanel.add(lblCreators);
		}
		{
			JLabel lblGabrielLettViviani = new JLabel("Gabriel Lett Viviani - 22111011-7");
			lblGabrielLettViviani.setBounds(10, 83, 198, 14);
			contentPanel.add(lblGabrielLettViviani);
		}
		{
			JLabel lblNewLabel = new JLabel("\u00CDtalo Cuzziol Ferreira - 22111065-3");
			lblNewLabel.setBounds(10, 108, 198, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblMuriloFigueiredo = new JLabel("Murilo Figueiredo - 22111070-3");
			lblMuriloFigueiredo.setBounds(10, 133, 198, 14);
			contentPanel.add(lblMuriloFigueiredo);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(218, 19, 174, 316);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			ArrayList<String> instrDescs = new ArrayList<String>();

			instrDescs.add("MNEMONIC(EQUIV):OPCODE");
			instrDescs.add("");
			Instruction inst = null;
			try{
				for(Class clazz: ClassUtils.getClasses("br.edu.fei.jarjarbinks.instructions.impl")){
					inst = (Instruction) clazz.newInstance();
					instrDescs.add(inst.getDescription());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			JList list = new JList(instrDescs.toArray());
			list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			list.setBounds(0, 33, 174, 283);
			panel.add(list);
			
		}
		
		JLabel lblInstructionSet = new JLabel("Instruction Set:");
		lblInstructionSet.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructionSet.setBounds(12, 12, 162, 16);
		panel.add(lblInstructionSet);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBounds(404, 19, 293, 316);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel lblInstructionStructure = new JLabel("Instruction Structure:");
				lblInstructionStructure.setHorizontalAlignment(SwingConstants.CENTER);
				lblInstructionStructure.setBounds(36, 12, 213, 16);
				panel_1.add(lblInstructionStructure);
			}
			
			JLabel label = new JLabel("0 0 0 0 | 0 0 | 0 0 | 0 0 0 0 | 0 0 0 0");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(25, 37, 240, 16);
			panel_1.add(label);
			
			JLabel lblNewLabel_1 = new JLabel("1");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(56, 50, 39, 16);
			panel_1.add(lblNewLabel_1);
			
			JLabel label_1 = new JLabel("2");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(88, 50, 39, 16);
			panel_1.add(label_1);
			
			JLabel label_2 = new JLabel("3");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(117, 50, 39, 16);
			panel_1.add(label_2);
			
			JLabel label_3 = new JLabel("4");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(151, 50, 39, 16);
			panel_1.add(label_3);
			
			JLabel label_4 = new JLabel("5");
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			label_4.setBounds(197, 50, 39, 16);
			panel_1.add(label_4);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_2.setBounds(12, 78, 131, 48);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblOpcode = new JLabel("1: OPCODE");
			lblOpcode.setBounds(5, 5, 114, 16);
			panel_2.add(lblOpcode);
			
			JLabel lblSeeInstructionSet = new JLabel("See Instruction Set");
			lblSeeInstructionSet.setBounds(5, 24, 114, 16);
			panel_2.add(lblSeeInstructionSet);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_3.setBounds(148, 78, 133, 104);
			panel_1.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblAddressingModes = new JLabel("2: Addressing Modes");
			lblAddressingModes.setBounds(5, 5, 121, 16);
			panel_3.add(lblAddressingModes);
			
			JLabel lblImediate = new JLabel("00: Imediate");
			lblImediate.setBounds(5, 27, 121, 16);
			panel_3.add(lblImediate);
			
			JLabel lblDirect = new JLabel("01: Direct");
			lblDirect.setBounds(5, 52, 121, 16);
			panel_3.add(lblDirect);
			
			JLabel lblIndirect = new JLabel("10: Indirect");
			lblIndirect.setBounds(5, 80, 121, 16);
			panel_3.add(lblIndirect);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_4.setBounds(12, 138, 131, 112);
			panel_1.add(panel_4);
			panel_4.setLayout(null);
			
			JLabel lblSource = new JLabel("3: Source - Destiny");
			lblSource.setBounds(5, 5, 114, 16);
			panel_4.add(lblSource);
			
			JLabel lblRegReg = new JLabel("00: Reg <-> Reg");
			lblRegReg.setBounds(5, 24, 114, 16);
			panel_4.add(lblRegReg);
			
			JLabel lblRegMem = new JLabel("01: Reg <-> Mem");
			lblRegMem.setBounds(5, 45, 114, 16);
			panel_4.add(lblRegMem);
			
			JLabel lblMemReg = new JLabel("01: Mem <-> Reg");
			lblMemReg.setBounds(5, 65, 114, 16);
			panel_4.add(lblMemReg);
			
			JLabel lblMemMem = new JLabel("11: Mem <-> Mem");
			lblMemMem.setBounds(5, 86, 114, 16);
			panel_4.add(lblMemMem);
			
			JPanel panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_5.setBounds(150, 194, 131, 56);
			panel_1.add(panel_5);
			
			JLabel lblSourceReg = new JLabel("4: Source Reg");
			lblSourceReg.setBounds(5, 5, 114, 16);
			panel_5.add(lblSourceReg);
			
			JLabel lblSeeRegisters = new JLabel("See Registers ->");
			lblSeeRegisters.setBounds(5, 24, 114, 16);
			panel_5.add(lblSeeRegisters);
			
			JPanel panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_6.setBounds(150, 256, 131, 48);
			panel_1.add(panel_6);
			
			JLabel lblDestinyReg = new JLabel("5: Destiny Reg");
			lblDestinyReg.setBounds(5, 5, 114, 16);
			panel_6.add(lblDestinyReg);
			
			JLabel lblSeeRegisters_1 = new JLabel("See Registers ->");
			lblSeeRegisters_1.setBounds(5, 24, 114, 16);
			panel_6.add(lblSeeRegisters_1);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(704, 19, 168, 318);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel panel_2 = new JLabel(new ImageIcon(getClass().getResource("jarjar.jpg")));
		panel_2.setBounds(-16, 147, 266, 188);
		contentPanel.add(panel_2);
		
		
		JLabel lblRegisters = new JLabel("Registers");
		lblRegisters.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisters.setBounds(12, 12, 144, 16);
		panel_1.add(lblRegisters);
		
		ArrayList<String> regsDesc = new ArrayList<String>();

		regsDesc.add("REG(EQUIV):CODE");
		regsDesc.add("");
		regsDesc.add("Michelangelo (R1) : 0000");
		regsDesc.add("Donatello (R2) : 0001");
		regsDesc.add("Rafael (R3) : 0010");
		regsDesc.add("Leonardo (R4) : 0011");
		regsDesc.add("ACME (A) : 0101");
		regsDesc.add("AMERICA (B) : 0110");
		
		JList list = new JList(regsDesc.toArray());
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(0, 34, 168, 284);
		panel_1.add(list);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Close");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AboutDialog.frame.setVisible(false);
						AboutDialog.frame.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}
