package agenciaViajesPaneles;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestorEleccionIda {

	private JPanel gestorEleccionIda;
	private JTextField tfNombreEvento;
	private JTextField tfCodVuelo;
	private JTextField tfAerolinea;
	private JTextField tfPrecio;
	private JTextField tfHorario;
	private JTextField tfDuracion;

	/**
	 * Create the panel.
	 */
	public GestorEleccionIda(ArrayList<JPanel> paneles) {

		gestorEleccionIda = new JPanel();
		gestorEleccionIda.setBackground(Color.LIGHT_GRAY);
		gestorEleccionIda.setBounds(0, 0, 1039, 666);
		gestorEleccionIda.setLayout(null);

		JLabel lbNombreEvento = new JLabel("NOMBRE EVENTO");
		lbNombreEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNombreEvento.setBounds(148, 78, 110, 17);
		gestorEleccionIda.add(lbNombreEvento);

		tfNombreEvento = new JTextField();
		tfNombreEvento.setBounds(309, 74, 130, 26);
		gestorEleccionIda.add(tfNombreEvento);
		tfNombreEvento.setColumns(10);

		JLabel lblTipoEvento = new JLabel("TIPO EVENTO");
		lblTipoEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoEvento.setBounds(148, 119, 86, 17);
		gestorEleccionIda.add(lblTipoEvento);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) comboBox.getSelectedItem();

				if (seleccion.equals("VUELO")) {
					paneles.get(5).setVisible(false);
					paneles.get(5).setVisible(true);
				}
				if (seleccion.equals("ALOJAMIENTO")) {
					paneles.get(5).setVisible(false);
					paneles.get(4).setVisible(true);

				}

				if (seleccion.equals("ACTIVIDAD")) {
					paneles.get(5).setVisible(false);
					paneles.get(8).setVisible(true);
				}
			}
		});

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar...", "VUELO", "ALOJAMIENTO", "ACTIVIDAD" }));
		comboBox.setBounds(309, 116, 151, 27);
		gestorEleccionIda.add(comboBox);

		JComboBox comboBoxIdaYVuelta = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String seleccion = (String) comboBox.getSelectedItem();
				if (seleccion.equals("IDA")) {
					paneles.get(5).setVisible(false);
					paneles.get(5).setVisible(true);
				}
				if (seleccion.equals("IDA Y VUELTA")) {
					paneles.get(5).setVisible(false);
					paneles.get(3).setVisible(true);

				}

			}
		});

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar...", "VUELO", "ALOJAMIENTO", "ACTIVIDAD" }));
		comboBox.setBounds(309, 116, 151, 27);
		gestorEleccionIda.add(comboBox);

		JLabel lbTrayecto = new JLabel("TRAYECTO");
		lbTrayecto.setHorizontalAlignment(SwingConstants.CENTER);
		lbTrayecto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTrayecto.setBounds(148, 161, 67, 17);
		gestorEleccionIda.add(lbTrayecto);

		JLabel lbOrigen = new JLabel("AEROPUERTO ORIGEN");
		lbOrigen.setBounds(148, 206, 151, 16);
		gestorEleccionIda.add(lbOrigen);

		JLabel lbDestino = new JLabel("AEROPUERTO DESTINO");
		lbDestino.setBounds(148, 244, 151, 16);
		gestorEleccionIda.add(lbDestino);

		JDatePickerImpl datePickerVueloIda = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerVueloIda.setBounds(309, 274, 151, 30);
		gestorEleccionIda.add(datePickerVueloIda);

		JLabel lbCodVuelo = new JLabel("CODIGO VUELO");
		lbCodVuelo.setBounds(148, 320, 151, 16);
		gestorEleccionIda.add(lbCodVuelo);

		JLabel lbAerolinea = new JLabel("AEROLINEA");
		lbAerolinea.setBounds(148, 358, 151, 16);
		gestorEleccionIda.add(lbAerolinea);

		JLabel lbPrecio = new JLabel("PRECIO");
		lbPrecio.setBounds(148, 396, 61, 16);
		gestorEleccionIda.add(lbPrecio);

		JLabel lbHorario = new JLabel("HORARIO");
		lbHorario.setBounds(148, 432, 61, 16);
		gestorEleccionIda.add(lbHorario);

		JLabel lbDuracion = new JLabel("DURACION");
		lbDuracion.setBounds(148, 471, 97, 16);
		gestorEleccionIda.add(lbDuracion);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paneles.get(5).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnGuardar.setBounds(275, 568, 117, 29);
		gestorEleccionIda.add(btnGuardar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paneles.get(5).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnCancelar.setBounds(538, 568, 117, 29);
		gestorEleccionIda.add(btnCancelar);

		JComboBox comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setBounds(309, 196, 151, 39);
		gestorEleccionIda.add(comboBoxOrigen);

		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setBounds(309, 234, 151, 39);
		gestorEleccionIda.add(comboBoxDestino);

		JButton btnBuscar = new JButton("BUSCAR VIAJE");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(482, 216, 117, 29);
		gestorEleccionIda.add(btnBuscar);

		tfCodVuelo = new JTextField();
		tfCodVuelo.setEditable(false);
		tfCodVuelo.setBounds(309, 315, 130, 26);
		gestorEleccionIda.add(tfCodVuelo);
		tfCodVuelo.setColumns(10);

		tfAerolinea = new JTextField();
		tfAerolinea.setEditable(false);
		tfAerolinea.setColumns(10);
		tfAerolinea.setBounds(309, 353, 130, 26);
		gestorEleccionIda.add(tfAerolinea);

		tfPrecio = new JTextField();
		tfPrecio.setEditable(false);
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(309, 391, 130, 26);
		gestorEleccionIda.add(tfPrecio);

		tfHorario = new JTextField();
		tfHorario.setEditable(false);
		tfHorario.setColumns(10);
		tfHorario.setBounds(309, 427, 130, 26);
		gestorEleccionIda.add(tfHorario);

		tfDuracion = new JTextField();
		tfDuracion.setEditable(false);
		tfDuracion.setColumns(10);
		tfDuracion.setBounds(309, 466, 130, 26);
		gestorEleccionIda.add(tfDuracion);

		JLabel lbFecIdaVuelo = new JLabel("FECHA IDA");
		lbFecIdaVuelo.setBounds(148, 287, 124, 16);
		gestorEleccionIda.add(lbFecIdaVuelo);

	}

	public JPanel getPanel() {

		return gestorEleccionIda;
	}
}