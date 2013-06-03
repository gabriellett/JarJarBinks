package br.edu.fei.jarjarbinks.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutDialog dialog = new AboutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setBounds(100, 100, 450, 237);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAboutJarJar = new JLabel("About Jar Jar Binks CPU");
			lblAboutJarJar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAboutJarJar.setBounds(10, 11, 414, 33);
			contentPanel.add(lblAboutJarJar);
		}
		{
			JLabel lblCreators = new JLabel("Creators:");
			lblCreators.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCreators.setBounds(10, 55, 414, 14);
			contentPanel.add(lblCreators);
		}
		{
			JLabel lblGabrielLettViviani = new JLabel("Gabriel Lett Viviani - 22111011-7");
			lblGabrielLettViviani.setBounds(10, 83, 414, 14);
			contentPanel.add(lblGabrielLettViviani);
		}
		{
			JLabel lblNewLabel = new JLabel("\u00CDtalo Cuzziol Ferreira");
			lblNewLabel.setBounds(10, 108, 414, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblMuriloFigueiredo = new JLabel("Murilo Figueiredo");
			lblMuriloFigueiredo.setBounds(10, 133, 414, 14);
			contentPanel.add(lblMuriloFigueiredo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
