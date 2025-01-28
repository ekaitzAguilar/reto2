package agenciaViajesPaneles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestorIdaVuelta  {

	

	private JTextField tfDuracion;
	private JTextField tfCodVuelo;
	private JTextField tfNombreEvento;
	private JPanel gestorIdaVuelta;
	private JTextField tfAerolinea;
	private JTextField tfHorario;
	private JTextField tfDuracionVuelta;
	private JTextField tfHorarioVuelta;
	private JTextField tfPrecioTotal;
	private JTextField tfAerolineaV;
	private JTextField tfCodVueloVuelta;

	/**
	 * Create the panel.
	 */
	public GestorIdaVuelta(ArrayList<JPanel> paneles) {
		

		gestorIdaVuelta = new JPanel();	
		gestorIdaVuelta.setBackground(Color.LIGHT_GRAY);
		gestorIdaVuelta.setBounds(0, 0, 1039, 666);
		gestorIdaVuelta.setLayout(null);	
		
		JLabel lbNombreEvento = new JLabel("NOMBRE EVENTO");
		lbNombreEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNombreEvento.setBounds(148, 78, 110, 17);
		gestorIdaVuelta.add(lbNombreEvento);
		
		tfNombreEvento = new JTextField();
		tfNombreEvento.setBounds(309, 74, 130, 26);
		gestorIdaVuelta.add(tfNombreEvento);
		tfNombreEvento.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("TIPO EVENTO");
		lblTipoEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoEvento.setBounds(148, 119, 86, 17);
		gestorIdaVuelta.add(lblTipoEvento);
		
		
		
		JLabel lbTrayecto = new JLabel("TRAYECTO");
		lbTrayecto.setHorizontalAlignment(SwingConstants.CENTER);
		lbTrayecto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTrayecto.setBounds(148, 161, 67, 17);
		gestorIdaVuelta.add(lbTrayecto);
		
		
		
		
		
		JLabel lbOrigen = new JLabel("AEROPUERTO ORIGEN");
		lbOrigen.setBounds(148, 206, 151, 16);
		gestorIdaVuelta.add(lbOrigen);
		
		JLabel lbDestino = new JLabel("AEROPUERTO DESTINO");
		lbDestino.setBounds(148, 244, 151, 16);
		gestorIdaVuelta.add(lbDestino);
		
		JLabel lbFecIda = new JLabel("FECHA IDA");
		lbFecIda.setBounds(148, 281, 110, 16);
		gestorIdaVuelta.add(lbFecIda);
		
		JDatePickerImpl datePickerFecIda = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerFecIda.setBounds(309, 277, 151, 30);
		gestorIdaVuelta.add(datePickerFecIda);
		
		JLabel lbCodVuelo = new JLabel("CODIGO VUELO");
		lbCodVuelo.setBounds(148, 320, 151, 16);
		gestorIdaVuelta.add(lbCodVuelo);
		
		JLabel lbAerolinea = new JLabel("AEROLINEA");
		lbAerolinea.setBounds(148, 358, 151, 16);
		gestorIdaVuelta.add(lbAerolinea);
		
		JLabel lbHorario = new JLabel("HORARIO");
		lbHorario.setBounds(148, 432, 61, 16);
		gestorIdaVuelta.add(lbHorario);
		
		JLabel lbDuracion = new JLabel("DURACION");
		lbDuracion.setBounds(148, 471, 97, 16);
		gestorIdaVuelta.add(lbDuracion);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(3).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnGuardar.setBounds(275, 568, 117, 29);
		gestorIdaVuelta.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paneles.get(3).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnCancelar.setBounds(538, 568, 117, 29);
		gestorIdaVuelta.add(btnCancelar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar...", "VUELO", "ALOJAMIENTO", "ACTIVIDAD" }));
		comboBox.setBounds(309, 158, 151, 27);
		gestorIdaVuelta.add(comboBox);

		JComboBox comboBoxIdaYVuelta = new JComboBox();
		comboBoxIdaYVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String seleccion = (String) comboBox.getSelectedItem();
				if (seleccion.equals("IDA")) {
					paneles.get(3).setVisible(false);
					paneles.get(5).setVisible(true);
				}
				if (seleccion.equals("IDA Y VUELTA")) {
					paneles.get(3).setVisible(false);
					paneles.get(3).setVisible(true);

				}

			}
		});

		comboBoxIdaYVuelta.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar...", "VUELO", "ALOJAMIENTO", "ACTIVIDAD" }));
		comboBoxIdaYVuelta.setBounds(309, 116, 151, 27);
		gestorIdaVuelta.add(comboBoxIdaYVuelta);
		
		JComboBox comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setBounds(309, 196, 151, 39);
		gestorIdaVuelta.add(comboBoxOrigen);
		
		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setBounds(309, 234, 151, 39);
		gestorIdaVuelta.add(comboBoxDestino);
		
		JButton btnBuscar = new JButton("BUSCAR VIAJE");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(482, 216, 117, 29);
		gestorIdaVuelta.add(btnBuscar);
				
		tfCodVuelo = new JTextField();
		tfCodVuelo.setEditable(false);
		tfCodVuelo.setBounds(309, 315, 130, 26);
		gestorIdaVuelta.add(tfCodVuelo);
		tfCodVuelo.setColumns(10);
		
		tfAerolinea = new JTextField();
		tfAerolinea.setEditable(false);
		tfAerolinea.setColumns(10);
		tfAerolinea.setBounds(309, 353, 130, 26);
		gestorIdaVuelta.add(tfAerolinea);
		
		tfHorario = new JTextField();
		tfHorario.setEditable(false);
		tfHorario.setColumns(10);
		tfHorario.setBounds(309, 427, 130, 26);
		gestorIdaVuelta.add(tfHorario);
		
		tfDuracion = new JTextField();
		tfDuracion.setEditable(false);
		tfDuracion.setColumns(10);
		tfDuracion.setBounds(309, 466, 130, 26);
		gestorIdaVuelta.add(tfDuracion);
		
		JLabel lbFecVuelta = new JLabel("FECHA VUELTA");
		lbFecVuelta.setBounds(506, 281, 110, 16);
		gestorIdaVuelta.add(lbFecVuelta);
		
		JDatePickerImpl datePickerFecVuelta = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerFecVuelta.setBounds(680, 267, 151, 30);
		gestorIdaVuelta.add(datePickerFecVuelta);
		
		JLabel lbCodVueloVuelta = new JLabel("CODIGO VUELO");
		lbCodVueloVuelta.setBounds(506, 320, 151, 16);
		gestorIdaVuelta.add(lbCodVueloVuelta);
		
		JLabel lbAerolineaVuelta = new JLabel("AEROLINEA VUELTA");
		lbAerolineaVuelta.setBounds(506, 358, 151, 16);
		gestorIdaVuelta.add(lbAerolineaVuelta);
		
		JLabel lbPrecioTotal = new JLabel("PRECIO TOTAL");
		lbPrecioTotal.setBounds(506, 396, 130, 16);
		gestorIdaVuelta.add(lbPrecioTotal);
		
		JLabel lbHorarioVuelta = new JLabel("HORARIO VUELTA");
		lbHorarioVuelta.setBounds(506, 432, 130, 16);
		gestorIdaVuelta.add(lbHorarioVuelta);
		
		JLabel lblDuracionVuelta = new JLabel("DURACION VUELTA");
		lblDuracionVuelta.setBounds(506, 471, 130, 16);
		gestorIdaVuelta.add(lblDuracionVuelta);
		
		tfDuracionVuelta = new JTextField();
		tfDuracionVuelta.setEditable(false);
		tfDuracionVuelta.setColumns(10);
		tfDuracionVuelta.setBounds(677, 466, 130, 26);
		gestorIdaVuelta.add(tfDuracionVuelta);
		
		tfHorarioVuelta = new JTextField();
		tfHorarioVuelta.setEditable(false);
		tfHorarioVuelta.setColumns(10);
		tfHorarioVuelta.setBounds(677, 427, 130, 26);
		gestorIdaVuelta.add(tfHorarioVuelta);
		
		tfPrecioTotal = new JTextField();
		tfPrecioTotal.setEditable(false);
		tfPrecioTotal.setColumns(10);
		tfPrecioTotal.setBounds(677, 391, 130, 26);
		gestorIdaVuelta.add(tfPrecioTotal);
		
		tfAerolineaV = new JTextField();
		tfAerolineaV.setEditable(false);
		tfAerolineaV.setColumns(10);
		tfAerolineaV.setBounds(677, 353, 130, 26);
		gestorIdaVuelta.add(tfAerolineaV);
		
		tfCodVueloVuelta = new JTextField();
		tfCodVueloVuelta.setEditable(false);
		tfCodVueloVuelta.setColumns(10);
		tfCodVueloVuelta.setBounds(677, 315, 130, 26);
		gestorIdaVuelta.add(tfCodVueloVuelta);

	}
	public JPanel getPanel() {
		
		return gestorIdaVuelta;
	}

}