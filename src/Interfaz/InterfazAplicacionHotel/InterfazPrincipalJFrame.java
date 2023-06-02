package Interfaz.InterfazAplicacionHotel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import Aplicacion.EnrutadorPrincipal;
import Aplicacion.Habitaciones.HabitacionBase;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Servicio;
import Interfaz.InterfazAplicacionHotel.ServiciosGUI.Interfazservicios;
import Interfaz.InterfazAplicacionHotel.TarifasGUI.Interfaztarifas;


/**
 * InterfazPrincipal
 * 
 * Es la clase encarga de conectar la lógica del
 * programa con la interfaz con la que interactua el
 * usuario
 */
public class InterfazPrincipalJFrame extends JFrame {

    private InfromacionReservas informacionReservas;
    private CrearReserva crearReserva;
    private CheckInInterfaz checkIn;
    private LoginInterfaz login;
    private ConsolaMenuEmpleado consolaMenu;
    private CheckOutInterfaz checkOut;
    private Interfazservicios agregarServicio;
    private Interfaztarifas cambiarTarifa;
    private RestauranteInterfaz restaurante;
    private ConsultarOcupacion consultarOcupacion;

    private EnrutadorPrincipal enrutadorPrincipal;

    public InterfazPrincipalJFrame() {
        this.enrutadorPrincipal = new EnrutadorPrincipal();

        this.informacionReservas = new InfromacionReservas(this);
        this.crearReserva = new CrearReserva(this);
        this.checkIn = new CheckInInterfaz(this);
        this.login = new LoginInterfaz(this);
        this.consolaMenu = new ConsolaMenuEmpleado(this);
        this.checkOut = new CheckOutInterfaz(this);
        this.agregarServicio = new Interfazservicios(this);
        this.cambiarTarifa = new Interfaztarifas(this);
        this.restaurante = new RestauranteInterfaz(this);
        this.consultarOcupacion = new ConsultarOcupacion(this);

        setTitle("SISTEMA HOTEL DPOO");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(login);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        InterfazPrincipalJFrame interfazPrincipal = new InterfazPrincipalJFrame();
        interfazPrincipal.CargarAplicacion();
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
     * 
     * private void InicioDeSesion() {
     * 
     * System.out.println("""
     **************************************************
     * SYSTEMA HOTEL DPOO *
     **************************************************
     * 
     * """);
     * 
     * boolean flag = true;
     * 
     * while (flag) {
     * System.out.println("-                Inicio de sesion                -");
     * 
     * String usuario = Input.input("Usuario: ");
     * System.out.println();
     * String contrasenia = Input.input("Contrasenia: ");
     * 
     * String tipoUsuario = enrutadorPrincipal.ComprobarLogin(usuario, contrasenia);
     * 
     * if (tipoUsuario.equals("admin")) {
     * this.consolaEmpleado = new ConsolaAdmin(this);
     * flag = false;
     * } else if (tipoUsuario.equals("empleado")) {
     * this.consolaEmpleado = new ConsolaEmpleado(this);
     * flag = false;
     * } else {
     * System.out.println("Usuario o contrasenia incorrectos");
     * System.out.println("Intente de nuevo");
     * System.out.println("\n");
     * String salir =
     * Input.input("¿Desea salir de la aplicacion? Ingrese 'si' para salir: ");
     * 
     * if (salir.equals("si")) {
     * System.exit(0);
     * }
     * 
     * }
     * }
     * IniciarAplicacion();
     * }
     */

    // METODOS

    public String Login(String usuario, String contrasenia) {
        return enrutadorPrincipal.ComprobarLogin(usuario, contrasenia);
    }

    public void crearConsolaMenu(String tipoConsola) {
        if (tipoConsola.equals("admin")) {
            consolaMenu = new ConsolaMenuAdmin(this);
        } else {
            consolaMenu = new ConsolaMenuEmpleado(this);
        }
    }

    public void IrAPanelConsolaMenu() {
        getContentPane().removeAll();
        add(consolaMenu);
        repaint();
        revalidate();
    }

    public void IrAPanelCrearReserva() {
        getContentPane().removeAll();
        //TODO
        //this.setSize(WIDTH, HEIGHT);
        add(crearReserva);
        repaint();
        revalidate();
    }

    public void IrAPanelInfoReserva() {
        getContentPane().removeAll();
        add(informacionReservas);
        repaint();
        revalidate();
    }

    public void IrAPanelCheckIn() {
        getContentPane().removeAll();
        add(checkIn);
        repaint();
        revalidate();
    }

    public void IrAPanelCheckOut() {
        getContentPane().removeAll();
        add(checkOut);
        repaint();
        revalidate();
    }

    public void IrAPanelAnadirServicios() {
        getContentPane().removeAll();
        add(agregarServicio);
        repaint();
        revalidate();
    }

    public void IrAPanelCambiarTarifa() {
        getContentPane().removeAll();
        add(cambiarTarifa);
        repaint();
        revalidate();
    }

    public void IrAPanelConsultarOcupacion() {
        getContentPane().removeAll();
        add(consultarOcupacion);
        repaint();
        revalidate();
    }

    public void IrAPanelLogin() {
        getContentPane().removeAll();
        add(login);
        repaint();
        revalidate();
    }

    public Reserva ConseguirReserva(String documento){
        return enrutadorPrincipal.ConseguirReserva(documento);
    }


    /*
     * IniciarAplicacion
     * 
     * Inicia el loop principal del programa para la ejecucion de
     * este, dependiendo del tipo de consola que se haya establecido
     */
    private void IniciarAplicacion() {
       
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

    public double precioProducto(String producto, String cantidad) 
    {
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

    public HashMap<String, Boolean[]> getOcupacionHotel() {
        return enrutadorPrincipal.getOcupacionHotel();
    }

    public void salirPrograma() {
        enrutadorPrincipal.salirPrograma();
    }

}