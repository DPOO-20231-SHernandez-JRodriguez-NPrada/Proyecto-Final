package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InfromacionReservas extends JPanel implements ActionListener{

    private InterfazPrincipalJFrame ventanaPadre;
    private JButton btnBuscar, btnSalir, btnCancelarReserva;
    private JLabel lbDocumento, lbFechaInicial, lbFechaFinal, lbPersonas;
    private JTextField txtFDocumento, txtFFechaInicial, txtFFechaFinal, txtFPersonas, txtFHabitaciones;

    public InfromacionReservas(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        this.ventanaPadre = interfazPrincipalJFrame;

        Color grisaceo = new Color(148, 142, 142);
		Font fuente = new Font("Arial", Font.BOLD, 20);
		Border vacio = BorderFactory.createEmptyBorder(); // estos son cosas que comparten todos los botones

        setLayout(getLayout());
        
        lbDocumento = new JLabel("Documento:");
        setSize(WIDTH, HEIGHT);
        lbDocumento.setFont(new Font("Arial", Font.BOLD, 50));
		lbDocumento.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbDocumento.setAlignmentY(Component.CENTER_ALIGNMENT);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
