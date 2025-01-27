package agenciaViajesPaneles;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GestorViajesEventos {

	
	private JPanel panelViajesEventos = null;
	private JTable tablaViajes;
	private JTable tablaEventos;
	private JButton btnNuevoViaje;
	private JButton btnNuevoEvento;
	private JButton btnGenerarAlerta;
	private JButton btnDesconectar;

	/**
	 * Create the frame.
	 */
	public GestorViajesEventos(ArrayList<JPanel> paneles) {
		
		panelViajesEventos = new JPanel();
		panelViajesEventos.setBackground(Color.LIGHT_GRAY);
		panelViajesEventos.setBounds(0, 0, 1039, 666);
		panelViajesEventos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 66, 596, 189);
		panelViajesEventos.add(scrollPane);
		
		DefaultTableModel modeloViajes = new DefaultTableModel();
		modeloViajes.addColumn("Nombre");
		modeloViajes.addColumn("Tipo");
		modeloViajes.addColumn("Fecha Inicio");
		modeloViajes.addColumn("Fecha Fin");
		modeloViajes.addColumn("Nº Días");
		modeloViajes.addColumn("País");
//		modelo.addColumn("Descripción");
//		modelo.addColumn("Servicios no incl.");
		
		tablaViajes = new JTable();
		scrollPane.add(tablaViajes);
		scrollPane.setViewportView(tablaViajes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 409, 605, 189);
		panelViajesEventos.add(scrollPane_1);
		
		DefaultTableModel modeloEventos = new DefaultTableModel();
		modeloEventos.addColumn("Nombre");
		modeloEventos.addColumn("Tipo");
		modeloEventos.addColumn("Fecha");
		modeloEventos.addColumn("Fin");
		modeloEventos.addColumn("Precio");
		
		tablaEventos = new JTable();
		scrollPane.add(tablaEventos);
		scrollPane.setViewportView(tablaEventos);
		
		btnNuevoViaje = new JButton("NUEVO VIAJE");
		btnNuevoViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paneles.get(2).setVisible(false);
				paneles.get(10).setVisible(true);
			}
		});
		btnNuevoViaje.setBounds(771, 66, 185, 23);
		panelViajesEventos.add(btnNuevoViaje);
		
		btnNuevoEvento = new JButton("NUEVO EVENTO");
		btnNuevoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paneles.get(2).setVisible(false);
				paneles.get(7).setVisible(true);
			}
		});
		btnNuevoEvento.setBounds(771, 232, 185, 23);
		panelViajesEventos.add(btnNuevoEvento);
		
		btnGenerarAlerta = new JButton("GENERAR ALERTA CLIENTE");
		btnGenerarAlerta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerarAlerta.setBounds(771, 409, 185, 23);
		panelViajesEventos.add(btnGenerarAlerta);
		
		btnDesconectar = new JButton("DESCONECTAR");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paneles.get(2).setVisible(false);
				JOptionPane.showMessageDialog(panelViajesEventos, "Se ha desconectado de la sesion", "DESCONEXION",
						JOptionPane.INFORMATION_MESSAGE);
				paneles.get(0).setVisible(true);
			}
		});
		btnDesconectar.setBounds(771, 575, 185, 23);
		panelViajesEventos.add(btnDesconectar);
		
		
	}
	public JPanel getPanel() {
		
		return panelViajesEventos;
	}
}
