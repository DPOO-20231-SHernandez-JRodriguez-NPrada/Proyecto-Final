package Interfaz.InterfazAplicacionHotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AgregarHuespedJFrame extends JFrame implements ActionListener{

    private JLabel lbTitulo,lbDocumento, lbNombre, lbCorreo, lbCelular;
    private JTextField txtFDocumento, txtFNombre, txtFCorreo, txtFCelular;
    private JButton btnAgregar, btnCerrar;
    private CheckInInterfaz padreCheckInInterfaz;


    public AgregarHuespedJFrame(CheckInInterfaz checkInInterfaz) {
        this.padreCheckInInterfaz = checkInInterfaz;

        setSize(400, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());
        panelSuperior.setPreferredSize(new Dimension(400, 100));
        panelSuperior.setMaximumSize(getPreferredSize());

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(4,1));
        panelIzquierdo.setPreferredSize(new Dimension(200, 200));
        panelIzquierdo.setMaximumSize(getPreferredSize());

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(4, 1));
        panelCentro.setPreferredSize(new Dimension(200, 200));
        panelCentro.setMaximumSize(getPreferredSize());

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout(1, 20, 0));
        panelInferior.setPreferredSize(new Dimension(400, 100));
        panelInferior.setMaximumSize(getPreferredSize());


        lbTitulo = new JLabel("Datos Huesped");

        lbDocumento = new JLabel("Documento:");

        lbNombre = new JLabel("Nombre:");

        lbCorreo = new JLabel("Correo:");

        lbCelular = new JLabel("Celular:");

        txtFDocumento = new JTextField();

        txtFNombre = new JTextField();

        txtFCorreo = new JTextField();

        txtFCelular = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(this);
        btnAgregar.setActionCommand("AGREGAR");
        btnAgregar.setPreferredSize(new Dimension(100, 50));
        btnAgregar.setMaximumSize(getPreferredSize());
        btnAgregar.setAlignmentX(CENTER_ALIGNMENT);
        btnAgregar.setAlignmentY(CENTER_ALIGNMENT);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setActionCommand("CERRAR");
        btnCerrar.setPreferredSize(new Dimension(100, 50));
        btnCerrar.setMaximumSize(getPreferredSize());
        btnCerrar.setAlignmentX(CENTER_ALIGNMENT);
        btnCerrar.setAlignmentY(CENTER_ALIGNMENT);

        panelSuperior.add(lbTitulo);

        panelIzquierdo.add(lbDocumento);
        panelIzquierdo.add(lbNombre);
        panelIzquierdo.add(lbCorreo);
        panelIzquierdo.add(lbCelular);

        panelCentro.add(txtFDocumento);
        panelCentro.add(txtFNombre);
        panelCentro.add(txtFCorreo);
        panelCentro.add(txtFCelular);

        panelInferior.add(btnAgregar);
        panelInferior.add(btnCerrar);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelCentro, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("AGREGAR")) {
            if(txtFDocumento.getText().equals("") || txtFNombre.getText().equals("") || txtFCorreo.getText().equals("") || txtFCelular.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
            }
            else if(padreCheckInInterfaz.getHuespedesRestantes() == 0){
                JOptionPane.showMessageDialog(this, "No hay mas cupos para huespedes");
            }
            else {
                padreCheckInInterfaz.agregarHuesped(txtFNombre.getText(), txtFDocumento.getText(), txtFCorreo.getText(), txtFCelular.getText());
                txtFDocumento.setText("");
                txtFNombre.setText("");
                txtFCorreo.setText("");
                txtFCelular.setText("");
            }
        } else if (comando.equals("CERRAR")) {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
    
}
