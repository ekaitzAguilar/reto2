package agenciaViajesMain;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import agenciaViajesPaneles.GestorActividad;
import agenciaViajesPaneles.GestorBienvenida;
import agenciaViajesPaneles.GestorEleccionEvento;
import agenciaViajesPaneles.GestorEleccionIda;
import agenciaViajesPaneles.GestorEleccionTrayecto;
import agenciaViajesPaneles.GestorHabitacionTipo;
import agenciaViajesPaneles.GestorIdaVuelta;
import agenciaViajesPaneles.GestorLogin;
import agenciaViajesPaneles.GestorNuevoPerfil;
import agenciaViajesPaneles.GestorNuevoViaje;
import agenciaViajesPaneles.GestorViajesEventos;

public class Main {

	public JFrame frame;
	private ArrayList<JPanel> paneles = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {

		initialize();

	}

	/**
	 * Create the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1039, 666);
		frame.setLocationRelativeTo(null);// pone la ventana en el centro de la pantalla

		paneles = new ArrayList<JPanel>();

		// Creamos los gestores y los paneles. Y pasamos la lista por el constructor.
		GestorBienvenida gestorBienvenida = new GestorBienvenida(paneles);
		JPanel panel1 = gestorBienvenida.getPanel();
		paneles.add(panel1); // 0

		GestorLogin gestorLogin = new GestorLogin(paneles);
		JPanel panel2 = gestorLogin.getPanel();
		paneles.add(panel2); // 1

		GestorViajesEventos gestorViajesYEventos = new GestorViajesEventos(paneles);
		JPanel panel3 = gestorViajesYEventos.getPanel();
		paneles.add(panel3); // 2

		GestorIdaVuelta gestorVuelta = new GestorIdaVuelta(paneles);
		JPanel panel4 = gestorVuelta.getPanel();
		paneles.add(panel4); // 3

		GestorHabitacionTipo gestorEventoTipo = new GestorHabitacionTipo(paneles);
		JPanel panel5 = gestorEventoTipo.getPanel();
		paneles.add(panel5); // 4

		GestorEleccionIda gestorElecionIda = new GestorEleccionIda(paneles);
		JPanel panel6 = gestorElecionIda.getPanel();
		paneles.add(panel6); // 5

		GestorEleccionTrayecto gestorEleccionTrayecto = new GestorEleccionTrayecto(paneles);
		JPanel panel7 = gestorEleccionTrayecto.getPanel();
		paneles.add(panel7);

		GestorEleccionEvento gestorEleccionEvento = new GestorEleccionEvento(paneles);
		JPanel panel8 = gestorEleccionEvento.getPanel();
		paneles.add(panel8);

		GestorActividad gestorActividad = new GestorActividad(paneles);
		JPanel panel9 = gestorActividad.getPanel();
		paneles.add(panel9);

		GestorNuevoPerfil gestorNuevoPerfil = new GestorNuevoPerfil(paneles);
		JPanel panel10 = gestorNuevoPerfil.getPanel();
		paneles.add(panel10);

		GestorNuevoViaje gestorNuevoViaje = new GestorNuevoViaje(paneles);
		JPanel panel11 = gestorNuevoViaje.getPanel();
		paneles.add(panel11);

		frame.add(paneles.get(0)).setVisible(true);// bienvenida
		frame.add(paneles.get(1)).setVisible(false);// login
		frame.add(paneles.get(2)).setVisible(false);// viajesEventos
		frame.add(paneles.get(3)).setVisible(false);// idaVuelta
		frame.add(paneles.get(4)).setVisible(false);// habitacionTipo
		frame.add(paneles.get(5)).setVisible(false);// ida
		frame.add(paneles.get(6)).setVisible(false);// eleccionTrayecto
		frame.add(paneles.get(7)).setVisible(false);// tipoEvento
		frame.add(paneles.get(8)).setVisible(false);// actividad
		frame.add(paneles.get(9)).setVisible(false);// nuevoPerfil
		frame.add(paneles.get(10)).setVisible(false);// nuevoViaje
	}
}
