package Interfaz.InterfazAplicacionHotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

import Aplicacion.Habitaciones.HabitacionBase;

public class CrearReserva extends JPanel implements ActionListener{

    private InterfazPrincipalJFrame ventanaPadre;
    private JPanel jpFiltros;
    private JLabel lbFFechaInicial, lbFFechaFinal, lbFAtributos, lbFTipoHabitacion;
    private JTextField txtfFechaInicial, txtfFechaFinal;
    private JButton btnFBuscar;
    private JCheckBox jcxVista, jcxBalcon, jcxCocina, jcxEstandar, jcxSuite, jcxDoble;
    
    private JPanel jpReservar;
    private JLabel lbRFechaInicial, lbRFechaFinal, lbRPersonas, lbRDocumento, lbRNombre, lbRCorreo, lbRCelular;
    private JTextField txtfRFechaInicial, txtfRFechaFinal, txtfRPersonas, txtfRDocumento, txtfRNombre, txtfRCorreo, txtfRCelular;

    private JPanel jpListaHabitaciones;
    private JLabel lbHabitacionesDisponibles, lbHabitacionesReservadas, lbHID;
    private JTextField txtfHID;
    private JTextArea txtAListaHabitacionesDisponibles, txtAListaHabitacionesReservadas;
    private JButton btnHAgregarHabitacion;

    private JPanel jpBotonesPrincipales;
    private JButton btnRReservar, btnRCancelar, btnRSalir, btnEliminarHabitacion;

    private HashMap<String, HabitacionBase> habitacionesDisponibles;
    private ArrayList<HabitacionBase> habitacionesAReservar;
    private String dateFormat;
    java.util.Date fechaInicialBusqueda;
    private java.util.Date fechaFinalBusqueda;

