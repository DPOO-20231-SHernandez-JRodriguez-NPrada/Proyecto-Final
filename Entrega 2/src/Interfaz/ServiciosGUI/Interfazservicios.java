package Interfaz.ServiciosGUI;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Interfaz.InterfazPrincipalJFrame;
import Interfaz.ServiciosGUI.GuiRestarurante.Interfazrestaurante;


import java.awt.BorderLayout;
import java.awt.Dimension;


public class Interfazservicios extends JPanel
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
    }
    
    public void agregar()
    {
        String documento = panelEntradas.dardni();
        String servicio = panelEntradas.darnombreser();
        String fecha = panelEntradas.darfconsumo();
        boolean pagado = panelEntradas.darpagado();
        double precio = 0;
        String descripcion = "";
        if(documento.equals("")||servicio.equals("")||fecha.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Alguna de las casillas no ha sido rellenada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            interfazpadre.AñadirServicio(documento, servicio, descripcion, fecha, pagado, precio);
        }
        
    }

    public void restaurante() {
        String documento = panelEntradas.dardni();
        String servicio = panelEntradas.darnombreser();
        String fecha = panelEntradas.darfconsumo();
        boolean pagado = panelEntradas.darpagado();
        if(documento.equals("")||servicio.equals("")||fecha.equals("")||fecha.equals(""))
        {
            
            JOptionPane.showMessageDialog(null, "Alguna de las casillas no ha sido rellenada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            new Interfazrestaurante(documento,servicio,fecha,pagado,interfazpadre);
        }
    }

    public void salir() 
    {
        interfazpadre.IrAPanelConsolaMenu();
    }
}
