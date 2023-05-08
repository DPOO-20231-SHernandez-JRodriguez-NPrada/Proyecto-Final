package Interfaz.ServiciosGUI.GuiRestarurante;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

public class PanelEntradasrestaurante extends JPanel{

    private JLabel numeroprod;
    private JLabel vecesconsumo;
    private JLabel menu;
    
    private JTextField numeroprodtxt;
	private JTextField vecesconsumotxt;

    public PanelEntradasrestaurante(int numero)
    {
        if(numero == 1)
        {
            numeroprod = new JLabel("Nombre del producto");
            numeroprodtxt = new JTextField();
            numeroprodtxt .setPreferredSize(new Dimension(50, 1));

            vecesconsumo = new JLabel("Veces que se consumió el producto");
            vecesconsumotxt = new JTextField();
            vecesconsumotxt .setPreferredSize(new Dimension(50, 1));

            TitledBorder centerBorder = BorderFactory.createTitledBorder("Ingrese los datos para añadir el servicio");
            centerBorder.setTitleJustification(TitledBorder.CENTER);
            setBorder(centerBorder);

            setLayout(new GridLayout(2,2));

            add(numeroprod);
            add(numeroprodtxt);
            add(vecesconsumo);
            add(vecesconsumotxt);
        }
        if(numero == 2)
        {
            menu = new JLabel("<html>El menu del restaurante es el siguiente con sus precios<br>1) Hamburguesa-5.99<br>2) Pizza-7.99<br>3)Papas Fritas-4.99<br>4) Perro Caliente-5.99<br>5) Nachos-3.99<br>6) Ensalada Cesar-7.99<br>7) Ensalada de Frutas-3.99<br>8) Omelet-4.99<br>9) Huevos Fritos-3.99<br>10) Huevos Revueltos-3.99<br>11) Mojito-12.49<br>12) Margarita-14.49<br>13) Coca-Cola-3.99<br>14) Agua-3.99<br>15) Cerveza-4.99</html>");

            TitledBorder centerBorder = BorderFactory.createTitledBorder("Menu");
            centerBorder.setTitleJustification(TitledBorder.CENTER);
            setBorder(centerBorder);

            setLayout(new GridLayout(1,1));

            add(menu);
        }

    }
    public String darnproducto()
    {
        String nprod = numeroprodtxt.getText();
        return nprod;
    }

    public String darvconsumo()
    {
        String vconsumo = vecesconsumotxt.getText();
        return vconsumo;
    }
}
