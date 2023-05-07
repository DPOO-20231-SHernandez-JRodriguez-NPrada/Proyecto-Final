package Interfaz.ServiciosGUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Interfaz.InterfazPrincipalJFrame;
import Interfaz.ServiciosGUI.GuiRestarurante.Interfazrestaurante;


import java.awt.BorderLayout;
import java.awt.Dimension;


public class Interfazservicios extends JFrame
{

    private InterfazPrincipalJFrame interfazpadre;
    private PanelEntradaservicios panelEntradas;
    private Paneldebotoneservicios paneldebotones;


    public Interfazservicios(InterfazPrincipalJFrame interfazprincipaljFrame)
    {
        interfazpadre = interfazprincipaljFrame;
        panelEntradas = new PanelEntradaservicios();
        paneldebotones = new Paneldebotoneservicios(this);

        setLayout(new BorderLayout());

        add(panelEntradas,BorderLayout.NORTH);
        add(paneldebotones,BorderLayout.SOUTH);


        setSize(new Dimension(700,200));
        setResizable(false);
		setTitle("Servicios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }
    
    public void agregar() 
    {
        String documento = panelEntradas.dardni();
        String servicio = panelEntradas.darnombreser();
        String fecha = panelEntradas.darfconsumo();
        boolean pagado = panelEntradas.darpagado();
        double precio = 0;
        String descripcion = "";
        interfazpadre.AñadirServicio(documento, servicio, descripcion, fecha, pagado, precio);
        
    }

    public void restaurante() {
        String documento = panelEntradas.dardni();
        String servicio = panelEntradas.darnombreser();
        String fecha = panelEntradas.darfconsumo();
        boolean pagado = panelEntradas.darpagado();
        if(documento.equals(""))
        {
            JFrame ventana = new JFrame("Error");
            JLabel mensaje = new JLabel("Llene el documento");
            ventana.add(mensaje);
            ventana.setSize(300, 200);
            ventana.setVisible(true);
        }
        if(servicio.equals(""))
        {
            JFrame ventana = new JFrame("Error");
            JLabel mensaje = new JLabel("Llene el nombre del servicio");
            ventana.add(mensaje);
            ventana.setSize(300, 200);
            ventana.setVisible(true);
        }
        if(fecha.equals(""))
        {
            JFrame ventana = new JFrame("Error");
            JLabel mensaje = new JLabel("Llene la fecha");
            ventana.add(mensaje);
            ventana.setSize(300, 200);
            ventana.setVisible(true);
        }
        else
        {
            new Interfazrestaurante(documento,servicio,fecha,pagado,interfazpadre);
        }
    }

    public void salir() 
    {
        dispose();
    }
}
