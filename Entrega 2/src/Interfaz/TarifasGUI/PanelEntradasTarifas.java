package Interfaz.TarifasGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class PanelEntradasTarifas extends JPanel
{
    private JLabel precio;
    private JLabel tipo;
    private JLabel dias;
    private JLabel fechaini;
    private JLabel fechafin;
    
    private JTextField preciotxt;

    private JCheckBox tipoSuite;
    private JCheckBox tipoDoble;
    private JCheckBox tipoEstandar;
    
    private JCheckBox lunesCheckBox;
    private JCheckBox martesCheckBox;
    private JCheckBox miercolesCheckBox;
    private JCheckBox juevesCheckBox;
    private JCheckBox viernesCheckBox;
    private JCheckBox sabadoCheckBox;
    private JCheckBox domingoCheckBox;

	private JTextField fechainitxt;
    private JTextField fechafintxt;

    public PanelEntradasTarifas(int numero)
    {
        if(numero ==1)
        {
            precio = new JLabel("Precio(USD$)");
            preciotxt = new JTextField();

            fechaini = new JLabel("Escriba la fecha inicial (dd/mm/aaaa)");
            fechainitxt = new JTextField();

            fechafin = new JLabel("Escriba la fecha final (dd/mm/aaaa)");
            fechafintxt = new JTextField();
        }
        
        if(numero == 2)
        {
            tipo = new JLabel("Seleccione el tipo de habitacion");
            tipoSuite = new JCheckBox("Suite", null, getFocusTraversalKeysEnabled());
            tipoDoble = new JCheckBox("Doble", null, getFocusTraversalKeysEnabled());
            tipoEstandar = new JCheckBox("Estandar", null, getFocusTraversalKeysEnabled());
        }

        if(numero == 3)
        {
            dias = new JLabel("Seleccione los dias");
            lunesCheckBox = new JCheckBox("Lunes", null, getFocusTraversalKeysEnabled());
            martesCheckBox = new JCheckBox("Martes", null, getFocusTraversalKeysEnabled());
            miercolesCheckBox = new JCheckBox("Miercoles", null, getFocusTraversalKeysEnabled());
            juevesCheckBox = new JCheckBox("Jueves", null, getFocusTraversalKeysEnabled());
            viernesCheckBox = new JCheckBox("Viernes", null, getFocusTraversalKeysEnabled());
            sabadoCheckBox = new JCheckBox("Sabado", null, getFocusTraversalKeysEnabled());
            domingoCheckBox = new JCheckBox("Domingo", null, getFocusTraversalKeysEnabled());
        }


        if(numero == 2)
        {
            TitledBorder centerBorder = BorderFactory.createTitledBorder("Ingrese los datos para cambiar las tarifas");
            centerBorder.setTitleFont(new Font("Arial", Font.BOLD, 10));
            centerBorder.setTitleJustification(TitledBorder.CENTER);
            setBorder(centerBorder);
        }
        else
        {
            TitledBorder centerBorder = BorderFactory.createTitledBorder("Ingrese los datos para cambiar las tarifas");
            centerBorder.setTitleJustification(TitledBorder.CENTER);
            setBorder(centerBorder);
        }


        if(numero == 1)
        {
            setLayout(new GridLayout(3,2));
            add(precio);
            add(preciotxt);
            add(fechaini);
            add(fechainitxt);
            add(fechafin);
            add(fechafintxt);
        }

        if(numero == 2)
        {
            ButtonGroup grupo1 = new ButtonGroup(); 
            grupo1.add(tipoSuite);
            grupo1.add(tipoDoble);
            grupo1.add(tipoEstandar);
            setLayout(new GridLayout(4,1));
            add(tipo);
            add(tipoSuite);
            add(tipoDoble);
            add(tipoEstandar);
        }

        if(numero == 3)
        {
            setLayout(new GridLayout(2,8));
            add(dias);
            add(lunesCheckBox);
            add(martesCheckBox);
            add(miercolesCheckBox);
            add(juevesCheckBox);
            add(viernesCheckBox);
            add(sabadoCheckBox);
            add(domingoCheckBox);
        }
    }

    public String darprecio()
    {
        String precioT = preciotxt.getText();
        return precioT;
    }

    public String darfechaini()
    {
        String fechainiT = fechainitxt.getText();
        return fechainiT;
    }

    public String darfechafin()
    {
        String fechafinT = fechafintxt.getText();
        return fechafinT;
    }

    public String dartipo()
    {
        boolean seleccionado1 = tipoSuite.isSelected();
        boolean seleccionado2 = tipoDoble.isSelected();
        if(seleccionado1 == true)
        {
            return "Suite";
        }
        if(seleccionado2 == true)
        {
            return "Doble";
        }
        else
        {
            return "Estandar";
        }
    }
    public ArrayList<String> darDias()
    {
        ArrayList<String> listadias = new ArrayList<String>();
        boolean dia1 = lunesCheckBox.isSelected();
        boolean dia2 = martesCheckBox.isSelected();
        boolean dia3 = miercolesCheckBox.isSelected();
        boolean dia4 = juevesCheckBox.isSelected();
        boolean dia5 = viernesCheckBox.isSelected();
        boolean dia6 = sabadoCheckBox.isSelected();
        boolean dia7 = domingoCheckBox.isSelected();

        if(dia1 == true)
        {
            listadias.add("MONDAY");
        }
        if(dia2 == true)
        {
            listadias.add("TUESDAY");
        }
        if(dia3 == true)
        {
            listadias.add("WEDNESDAY");
        }
        if(dia4 == true)
        {
            listadias.add("THURSDAY");
        }
        if(dia5 == true)
        {
            listadias.add("FRIDAY");
        }
        if(dia6 == true)
        {
            listadias.add("SATURDAY");
        }
        if(dia7 == true)
        {
            listadias.add("SUNDAY");
        }
        return listadias;
    }
}
