package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfromacionReservas extends JPanel implements ActionListener {

    private InterfazPrincipalJFrame ventanaPadre;
    private JLabel lbDocumento;
    private JTextField txtDocumento;
    private JButton btnBuscar, btnSalir;
    private String documento;

    public InfromacionReservas(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        this.ventanaPadre = interfazPrincipalJFrame;
        setBackground(new Color(148, 142, 142));
        Font fuente = new Font("Arial", Font.BOLD, 18);

        // Setup los elementos de la interfaz
        // Labels
        lbDocumento = new JLabel("Documento:");

        // TextFields
        txtDocumento = new JTextField();

        // Buttons
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(Color.BLACK);
        // btnIngresar.setForeground(Color.WHITE);
        btnBuscar.setFont(fuente);
        btnBuscar.setMaximumSize(new Dimension(200, 200));
        btnBuscar.addActionListener(this);
        btnBuscar.setActionCommand("BUSCAR");

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(Color.BLACK);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(fuente);
        btnSalir.setMaximumSize(new Dimension(200, 200));
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("SALIR");

        // Styles
        txtDocumento.setBackground(Color.WHITE);
        lbDocumento.setFont(fuente);

        // Add elements to the panel
        setLayout(new GridLayout(3, 3, 30, 5));
        add(lbDocumento);
        add(txtDocumento);
        add(btnBuscar);
        add(btnSalir);

        btnBuscar.addActionListener(this);
    }

    public String getDocumento() {
        return documento;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if (grito.equals("BUSCAR")) {
            documento = txtDocumento.getText();
            String reserva = ventanaPadre.VerReserva(documento);
            System.out.println(reserva);
        } else if (grito.equals("SALIR")) {
            System.exit(0);
        } else {
            System.out.println("No se reconoce el comando");
        }
    }

}
