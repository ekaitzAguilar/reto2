package agenciaViajesPaneles;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class GestorBienvenida {

	
	private JPanel panelBienvenida = null;


	/**
	 * Create the frame.
	 */
	public GestorBienvenida(ArrayList<JPanel> paneles) {
		
		panelBienvenida = new JPanel();
		
		panelBienvenida.setBackground(Color.LIGHT_GRAY);
		panelBienvenida.setBounds(0, 0, 1039, 666);
		panelBienvenida.setLayout(null);
	
		
		JButton btnBienvenida = new JButton("BIENVENIDA");
		btnBienvenida.setBounds(277, 253, 471, 108);
		btnBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paneles.get(0).setVisible(false);//login
				paneles.get(1).setVisible(true);//login
				
				
				
			}
		});
		btnBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBienvenida.add(btnBienvenida);
		
	}

	
	/**
	 * Devuelve el panel.
	 * @return panel.
	 */
	public JPanel getPanel() {
		
		return panelBienvenida;
	}
}