package Interfaz.InterfazAplicacionHuesped;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrearUsuarioJPanel extends JPanel implements ActionListener{

    private InterfazprincipalHuespedJFrame ventanaPadre;
    private JButton btnCrearUsuario, btnVolver;
    private JTextField txtFUsuario, txtFContrasenia, txtFContraseniaConfirmar;
    private JLabel lblUsuario, lblContrasenia, lblContraseniaConfirmar;


    public CrearUsuarioJPanel(InterfazprincipalHuespedJFrame ventanaPadre) {
        this.ventanaPadre = ventanaPadre;

        this.btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setSize(200, 50);
        btnCrearUsuario.addActionListener(this);
        btnCrearUsuario.setActionCommand("CREAR_USUARIO");

        this.btnVolver = new JButton("Volver");
        btnVolver.setSize(200, 50);
        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("VOLVER");

        this.txtFUsuario = new JTextField();
        txtFUsuario.setSize(200, 50);
        txtFUsuario.setPreferredSize(new Dimension(200, 50));
        txtFUsuario.setMaximumSize(getPreferredSize());

        this.txtFContrasenia = new JTextField();
        txtFContrasenia.setSize(200, 50);
        txtFContrasenia.setPreferredSize(new Dimension(200, 50));
        txtFContrasenia.setMaximumSize(getPreferredSize());

        this.txtFContraseniaConfirmar = new JTextField();
        txtFContraseniaConfirmar.setSize(200, 50);
        txtFContraseniaConfirmar.setPreferredSize(new Dimension(200, 50));
        txtFContraseniaConfirmar.setMaximumSize(getPreferredSize());

        this.lblUsuario = new JLabel("Usuario");
        lblUsuario.setSize(150, 50);
        lblUsuario.setPreferredSize(new Dimension(150, 50));
        lblUsuario.setMaximumSize(getPreferredSize());

        this.lblContrasenia = new JLabel("Contraseña");
        lblContrasenia.setSize(150, 50);
        lblContrasenia.setPreferredSize(new Dimension(150, 50));
        lblContrasenia.setMaximumSize(getPreferredSize());

        this.lblContraseniaConfirmar = new JLabel("Confirmar Contraseña");
        lblContraseniaConfirmar.setSize(150, 50);
        lblContraseniaConfirmar.setPreferredSize(new Dimension(150, 50));
        lblContraseniaConfirmar.setMaximumSize(getPreferredSize());

        setLayout(new BorderLayout());

        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSur.setSize(400, 150);
        panelSur.setPreferredSize(new Dimension(400, 150));
        panelSur.setMaximumSize(getPreferredSize());

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));
        panelCentro.setSize(400, 400);
        panelCentro.setPreferredSize(new Dimension(400, 400));
        panelCentro.setMaximumSize(getPreferredSize());

        JPanel panelNorte = new JPanel();
        panelNorte.setSize(400, 50);
        panelNorte.setPreferredSize(new Dimension(400, 100));
        panelNorte.setMaximumSize(getPreferredSize());
        
        JPanel panelEste = new JPanel();
        panelEste.setSize(200,400);
        panelEste.setPreferredSize(new Dimension(200, 400));
        panelEste.setMaximumSize(getPreferredSize());
        
        JPanel panelOeste = new JPanel();
        panelOeste.setSize(200,400);
        panelOeste.setPreferredSize(new Dimension(200, 400));
        panelOeste.setMaximumSize(getPreferredSize());


        panelSur.add(btnVolver);
        panelCentro.add(lblUsuario);
        panelCentro.add(txtFUsuario);
        panelCentro.add(lblContrasenia);
        panelCentro.add(txtFContrasenia);
        panelCentro.add(lblContraseniaConfirmar);
        panelCentro.add(txtFContraseniaConfirmar);
        panelCentro.add(btnCrearUsuario);

        add(panelSur, BorderLayout.SOUTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelNorte, BorderLayout.NORTH);
        add(panelEste, BorderLayout.EAST);
        add(panelOeste, BorderLayout.WEST);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("VOLVER")) {
            ventanaPadre.cambiarPanel("iniciarSesion");
        } else if (e.getActionCommand().equals("CREAR_USUARIO")) {
            if(txtFContrasenia.getText().equals(txtFContraseniaConfirmar.getText())){
                if(ventanaPadre.CrearUsuario(txtFUsuario.getText(), txtFContrasenia.getText())){
                    JOptionPane.showMessageDialog(this, "Usuario creado correctamente", "Usuario Creado", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Las Contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }    
    }
    
}
