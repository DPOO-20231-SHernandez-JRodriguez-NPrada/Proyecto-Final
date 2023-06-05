package Interfaz.InterfazAplicacionHotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Aplicacion.PasarelasDePagos.TarjetaDeCredito;

public class PasarelaInterfaz extends JPanel implements ActionListener 
{
    private InterfazPrincipalJFrame interfazpadre;
    private JLabel titulo, nombre, celular, documento, numerotar, codigoseg;
    private JPanel datos, botones;
    private JTextField nombreTxt, celularTxt, documentoTxt, numerotarTxt, codigosegTxt;
    private JButton BotonSalir, BotonPagar;


    public PasarelaInterfaz(InterfazPrincipalJFrame interfazPrincipalJFrame)
    {
        interfazpadre = interfazPrincipalJFrame;
        setLayout(new BorderLayout());
        datos = datos();
        titulo = new JLabel("Ingrese los datos del titular de la tarjeta");
        botones = botonesPanel();
        add(titulo,BorderLayout.NORTH);
        add(datos,BorderLayout.CENTER);
        add(botones,BorderLayout.SOUTH);

         
    }

    private JPanel datos()
    {
        datos = new JPanel(new GridLayout(6,2));

        nombre = new JLabel("Ingrese su nombre completo con apellidos");
        celular = new JLabel("Ingrese su numero de celular");
        documento = new JLabel("Ingrese su documento");
        numerotar = new JLabel("Ingrese el numero de su tarjeta");
        codigoseg = new JLabel("Ingrese el codigo de seguridad");

        nombreTxt = new JTextField();
        celularTxt = new JTextField();
        documentoTxt = new JTextField();
        numerotarTxt = new JTextField();
        codigosegTxt = new JTextField();

        datos.add(nombre);
        datos.add(nombreTxt);
        datos.add(celular);
        datos.add(celularTxt);
        datos.add(documento);
        datos.add(documentoTxt);
        datos.add(numerotar);
        datos.add(numerotarTxt);
        datos.add(codigoseg);
        datos.add(codigosegTxt);

        return datos;
    }

    private JPanel botonesPanel()
    {
        botones = new JPanel(new GridLayout(1,2));


        BotonPagar = new JButton("Pagar");
        BotonPagar.addActionListener(this);
        BotonPagar.setPreferredSize(new Dimension(200, 45));
        BotonPagar.setMaximumSize(new Dimension(300, 45));
        BotonPagar.setActionCommand("PAGAR");
        
        BotonSalir = new JButton("Salir");
        BotonSalir.addActionListener(this);
        BotonSalir.setMaximumSize(new Dimension(300, 45));
        BotonSalir.setActionCommand("SALIR");


        botones.add(BotonSalir);
        botones.add(BotonPagar);

        return botones;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String grito = e.getActionCommand();
        if(grito.equals("PAGAR"))
        {
            if(nombreTxt.getText().equals("")||celularTxt.getText().equals("")||documentoTxt.getText().equals("")||numerotarTxt.getText().equals("")||codigosegTxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Alguna de las casillas no ha sido rellenada", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else
            {

                TarjetaDeCredito tarjeta = interfazpadre.crearTarjetaDeCredito(numerotarTxt.getText(),nombreTxt.getText(),codigosegTxt.getText());
                Double total = interfazpadre.valorapagar();
                String direccion = interfazpadre.direccion();
                System.out.println(total);
                System.out.println(direccion);
                System.out.println(tarjeta);
                //interfazpadre.hacerPago(total, tarjeta, direccion)
            }
        }
        else if(grito.equals("SALIR"))
        {
            interfazpadre.IrAlPanelOpcionesDePago();
        }

    }
}
