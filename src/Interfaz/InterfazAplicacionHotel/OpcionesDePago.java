package Interfaz.InterfazAplicacionHotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpcionesDePago extends JPanel implements ActionListener {

    private JPanel Paneldebotones, Salida;
    private JButton BotonPago, BotonSalir;
    //private ImageIcon PSE, PAYU;
    private JLabel opciones;
    private InterfazPrincipalJFrame interfazpadre;
    private ArrayList<String> cantBotones;
    private String direccion = "";

    public OpcionesDePago(InterfazPrincipalJFrame interfazPrincipalJFrame) 
    {
        interfazpadre = interfazPrincipalJFrame;
        setLayout(new BorderLayout());
        opciones = new JLabel("Seleccione alguno de los metodos de pago");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(opciones,BorderLayout.CENTER);

        cantBotones = interfazpadre.cantBotones();

        this.Paneldebotones = creaPanelbotones(cantBotones);
        this.Salida = salidaPanel();

        add(Salida,BorderLayout.SOUTH);
        add(panel,BorderLayout.NORTH);
        add(Paneldebotones,BorderLayout.CENTER);
        add(Salida,BorderLayout.SOUTH);

        setSize(new Dimension(700,200));
        return;
    }

    private JPanel salidaPanel()
    {
        Salida = new JPanel();

        BotonSalir = new JButton("Salir");
        BotonSalir.addActionListener(this);
        BotonPago.setPreferredSize(new Dimension(200, 45));
        BotonSalir.setMaximumSize(new Dimension(300, 45));
        BotonSalir.setActionCommand("SALIR");
        Salida.add(BotonSalir);
        return Salida;
    }

    private JPanel creaPanelbotones(ArrayList<String> cantBotones) 
    {
        
        Paneldebotones = new JPanel();
        //PSE = new ImageIcon("Data/Iconos/logo-pse.png");
        //PAYU = new ImageIcon("Data/Iconos/PAYU_LOGO_LIME.png");

        for(int i = 0; i < cantBotones.size(); i++)
        {   
            String direccion = cantBotones.get(i);
            String[] nombreTemp = direccion.split("\\.");
            String nombre = nombreTemp[nombreTemp.length-1].replace("Pasarela", "");
            
            BotonPago = new JButton(nombre);
            BotonPago.addActionListener(this);
            BotonPago.setPreferredSize(new Dimension(200, 45));
            BotonPago.setMaximumSize(new Dimension(300, 45));
            //BotonPSE.setIcon(new ImageIcon(PSE.getImage().getScaledInstance(300,70, java.awt.Image.SCALE_SMOOTH)));
            BotonPago.setActionCommand(direccion);
            Paneldebotones.add(BotonPago);

        }
        

        return Paneldebotones;
    }


    public String getDireccion() {
        return direccion;
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String grito = e.getActionCommand();

        if(grito.equals("SALIR"))
        {
            interfazpadre.IrAPanelCheckOut();
        }
        else
        {
            direccion = grito;
            interfazpadre.IrAlPanelPago();
        }
    }

}
