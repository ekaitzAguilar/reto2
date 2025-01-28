package agenciaViajesPaneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GestorNuevoViaje {

	private JPanel panelNuevoViaje;
	private JTextField textFieldNombreViaje;
	private JTextArea textAreaDescrip;
	private JTextArea textAreaServNoIncl;
	private JDatePickerImpl datePickerInicio;
	private JDatePickerImpl datePickerFin;
	private JLabel lblCantidadDias;
	private JComboBox<String> comboBoxTipoViaje;
	private JComboBox<String> comboBoxPaises;

	public GestorNuevoViaje(ArrayList<JPanel> paneles) {

		panelNuevoViaje = new JPanel();
		panelNuevoViaje.setBackground(Color.LIGHT_GRAY);
		panelNuevoViaje.setBounds(0, 0, 1039, 666);
		panelNuevoViaje.setLayout(null);

		JLabel lblNombreViaje = new JLabel("NOMBRE VIAJE");
		lblNombreViaje.setBounds(46, 92, 122, 20);
		panelNuevoViaje.add(lblNombreViaje);

		JLabel lblTipoViaje = new JLabel("TIPO DE VIAJE");
		lblTipoViaje.setBounds(47, 130, 122, 20);
		panelNuevoViaje.add(lblTipoViaje);

		JLabel lblNewLabel = new JLabel("NUEVO VIAJE");
		lblNewLabel.setBounds(46, 32, 234, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelNuevoViaje.add(lblNewLabel);

		JLabel lblInicioViaje = new JLabel("INICIO VIAJE");
		lblInicioViaje.setBounds(46, 195, 122, 20);
		panelNuevoViaje.add(lblInicioViaje);

		JLabel lblFinViaje = new JLabel("FIN VIAJE");
		lblFinViaje.setBounds(46, 236, 122, 20);
		panelNuevoViaje.add(lblFinViaje);

		JLabel lblDias = new JLabel("DIAS");
		lblDias.setBounds(46, 282, 122, 20);
		panelNuevoViaje.add(lblDias);

		lblCantidadDias = new JLabel("0");
		lblCantidadDias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadDias.setForeground(new Color(255, 0, 0));
		lblCantidadDias.setBounds(185, 285, 122, 14);
		panelNuevoViaje.add(lblCantidadDias);

		JLabel lblPais = new JLabel("PAIS");
		lblPais.setBounds(46, 336, 122, 20);
		panelNuevoViaje.add(lblPais);

		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(46, 449, 122, 20);
		panelNuevoViaje.add(lblDescripcion);

		JLabel lblServiciosNoIncluidos = new JLabel("SERVICIOS NO INCLUIDOS");
		lblServiciosNoIncluidos.setBounds(46, 567, 171, 20);
		panelNuevoViaje.add(lblServiciosNoIncluidos);

		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(691, 44, 219, 133);
		panelNuevoViaje.add(lblLogo);

		// Campo de texto para el nombre del viaje
		textFieldNombreViaje = new JTextField();
		textFieldNombreViaje.setBounds(185, 92, 203, 20);
		panelNuevoViaje.add(textFieldNombreViaje);
		textFieldNombreViaje.setColumns(10);

		// Combobox para el tipo de viaje
		comboBoxTipoViaje = new JComboBox();
		comboBoxTipoViaje.setBounds(186, 129, 203, 22);
		comboBoxTipoViaje.setModel(new DefaultComboBoxModel(
				new String[] { "Senior", "Grupos", "Grandes viajes (destinos exóticos + vuelo + alojamiento)",
						"Escapada", "Familias (con niños pequeños)" }));
		panelNuevoViaje.add(comboBoxTipoViaje);

		// Datepicker para la fecha de inicio
		JDatePickerImpl datePickerInicio = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerInicio.setBounds(185, 195, 203, 30);
		panelNuevoViaje.add(datePickerInicio);

		// Datepicker para la fecha de fin
		JDatePickerImpl datePickerFin = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerFin.setBounds(185, 236, 203, 30);
		panelNuevoViaje.add(datePickerFin);

		// Área de texto para la descripción
		textAreaDescrip = new JTextArea();
		textAreaDescrip.setBounds(244, 385, 203, 84);
		panelNuevoViaje.add(textAreaDescrip);

		// Área de texto para servicios no incluidos
		JTextArea textAreaServNoIncl = new JTextArea();
		textAreaServNoIncl.setBounds(244, 503, 203, 84);
		panelNuevoViaje.add(textAreaServNoIncl);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarCampos(textFieldNombreViaje, datePickerInicio, datePickerFin, textAreaDescrip,
						textAreaServNoIncl)) {
					System.out.println("Todos los datos son válidos. Guardando información...");
				} else {
					JOptionPane.showMessageDialog(panelNuevoViaje,
							"Por favor, complete todos los campos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
				}

				paneles.get(10).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnGuardar.setBounds(380, 631, 117, 29);
		panelNuevoViaje.add(btnGuardar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//resetearCampos();
				//volverAInicio();

				paneles.get(10).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		btnCancelar.setBounds(589, 631, 117, 29);
		panelNuevoViaje.add(btnCancelar);

		JComboBox comboBoxPais = new JComboBox();
		comboBoxPais.setModel(new DefaultComboBoxModel(new String[] { "Opcion 1", "opcion 2" }));
		comboBoxPais.setBounds(185, 335, 203, 22);
		panelNuevoViaje.add(comboBoxPais);

//		// Listener para calcular los días entre las fechas (Inicio)
//		datePickerInicio.addActionListener(new java.awt.event.ActionListener() {
//		    @Override
//		    public void actionPerformed(java.awt.event.ActionEvent e) {
//		        calcularDias(datePickerInicio, datePickerFin, lblCantidadDias);
//		    }
//		});
//
//		// Listener para calcular los días entre las fechas (Fin)
//		datePickerFin.addActionListener(new java.awt.event.ActionListener() {
//		    @Override
//		    public void actionPerformed(java.awt.event.ActionEvent e) {
//		        calcularDias(datePickerInicio, datePickerFin, lblCantidadDias);
//		    }
//		});
	}

	// Método para validar todos los campos obligatorios
	private boolean validarCampos(JTextField textFieldNombre, JDatePickerImpl datePickerInicio,
			JDatePickerImpl datePickerFin, JTextArea textAreaDescripcion, JTextArea textAreaServicios) {

		// Validar que el nombre del viaje no esté vacío
		if (textFieldNombre.getText().trim().isEmpty()) {
			return false;
		}

		// Validar que la fecha de inicio sea posterior o igual a la fecha actual
		Date fechaInicio = (Date) datePickerInicio.getModel().getValue();
		if (fechaInicio != null) {
			Date fechaActual = new Date();
			if (fechaInicio.before(fechaActual)) {
				return false;
			}
		}

		// Validar que la fecha de fin sea posterior a la fecha de inicio
		Date fechaFin = (Date) datePickerFin.getModel().getValue();
		if (fechaInicio != null && fechaFin != null) {
			if (!fechaFin.after(fechaInicio)) {
				return false;
			}
		}

		// Validar que la descripción no esté vacía
		if (textAreaDescripcion.getText().trim().isEmpty()) {
			return false;
		}

		// Validar que los servicios no incluidos no estén vacíos
		if (textAreaServicios.getText().trim().isEmpty()) {
			return false;
		}

		// Todos los campos son válidos
		return true;
	}

	private void resetearCampos() {
		textFieldNombreViaje.setText("");
		textAreaDescrip.setText("");
		textAreaServNoIncl.setText("");

		datePickerInicio.getModel().setValue(null);
		datePickerFin.getModel().setValue(null);

		comboBoxPaises.setSelectedIndex(0);

		lblCantidadDias.setText("0");
	}

	private void volverAInicio() {
		panelNuevoViaje.setVisible(false);
		// Ir al panel de login
	}

//	// Método para calcular los días entre dos fechas y actualizar la etiqueta
//	private void calcularDias(JDatePickerImpl datePickerInicio, JDatePickerImpl datePickerFin, JLabel lblCantidadDias) {
//		Date fechaInicio = (Date) datePickerInicio.getModel().getValue();
//		Date fechaFin = (Date) datePickerFin.getModel().getValue();
//
//
//			lblCantidadDias.setText(String.valueOf(dias));
//		} else {
//			lblCantidadDias.setText("0");
//		}
//	}

	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return panelNuevoViaje;
	}
}
