package Interfaz.InterfazAplicacionHotel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Aplicacion.Huespedes.Huesped;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Servicio;

public class CheckInInterfaz extends JPanel implements ActionListener {

    private InterfazPrincipalJFrame ventanaPadre;
    private JFrame hijoAgregarHuesped;
    private JLabel lbDocumento, lbHuespedesFaltantes, lbTitulo;
    private JButton btnBuscar, btnConfirmar, btnCancelar, btnAgregarHuesped, btnEliminar, btnSalir;
    private JTextField txtFDocumento, txtFHuespedesRestantes;
    private JTextArea textFHuespedes;

    private ArrayList<Huesped> huespedesAnadir;
    private Reserva reservaCheckIn;

    public CheckInInterfaz(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        
        this.ventanaPadre = interfazPrincipalJFrame;
        this.reservaCheckIn = null;
        this.huespedesAnadir = new ArrayList<Huesped>();

		Border vacio = BorderFactory.createEmptyBorder(); // estos son cosas que comparten todos los botones

        setLayout(new BorderLayout());
        setSize(800, 600);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(vacio);
        panelSuperior.setLayout(new FlowLayout());
        panelSuperior.setPreferredSize(new Dimension(800, 100));
        panelSuperior.setMaximumSize(getPreferredSize());

        JPanel panelInferior = new JPanel();
        panelInferior.setBorder(vacio);
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setPreferredSize(new Dimension(800, 100));
        panelInferior.setMaximumSize(getPreferredSize());

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBorder(vacio);
        panelIzquierdo.setLayout(new FlowLayout(0,5,20));
        panelIzquierdo.setPreferredSize(new Dimension(400, 400));
        panelIzquierdo.setMaximumSize(getPreferredSize());

        JPanel panelDerecho = new JPanel();
        panelDerecho.setBorder(vacio);
        panelDerecho.setLayout(new FlowLayout());
        panelDerecho.setPreferredSize(new Dimension(400, 400));
        panelDerecho.setMaximumSize(getPreferredSize());

        lbTitulo = new JLabel("Hacer Check In");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        lbTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbTitulo.setAlignmentY(Component.CENTER_ALIGNMENT);

        lbDocumento = new JLabel("Documento:");
        lbDocumento.setFont(new Font("Arial", Font.BOLD, 20));
        lbDocumento.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbDocumento.setAlignmentY(Component.CENTER_ALIGNMENT);
        lbDocumento.setPreferredSize(new Dimension(130, 20));
        lbDocumento.setMaximumSize(getPreferredSize());

        lbHuespedesFaltantes = new JLabel("Huespedes Faltantes:");
        lbHuespedesFaltantes.setFont(new Font("Arial", Font.BOLD, 20));
        lbHuespedesFaltantes.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbHuespedesFaltantes.setAlignmentY(Component.CENTER_ALIGNMENT);

        txtFDocumento = new JTextField(); 
        txtFDocumento.setFont(new Font("Arial", Font.BOLD, 20));
        txtFDocumento.setAlignmentY(Component.CENTER_ALIGNMENT);
        txtFDocumento.setPreferredSize(new Dimension(120, 20));
        txtFDocumento.setMaximumSize(getPreferredSize());

        txtFHuespedesRestantes = new JTextField();
        txtFHuespedesRestantes.setFont(new Font("Arial", Font.BOLD, 20));
        txtFHuespedesRestantes.setAlignmentY(Component.CENTER_ALIGNMENT);
        txtFHuespedesRestantes.setEditable(false);
        txtFHuespedesRestantes.setPreferredSize(new Dimension(120, 20));
        txtFHuespedesRestantes.setMaximumSize(getPreferredSize());

        textFHuespedes = new JTextArea();
        textFHuespedes.setFont(new Font("Arial", Font.BOLD, 20));
        textFHuespedes.setAlignmentY(CENTER_ALIGNMENT);
        textFHuespedes.setAlignmentX(CENTER_ALIGNMENT);
        textFHuespedes.setEditable(false);
        textFHuespedes.setPreferredSize(new Dimension(390, 390));
        textFHuespedes.setMaximumSize(getPreferredSize());
        textFHuespedes.setBorder(vacio);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 20));
        btnBuscar.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnBuscar.addActionListener(this);
        btnBuscar.setActionCommand("BUSCAR");
        btnBuscar.setPreferredSize(new Dimension(120, 20));

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Arial", Font.BOLD, 20));
        btnConfirmar.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnConfirmar.addActionListener(this);
        btnConfirmar.setActionCommand("CONFIRMAR");

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 20));
        btnCancelar.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnCancelar.addActionListener(this);
        btnCancelar.setActionCommand("CANCELAR");

        btnAgregarHuesped = new JButton("Agregar Huesped");
        btnAgregarHuesped.setFont(new Font("Arial", Font.BOLD, 20));
        btnAgregarHuesped.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnAgregarHuesped.addActionListener(this);
        btnAgregarHuesped.setActionCommand("AGREGAR_HUESPED");

        btnEliminar = new JButton("Eliminar Huesped");
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 20));
        btnEliminar.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnEliminar.addActionListener(this);
        btnEliminar.setActionCommand("ELIMINAR_HUESPED");

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
        btnSalir.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("SALIR");

        panelSuperior.add(lbTitulo);

        panelIzquierdo.add(lbDocumento);
        panelIzquierdo.add(txtFDocumento);
        panelIzquierdo.add(btnBuscar);
        panelIzquierdo.add(lbHuespedesFaltantes);
        panelIzquierdo.add(txtFHuespedesRestantes);
        
        panelDerecho.add(textFHuespedes);

        panelInferior.add(btnAgregarHuesped);
        panelInferior.add(btnEliminar);
        panelInferior.add(btnConfirmar);
        panelInferior.add(btnCancelar);
        panelInferior.add(btnSalir);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if(grito.equals("BUSCAR")){
            if(txtFDocumento.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ingrese un documento");
            }
            
            else {
                reservaCheckIn = ventanaPadre.ConseguirReserva(txtFDocumento.getText());
                if(reservaCheckIn == null){
                    JOptionPane.showMessageDialog(this, "No se encontro la reserva");
                }
                else if(reservaCheckIn.getEstadoReserva().equals("cancelado") || reservaCheckIn.getEstadoReserva().equals("terminado") || reservaCheckIn.getEstadoReserva().equals("checked")){
                    reservaCheckIn = null;
                    JOptionPane.showMessageDialog(this, "El estado de la reserva es '" + reservaCheckIn.getEstadoReserva() + "' no se puede hacer check in");
                }
                else {
                    txtFHuespedesRestantes.setText(String.valueOf(reservaCheckIn.getPersonasEsperadas() - 1));
                    textFHuespedes.setText("");
                    for(int i = 0; i < reservaCheckIn.getGrupo().size(); i++){
                        huespedesAnadir.add(reservaCheckIn.getGrupo().get(i));
                        textFHuespedes.append(reservaCheckIn.getGrupo().get(i).getNombre() + "\n");
                    }
                }
            }
        }
        else if(grito.equals("CONFIRMAR")){
            if(reservaCheckIn == null){
                JOptionPane.showMessageDialog(this, "No hay reserva para confirmar");
            }
            else if(reservaCheckIn.getGrupo().size() != huespedesAnadir.size()) {
                JOptionPane.showMessageDialog(this, "No se agregaron todos los huespedes");
            }
            else {
                for (Huesped huesped : huespedesAnadir) {
                    String documentoPrincipal = reservaCheckIn.getGrupo().get(0).getDocumento();
                    String documentoSecundario = huesped.getDocumento();
                    String nombre = huesped.getNombre();
                    String correo = huesped.getCorreo();
                    String celular = huesped.getCelular();

                    ventanaPadre.HacerCheckIn(documentoPrincipal, documentoSecundario, nombre, correo, celular);
                }
                JOptionPane.showMessageDialog(this, "Check In realizado con exito");
                
                huespedesAnadir.removeAll(huespedesAnadir);
                reservaCheckIn = null;

                txtFDocumento.setText("");
                txtFHuespedesRestantes.setText("");
                textFHuespedes.setText("");
        
            }
        }
        else if(grito.equals("CANCELAR")){
            huespedesAnadir.removeAll(huespedesAnadir);
            reservaCheckIn = null;
            txtFDocumento.setText("");
            txtFHuespedesRestantes.setText("");
            textFHuespedes.setText("");
        }
        else if(grito.equals("AGREGAR_HUESPED")){
            if(reservaCheckIn == null){
                JOptionPane.showMessageDialog(this, "No hay reserva para agregar huesped");
            }
            else {
                hijoAgregarHuesped = new AgregarHuespedJFrame(this);
            }
        }
        else if(grito.equals("ELIMINAR_HUESPED")){
            if(reservaCheckIn == null){
                JOptionPane.showMessageDialog(this, "No hay reserva para eliminar huesped");
            }
            else if(huespedesAnadir.size() == 1){
                JOptionPane.showMessageDialog(this, "No se puede eliminar al huesped lider");
            }
            else {
                huespedesAnadir.remove(huespedesAnadir.size() - 1);
                textFHuespedes.setText("");
                for (Huesped huesped : huespedesAnadir) {
                    textFHuespedes.append(huesped.getNombre() + "\n");
                }
                txtFHuespedesRestantes.setText(String.valueOf(Integer.parseInt(txtFHuespedesRestantes.getText()) + 1));
            }
        }
        else if(grito.equals("SALIR")) {
            huespedesAnadir.removeAll(huespedesAnadir);
            reservaCheckIn = null;
            textFHuespedes.setText("");
            txtFDocumento.setText("");
            txtFHuespedesRestantes.setText("");

            if(hijoAgregarHuesped !=null){
                hijoAgregarHuesped.dispatchEvent(new WindowEvent(hijoAgregarHuesped, WindowEvent.WINDOW_CLOSING));
            }
            
            ventanaPadre.IrAPanelConsolaMenu();
        }
    }

    public void agregarHuesped(String nombre, String documento, String correo, String celular) {
        Huesped huesped = new Huesped(nombre, documento, correo, celular, new ArrayList<Servicio>());
        huespedesAnadir.add(huesped);
        textFHuespedes.append(huesped.getNombre() + "\n");
        txtFHuespedesRestantes.setText(String.valueOf(Integer.parseInt(txtFHuespedesRestantes.getText()) - 1));
    }

    public int getHuespedesRestantes() {
        return Integer.parseInt(txtFHuespedesRestantes.getText());
    }
}
