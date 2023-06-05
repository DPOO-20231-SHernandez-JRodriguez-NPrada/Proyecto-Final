package Interfaz.InterfazAplicacionHotel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Aplicacion.CaracteristicasHotel;
import Aplicacion.Habitaciones.HabitacionBase;

public class VerEspecificacionesHotelHabitacionJFrame extends JFrame{

    private JLabel lblParqueaderoGratis, lblParquaderoGratisDato;
    private JLabel lblPiscina, lblPiscinaDato;
    private JLabel lblZonasHumedas, lblZonasHumedasDato;
    private JLabel lblBbq, lblBbqDato;
    private JLabel lblWifiGratis, lblWifiGratisDato;
    private JLabel lblRecepcion24, lblRecepcion24Dato;
    private JLabel lblMascotas, lblMascotasDato;

    private JLabel lblMetrosHabitacion, lblMetrosDato;
    private JLabel lblAireAcondicionado, lblAireAcondicionadoDato;
    private JLabel lblCalefaccion, lblCalefaccionDato;
    private JLabel lblTamañoCama, lblTamañoCamaDato;
    private JLabel lblTv, lblTvDato;
    private JLabel lblCafetera, lblCafeteraDato;
    private JLabel lblRopaDeCama, lblRopaDeCamaDato;
    private JLabel lblPlancha, lblPlanchaDato;
    private JLabel lblSecador, lblSecadorDato;
    private JLabel lblVoltaje, lblVoltajeDato;
    private JLabel lblUsb, lblUsbDato;
    private JLabel lblUsbc, lblUsbcDato;
    private JLabel lblDesayuno, lblDesayunoDato;


    
    public VerEspecificacionesHotelHabitacionJFrame(CaracteristicasHotel caracteristicasHotel, HabitacionBase habitacionBase){
        setTitle("SISTEMA HOTEL DPOO");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

        Border bdHotel = BorderFactory.createTitledBorder("Hotel");
        JPanel jpEspecificacionesHotel = new JPanel(new FlowLayout(0, 10, 5));
        jpEspecificacionesHotel.setBorder(bdHotel);
        lblParqueaderoGratis = new JLabel("Parqueadero Gratis: ");
        lblParqueaderoGratis.setSize(160, 50);
        lblParqueaderoGratis.setPreferredSize(new Dimension(160, 50));
        lblParqueaderoGratis.setMaximumSize(getPreferredSize());

        lblParquaderoGratisDato = new JLabel(caracteristicasHotel.isParqueaderoGratis() ? "Si" : "No");
        lblParquaderoGratisDato.setSize(50, 50);
        lblParquaderoGratisDato.setPreferredSize(new Dimension(50, 50));
        lblParquaderoGratisDato.setMaximumSize(getPreferredSize());

        lblPiscina = new JLabel("Piscina: ");
        lblPiscina.setSize(160, 50);
        lblPiscina.setPreferredSize(new Dimension(160, 50));
        lblPiscina.setMaximumSize(getPreferredSize());

        lblPiscinaDato = new JLabel(caracteristicasHotel.isPiscina() ? "Si" : "No");
        lblPiscinaDato.setSize(50, 50);
        lblPiscinaDato.setPreferredSize(new Dimension(50, 50));
        lblPiscinaDato.setMaximumSize(getPreferredSize());

        lblZonasHumedas = new JLabel("Zonas Humedas: ");
        lblZonasHumedas.setSize(160, 50);
        lblZonasHumedas.setPreferredSize(new Dimension(160, 50));
        lblZonasHumedas.setMaximumSize(getPreferredSize());
        
        lblZonasHumedasDato = new JLabel(caracteristicasHotel.isZonasHumedas() ? "Si" : "No");
        lblZonasHumedasDato.setSize(50, 50);
        lblZonasHumedasDato.setPreferredSize(new Dimension(50, 50));
        lblZonasHumedasDato.setMaximumSize(getPreferredSize());

        lblBbq = new JLabel("BBQ: ");
        lblBbq.setSize(160, 50);   
        lblBbq.setPreferredSize(new Dimension(160, 50));
        lblBbq.setMaximumSize(getPreferredSize());

        lblBbqDato = new JLabel(caracteristicasHotel.isBbq() ? "Si" : "No");
        lblBbqDato.setSize(50, 50);
        lblBbqDato.setPreferredSize(new Dimension(50, 50));
        lblBbqDato.setMaximumSize(getPreferredSize());

        lblWifiGratis = new JLabel("Wifi Gratis: ");
        lblWifiGratis.setSize(160, 50);
        lblWifiGratis.setPreferredSize(new Dimension(160, 50));
        lblWifiGratis.setMaximumSize(getPreferredSize());

        lblWifiGratisDato = new JLabel(caracteristicasHotel.isWifiGratis() ? "Si" : "No");
        lblWifiGratisDato.setSize(50, 50);
        lblWifiGratisDato.setPreferredSize(new Dimension(50, 50));
        lblWifiGratisDato.setMaximumSize(getPreferredSize());

        lblRecepcion24 = new JLabel("Recepcion 24 Horas: ");
        lblRecepcion24.setSize(160, 50);
        lblRecepcion24.setPreferredSize(new Dimension(160, 50));
        lblRecepcion24.setMaximumSize(getPreferredSize());

        lblRecepcion24Dato = new JLabel(caracteristicasHotel.isRecepcion24() ? "Si" : "No");
        lblRecepcion24Dato.setSize(50, 50);
        lblRecepcion24Dato.setPreferredSize(new Dimension(50, 50));
        lblRecepcion24Dato.setMaximumSize(getPreferredSize());

        lblMascotas = new JLabel("Se admiten mascotas: ");
        lblMascotas.setSize(160, 50);
        lblMascotas.setPreferredSize(new Dimension(160, 50));
        lblMascotas.setMaximumSize(getPreferredSize());

        lblMascotasDato = new JLabel(caracteristicasHotel.isMascotas() ? "Si" : "No");
        lblMascotasDato.setSize(50, 50);
        lblMascotasDato.setPreferredSize(new Dimension(50, 50));
        lblMascotasDato.setMaximumSize(getPreferredSize());

        jpEspecificacionesHotel.add(lblParqueaderoGratis);
        jpEspecificacionesHotel.add(lblParquaderoGratisDato);
        jpEspecificacionesHotel.add(lblPiscina);
        jpEspecificacionesHotel.add(lblPiscinaDato);
        jpEspecificacionesHotel.add(lblZonasHumedas);
        jpEspecificacionesHotel.add(lblZonasHumedasDato);
        jpEspecificacionesHotel.add(lblBbq);
        jpEspecificacionesHotel.add(lblBbqDato);
        jpEspecificacionesHotel.add(lblWifiGratis);
        jpEspecificacionesHotel.add(lblWifiGratisDato);
        jpEspecificacionesHotel.add(lblRecepcion24);
        jpEspecificacionesHotel.add(lblRecepcion24Dato);
        jpEspecificacionesHotel.add(lblMascotas);
        jpEspecificacionesHotel.add(lblMascotasDato);
        

        Border bdHabitacion = BorderFactory.createTitledBorder("Habitacion");
        JPanel jpEspecificacionesHabitacion = new JPanel(new FlowLayout(0, 10, 5));
        jpEspecificacionesHabitacion.setBorder(bdHabitacion);

        lblMetrosHabitacion = new JLabel("Metros: ");
        lblMetrosHabitacion.setSize(160, 25);
        lblMetrosHabitacion.setPreferredSize(new Dimension(160, 25));
        lblMetrosHabitacion.setMaximumSize(getPreferredSize());

        lblMetrosDato = new JLabel(String.valueOf(habitacionBase.getMetros()) + " metros^2");
        lblMetrosDato.setSize(100, 25);
        lblMetrosDato.setPreferredSize(new Dimension(100, 25));
        lblMetrosDato.setMaximumSize(getPreferredSize());

        lblAireAcondicionado = new JLabel("Aire Acondicionado: ");
        lblAireAcondicionado.setSize(160, 25);
        lblAireAcondicionado.setPreferredSize(new Dimension(160, 25));
        lblAireAcondicionado.setMaximumSize(getPreferredSize());

        lblAireAcondicionadoDato = new JLabel(habitacionBase.getAireAcondicionado() ? "Si" : "No");
        lblAireAcondicionadoDato.setSize(100, 25);
        lblAireAcondicionadoDato.setPreferredSize(new Dimension(100, 25));
        lblAireAcondicionadoDato.setMaximumSize(getPreferredSize());

        lblCalefaccion = new JLabel("Calefaccion: ");
        lblCalefaccion.setSize(160, 25);
        lblCalefaccion.setPreferredSize(new Dimension(160, 25));
        lblCalefaccion.setMaximumSize(getPreferredSize());

        lblCalefaccionDato = new JLabel(habitacionBase.getCalefaccion() ? "Si" : "No");
        lblCalefaccionDato.setSize(100, 25);
        lblCalefaccionDato.setPreferredSize(new Dimension(100, 25));
        lblCalefaccionDato.setMaximumSize(getPreferredSize());

        lblTamañoCama = new JLabel("Tamaño Cama: ");
        lblTamañoCama.setSize(160, 25);
        lblTamañoCama.setPreferredSize(new Dimension(160, 25));
        lblTamañoCama.setMaximumSize(getPreferredSize());

        lblTamañoCamaDato = new JLabel(String.valueOf(habitacionBase.getTamanioCama()) + " metros");
        lblTamañoCamaDato.setSize(100, 25);
        lblTamañoCamaDato.setPreferredSize(new Dimension(100, 25));
        lblTamañoCamaDato.setMaximumSize(getPreferredSize());
        
        lblTv = new JLabel("Tv: ");
        lblTv.setSize(160, 25);
        lblTv.setPreferredSize(new Dimension(160, 25));
        lblTv.setMaximumSize(getPreferredSize());
        
        lblTvDato = new JLabel(habitacionBase.getTv() ? "Si" : "No");
        lblTvDato.setSize(100, 25);
        lblTvDato.setPreferredSize(new Dimension(100, 25));
        lblTvDato.setMaximumSize(getPreferredSize());

        lblCafetera = new JLabel("Cafetera: ");
        lblCafetera.setSize(160, 25);
        lblCafetera.setPreferredSize(new Dimension(160, 25));
        lblCafetera.setMaximumSize(getPreferredSize());

        lblCafeteraDato = new JLabel(habitacionBase.getCafetera() ? "Si" : "No");
        lblCafeteraDato.setSize(100, 25);
        lblCafeteraDato.setPreferredSize(new Dimension(100, 25));
        lblCafeteraDato.setMaximumSize(getPreferredSize());

        lblRopaDeCama = new JLabel("Ropa de Cama: ");
        lblRopaDeCama.setSize(160, 25);
        lblRopaDeCama.setPreferredSize(new Dimension(160, 25));
        lblRopaDeCama.setMaximumSize(getPreferredSize());

        lblRopaDeCamaDato = new JLabel(habitacionBase.getRopaDeCama() ? "Si" : "No");
        lblRopaDeCamaDato.setSize(100, 25);
        lblRopaDeCamaDato.setPreferredSize(new Dimension(100, 25));
        lblRopaDeCamaDato.setMaximumSize(getPreferredSize());

        lblPlancha = new JLabel("Plancha: ");
        lblPlancha.setSize(160, 25);
        lblPlancha.setPreferredSize(new Dimension(160, 25));
        lblPlancha.setMaximumSize(getPreferredSize());

        lblPlanchaDato = new JLabel(habitacionBase.getPlancha() ? "Si" : "No");
        lblPlanchaDato.setSize(100, 25);
        lblPlanchaDato.setPreferredSize(new Dimension(100, 25));
        lblPlanchaDato.setMaximumSize(getPreferredSize());

        lblSecador = new JLabel("Secador: ");
        lblSecador.setSize(160, 25);
        lblSecador.setPreferredSize(new Dimension(160, 25));
        lblSecador.setMaximumSize(getPreferredSize());

        lblSecadorDato = new JLabel(habitacionBase.getSecador() ? "Si" : "No");
        lblSecadorDato.setSize(100, 25);
        lblSecadorDato.setPreferredSize(new Dimension(100, 25));
        lblSecadorDato.setMaximumSize(getPreferredSize());

        lblVoltaje = new JLabel("Voltaje AC: ");
        lblVoltaje.setSize(160, 25);
        lblVoltaje.setPreferredSize(new Dimension(160, 25));
        lblVoltaje.setMaximumSize(getPreferredSize());

        lblVoltajeDato = new JLabel(habitacionBase.getVoltaje() ? "Si" : "No");
        lblVoltajeDato.setSize(100, 25);
        lblVoltajeDato.setPreferredSize(new Dimension(100, 25));
        lblVoltajeDato.setMaximumSize(getPreferredSize());
        
        lblUsb = new JLabel("Tomas USB-A: ");
        lblUsb.setSize(160, 25);   
        lblUsb.setPreferredSize(new Dimension(160, 25));
        lblUsb.setMaximumSize(getPreferredSize());

        lblUsbDato = new JLabel(habitacionBase.getUsb() ? "Si" : "No");
        lblUsbDato.setSize(100, 25);
        lblUsbDato.setPreferredSize(new Dimension(100, 25));
        lblUsbDato.setMaximumSize(getPreferredSize());
        
        lblUsbc = new JLabel("Tomas USB-C: ");
        lblUsbc.setSize(160, 25);
        lblUsbc.setPreferredSize(new Dimension(160, 25));
        lblUsbc.setMaximumSize(getPreferredSize());

        lblUsbcDato = new JLabel(habitacionBase.getUsbc() ? "Si" : "No");
        lblUsbcDato.setSize(100, 25);
        lblUsbcDato.setPreferredSize(new Dimension(100, 25));
        lblUsbcDato.setMaximumSize(getPreferredSize());

        lblDesayuno = new JLabel("Desayuno incluido: ");
        lblDesayuno.setSize(160, 25);
        lblDesayuno.setPreferredSize(new Dimension(160, 25));
        lblDesayuno.setMaximumSize(getPreferredSize());

        lblDesayunoDato = new JLabel(habitacionBase.getDesayuno() ? "Si" : "No");
        lblDesayunoDato.setSize(100, 25);
        lblDesayunoDato.setPreferredSize(new Dimension(100, 25));
        lblDesayunoDato.setMaximumSize(getPreferredSize());

        jpEspecificacionesHabitacion.add(lblMetrosHabitacion);
        jpEspecificacionesHabitacion.add(lblMetrosDato);
        jpEspecificacionesHabitacion.add(lblAireAcondicionado);
        jpEspecificacionesHabitacion.add(lblAireAcondicionadoDato);
        jpEspecificacionesHabitacion.add(lblCalefaccion);
        jpEspecificacionesHabitacion.add(lblCalefaccionDato);
        jpEspecificacionesHabitacion.add(lblTamañoCama);
        jpEspecificacionesHabitacion.add(lblTamañoCamaDato);
        jpEspecificacionesHabitacion.add(lblTv);
        jpEspecificacionesHabitacion.add(lblTvDato);
        jpEspecificacionesHabitacion.add(lblCafetera);
        jpEspecificacionesHabitacion.add(lblCafeteraDato);
        jpEspecificacionesHabitacion.add(lblRopaDeCama);
        jpEspecificacionesHabitacion.add(lblRopaDeCamaDato);
        jpEspecificacionesHabitacion.add(lblPlancha);
        jpEspecificacionesHabitacion.add(lblPlanchaDato);
        jpEspecificacionesHabitacion.add(lblSecador);
        jpEspecificacionesHabitacion.add(lblSecadorDato);
        jpEspecificacionesHabitacion.add(lblVoltaje);
        jpEspecificacionesHabitacion.add(lblVoltajeDato);
        jpEspecificacionesHabitacion.add(lblUsb);
        jpEspecificacionesHabitacion.add(lblUsbDato);
        jpEspecificacionesHabitacion.add(lblUsbc);
        jpEspecificacionesHabitacion.add(lblUsbcDato);
        jpEspecificacionesHabitacion.add(lblDesayuno);
        jpEspecificacionesHabitacion.add(lblDesayunoDato);

        this.add(jpEspecificacionesHotel);
        this.add(jpEspecificacionesHabitacion);

        setVisible(true);
    }
}
