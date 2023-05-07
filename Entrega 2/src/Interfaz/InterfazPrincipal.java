package Interfaz;

import java.util.ArrayList;
import java.util.HashMap;

import Aplicacion.EnrutadorPrincipal;
import Aplicacion.Input;
import Aplicacion.Habitaciones.HabitacionBase;
import Aplicacion.Servicios.Servicio;
import Interfaz.ClasesReHechas.DialogoLogin;
import Interfaz.ClasesReHechas.PanelOpciones;
import Interfaz.ClasesViejas.ConsolaAdmin;
import Interfaz.ClasesViejas.ConsolaEmpleado;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * InterfazPrincipal
 * 
 * Es la clase encarga de conectar la lógica del
 * programa con la interfaz con la que interactua el
 * usuario
 */
public class InterfazPrincipal extends JFrame {

    private DialogoLogin login;
    private PanelOpciones panelOpciones;
    private EnrutadorPrincipal enrutadorPrincipal;
    private ConsolaEmpleado consolaEmpleado;

    public InterfazPrincipal() {
        this.enrutadorPrincipal = new EnrutadorPrincipal();
        setSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hotel Transilvania");
        login = new DialogoLogin(this);

        String username = login.getUsuario();
        String password = login.getPassword();
        JOptionPane.showMessageDialog(this, "Username: " + username + "\nPassword: " + password); // TODO esto hara que
                                                                                                  // se vea si hubo
                                                                                                  // error

        // TODO del login debe conseguir de alguna manera si es admin o no
        panelOpciones = new PanelOpciones(true);// debe recibir como parametro si es admin o no
        setLayout(new FlowLayout());
        add(panelOpciones);

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {

        InterfazPrincipal interfazPrincipal = new InterfazPrincipal();

        interfazPrincipal.CargarAplicacion();
        interfazPrincipal.InicioDeSesion();

    }

    /*
     * CragarAplicacion
     * 
     * Le indica al enrutador principal que ejecute su metodo
     * de iniciar aplicacion
     */
    private void CargarAplicacion() {
        enrutadorPrincipal.CargarAplicacion();
    }

    /*
     * InicioDeSesion
     * 
     * Muestra una interfaz en consola para que el usuario ingrese
     * usuario y contraseña
     * Llama al metodo del enrutador princiapl con el mismo nombre
     * Le atribuya a consolaEmpleado una consola de administrador o de empleado,
     * dependiendo
     * de la respuesta del enrutador principal
     * Inicia el programa principal
     */
    private void InicioDeSesion() {

        System.out.println("""
                **************************************************
                *               SYSTEMA HOTEL DPOO               *
                **************************************************

                """);

        boolean flag = true;

        while (flag) {
            System.out.println("-                Inicio de sesion                -");

            String usuario = Input.input("Usuario: ");
            System.out.println();
            String contrasenia = Input.input("Contrasenia: ");

            String tipoUsuario = enrutadorPrincipal.ComprobarLogin(usuario, contrasenia);

            if (tipoUsuario.equals("admin")) {
                this.consolaEmpleado = new ConsolaAdmin(this);
                flag = false;
            } else if (tipoUsuario.equals("empleado")) {
                this.consolaEmpleado = new ConsolaEmpleado(this);
                flag = false;
            } else {
                System.out.println("Usuario o contrasenia incorrectos");
                System.out.println("Intente de nuevo");
                System.out.println("\n");
                String salir = Input.input("¿Desea salir de la aplicacion? Ingrese 'si' para salir: ");

                if (salir.equals("si")) {
                    System.exit(0);
                }

            }
        }
        IniciarAplicacion();
    }

    /*
     * IniciarAplicacion
     * 
     * Inicia el loop principal del programa para la ejecucion de
     * este, dependiendo del tipo de consola que se haya establecido
     */
    private void IniciarAplicacion() {
        if (consolaEmpleado instanceof ConsolaAdmin) {
            ComprobarTarifaActual();
        }

        consolaEmpleado.IniciarPrograma();

    }

    public EnrutadorPrincipal getEP() {
        return this.enrutadorPrincipal;
    }

    private void ComprobarTarifaActual() {
    }

    protected ArrayList<HabitacionBase> buscarHabitaciones(Boolean cocinaB, Boolean balconB, Boolean vistaB,
            String fechainicial, String fechafinal, String tipo) {
        ArrayList<HabitacionBase> HabitacionesBs = enrutadorPrincipal.buscarHabitaciones(cocinaB, balconB, vistaB,
                fechainicial, fechafinal, tipo);
        return HabitacionesBs;
    }

    protected double CrearReserva(String documento, String estadoReserva, int personasEsperadas, String fechainicial,
            String fechafinal, ArrayList<HabitacionBase> habitacionesBs, String nombre, String correo, String celular) {
        double precio = enrutadorPrincipal.CrearReserva(documento, estadoReserva, personasEsperadas, fechainicial,
                fechafinal, habitacionesBs, nombre, correo, celular);
        return precio;
    }

    protected String VerReserva(String documento) {
        return enrutadorPrincipal.VerReserva(documento);
    }

    public String EliminarReserva(String documento, String fechactual) {
        String resultado = enrutadorPrincipal.EliminarReserva(documento, fechactual);
        return resultado;
    }

    public double precioProducto(String producto, String cantidad) {
        return enrutadorPrincipal.precioProducto(producto, cantidad);
    }

    public void AñadirServicio(String documento, String servicio, String descripcion, String fecha, boolean pagado,
            double precio) {
        enrutadorPrincipal.AñadirServicio(documento, servicio, descripcion, fecha, pagado, precio);
    }

    public void HacerCheckIn(String documentoPrincipal, String documento, String nombre, String correo,
            String celular) {
        enrutadorPrincipal.HacerCheckIn(documentoPrincipal, documento, nombre, correo, celular);
    }

    public HashMap<String, ArrayList<Servicio>> HacerCheckOut(String documento, boolean confirmarPago) {
        return enrutadorPrincipal.HacerCheckOut(documento, confirmarPago);
    }

    public void FacturarGrupo(String documento) {
        enrutadorPrincipal.facturarReserva(documento);
    }

    public void salirPrograma() {
        enrutadorPrincipal.salirPrograma();
    }

}