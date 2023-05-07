package Interfaz.TarifasGUI;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

public class Interfaztarifas extends JFrame 
{
    private PanelEntradasTarifas panelEntradas1;
    private PanelEntradasTarifas panelEntradas2;
    private PanelEntradasTarifas panelEntradas3;
    private PanelBotonesTarifas paneldebotones;

    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    public Interfaztarifas()
    {
        panelEntradas1 = new PanelEntradasTarifas(1);
        panelEntradas2 = new PanelEntradasTarifas(2);
        panelEntradas3 = new PanelEntradasTarifas(3);
        paneldebotones = new PanelBotonesTarifas(this);

        frame = new JFrame("Tarifas");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        panel1.add(panelEntradas1,BorderLayout.NORTH);
        panel1.add(panelEntradas2,BorderLayout.SOUTH);

        panel2.add(panelEntradas3);

        panel3.add(paneldebotones);

        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.CENTER);
        frame.add(panel3,BorderLayout.SOUTH);

        frame.setSize(new Dimension(800,600));
        frame.setResizable(false);
		frame.setTitle("Tarifas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
    }
    
    public void agregar() 
    {
        String precio = panelEntradas1.darprecio();
        String fechaini = panelEntradas1.darfechaini();
        String fechafin = panelEntradas1.darfechafin();
        String tipo = panelEntradas2.dartipo();
        ArrayList<String> listadias = panelEntradas3.darDias();
    }
    
    public void salir() 
    {

    }
}
