package Interfaz.InterfazAplicacionHotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Servicio;

public class CheckOutInterfaz extends JPanel implements ActionListener {

    private String servicios;
    private Double total;
    private InterfazPrincipalJFrame ventanaPadre;
    private JPanel searchPanel, checkOutPanel, buttonPanel;
    private JLabel lbDocumento, lbTitle;
    private JTextField txtDocumento;
    private JButton btnBuscar, btnSalir, btnConfirmarSalida, btnPagar;
    private String documento;
    private Reserva reserva;
    private Font fuente;
    private Border vacio;
    private boolean pagado = false;
    private boolean permitirpag = false;

    public CheckOutInterfaz(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        // Empty info
        servicios = "";
        total = 0.0;

        ventanaPadre = interfazPrincipalJFrame;
        setLayout(new BorderLayout());
        setBackground(new Color(148, 142, 142));
        fuente = new Font("Arial", Font.BOLD, 20);
        vacio = BorderFactory.createEmptyBorder();

        searchPanel = getSearchPanel();
        checkOutPanel = getCheckOutPanel(servicios, total);
        buttonPanel = getButtonPanel();

        add(searchPanel, BorderLayout.PAGE_START);
        add(checkOutPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);

    }

    public String getDocumento() {
        return documento;
    }

    public String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    // Panel de search por documento
    public JPanel getSearchPanel() {
        searchPanel = new JPanel();
        // searchPanel.setBackground(new Color(148, 142, 142));
        searchPanel.setLayout(new BorderLayout(40, 20));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Search elements
        txtDocumento = new JTextField();
        txtDocumento.setBackground(Color.WHITE);
        txtDocumento.setPreferredSize(new Dimension(100, 30));
        lbDocumento = new JLabel("Documento del huésped principal");
        lbDocumento.setFont(fuente);
        lbTitle = new JLabel("Hacer Check Out");
        lbTitle.setFont(fuente);
        // border
        lbDocumento.setBorder(vacio);
        lbTitle.setBorder(vacio);
        txtDocumento.setBorder(vacio);

        // Buttons
        btnBuscar = new JButton("Buscar");
        btnBuscar.setPreferredSize(new Dimension(200, 45));
        btnBuscar.setBackground(Color.BLACK);
        // btnIngresar.setForeground(Color.WHITE);
        btnBuscar.setFont(fuente);
        btnBuscar.setMaximumSize(new Dimension(200, 200));
        btnBuscar.addActionListener(this);
        btnBuscar.setActionCommand("BUSCAR");

        // Añadir elementos al panel
        searchPanel.add(lbTitle, BorderLayout.PAGE_START);
        searchPanel.add(lbDocumento, BorderLayout.LINE_START);
        searchPanel.add(txtDocumento, BorderLayout.CENTER);
        searchPanel.add(btnBuscar, BorderLayout.PAGE_END);

        return searchPanel;
    }

