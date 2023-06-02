package Interfaz.InterfazAplicacionHotel.ServiciosGUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;

public class Paneldebotoneservicios extends JPanel implements ActionListener{
    
    private static final String Agr = "Agregar";
    private static final String Res = "Restaurante";
    private static final String Sal = "Salir";

    private JButton agregar;
    private JButton restaurante;
    private JButton salir;


    private Interfazservicios interser;

    public Paneldebotoneservicios(Interfazservicios interfazservicios)
    {
        interser = interfazservicios;

        agregar = new JButton("Agregar Servicio");
        agregar.addActionListener(this);
        agregar.setActionCommand(Agr);

        restaurante = new JButton("Servicio Restaurante");
        restaurante.addActionListener(this);
        restaurante.setActionCommand(Res);
        
        salir = new JButton("Salir");
        salir.setBackground(new Color(255, 0, 0));
        salir.addActionListener(this);
        salir.setActionCommand(Sal);


        setLayout(new FlowLayout());
        add(agregar);
        add(restaurante);
        add(salir);
    }


    @Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if(grito.equals(Agr)) {
			interser.agregar();
		}
        if(grito.equals(Res)) {
			interser.restaurante();
		}
        if(grito.equals(Sal)) {
			interser.salir();
		}
		
	}
}
