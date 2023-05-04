package Interfaz.ClasesReHechas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelOpciones extends JPanel {
	private JLabel lbBienvenido;
	private JButton btnCrearReserva;
	private JButton btnInfoReserva;
	private JButton btnCheckIn;
	private JButton btnCheckOut;
	private JButton btnAnadir;
	private JButton btnCambiarTarifa;
	private JButton btnOcupacion;
	private JButton btnSalir;

	public PanelOpciones(Boolean admin) {
		setPreferredSize(new Dimension(800, 800));

		Dimension tamanho = new Dimension(300, 100);
		Color grisaceo = new Color(148, 142, 142);
		Font fuente = new Font("Arial", Font.BOLD, 20);
		Border vacio = BorderFactory.createEmptyBorder(); // estos son cosas que comparten todos los botones

		lbBienvenido = new JLabel("Seleccione una opción");
		lbBienvenido.setPreferredSize(new Dimension(800, 150));
		lbBienvenido.setFont(new Font("Arial", Font.BOLD, 50));
		lbBienvenido.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbBienvenido.setAlignmentY(Component.CENTER_ALIGNMENT);

		btnCrearReserva = new JButton("Crear reserva");
		btnCrearReserva.setPreferredSize(tamanho);
		btnCrearReserva.setMaximumSize(tamanho);
		btnCrearReserva.setBackground(grisaceo);
		btnCrearReserva.setFont(fuente);
		btnCrearReserva.setBorder(vacio);

		btnInfoReserva = new JButton("Informacion reserva");
		btnInfoReserva.setPreferredSize(tamanho);
		btnInfoReserva.setMaximumSize(tamanho);
		btnInfoReserva.setBackground(grisaceo);
		btnInfoReserva.setFont(fuente);
		btnInfoReserva.setBorder(vacio);

		btnCheckIn = new JButton("Hacer check-in");
		btnCheckIn.setPreferredSize(tamanho);
		btnCheckIn.setMaximumSize(tamanho);
		btnCheckIn.setBackground(grisaceo);
		btnCheckIn.setFont(fuente);
		btnCheckIn.setBorder(vacio);

		btnCheckOut = new JButton("Hacer check-out");
		btnCheckOut.setPreferredSize(tamanho);
		btnCheckOut.setMaximumSize(tamanho);
		btnCheckOut.setBackground(grisaceo);
		btnCheckOut.setFont(fuente);
		btnCheckOut.setBorder(vacio);

		btnAnadir = new JButton("Añadir servicios");
		btnAnadir.setPreferredSize(tamanho);
		btnAnadir.setMaximumSize(tamanho);
		btnAnadir.setBackground(grisaceo);
		btnAnadir.setFont(fuente);
		btnAnadir.setBorder(vacio);

		btnSalir = new JButton("Salir");
		btnSalir.setPreferredSize(tamanho);
		btnSalir.setMaximumSize(tamanho);
		btnSalir.setBackground(Color.RED);
		btnSalir.setFont(fuente);
		btnSalir.setBorder(vacio);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(Box.createVerticalStrut(20));
		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new GridLayout(4, 2, 15, 15));

		add(lbBienvenido);

		add(Box.createVerticalStrut(10));

		auxiliar.add(btnCrearReserva);
		auxiliar.add(btnInfoReserva);
		auxiliar.add(btnCheckIn);
		auxiliar.add(btnCheckOut);
		auxiliar.add(btnAnadir);

		if (admin) { // if para añadir las opciones de admin
			btnCambiarTarifa = new JButton("Cambiar tarifa");
			btnCambiarTarifa.setPreferredSize(tamanho);
			btnCambiarTarifa.setMaximumSize(tamanho);
			btnCambiarTarifa.setBackground(grisaceo);
			btnCambiarTarifa.setFont(fuente);
			btnCambiarTarifa.setBorder(vacio);

			btnOcupacion = new JButton("Consultar ocupacion");
			btnOcupacion.setPreferredSize(tamanho);
			btnOcupacion.setMaximumSize(tamanho);
			btnOcupacion.setBackground(grisaceo);
			btnOcupacion.setFont(fuente);
			btnOcupacion.setBorder(vacio);
			// setMaximumSize(tamanho);
			auxiliar.add(btnCambiarTarifa);
			auxiliar.add(btnOcupacion);
		}
		auxiliar.add(btnSalir);
		JPanel auxiliarX = new JPanel();
		auxiliarX.setLayout(new BoxLayout(auxiliarX, BoxLayout.X_AXIS));
		auxiliarX.add(Box.createHorizontalStrut(20));
		auxiliarX.add(auxiliar);
		auxiliarX.add(Box.createHorizontalStrut(20));
		add(auxiliarX);
		add(Box.createVerticalStrut(80));
	}

}
