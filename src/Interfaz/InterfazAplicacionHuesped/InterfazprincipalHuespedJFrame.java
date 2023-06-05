package Interfaz.InterfazAplicacionHuesped;

import java.util.ArrayList;

import javax.swing.JFrame;

import Aplicacion.CaracteristicasHotel;
import Aplicacion.EnrutadorPrincipal;
import Aplicacion.Habitaciones.HabitacionBase;

public class InterfazprincipalHuespedJFrame extends JFrame {

    EnrutadorPrincipal enrutadorPrincipal;
    IniciarSesionJPanel iniciarSesionJPanel;
    CrearUsuarioJPanel crearUsuarioJPanel;
    VerYReservarCuartosJPanel verYReservarCuartosJPanel;

    public InterfazprincipalHuespedJFrame() {
        this.iniciarSesionJPanel = new IniciarSesionJPanel(this);
        this.crearUsuarioJPanel = new CrearUsuarioJPanel(this);
        this.verYReservarCuartosJPanel = new VerYReservarCuartosJPanel(this);
        this.enrutadorPrincipal = new EnrutadorPrincipal();


        setTitle("SISTEMA RESERVAS HOTEL");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(iniciarSesionJPanel);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    public static void main(String[] args) {

        InterfazprincipalHuespedJFrame interfazPrincipal = new InterfazprincipalHuespedJFrame();
        interfazPrincipal.CargarAplicacion();

    }

    public void cambiarPanel(String panel) {
        if (panel.equals("iniciarSesion")) {
            getContentPane().removeAll();
            add(iniciarSesionJPanel);
            repaint();
            revalidate();
        } else if (panel.equals("crearUsuario")) {
            getContentPane().removeAll();
            add(crearUsuarioJPanel);
            repaint();
            revalidate();
        }
        else if(panel.equals("reservar")){
            getContentPane().removeAll();
            add(verYReservarCuartosJPanel);
            repaint();
            revalidate();
        }
    }

    private void CargarAplicacion() {
        this.enrutadorPrincipal.CargarAplicacion();
    }

    public boolean IniciarSesion(String usuario, String contrasenia) {
        return enrutadorPrincipal.ComprobarLoginUsuario(usuario, contrasenia);
    }

    public boolean CrearUsuario(String usuario, String contrasenia) {
        return enrutadorPrincipal.CrearUsuario(usuario, contrasenia);
    }

    public double CrearReserva(String text, String string, int parseInt, String text2, String text3,
            ArrayList<HabitacionBase> habitacionesAReservar, String text4, String text5, String text6) {
        return enrutadorPrincipal.CrearReserva(text, string, parseInt, text2, text3, habitacionesAReservar, text4, text5,
                text6);
    }

    public ArrayList<HabitacionBase> buscarHabitaciones(boolean selected, boolean selected2, boolean selected3,
            String text, String text2, String tipoHabitacion) {
        return enrutadorPrincipal.buscarHabitaciones(selected, selected2, selected3, text, text2, tipoHabitacion);
    }

    public CaracteristicasHotel darCaracteristicasHotel() {
        return enrutadorPrincipal.getCaracteristicasHotel();
    }

    public HabitacionBase BuscarHabitacionBase(String text) {
        return enrutadorPrincipal.BuscarHabitacionBase(text);
    }

}
