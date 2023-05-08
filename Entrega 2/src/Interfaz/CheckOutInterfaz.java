package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CheckOutInterfaz extends JPanel implements ActionListener {

    private String servicios, total;
    private InterfazPrincipalJFrame ventanaPadre;
    private JPanel searchPanel, checkOutPanel, buttonPanel;
    private JLabel lbDocumento, lbTitle;
    private JTextField txtDocumento;
    private JButton btnBuscar, btnSalir, btnConfirmarSalida;
    private String documento;
    private Font fuente;
    private Border vacio;

    public CheckOutInterfaz(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        // Empty info
        servicios = "2";
        total = "";

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
    public JPanel getCheckOutPanel(String servicios, String total) {
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
        fechaFTextField.setText(total);

        // Adding components to the panel
        panel.add(serviciosLabel);
        panel.add(serviciosTextField);
        panel.add(totalLabel);
        panel.add(fechaFTextField);

        return panel;
    }

    public JPanel getButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
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

        // Añadir elementos al panel

        buttonPanel.add(btnSalir);
        buttonPanel.add(btnConfirmarSalida);

        return buttonPanel;
    }

    private void updateReservationInfo(String stringReserva) {
        // fechaini + "," + total + "," + personasEs + "," + cantidadHab + "," + id;
        String[] datos = stringReserva.split(",");
        servicios = datos[0];
        total = datos[1];
        System.out.println(servicios);
        System.out.println(total);
        // Update info panel
        ventanaPadre.removeAll();
        ventanaPadre.add(getSearchPanel(), BorderLayout.PAGE_START);
        ventanaPadre.add(getCheckOutPanel(servicios, total), BorderLayout.CENTER);
        ventanaPadre.add(getButtonPanel(), BorderLayout.PAGE_END);
        ventanaPadre.revalidate();
        ventanaPadre.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if (grito.equals("BUSCAR")) {
            documento = txtDocumento.getText();
            String reserva = ventanaPadre.VerReserva(documento);
            if (reserva == null || reserva.equals("")) {
                System.out.println("" + reserva);
                JOptionPane.showMessageDialog(ventanaPadre,
                        "No se encontró ninguna reserva bajo el documento " + documento + ".");
                return;
            }
            System.out.println(reserva);

            // Update info de las reservas
            updateReservationInfo(reserva);

        } else if (grito.equals("CONFIRMAR")) {
            documento = txtDocumento.getText();
            System.out.println(documento);
            ventanaPadre.HacerCheckOut(documento, true);
            JOptionPane.showMessageDialog(ventanaPadre,
                    "Se ha registrado la salida de la reserva bajo el documento " + documento + ".");

        } else if (grito.equals("SALIR")) {
            System.exit(0);

        } else {
            System.out.println("No se reconoce el comando");
        }
    }

}
