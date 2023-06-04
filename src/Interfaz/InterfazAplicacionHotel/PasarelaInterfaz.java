package Interfaz.InterfazAplicacionHotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PasarelaInterfaz extends JPanel implements ActionListener 
{
    private InterfazPrincipalJFrame interfazpadre;
    private JLabel titulo, nombre, celular, documento, numerotar, fechaven, codigoseg;
    private JPanel datos, Salida;
    private JTextField nombreTxt, celularTxt, documentoTxt, numerotarTxt, fechavenTxt;
    private JPasswordField codigosegTxt;
    private JButton BotonSalir;


    public PasarelaInterfaz(InterfazPrincipalJFrame interfazPrincipalJFrame)
    {
        interfazpadre = interfazPrincipalJFrame;
        setLayout(new BorderLayout());
        datos = datos();
        titulo = new JLabel("Ingrese los datos del titular de la tarjeta");
        Salida = salidaPanel();
        add(titulo,BorderLayout.NORTH);
        add(datos,BorderLayout.CENTER);
        add(Salida,BorderLayout.SOUTH);

         
    }

    private JPanel datos()
    {
        datos = new JPanel(new GridLayout(6,2));

        nombre = new JLabel("Ingrese su nombre completo con apellidos");
        celular = new JLabel("Ingrese su numero de celular");
        documento = new JLabel("Ingrese su documento");
        numerotar = new JLabel("Ingrese el numero de su tarjeta");
        fechaven = new JLabel("Ingrese la fecha de vencimiento");
        codigoseg = new JLabel("Ingrese el codigo de seguridad");

        nombreTxt = new JTextField();
        celularTxt = new JTextField();
        documentoTxt = new JTextField();
        numerotarTxt = new JTextField();
        fechavenTxt = new JTextField();
        codigosegTxt = new JPasswordField();

        datos.add(nombre);
        datos.add(nombreTxt);
        datos.add(celular);
        datos.add(celularTxt);
        datos.add(documento);
        datos.add(documentoTxt);
        datos.add(numerotar);
        datos.add(numerotarTxt);
        datos.add(fechaven);
        datos.add(fechavenTxt);
        datos.add(codigoseg);
        datos.add(codigosegTxt);

        return datos;
    }

    private JPanel salidaPanel()
    {
        Salida = new JPanel();

        BotonSalir = new JButton("Salir");
        BotonSalir.addActionListener(this);
        BotonSalir.setMaximumSize(new Dimension(300, 45));
        BotonSalir.setActionCommand("SALIR");
        Salida.add(BotonSalir);
        return Salida;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String grito = e.getActionCommand();
        if(grito.equals("SALIR"))
        {
            interfazpadre.IrAlPanelOpcionesDePago();
        }

    }
}
