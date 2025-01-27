package agenciaViajesPaneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class GestorLogin {

	private JPanel panelLogin = null;
	private JTextField tfNomAgencia;
	private JTextField tfContraseña;
	Scanner teclado = new Scanner(System.in);

	/**
	 * Create the frame.
	 */
	public GestorLogin(ArrayList<JPanel> paneles) {

		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 1039, 666);
		panelLogin.setBackground(Color.LIGHT_GRAY);
		panelLogin.setLayout(null);

		JLabel lblNomAgencia = new JLabel("NOMBRE AGENCIA");
		lblNomAgencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomAgencia.setBounds(333, 177, 114, 16);
		panelLogin.add(lblNomAgencia);

		JLabel lblContraseña = new JLabel("CONTRASEÑA");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setBounds(333, 257, 87, 16);
		panelLogin.add(lblContraseña);

		tfNomAgencia = new JTextField();
		tfNomAgencia.setBounds(560, 172, 130, 26);
		panelLogin.add(tfNomAgencia);
		tfNomAgencia.setColumns(10);

		tfContraseña = new JTextField();
		tfContraseña.setColumns(10);
		tfContraseña.setBounds(560, 252, 130, 26);
		panelLogin.add(tfContraseña);

		JButton btnIniSesion = new JButton("INICIAR SESION");
		btnIniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(true);
				
				//login();
				//JOptionPane.showMessageDialog(panelLogin, "Las credenciales no son correctas", "ERROR",
				//JOptionPane.ERROR_MESSAGE);
			}

		});
		btnIniSesion.setBounds(336, 454, 141, 29);
		panelLogin.add(btnIniSesion);

		JButton btnNuevaAgencia = new JButton("NUEVA AGENCIA");
		btnNuevaAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paneles.get(1).setVisible(false);
				paneles.get(9).setVisible(true);
			}
		});
		btnNuevaAgencia.setBounds(578, 454, 148, 29);
		panelLogin.add(btnNuevaAgencia);
	}

	/**
	 * Devuelve el panel.
	 * 
	 * @return panel.
	 */
	public JPanel getPanel() {

		return panelLogin;
	}

}