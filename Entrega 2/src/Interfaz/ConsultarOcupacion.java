package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ConsultarOcupacion extends JPanel implements ActionListener {
    private InterfazPrincipalJFrame ventanaPadre;
    private JPanel calendarPanel, buttonPanel, searchPanel;
    private HashMap<String, Boolean[]> ocupacionHotel;
    private JLabel lbTitle;
    private Font fuente;
    private Border vacio;
    private JButton btnSalir;

    public ConsultarOcupacion(InterfazPrincipalJFrame interfazPrincipalJFrame) {
        ventanaPadre = interfazPrincipalJFrame;

        ocupacionHotel = new HashMap<>();
        // 365 days represented by boolean
        // ocupacionHotel.put("501", new Boolean[] { false, true, false, true, false,
        // false, true, true, false, true,
        // false, false, true, false, true, true, false, true, false, false, true,
        // false, true, true, false, false,
        // true, true, false, true, false, true, false, true, false, false, true, true,
        // false, false, true, false,
        // true, true, false, true, false, false, true, false, true, true, false, true,
        // false, false, true, false,
        // true, false, true, false, true, false, true, false, true, false, true, false,
        // true, true, false, true,
        // false, false, true, true, false, false, true, false, true, false, true, true,
        // false, false, true, false,
        // true, true, false, false, true, true, false, true, false, false, true, false,
        // true, true, false, true,
        // false, true, false, true, false, false, true, false, true, true, false,
        // false, true, true, false, true,
        // false, true, false, true, false, false, true, false, true, true, false, true,
        // false, false, true, true,
        // false, false, true, false, true, true, false, false, true, true, false, true,
        // false, false, true, false,
        // true, true, false, true, false, true, false, true, false, false, true, true,
        // false, false, true, false,
        // true, true, false, true, false, false, true, false, true, false, true, false,
        // true, true, false, true,
        // false, false, true, false, true, true, false, true, false, false, true, true,
        // false, false, true, false,
        // true, true, false, true, false, false, true, false, true, true, false, true,
        // false, false, true, false,
        // true, false, true, false, true, false, true, false, true, true, false, false,
        // true, false, true, true,
        // false, true, false, false, true, true, false, true, false, false, true,
        // false, true, true, false, false,
        // true, true, false, true, false, false, true, false, true, true, false, false,
        // true, true, false, true,
        // false, true, false, true, false, false, true, true, false, false, true,
        // false, true, true, false, true,
        // false, false, true, false, true, true, false, false, true, true, false, true,
        // false, false, true, false,
        // true, true, false, true, false, false, true, true, false, false, true, false,
        // true, true, false, true,
        // false, false, true, false, true, false, true, false, true, false, true,
        // false, true, false, true, false,
        // true, true, false, true, false, false, true, false, true, true, false, false,
        // true, true, false, true,
        // false, false, true, false, true, true, false, false, true, true, false, true,
        // false, false, true, false,
        // true, true, false, true, false, false, true, true, false });
        // ocupacionHotel.put("502", new Boolean[] { false, true, true, true, true, true
        // });
        ocupacionHotel.put("503", new Boolean[] { true, true, false, false, false,
                true });

        // this.ocupacionHotel = ventanaPadre.getOcupacionHotel();

        setLayout(new BorderLayout());
        setBackground(new Color(148, 142, 142));
        fuente = new Font("Arial", Font.BOLD, 20);
        vacio = BorderFactory.createEmptyBorder();

        // ocupacion = new HashMap<String, Boolean[]>();

        searchPanel = getSearchPanel();
        calendarPanel = getCalendarPanel();
        buttonPanel = getButtonPanel();

        add(searchPanel, BorderLayout.PAGE_START);
        add(calendarPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    public HashMap<String, Boolean[]> getOcupacion() {
        HashMap<String, Boolean[]> ocupacionHotel = ventanaPadre.getOcupacionHotel();
        return ocupacionHotel;
    }

    public JPanel getSearchPanel() {
        searchPanel = new JPanel();
        // searchPanel.setBackground(new Color(148, 142, 142));
        searchPanel.setLayout(new BorderLayout(40, 20));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbTitle = new JLabel("Ocupación del hotel");
        lbTitle.setFont(fuente);

        // border
        lbTitle.setBorder(vacio);

        return searchPanel;
    }

    public JPanel getCalendarPanel() {
        calendarPanel = new JPanel(new GridLayout(ocupacionHotel.size() + 1, 366));

        // Add headers for each day of the year
        for (int i = 1; i <= 366; i++) {
            JLabel dayLabel = new JLabel(String.valueOf(i));
            calendarPanel.add(dayLabel);
        }

        // Add rows for each room
        for (String id : ocupacionHotel.keySet()) {
            JLabel roomLabel = new JLabel(id);
            calendarPanel.add(roomLabel);

            for (boolean isOccupied : ocupacionHotel.get(id)) {
                JPanel dayPanel = new JPanel();
                dayPanel.setBackground(isOccupied ? Color.BLUE : Color.WHITE);
                calendarPanel.add(dayPanel);
            }
        }

        return calendarPanel;
    }

    public JPanel getButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Buttons
        btnSalir = new JButton("Salir");
        btnSalir.setPreferredSize(new Dimension(200, 45));
        btnSalir.setBackground(Color.BLACK);
        // btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(fuente);
        btnSalir.setMaximumSize(new Dimension(200, 200));
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("SALIR");

        // Añadir elementos al panel

        buttonPanel.add(btnSalir);

        return buttonPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if (grito.equals("SALIR")) {
            System.exit(0);
        }
    }

}
