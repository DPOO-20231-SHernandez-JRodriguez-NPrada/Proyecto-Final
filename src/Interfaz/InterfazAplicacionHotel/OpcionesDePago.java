package Interfaz.InterfazAplicacionHotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpcionesDePago extends JPanel implements ActionListener {

    private JPanel Paneldebotones, Salida;
    private JButton BotonPSE, BotonPayu, BotonSalir;
    private ImageIcon PSE, PAYU;
    private JLabel opciones;
    private InterfazPrincipalJFrame interfazpadre;

    public OpcionesDePago(InterfazPrincipalJFrame interfazPrincipalJFrame) 
    {
        interfazpadre = interfazPrincipalJFrame;
        setLayout(new BorderLayout());
        opciones = new JLabel("Seleccione alguno de los metodos de pago");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(opciones,BorderLayout.CENTER);
        this.Paneldebotones = creaPanelbotones();
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
        BotonSalir.setMaximumSize(new Dimension(300, 45));
        BotonSalir.setActionCommand("SALIR");
        Salida.add(BotonSalir);
        return Salida;
    }

    private JPanel creaPanelbotones() 
    {

        Paneldebotones = new JPanel();
        PSE = new ImageIcon("Data/Iconos/logo-pse.png");
        PAYU = new ImageIcon("Data/Iconos/PAYU_LOGO_LIME.png");

        BotonPSE = new JButton();
        BotonPSE.addActionListener(this);
        BotonPSE.setMaximumSize(new Dimension(300, 45));
        BotonPSE.setIcon(new ImageIcon(PSE.getImage().getScaledInstance(300,70, java.awt.Image.SCALE_SMOOTH)));
        BotonPSE.setActionCommand("PSE");

        BotonPayu = new JButton();
        BotonPayu.addActionListener(this);
        BotonPayu.setMaximumSize(new Dimension(300, 45));
        BotonPayu.setIcon(new ImageIcon(PAYU.getImage().getScaledInstance(300,70, java.awt.Image.SCALE_SMOOTH)));
        BotonPayu.setActionCommand("PAYU");

        Paneldebotones.add(BotonPSE);
        Paneldebotones.add(BotonPayu);

        return Paneldebotones;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if(grito.equals("PSE"))
        {
            interfazpadre.IrAlPanelPago();
        }
        else if(grito.equals("PAYU"))
        {
            interfazpadre.IrAlPanelPago();
        }
        else if(grito.equals("SALIR"))
        {
            interfazpadre.IrAPanelCheckOut();
        }
    }

}
