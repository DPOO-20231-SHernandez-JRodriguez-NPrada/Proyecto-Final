package Interfaz.InterfazAplicacionHuesped;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IniciarSesionJPanel extends JPanel implements ActionListener{
    
    InterfazprincipalHuespedJFrame ventanaPadre;
    JButton btnIniciarSesion, btnCrearUsuario;
    JTextField txtFUsuario, txtContrasenia;
    JLabel lblUsuario, lblContrasenia;

    public IniciarSesionJPanel(InterfazprincipalHuespedJFrame ventanaPadre) {
        this.ventanaPadre = ventanaPadre;

        setSize(800, 600);
        setPreferredSize(new Dimension(800, 600));
        setMaximumSize(getPreferredSize());
        
        this.btnIniciarSesion = new JButton("Iniciar Sesion");
        btnIniciarSesion.setSize(200, 50);
        btnIniciarSesion.addActionListener(this);
        btnIniciarSesion.setActionCommand("INICIAR_SESION");

        this.btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setSize(200, 50);
        btnCrearUsuario.addActionListener(this);
        btnCrearUsuario.setActionCommand("CREAR_USUARIO");


        this.txtFUsuario = new JTextField();
        txtFUsuario.setSize(200, 50);
        txtFUsuario.setPreferredSize(new Dimension(200, 50));
        txtFUsuario.setMaximumSize(getPreferredSize());

        this.txtContrasenia = new JTextField();
        txtContrasenia.setSize(200, 50);
        txtContrasenia.setPreferredSize(new Dimension(200, 50));
        txtContrasenia.setMaximumSize(getPreferredSize());

        this.lblUsuario = new JLabel("Usuario");
        lblUsuario.setSize(100, 50);
        lblUsuario.setPreferredSize(new Dimension(100, 50));
        lblUsuario.setMaximumSize(getPreferredSize());

        this.lblContrasenia = new JLabel("Contraseña");
        lblContrasenia.setSize(100, 50);
        lblContrasenia.setPreferredSize(new Dimension(100, 50));
        lblContrasenia.setMaximumSize(getPreferredSize());
        
        setLayout(new BorderLayout());

        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSur.setSize(400, 150);
        panelSur.setPreferredSize(new Dimension(400, 150));
        panelSur.setMaximumSize(getPreferredSize());

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
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


        panelSur.add(btnCrearUsuario);
        panelCentro.add(lblUsuario);
        panelCentro.add(txtFUsuario);
        panelCentro.add(lblContrasenia);
        panelCentro.add(txtContrasenia);
        panelCentro.add(btnIniciarSesion);

        add(panelSur, BorderLayout.SOUTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelNorte, BorderLayout.NORTH);
        add(panelEste, BorderLayout.EAST);
        add(panelOeste, BorderLayout.WEST);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("INICIAR_SESION")) {
            if(ventanaPadre.IniciarSesion(txtFUsuario.getText(), txtContrasenia.getText())){
                ventanaPadre.cambiarPanel("reservar");
            }
        } else if (e.getActionCommand().equals("CREAR_USUARIO")) {
            this.ventanaPadre.cambiarPanel("crearUsuario");
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }



    
}
