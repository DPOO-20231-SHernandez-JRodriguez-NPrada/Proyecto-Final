package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogoLogin extends JDialog {
    private JLabel lbUsuario, lbContrasena;
    private JTextField txtUsuario, txtContrasena;
    private JButton btnIngresar;
    private String usuario, password;

    public DialogoLogin(JFrame parent) {
        super(parent, "Login", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(new Color(148,142,142));
        Font fuente = new Font("Arial", Font.BOLD, 18);
        
        lbUsuario = new JLabel("      Usuario:");
        lbUsuario.setFont(fuente);
        
        lbContrasena = new JLabel("   Contraseña:");
        lbContrasena.setFont(fuente);
        
        txtUsuario = new JTextField();
        txtUsuario.setBackground(Color.WHITE);
        
        txtContrasena = new JTextField();
        txtContrasena.setBackground(Color.WHITE);
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(Color.BLACK);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFont(fuente);
        btnIngresar.setMaximumSize(new Dimension(200, 50));

        JPanel aux = new JPanel();
        aux.setLayout(new GridLayout(2, 2, 5, 5));
        setLayout(new GridLayout(2, 1, 30, 5));
        aux.add(lbUsuario);
        aux.add(txtUsuario);
        aux.add(lbContrasena);
        aux.add(txtContrasena);
        add(aux);
        
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(btnIngresar);
        add(panelBoton);

        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usuario = txtUsuario.getText();
                password = txtContrasena.getText();
                dispose();
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(parent);
        setResizable(false);
        setVisible(true);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
}