    // Panel de información de reservas
    public JPanel getCheckOutPanel(String servicios, Double totalDouble) {
        String totalString = totalDouble.toString();
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200));

        // Labels primera columna, text segunda columna
        JLabel serviciosLabel = new JLabel("Servicios");
        JTextField serviciosTextField = new JTextField();
        serviciosTextField.setEditable(false);
        JLabel totalLabel = new JLabel("Total a pagar");
        JTextField fechaFTextField = new JTextField();
        fechaFTextField.setEditable(false);

        // Set text fields
        serviciosTextField.setText(servicios);
        fechaFTextField.setText(totalString);

        // Adding components to the panel
        panel.add(serviciosLabel);
        panel.add(serviciosTextField);
        panel.add(totalLabel);
        panel.add(fechaFTextField);

        return panel;
    }

    public JPanel getButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Buttons
        btnSalir = new JButton("Salir");
        btnSalir.setPreferredSize(new Dimension(200, 45));
        btnSalir.setBackground(Color.BLACK);
        // btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(fuente);
        btnSalir.setMaximumSize(new Dimension(200, 200));
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("SALIR");

        btnConfirmarSalida = new JButton("Confirmar Salida");
        btnConfirmarSalida.setPreferredSize(new Dimension(200, 45));
        btnConfirmarSalida.setBackground(Color.BLACK);
        // btnConfirmarSalida.setForeground(Color.WHITE);
        btnConfirmarSalida.setFont(fuente);
        btnConfirmarSalida.setMaximumSize(new Dimension(200, 200));
        btnConfirmarSalida.addActionListener(this);
        btnConfirmarSalida.setActionCommand("CONFIRMAR");

        btnPagar = new JButton("Pagar");
        btnPagar.setPreferredSize(new Dimension(200, 45));
        btnPagar.setBackground(Color.BLACK);
        // btnConfirmarSalida.setForeground(Color.WHITE);
        btnPagar.setFont(fuente);
        btnPagar.setMaximumSize(new Dimension(200, 200));
        btnPagar.addActionListener(this);
        btnPagar.setActionCommand("PAGAR");

        // Añadir elementos al panel

        buttonPanel.add(btnSalir);
        buttonPanel.add(btnConfirmarSalida);
        buttonPanel.add(btnPagar);

        return buttonPanel;
    }

    private void updateCheckoutInfo(HashMap<String, ArrayList<Servicio>> serviciosConsumidosPorNombreHuesped) {
        // fechaini + "," + total + "," + personasEs + "," + cantidadHab + "," + id;

        for (String nombreHuesped : serviciosConsumidosPorNombreHuesped.keySet()) {
            ArrayList<Servicio> serviciosConsumidos = serviciosConsumidosPorNombreHuesped.get(nombreHuesped);
            for (Servicio servicio : serviciosConsumidos) {
                total = 0.0;
                servicios = "";
                servicios += servicio.getNombre() + " " + servicio.getPrecio() + "\n";
                total += servicio.getPrecio();
            }
        }

        System.out.println(servicios);
        System.out.println(total);
        // Update info panel
        this.removeAll();
        this.add(getSearchPanel(), BorderLayout.PAGE_START);
        this.add(getCheckOutPanel(servicios, total), BorderLayout.CENTER);
        this.add(getButtonPanel(), BorderLayout.PAGE_END);
        this.revalidate();
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if (grito.equals("BUSCAR")) {
            // Revisa si la reserva existe y si no, muestra un mensaje de error

            // lista los servicios si todoPago es true,
            documento = txtDocumento.getText();
            reserva = ventanaPadre.ConseguirReserva(documento);

            if (reserva == null) {
                JOptionPane.showMessageDialog(ventanaPadre,
                        "No se encontró ninguna reserva bajo el documento " + documento + ".");
                        permitirpag = false;
                return;
            }
            HashMap<String, ArrayList<Servicio>> serviciosConsumidosPorNombreHuesped = ventanaPadre
                    .HacerCheckOut(documento, false);
            updateCheckoutInfo(serviciosConsumidosPorNombreHuesped);
            System.out.println(serviciosConsumidosPorNombreHuesped);
            permitirpag = true;
            if (pagado) {
                JOptionPane.showMessageDialog(ventanaPadre,
                        "Su consumo se encuentra pago, ya se hizo el checkout de este documento.");
                        permitirpag = false;
                return;
            }
            // Update info de las reservas
            // TODO pagado = ventanaPadre.hacerPago(reserva));

        } else if (grito.equals("CONFIRMAR")) {
            documento = txtDocumento.getText();
            System.out.println(documento);
            ventanaPadre.HacerCheckOut(documento, true);
            JOptionPane.showMessageDialog(ventanaPadre,
                    "Se ha registrado la salida de la reserva bajo el documento " + documento + ".");

        } 
        else if (grito.equals("PAGAR")) 
        {   
            if(permitirpag == true)
            {
                ventanaPadre.IrAlPanelOpcionesDePago();
                permitirpag = false;
            }
            else
            {
                JOptionPane.showMessageDialog(ventanaPadre,"Pago no disponible");
            }

        }

        else if (grito.equals("SALIR")) {
            // this.removeAll();

            ventanaPadre.IrAPanelConsolaMenu();

        } else {
            System.out.println("No se reconoce el comando");
        }
    }

    public Double getTotal() {
        return total;
    }
    
}
