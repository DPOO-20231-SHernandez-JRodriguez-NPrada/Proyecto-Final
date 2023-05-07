package Interfaz.ServiciosGUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Interfaz.ServiciosGUI.GuiRestarurante.Interfazrestaurante;
import Interfaz.InterfazPrincipal;

import java.awt.BorderLayout;
import java.awt.Dimension;


public class Interfazservicios extends JFrame
{
    private PanelEntradaservicios panelEntradas;
    private Paneldebotoneservicios paneldebotones;


    public Interfazservicios()
    {
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

    public static void main(String[] args) {
        Interfazservicios interfazservicios = new Interfazservicios();
    }

    public void agregar() 
    {
        String documento = panelEntradas.dardni();
        String servicio = panelEntradas.darnombreser();
        String fecha = panelEntradas.darfconsumo();
        boolean pagado = panelEntradas.darpagado();
        String descripcion = "";
        
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
            new Interfazrestaurante(documento,servicio,fecha,pagado);
        }
    }

    public void salir() 
    {
        dispose();
    }
}