    public CrearReserva(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        
        this.ventanaPadre = interfazPrincipalJFrame;
        this.habitacionesDisponibles = new HashMap<String, HabitacionBase>();
        this.habitacionesAReservar = new ArrayList<HabitacionBase>();
        this.dateFormat = "dd/MM/yyyy";

        setLayout(new BorderLayout());
        
        Border bdFiltros = BorderFactory.createTitledBorder("Filtros");
        jpFiltros = new JPanel();
        jpFiltros.setBorder(bdFiltros);
        jpFiltros.setLayout(new FlowLayout(1,0,3));
        jpFiltros.setAlignmentY(TOP_ALIGNMENT);
        jpFiltros.setPreferredSize(new Dimension(800, 220));
        jpFiltros.setMaximumSize(getPreferredSize());

        JPanel jpAuxFiltrosAtributosYTipos = new JPanel();
        jpAuxFiltrosAtributosYTipos.setLayout(new FlowLayout());
        jpAuxFiltrosAtributosYTipos.setPreferredSize(new Dimension(800, 75));
        jpAuxFiltrosAtributosYTipos.setMaximumSize(getPreferredSize());

        JPanel jpAuxFiltrosFechas = new JPanel();
        jpAuxFiltrosFechas.setLayout(new FlowLayout());
        jpAuxFiltrosFechas.setPreferredSize(new Dimension(800, 75));
        jpAuxFiltrosFechas.setMaximumSize(getPreferredSize());

        JPanel jpAuxAtributos = new JPanel(new FlowLayout(1,10,0));
        jpAuxAtributos.setPreferredSize(new Dimension(800, 75/2));
        jpAuxAtributos.setMaximumSize(getPreferredSize());

        lbFAtributos = new JLabel("Atributos:   ");
        lbFAtributos.setFont(new Font("Arial", Font.BOLD, 28));

        jcxVista = new JCheckBox("Vista");
        jcxVista.setIcon (new MetalCheckBoxIcon () {protected int getControlSize() { return 20; }});
        jcxBalcon = new JCheckBox("Balcon");
        jcxBalcon.setIcon (new MetalCheckBoxIcon () {protected int getControlSize() { return 20; }});
        jcxCocina = new JCheckBox("Cocina");
        jcxCocina.setIcon (new MetalCheckBoxIcon () {protected int getControlSize() { return 20; }});

        jpAuxAtributos.add(lbFAtributos);
        jpAuxAtributos.add(jcxVista);
        jpAuxAtributos.add(jcxBalcon);
        jpAuxAtributos.add(jcxCocina);

        JPanel jpAuxTipos = new JPanel(new FlowLayout(1,10,0));
        jpAuxTipos.setPreferredSize(new Dimension(800, 75/2));
        jpAuxTipos.setMaximumSize(getPreferredSize());

        lbFTipoHabitacion = new JLabel("Habitacion:");
        lbFTipoHabitacion.setFont(new Font("Arial", Font.BOLD, 28));

        jcxEstandar = new JCheckBox("Estandar");
        jcxEstandar.setIcon (new MetalCheckBoxIcon () {protected int getControlSize() { return 20; }});
        jcxSuite = new JCheckBox("Suite");
        jcxSuite.setIcon (new MetalCheckBoxIcon () {protected int getControlSize() { return 20; }});
        jcxDoble = new JCheckBox("Doble");
        jcxDoble.setIcon (new MetalCheckBoxIcon () {protected int getControlSize() { return 20; }});

        ButtonGroup checkBoxGroup = new ButtonGroup();
        checkBoxGroup.add(jcxEstandar);
        checkBoxGroup.add(jcxSuite);
        checkBoxGroup.add(jcxDoble);

        jpAuxTipos.add(lbFTipoHabitacion);
        jpAuxTipos.add(jcxEstandar);
        jpAuxTipos.add(jcxSuite);
        jpAuxTipos.add(jcxDoble);

        JPanel jpAuxInputFechaInicial = new JPanel(new FlowLayout(1, 20, 0));
        jpAuxInputFechaInicial.setPreferredSize(new Dimension(800, 30));
        jpAuxInputFechaInicial.setMaximumSize(getPreferredSize());

        lbFFechaInicial = new JLabel("Fecha Inicial:");
        lbFFechaInicial.setFont(new Font("Arial", Font.BOLD, 28));

        txtfFechaInicial = new JTextField();
        txtfFechaInicial.setFont(new Font("Arial", Font.PLAIN, 24));
        txtfFechaInicial.setPreferredSize(new Dimension(300, 30));
        txtfFechaInicial.setMaximumSize(getPreferredSize());

        jpAuxInputFechaInicial.add(lbFFechaInicial);
        jpAuxInputFechaInicial.add(txtfFechaInicial);

        JPanel jpAuxInputFechaFinal = new JPanel(new FlowLayout(1, 20, 0));
        jpAuxInputFechaFinal.setPreferredSize(new Dimension(800, 30));
        jpAuxInputFechaFinal.setMaximumSize(getPreferredSize());

        lbFFechaFinal = new JLabel("Fecha Final:  ");
        lbFFechaFinal.setFont(new Font("Arial", Font.BOLD, 28));

        txtfFechaFinal = new JTextField();
        txtfFechaFinal.setFont(new Font("Arial", Font.PLAIN, 24));
        txtfFechaFinal.setPreferredSize(new Dimension(300, 30));
        txtfFechaFinal.setMaximumSize(getPreferredSize());

        jpAuxInputFechaFinal.add(lbFFechaFinal);
        jpAuxInputFechaFinal.add(txtfFechaFinal);

        btnFBuscar = new JButton("Buscar");
        btnFBuscar.addActionListener(this);
        btnFBuscar.setActionCommand("BUSCAR");
        btnFBuscar.setPreferredSize(new Dimension(100, 30));

        jpAuxFiltrosAtributosYTipos.add(jpAuxAtributos);
        jpAuxFiltrosAtributosYTipos.add(jpAuxTipos);

        jpAuxFiltrosFechas.add(jpAuxInputFechaInicial);
        jpAuxFiltrosFechas.add(jpAuxInputFechaFinal);
        
        jpFiltros.add(jpAuxFiltrosAtributosYTipos);
        jpFiltros.add(jpAuxFiltrosFechas);
        jpFiltros.add(btnFBuscar);


        Border bdHabitaciones = BorderFactory.createTitledBorder("Habitaciones");
        jpListaHabitaciones = new JPanel();
        jpListaHabitaciones.setBorder(bdHabitaciones);
        jpListaHabitaciones.setLayout(new FlowLayout(0,5,0));
        jpListaHabitaciones.setPreferredSize(new Dimension(300, 300));
        jpListaHabitaciones.setMaximumSize(getPreferredSize());

        JPanel jpAuxLHDispnibles = new JPanel();
        jpAuxLHDispnibles.setLayout(new FlowLayout(0,0,5));
        jpAuxLHDispnibles.setPreferredSize(new Dimension(140, 250));

        lbHabitacionesDisponibles = new JLabel("Habitaciones disponibles");
        lbHabitacionesDisponibles.setFont(new Font("Arial", Font.BOLD, 10));
        lbHabitacionesDisponibles.setPreferredSize(new Dimension(140, 30));
        lbHabitacionesDisponibles.setMaximumSize(getPreferredSize());

        txtAListaHabitacionesDisponibles = new JTextArea();
        txtAListaHabitacionesDisponibles.setFont(new Font("Arial", Font.PLAIN, 10));
        txtAListaHabitacionesDisponibles.setPreferredSize(new Dimension(140,200));
        txtAListaHabitacionesDisponibles.setMaximumSize(getPreferredSize());
        txtAListaHabitacionesDisponibles.setEditable(false);

        jpAuxLHDispnibles.add(lbHabitacionesDisponibles);
        jpAuxLHDispnibles.add(txtAListaHabitacionesDisponibles);

        JPanel jpAuxLHReservadas = new JPanel();
        jpAuxLHReservadas.setLayout(new FlowLayout(0,0,5));
        jpAuxLHReservadas.setPreferredSize(new Dimension(140, 250));
        jpAuxLHReservadas.setMaximumSize(getPreferredSize());

        lbHabitacionesReservadas = new JLabel("Habitaciones reservadas");
        lbHabitacionesReservadas.setFont(new Font("Arial", Font.BOLD, 10));
        lbHabitacionesReservadas.setPreferredSize(new Dimension(140, 30));
        lbHabitacionesReservadas.setMaximumSize(getPreferredSize());

        txtAListaHabitacionesReservadas = new JTextArea();
        txtAListaHabitacionesReservadas.setFont(new Font("Arial", Font.PLAIN, 10));
        txtAListaHabitacionesReservadas.setPreferredSize(new Dimension(140, 200));
        txtAListaHabitacionesReservadas.setMaximumSize(getPreferredSize());
        txtAListaHabitacionesReservadas.setEditable(false);

        jpAuxLHReservadas.add(lbHabitacionesReservadas);
        jpAuxLHReservadas.add(txtAListaHabitacionesReservadas);

        lbHID = new JLabel("Id habitacion: ");
        lbHID.setFont(new Font("Arial", Font.BOLD, 12));
        lbHID.setPreferredSize(new Dimension(80, 30));
        lbHID.setMaximumSize(getPreferredSize());

        txtfHID = new JTextField();
        txtfHID.setFont(new Font("Arial", Font.PLAIN, 12));
        txtfHID.setPreferredSize(new Dimension(80, 30));
        txtfHID.setMaximumSize(getPreferredSize());

        btnHAgregarHabitacion = new JButton("Agregar");
        btnHAgregarHabitacion.addActionListener(this);
        btnHAgregarHabitacion.setActionCommand("AGREGAR_HABITACION");
        btnHAgregarHabitacion.setPreferredSize(new Dimension(80, 30));
        btnHAgregarHabitacion.setMaximumSize(getPreferredSize());

        jpListaHabitaciones.add(jpAuxLHDispnibles);
        jpListaHabitaciones.add(jpAuxLHReservadas);
        jpListaHabitaciones.add(lbHID);
        jpListaHabitaciones.add(txtfHID);
        jpListaHabitaciones.add(btnHAgregarHabitacion);

        Border bdReservaciones = BorderFactory.createTitledBorder("Reservar");
        jpReservar = new JPanel();
        jpReservar.setBorder(bdReservaciones);
        jpReservar.setLayout(new FlowLayout(1,0,20));
        jpReservar.setPreferredSize(new Dimension(490, 300));
        jpReservar.setMaximumSize(getPreferredSize());

        JPanel jpAuxRFechas = new JPanel();
        jpAuxRFechas.setLayout(new FlowLayout(0,0,5));
        jpAuxRFechas.setPreferredSize(new Dimension(480, 60));

        lbRFechaInicial = new JLabel("Fecha Inicial: ");
        lbRFechaInicial.setFont(new Font("Arial", Font.BOLD, 20));
        lbRFechaInicial.setPreferredSize(new Dimension(255, 20));

        txtfRFechaInicial = new JTextField();
        txtfRFechaInicial.setFont(new Font("Arial", Font.PLAIN, 16));
        txtfRFechaInicial.setPreferredSize(new Dimension(150, 20));

        lbRFechaFinal = new JLabel("Fecha Final: ");
        lbRFechaFinal.setFont(new Font("Arial", Font.BOLD, 20));
        lbRFechaFinal.setPreferredSize(new Dimension(255, 20));

        txtfRFechaFinal = new JTextField();
        txtfRFechaFinal.setFont(new Font("Arial", Font.PLAIN, 16));
        txtfRFechaFinal.setPreferredSize(new Dimension(150, 20));

        jpAuxRFechas.add(lbRFechaInicial);
        jpAuxRFechas.add(txtfRFechaInicial);
        jpAuxRFechas.add(lbRFechaFinal);
        jpAuxRFechas.add(txtfRFechaFinal);

        JPanel jpAuxRInput = new JPanel();
        jpAuxRInput.setLayout(new FlowLayout(0));
        jpAuxRInput.setPreferredSize(new Dimension(490, 130));

        lbRDocumento = new JLabel("Documento: ");
        lbRDocumento.setFont(new Font("Arial", Font.BOLD, 20));
        lbRDocumento.setPreferredSize(new Dimension(250, 20));
        lbRDocumento.setMaximumSize(getPreferredSize());

        txtfRDocumento = new JTextField();
        txtfRDocumento.setFont(new Font("Arial", Font.PLAIN, 16));
        txtfRDocumento.setPreferredSize(new Dimension(150, 20));
        txtfRDocumento.setMaximumSize(getPreferredSize());

        lbRNombre = new JLabel("Nombre: ");
        lbRNombre.setFont(new Font("Arial", Font.BOLD, 20));
        lbRNombre.setPreferredSize(new Dimension(250, 20));
        lbRNombre.setMaximumSize(getPreferredSize());

        txtfRNombre = new JTextField();
        txtfRNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        txtfRNombre.setPreferredSize(new Dimension(150, 20));
        txtfRNombre.setMaximumSize(getPreferredSize());

        lbRCorreo = new JLabel("Correo: ");
        lbRCorreo.setFont(new Font("Arial", Font.BOLD, 20));
        lbRCorreo.setPreferredSize(new Dimension(250, 20));
        lbRCorreo.setMaximumSize(getPreferredSize());

        txtfRCorreo = new JTextField();
        txtfRCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
        txtfRCorreo.setPreferredSize(new Dimension(150, 20));
        txtfRCorreo.setMaximumSize(getPreferredSize());

        lbRCelular = new JLabel("Celular: ");
        lbRCelular.setFont(new Font("Arial", Font.BOLD, 20));
        lbRCelular.setPreferredSize(new Dimension(250, 20));
        lbRCelular.setMaximumSize(getPreferredSize());

        txtfRCelular = new JTextField();
        txtfRCelular.setFont(new Font("Arial", Font.PLAIN, 16));
        txtfRCelular.setPreferredSize(new Dimension(150, 20));
        txtfRCelular.setMaximumSize(getPreferredSize());

        lbRPersonas = new JLabel("Personas esperadas: ");
        lbRPersonas.setFont(new Font("Arial", Font.BOLD, 20));
        lbRPersonas.setPreferredSize(new Dimension(250, 20));
        lbRPersonas.setMaximumSize(getPreferredSize());

        txtfRPersonas = new JTextField();
        txtfRPersonas.setFont(new Font("Arial", Font.PLAIN, 16));
        txtfRPersonas.setPreferredSize(new Dimension(150, 20));
        txtfRPersonas.setMaximumSize(getPreferredSize());

        jpAuxRInput.add(lbRDocumento);
        jpAuxRInput.add(txtfRDocumento);
        jpAuxRInput.add(lbRNombre);
        jpAuxRInput.add(txtfRNombre);
        jpAuxRInput.add(lbRCorreo);
        jpAuxRInput.add(txtfRCorreo);
        jpAuxRInput.add(lbRCelular);
        jpAuxRInput.add(txtfRCelular);
        jpAuxRInput.add(lbRPersonas);
        jpAuxRInput.add(txtfRPersonas);

        jpBotonesPrincipales = new JPanel();
        jpBotonesPrincipales.setLayout(new FlowLayout(1,10,0));
        jpBotonesPrincipales.setPreferredSize(new Dimension(500, 50));
        jpBotonesPrincipales.setMaximumSize(getPreferredSize());

        btnEliminarHabitacion = new JButton("Eliminar");
        btnEliminarHabitacion.setFont(new Font("Arial", Font.BOLD, 16));
        btnEliminarHabitacion.setPreferredSize(new Dimension(100, 40));
        btnEliminarHabitacion.setMaximumSize(getPreferredSize());
        btnEliminarHabitacion.addActionListener(this);
        btnEliminarHabitacion.setActionCommand("ELIMINAR_HABITACION");

        btnRReservar = new JButton("Reservar");
        btnRReservar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRReservar.setPreferredSize(new Dimension(100, 40));
        btnRReservar.setMaximumSize(getPreferredSize());
        btnRReservar.addActionListener(this);
        btnRReservar.setActionCommand("RESERVAR");

        btnRCancelar = new JButton("Cancelar");
        btnRCancelar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRCancelar.setPreferredSize(new Dimension(100, 40));
        btnRCancelar.setMaximumSize(getPreferredSize());
        btnRCancelar.addActionListener(this);
        btnRCancelar.setActionCommand("CANCELAR");

        btnRSalir = new JButton("Salir");
        btnRSalir.setFont(new Font("Arial", Font.BOLD, 16));
        btnRSalir.setPreferredSize(new Dimension(100, 40));
        btnRSalir.setMaximumSize(getPreferredSize());
        btnRSalir.addActionListener(this);
        btnRSalir.setActionCommand("SALIR");

        jpBotonesPrincipales.add(btnEliminarHabitacion);
        jpBotonesPrincipales.add(btnRReservar);
        jpBotonesPrincipales.add(btnRCancelar);
        jpBotonesPrincipales.add(btnRSalir);

        jpReservar.add(jpAuxRFechas);
        jpReservar.add(jpAuxRInput);
        jpReservar.add(jpBotonesPrincipales);


        jpBotonesPrincipales = new JPanel();
        jpBotonesPrincipales.setLayout(new FlowLayout(1,10,0));
        jpBotonesPrincipales.setPreferredSize(new Dimension(500, 50));
        jpBotonesPrincipales.setMaximumSize(getPreferredSize());

        add(jpFiltros, BorderLayout.NORTH);
        add(jpListaHabitaciones, BorderLayout.WEST);
        add(jpReservar, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "BUSCAR":
                buscarHabitaciones();
                break;
            case "RESERVAR":
                reservarHabitacion();
                break;
            case "CANCELAR":
                cancelarReserva();
                break;
            case "SALIR":
                ventanaPadre.IrAPanelConsolaMenu();
                break;
            case "ELIMINAR_HABITACION":
                eliminarHabitacion();
                break;
            case "AGREGAR_HABITACION":
                agregarHabitacion();
                break;
            default:
                break;
        }
    }

