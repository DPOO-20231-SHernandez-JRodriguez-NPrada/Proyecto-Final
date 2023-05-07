package Interfaz.ServiciosGUI.GuiRestarurante;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Interfazrestaurante extends JFrame
{
    private PanelEntradasrestaurante panelEntradasR;
    private Paneldebotonesrestaurante paneldebotonesR;
    private PanelEntradasrestaurante panelMenu;

    private String documento;
    private String servicio;
    private String fecha;
    private boolean pagado;
    private double precio;

    public Interfazrestaurante(String documento,String servicio,String fecha,boolean pagado)
    {
        this.documento = documento;
        this.servicio = servicio;
        this.fecha = fecha;
        this.pagado = pagado;
        this.precio = 0;

        panelEntradasR = new PanelEntradasrestaurante(1);
        panelMenu = new PanelEntradasrestaurante(2);
        paneldebotonesR = new Paneldebotonesrestaurante(this);

        setLayout(new BorderLayout());

        add(panelEntradasR,BorderLayout.WEST);
        add(panelMenu,BorderLayout.EAST);
        add(paneldebotonesR,BorderLayout.SOUTH);

        setSize(new Dimension(800,350));
        setResizable(false);
		setTitle("Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }

    public void agregar() 
    {
        String nombre = panelEntradasR.darnproducto();
        String cant = panelEntradasR.darvconsumo();
        /*Enviar para obtener el precio  */
    }

    public void salir() 
    {
        dispose();
    }

    public void repetir() 
    {
        this.precio = 0;
    }

    public void agregarSer() 
    {
        /*Se envian todos los valores para agregar el servicio */
    }
}
