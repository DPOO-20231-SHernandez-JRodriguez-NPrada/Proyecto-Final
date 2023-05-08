package Interfaz.TarifasGUI;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Interfaz.InterfazPrincipalJFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

public class Interfaztarifas extends JPanel 
{
    private PanelEntradasTarifas panelEntradas1;
    private PanelEntradasTarifas panelEntradas2;
    private PanelEntradasTarifas panelEntradas3;
    private PanelBotonesTarifas paneldebotones;
    private InterfazPrincipalJFrame interfazpadre;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    public Interfaztarifas(InterfazPrincipalJFrame interfazPrincipal)
    {

        panelEntradas1 = new PanelEntradasTarifas(1);
        panelEntradas2 = new PanelEntradasTarifas(2);
        panelEntradas3 = new PanelEntradasTarifas(3);
        paneldebotones = new PanelBotonesTarifas(this);

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        panel1.add(panelEntradas1,BorderLayout.NORTH);
        panel1.add(panelEntradas2,BorderLayout.SOUTH);

        panel2.add(panelEntradas3);

        panel3.add(paneldebotones);

        add(panel1,BorderLayout.NORTH);
        add(panel2,BorderLayout.CENTER);
        add(panel3,BorderLayout.SOUTH);

        setSize(new Dimension(800,600));
    }
    
    public void agregar() 
    {
        Double precio = Double.parseDouble(panelEntradas1.darprecio());
        String fechaini = panelEntradas1.darfechaini();
        String anioStr = fechaini;
        String[] listanio = anioStr.split("/");
        int anio = Integer.parseInt(listanio[2]);
        String fechafin = panelEntradas1.darfechafin();
        String tipo = panelEntradas2.dartipo();
        ArrayList<String> listadias = panelEntradas3.darDias(); 
        interfazpadre.getEP().cambiarTarifa(tipo, anio, precio, fechaini, fechafin, listadias);
    }
    
    public void salir() 
    {
       
    }

}
