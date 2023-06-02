package Interfaz.InterfazAplicacionHotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginInterfaz extends JPanel implements ActionListener{
    
    private InterfazPrincipalJFrame ventanaPadre;
    private JLabel lbUsuario, lbContrasena;
    private JTextField txtUsuario, txtContrasena;
    private JButton btnIngresar, btnSalir;
    private String usuario, password;

    public LoginInterfaz(InterfazPrincipalJFrame parent) {
        this.ventanaPadre = parent;
        setBackground(new Color(148, 142, 142));
        Font fuente = new Font("Arial", Font.BOLD, 18);
        Dimension estandar = new Dimension(100, 50);

        lbUsuario = new JLabel("               Usuario:");
        lbUsuario.setFont(fuente);
        lbUsuario.setForeground(Color.BLACK);
        lbUsuario.setMaximumSize(estandar);

        lbContrasena = new JLabel("            Contraseña:");
        lbContrasena.setFont(fuente);
        lbContrasena.setMaximumSize(estandar);
        lbContrasena.setForeground(Color.BLACK);

        txtUsuario = new JTextField();
        txtUsuario.setBackground(Color.WHITE);
        txtUsuario.setMaximumSize(estandar);

        txtContrasena = new JTextField();
        txtContrasena.setBackground(Color.WHITE);
        txtContrasena.setMaximumSize(estandar);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(Color.BLACK);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFont(fuente);
        btnIngresar.setMaximumSize(estandar);
        btnIngresar.addActionListener(this);
        btnIngresar.setActionCommand("INGRESAR");

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(Color.BLACK);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(fuente);
        btnSalir.setMaximumSize(estandar);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("SALIR");

        JPanel aux = new JPanel();
        aux.setLayout(new GridLayout(3, 2,5,50));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        aux.add(lbUsuario);
        aux.add(txtUsuario);
        aux.add(lbContrasena);
        aux.add(txtContrasena);
        aux.add(btnIngresar);
        aux.add(btnSalir);
        aux.setBackground(getBackground());

        add(Box.createVerticalGlue());
        add(aux);
        add(Box.createVerticalGlue());
        btnIngresar.addActionListener(this);

        setSize(250, 200);
        setVisible(true);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if(grito.equals("INGRESAR")){
            usuario = txtUsuario.getText();
            password = txtContrasena.getText();
            String resultado = ventanaPadre.Login(usuario, password);

            if(resultado.equals("admin") || resultado.equals("empleado")){
                ventanaPadre.crearConsolaMenu(resultado);
                ventanaPadre.IrAPanelConsolaMenu();
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "ERROR INCIO SESION", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(grito.equals("SALIR")){
            System.exit(0);
        }
        else{
            System.out.println("No se reconoce el comando");
        }
    }
}
