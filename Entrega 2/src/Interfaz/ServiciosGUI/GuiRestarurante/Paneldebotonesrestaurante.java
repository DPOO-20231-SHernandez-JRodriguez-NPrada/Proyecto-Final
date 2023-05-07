package Interfaz.ServiciosGUI.GuiRestarurante;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;

public class Paneldebotonesrestaurante extends JPanel implements ActionListener{


    private static final String Agr = "Agregar producto";
    private static final String Rep = "Repetir";
    private static final String AgrSer = "Agregar servicio";
    private static final String Sal = "Salir";

    private JButton agregar;
    private JButton repetir;
    private JButton agregarSer;
    private JButton salir;

    private Interfazrestaurante interres;

    public Paneldebotonesrestaurante(Interfazrestaurante interfazrestaurante) 
    {
        interres = interfazrestaurante;

        agregar = new JButton("Agregar Producto");
        agregar.addActionListener(this);
        agregar.setActionCommand(Agr);

        repetir = new JButton("Repetir Proceso");
        repetir.addActionListener(this);
        repetir.setActionCommand(Rep);

        agregarSer = new JButton("Agregar Servicio");
        agregarSer.addActionListener(this);
        agregarSer.setActionCommand(AgrSer);

        salir = new JButton("Salir");
        salir.setBackground(new Color(255, 0, 0));
        salir.addActionListener(this);
        salir.setActionCommand(Sal);

        setLayout(new FlowLayout());
        add(agregar);
        add(repetir);
        add(agregarSer);
        add(salir);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if(grito.equals(Agr)) {
			interres.agregar();
		}
        if(grito.equals(Rep)) {
			interres.repetir();
		}
        if(grito.equals(AgrSer)) {
			interres.agregarSer();
		}
        if(grito.equals(Sal)) {
			interres.salir();
		}
		
	}
    
}
