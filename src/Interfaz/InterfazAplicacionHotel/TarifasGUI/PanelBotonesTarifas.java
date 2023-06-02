package Interfaz.InterfazAplicacionHotel.TarifasGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;

public class PanelBotonesTarifas extends JPanel implements ActionListener
{
    
    private static final String Con = "Confirmar";
    private static final String Sal = "Salir";

    private JButton confirmar;
    private JButton salir;

    private Interfaztarifas intertar;

    public PanelBotonesTarifas(Interfaztarifas interfaztarifas)
    {
        intertar = interfaztarifas;

        confirmar = new JButton("Cambiar Tarifa");
        confirmar.addActionListener(this);
        confirmar.setActionCommand(Con);

        salir = new JButton("Salir");
        salir.setBackground(new Color(255, 0, 0));
        salir.addActionListener(this);
        salir.setActionCommand(Sal);

        setLayout(new FlowLayout());
        add(confirmar);
        add(salir);
    }



    @Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if(grito.equals(Con)) {
			intertar.agregar();
		}
        if(grito.equals(Sal)) {
			intertar.salir();
		}
		
	}
}
