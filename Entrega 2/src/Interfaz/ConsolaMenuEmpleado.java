package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ConsolaMenuEmpleado extends JPanel implements ActionListener{
    
    private InterfazPrincipalJFrame ventanaPadre;
    private JLabel lbBienvenido;
    private JButton btnCrearReserva;
    private JButton btnInfoReserva;
    private JButton btnCheckIn;
    private JButton btnCheckOut;
    private JButton btnAnadir;
    private JButton btnCambiarTarifa;
    private JButton btnOcupacion;
    private JButton btnSalir;

    public ConsolaMenuEmpleado(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        this.ventanaPadre = interfazPrincipalJFrame;

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
        btnCrearReserva.addActionListener(this);
        btnCrearReserva.setActionCommand("CREAR_RESERVA");

		btnInfoReserva = new JButton("Informacion reserva");
		btnInfoReserva.setPreferredSize(tamanho);
		btnInfoReserva.setMaximumSize(tamanho);
		btnInfoReserva.setBackground(grisaceo);
		btnInfoReserva.setFont(fuente);
		btnInfoReserva.setBorder(vacio);
        btnInfoReserva.addActionListener(this);
        btnInfoReserva.setActionCommand("INFO_RESERVA");

		btnCheckIn = new JButton("Hacer check-in");
		btnCheckIn.setPreferredSize(tamanho);
		btnCheckIn.setMaximumSize(tamanho);
		btnCheckIn.setBackground(grisaceo);
		btnCheckIn.setFont(fuente);
		btnCheckIn.setBorder(vacio);
        btnCheckIn.addActionListener(this);
        btnCheckIn.setActionCommand("CHECK_IN");

		btnCheckOut = new JButton("Hacer check-out");
		btnCheckOut.setPreferredSize(tamanho);
		btnCheckOut.setMaximumSize(tamanho);
		btnCheckOut.setBackground(grisaceo);
		btnCheckOut.setFont(fuente);
		btnCheckOut.setBorder(vacio);
        btnCheckOut.addActionListener(this);
        btnCheckOut.setActionCommand("CHECK_OUT");

		btnAnadir = new JButton("Añadir servicios");
		btnAnadir.setPreferredSize(tamanho);
		btnAnadir.setMaximumSize(tamanho);
		btnAnadir.setBackground(grisaceo);
		btnAnadir.setFont(fuente);
		btnAnadir.setBorder(vacio);
        btnAnadir.addActionListener(this);
        btnAnadir.setActionCommand("ANADIR_SERVICIOS");

		btnSalir = new JButton("Salir");
		btnSalir.setPreferredSize(tamanho);
		btnSalir.setMaximumSize(tamanho);
		btnSalir.setBackground(Color.RED);
		btnSalir.setFont(fuente);
		btnSalir.setBorder(vacio);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("SALIR");

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

        if (this instanceof ConsolaMenuAdmin) { // if para añadir las opciones de admin
			btnCambiarTarifa = new JButton("Cambiar tarifa");
			btnCambiarTarifa.setPreferredSize(tamanho);
			btnCambiarTarifa.setMaximumSize(tamanho);
			btnCambiarTarifa.setBackground(grisaceo);
			btnCambiarTarifa.setFont(fuente);
			btnCambiarTarifa.setBorder(vacio);
            btnCambiarTarifa.addActionListener(this);
            btnCambiarTarifa.setActionCommand("CAMBIAR_TARIFA");

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
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if(grito.equals("CREAR_RESERVA")){
            ventanaPadre.IrAPanelCrearReserva();
        }
        else if(grito.equals("INFO_RESERVA")){
            ventanaPadre.IrAPanelInfoReserva();
        }
        else if(grito.equals("CHECK_IN")){
            ventanaPadre.IrAPanelCheckIn();
        }
        else if(grito.equals("CHECK_OUT")){
            ventanaPadre.IrAPanelCheckOut();
        }
        else if(grito.equals("ANADIR_SERVICIOS")){
            ventanaPadre.IrAPanelAnadirServicios();
        }
        else if(grito.equals("CAMBIAR_TARIFA")){
            ventanaPadre.IrAPanelCambiarTarifa();
        }
        else if(grito.equals("CONSULTAR_OCUPACION")){
            ventanaPadre.IrAPanelConsultarOcupacion();
        }
        else if(grito.equals("SALIR")){
            ventanaPadre.IrAPanelLogin();
        }

    }
    
}
