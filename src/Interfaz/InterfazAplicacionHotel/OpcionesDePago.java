package Interfaz.InterfazAplicacionHotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class OpcionesDePago extends JPanel implements ActionListener {

    public OpcionesDePago(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();
    }

}
