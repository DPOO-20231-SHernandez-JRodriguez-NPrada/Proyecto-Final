package Interfaz.ServiciosGUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;

public class PanelEntradaservicios extends JPanel {
    private JLabel dni;
    private JLabel pagado;
    private JLabel fconsumo;
    private JLabel nombreser;


    private JCheckBox pagadoBox;
    private JTextField dnitxt;
	private JTextField fconsumotxt;
    private JTextField nombresertxt;

    public PanelEntradaservicios()
    {
        dni = new JLabel("Escriba el documento del huesped principal");
        dnitxt = new JTextField();
        
        pagado = new JLabel("Seleccione si está pago o no");
        pagadoBox = new JCheckBox("Pagado", null, getFocusTraversalKeysEnabled());

        fconsumo = new JLabel("Escriba la fecha del consumo del servicio (dd/mm/aaaa)");
        fconsumotxt = new JTextField();

        nombreser = new JLabel("Nombre del servicio");
        nombresertxt = new JTextField();




        TitledBorder centerBorder = BorderFactory.createTitledBorder("Ingrese los datos para añadir el servicio");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        setBorder(centerBorder);

        setLayout(new GridLayout(4,2));

        add(dni);
        add(dnitxt);

        add(pagado);
        add(pagadoBox);

        add(fconsumo);
        add(fconsumotxt);

        add(nombreser);
        add(nombresertxt);
        
    }
    public String dardni()
    {
        String documento = dnitxt.getText();
        return documento;
    }

    public boolean darpagado()
    {
        boolean seleccionado = pagadoBox.isSelected();
        return seleccionado;
    }

    public String darfconsumo()
    {
        String fechaconsumo = fconsumotxt.getText();
        return fechaconsumo;
    }

    public String darnombreser()
    {
        String servicio = nombresertxt.getText();
        return servicio;
    }
}