    private void agregarHabitacion() {
        String idHabitacion = txtfHID.getText();

        if (idHabitacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un ID de habitacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(habitacionesDisponibles.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay habitaciones disponibles", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!habitacionesDisponibles.containsKey(idHabitacion)){
            JOptionPane.showMessageDialog(this, "La habitacion no está entre las habitaciones disponibles", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            habitacionesAReservar.add(habitacionesDisponibles.get(idHabitacion));
            txtAListaHabitacionesReservadas.setText(txtAListaHabitacionesReservadas.getText() + idHabitacion + "\n");

            habitacionesDisponibles.remove(idHabitacion);
            txtAListaHabitacionesDisponibles.setText("");
            for (HabitacionBase habitacion : habitacionesDisponibles.values()) {
                txtAListaHabitacionesDisponibles.setText(txtAListaHabitacionesDisponibles.getText()+ habitacion.getUbicacion() + ": " + habitacion.getId() + "\n");
            }
        }
    }

    private void eliminarHabitacion() {
        if(habitacionesAReservar.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay habitaciones para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            HabitacionBase habitacionDisponible = habitacionesAReservar.get(habitacionesAReservar.size() - 1);
            habitacionesDisponibles.put(habitacionDisponible.getId(), habitacionDisponible);
            habitacionesAReservar.remove(habitacionesAReservar.size() - 1);

            txtAListaHabitacionesReservadas.setText("");
            for (HabitacionBase habitacion : habitacionesAReservar) {
                txtAListaHabitacionesReservadas.setText(txtAListaHabitacionesReservadas.getText() + habitacion.getUbicacion() + ": " + habitacion.getId() + "\n");
            }

            txtAListaHabitacionesDisponibles.setText("");
            for (HabitacionBase habitacion : habitacionesDisponibles.values()) {
                txtAListaHabitacionesDisponibles.setText(txtAListaHabitacionesDisponibles.getText() + habitacion.getUbicacion() + ": " + habitacion.getId() + "\n");
            }
        }
        
    }

    private void cancelarReserva() {
        habitacionesAReservar.clear();
        jpListaHabitaciones.removeAll();
        
        txtfRDocumento.setText("");
        txtfRNombre.setText("");
        txtfRCorreo.setText("");
        txtfRCelular.setText("");
        txtfRPersonas.setText("");

        txtAListaHabitacionesDisponibles.setText("");
        txtAListaHabitacionesReservadas.setText("");

        txtfRFechaInicial.setText("");
        txtfRFechaFinal.setText("");

        txtfRFechaInicial.setEditable(true);
        txtfRFechaFinal.setEditable(true);
    }

    private void reservarHabitacion() {
        SimpleDateFormat sdf = new SimpleDateFormat(this.dateFormat);
        
        try {

            if(habitacionesAReservar.isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una habitacion", "Error", JOptionPane.ERROR_MESSAGE);
                
            }

            else if(txtfRDocumento.getText().equals("") || txtfRNombre.getText().equals("") || txtfRCorreo.getText().equals("") || txtfRCelular.getText().equals("") || txtfRPersonas.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else if(!isValid(txtfRFechaInicial.getText()) || !isValid(txtfRFechaFinal.getText())){
                JOptionPane.showMessageDialog(this, "Las fechas ingresadas no son validas", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            else {
                java.util.Date fechaInicial = sdf.parse(txtfRFechaInicial.getText());
                java.util.Date fechaFinal = sdf.parse(txtfRFechaFinal.getText());

                if(fechaInicial.compareTo(fechaFinal) >= 0){
                    JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser menor a la fecha de fin", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(fechaInicial.compareTo(fechaInicialBusqueda) < 0){
                    JOptionPane.showMessageDialog(this, "La fecha de inicio debe estar en el rango de fechas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(fechaFinal.compareTo(fechaFinalBusqueda) > 0){
                    JOptionPane.showMessageDialog(this, "La fecha de fin debe estar en el rango de fechas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else{
                    double precioReserva = ventanaPadre.CrearReserva(txtfRDocumento.getText(), "reservado", Integer.parseInt(txtfRPersonas.getText()) , txtfRFechaInicial.getText(), txtfRFechaFinal.getText(), habitacionesAReservar, txtfRNombre.getText(), txtfRCorreo.getText(), txtfRCelular.getText());
                    JOptionPane.showMessageDialog(this, "La reserva se ha realizado con exito, el precio total es: " + precioReserva, "Reserva exitosa", JOptionPane.INFORMATION_MESSAGE);

                    txtfFechaInicial.setEditable(true);
                    txtfFechaFinal.setEditable(true);

                    txtfRDocumento.setText("");
                    txtfRNombre.setText("");
                    txtfRCorreo.setText("");
                    txtfRCelular.setText("");
                    txtfRPersonas.setText("");
                    txtfRFechaInicial.setEditable(true);
                    txtfRFechaFinal.setEditable(true);
                    txtfRFechaInicial.setText("");
                    txtfRFechaFinal.setText("");
                    txtfRFechaInicial.setEditable(true);
                    txtfFechaFinal.setEditable(true);
                    txtfFechaInicial.setText("");
                    txtfFechaFinal.setText("");
                    txtAListaHabitacionesDisponibles.setText("");
                    txtAListaHabitacionesReservadas.setText("");
                    txtfHID.setText("");
                    
                }
                
            }

        }
        
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "Error al hacer la reservacion de la habitacion", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void buscarHabitaciones() {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);

        try {

            if(txtfFechaInicial.getText().equals("") || txtfFechaFinal.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe ingresar las fechas de inicio y fin de la reserva", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(!isValid(txtfFechaInicial.getText()) || !isValid(txtfFechaFinal.getText())){
                JOptionPane.showMessageDialog(this, "Las fechas ingresadas no son validas", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(sdf.parse(txtfFechaInicial.getText()).compareTo(sdf.parse(txtfFechaFinal.getText())) >= 0){
                JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser menor a la fecha de fin", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(jcxEstandar.isSelected() == false && jcxSuite.isSelected() == false && jcxDoble.isSelected() == false){
                JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un tipo de habitacion", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                String tipoHabitacion;

                if(jcxEstandar.isSelected() == true){
                    tipoHabitacion = "estandar";
                }
                else if(jcxSuite.isSelected() == true){
                    tipoHabitacion = "suite";
                }
                else if(jcxDoble.isSelected() == true){
                    tipoHabitacion = "doble";
                }
                else{
                    tipoHabitacion = "estandar";
                }

                ArrayList<HabitacionBase> ListaHabitacionesDisponibles = ventanaPadre.buscarHabitaciones(jcxCocina.isSelected(), jcxBalcon.isSelected(), jcxVista.isSelected(), txtfFechaInicial.getText(), txtfFechaFinal.getText(), tipoHabitacion);

                System.out.println(jcxCocina.isSelected());
                System.out.println(jcxBalcon.isSelected());
                System.out.println(jcxVista.isSelected());
                System.out.println(txtfFechaInicial.getText());
                System.out.println(txtfFechaFinal.getText());
                System.out.println(tipoHabitacion);

                if(ListaHabitacionesDisponibles.size() == 0){
                    JOptionPane.showMessageDialog(this, "No se encontraron habitaciones disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    txtfFechaInicial.setEditable(false);
                    txtfFechaFinal.setEditable(false);

                    fechaInicialBusqueda = sdf.parse(txtfFechaInicial.getText());
                    fechaFinalBusqueda = sdf.parse(txtfFechaFinal.getText());


                    txtAListaHabitacionesDisponibles.setText("");

                    for (HabitacionBase habitacion : ListaHabitacionesDisponibles) {
                        txtAListaHabitacionesDisponibles.append(habitacion.getUbicacion() + ": " + habitacion.getId() + "\n");
                        this.habitacionesDisponibles.put(habitacion.getId(), habitacion);
                    }
                }

            }

        } catch (HeadlessException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Hubo un error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Hubo un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    
}
