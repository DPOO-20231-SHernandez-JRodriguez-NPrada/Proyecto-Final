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

public class InfromacionReservas extends JPanel implements ActionListener {

    private String fechaInicio, fechaFin, huespedes, cantidadHab, id;
    private InterfazPrincipalJFrame ventanaPadre;
    private JPanel searchPanel, infoPanel, roomPanel, buttonPanel;
    private JLabel lbDocumento, lbTitle;
    private JTextField txtDocumento;
    private JButton btnBuscar, btnSalir, btnEliminar;
    private String documento;
    private Font fuente;
    private Border vacio;

    public InfromacionReservas(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        // Empty info
        fechaInicio = "";
        fechaFin = "";
        huespedes = "";
        cantidadHab = "";
        id = "";

        ventanaPadre = interfazPrincipalJFrame;
        setLayout(new BorderLayout());
        setBackground(new Color(148, 142, 142));
        fuente = new Font("Arial", Font.BOLD, 20);
        vacio = BorderFactory.createEmptyBorder();

        searchPanel = getSearchPanel();
        infoPanel = getInfoPanel(fechaInicio, fechaFin, huespedes);
        roomPanel = getRoomPanel(id);
        buttonPanel = getButtonPanel();

        add(searchPanel, BorderLayout.PAGE_START);
        add(infoPanel, BorderLayout.CENTER);
        add(roomPanel, BorderLayout.LINE_END);
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
        lbDocumento = new JLabel("Documento  ");
        lbDocumento.setFont(fuente);
        lbTitle = new JLabel("Información de Reservas");
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
        searchPanel.add(btnBuscar, BorderLayout.LINE_END);

        return searchPanel;
    }

    // Panel de información de reservas
    public JPanel getInfoPanel(String fechaInicio, String fechaFin, String huespedes) {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 30, 100, 100));

        // Labels primera columna, text segunda columna
        JLabel fechaILabel = new JLabel("Fecha Inicio");
        JTextField fechaITextField = new JTextField();
        fechaITextField.setEditable(false);
        JLabel fechaFLabel = new JLabel("Fecha Fin");
        JTextField fechaFTextField = new JTextField();
        fechaFTextField.setEditable(false);
        JLabel huespedesLabel = new JLabel("Huéspedes");
        JTextArea huespedesTextArea = new JTextArea();
        huespedesTextArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(huespedesTextArea);

        // Set text fields
        fechaITextField.setText(fechaInicio);
        fechaFTextField.setText(fechaFin);
        huespedesTextArea.setText(huespedes);

        // Adding components to the panel
        panel.add(fechaILabel);
        panel.add(fechaITextField);
        panel.add(fechaFLabel);
        panel.add(fechaFTextField);
        panel.add(huespedesLabel);
        panel.add(scroll);

        return panel;
    }

    // Panel de lista de info de habitaciones
    public JPanel getRoomPanel(String id) {
        JPanel panel = new JPanel(new BorderLayout(40, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 30));

        // Labels y text area
        JLabel titleLabel = new JLabel("Habitaciones en la reserva");
        JTextArea listaTextArea = new JTextArea();
        listaTextArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(listaTextArea);

        // Set text area
        listaTextArea.setText(id);

        // Empty borders
        titleLabel.setBorder(vacio);
        scroll.setBorder(vacio);

        // Adding components to the panel
        panel.add(titleLabel, BorderLayout.PAGE_START);
        panel.add(scroll, BorderLayout.CENTER);
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

        btnEliminar = new JButton("Eliminar reserva");
        btnEliminar.setPreferredSize(new Dimension(200, 45));
        btnEliminar.setBackground(Color.BLACK);
        // btnSalir.setForeground(Color.WHITE);
        btnEliminar.setFont(fuente);
        btnEliminar.setMaximumSize(new Dimension(200, 200));
        btnEliminar.addActionListener(this);
        btnEliminar.setActionCommand("ELIMINAR");

        // Añadir elementos al panel

        buttonPanel.add(btnSalir);
        buttonPanel.add(btnEliminar);

        return buttonPanel;
    }

    private void updateReservationInfo(String stringReserva) {
        // fechaini + "," + fechafin + "," + personasEs + "," + cantidadHab + "," + id;
        String[] datos = stringReserva.split(",");
        fechaInicio = datos[0];
        fechaFin = datos[1];
        huespedes = datos[2];
        cantidadHab = datos[3];
        id = datos[4];
        System.out.println(fechaInicio);
        System.out.println(fechaFin);
        System.out.println(huespedes);
        System.out.println(cantidadHab);
        System.out.println(id);

        // Update info panel
        this.removeAll();
        this.add(getSearchPanel(), BorderLayout.PAGE_START);
        this.add(getInfoPanel(fechaInicio, fechaFin, huespedes), BorderLayout.CENTER);
        this.add(getRoomPanel(id), BorderLayout.LINE_END);
        this.add(getButtonPanel(), BorderLayout.PAGE_END);
        this.revalidate();
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if (grito.equals("BUSCAR")) {
            documento = txtDocumento.getText();
            String reserva = ventanaPadre.VerReserva(documento);
            if (reserva == null) {
                JOptionPane.showMessageDialog(ventanaPadre, "No se encontró una reserva con ese documento.");
                return;
            }
            System.out.println(reserva);

            // Update info de las reservas
            updateReservationInfo(reserva);

        } else if (grito.equals("SALIR")) {
            ventanaPadre.IrAPanelConsolaMenu();
        } else if (grito.equals("ELIMINAR")) {
            documento = txtDocumento.getText();
            System.out.println(documento);
            String date = getCurrentDate();
            ventanaPadre.EliminarReserva(documento, date);
            JOptionPane.showMessageDialog(ventanaPadre,
                    "La reserva bajo el documento " + documento + " ha sido eliminada exitosamente.");
        } else {
            System.out.println("No se reconoce el comando");
        }
    }

}