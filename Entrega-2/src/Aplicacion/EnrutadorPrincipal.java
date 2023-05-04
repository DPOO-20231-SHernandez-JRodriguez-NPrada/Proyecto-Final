package Aplicacion;

import java.util.ArrayList;
import java.util.HashMap;


import Aplicacion.Habitaciones.AdministradorHabitaciones;
import Aplicacion.Habitaciones.HabitacionBase;
import Aplicacion.Huespedes.AdministradorHuespedes;
import Aplicacion.Huespedes.Huesped;
import Aplicacion.Reservas.AdministradorReservas;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.AdministradorServicios;
import Aplicacion.Servicios.Producto;
import Aplicacion.Servicios.Servicio;
import Aplicacion.Servicios.ServicioBase;
import Aplicacion.Tarifas.AdministradorTarifas;
import Aplicacion.Tarifas.Tarifa;
import BaseDatos.ControladorBaseDatos;
import Facturas.AdministradorFacturas;
import Login.AdministradorLogin;
import Facturas.Factura;


public class EnrutadorPrincipal {
    
    private ControladorBaseDatos controladorBD;
    private AdministradorLogin adminLogin;
    private AdministradorFacturas adminFacturas;

    private AdministradorTarifas adminTarifas;
    private AdministradorReservas adminReservas;
    private AdministradorHuespedes adminHuespedes;
    private AdministradorServicios adminServicios;
    private AdministradorHabitaciones adminHabitaciones;
    private ChekInOut checkInOut;

    public EnrutadorPrincipal() {
        this.controladorBD = new ControladorBaseDatos();
        this.adminLogin = new AdministradorLogin();
        this.adminFacturas = new AdministradorFacturas();

        this.adminTarifas = new AdministradorTarifas();
        this.adminReservas = new AdministradorReservas(this);
        this.adminHuespedes = new AdministradorHuespedes();
        this.adminServicios = new AdministradorServicios();
        this.adminHabitaciones = new AdministradorHabitaciones();
        this.checkInOut = new ChekInOut();

    }
    
    /*
     * CargarAplicacion
     * 
     * Se encarga de comunicarse con los otros administradores para
     * cargar los datos de la aplicacion, asignandole a cada administrador 
     * los datos que necesita
     * 
     */
    public void CargarAplicacion() {
        CargarDatosLogin();
        CargarDatosReservas();
        CargarDatosServiciosBase();
        CargarDatosHabitaciones();
        CargarDatosHuespedes();
        CargarDatosTarifas();
        CargarDatosMenu();
        CargarDatosFacturas();
    }

    private void CargarDatosLogin() {
        HashMap<String,String> datosLogin = controladorBD.ConseguirDatosLogin();
        adminLogin.AsignarDatos(datosLogin);
    } 

    private void CargarDatosReservas() {
        HashMap<String, Reserva> datosReservas = controladorBD.ConseguirDatosReservas();
        adminReservas.AsignarDatosReserva(datosReservas);
    }

    private void CargarDatosServiciosBase() {
        ArrayList<ServicioBase> datosServiciosBase = controladorBD.ConseguirServiciosBase();
        adminServicios.AsignarServiciosBase(datosServiciosBase);
    }

    private void CargarDatosHabitaciones() {
        HashMap<String,HabitacionBase> datosHabitacionBase = controladorBD.ConseguirHabitacionesBase();
        adminHabitaciones.AsignarHabitacionesBase(datosHabitacionBase);
    }

    private void CargarDatosHuespedes() {
        HashMap<String, Huesped> datosHuespedes = controladorBD.ConseguirDatosHuespedes();
        adminHuespedes.AsignarHuespedes(datosHuespedes);
    }

    private void CargarDatosTarifas() {
        ArrayList<Tarifa> datosTarifas = controladorBD.ConseguirDatosTarifas();
        adminTarifas.AsignarTarifas(datosTarifas);   
    }

    private void CargarDatosMenu() {
        ArrayList<Producto> menuProductos = controladorBD.ConseguirMenu();
        adminServicios.AsignarMenu(menuProductos);
    }

    private void CargarDatosFacturas() {
        HashMap<String, ArrayList<Factura>> datosFacturas = controladorBD.ConseguirDatosFacturas();
        adminFacturas.AsignarFacturas(datosFacturas);
    }
    
    public String ComprobarLogin(String usuario, String contrasenia) {
        return adminLogin.ComprobarLogin(usuario, contrasenia);
    }
 
    public void cambiarTarifa(String tipo, int anio, Double precio, String finicio, String ffinal, ArrayList<String> dias)
    {
        this.adminTarifas.cambiarTarifa(tipo, anio, precio, finicio, ffinal, dias);
    }


    public double CrearReserva(String documento, String estadoReserva, int personasEsperadas, String fechainicial, String fechafinal, ArrayList<HabitacionBase> HabitacionesBs, String nombre, String correo, String celular)
    {
        Huesped huesped = adminHuespedes.crearHuesped(nombre, documento, correo, celular);
       double precio = adminReservas.CrearReserva(documento,estadoReserva,personasEsperadas,fechainicial,fechafinal,HabitacionesBs, huesped);
        return precio;
    }
    public String VerReserva(String documento)
    {
        String Texto = adminReservas.VerReserva(documento);
        return Texto;
    }
    public String  EliminarReserva(String documento, String fechactual)
    {
        String resultado = adminReservas.eliminarReserva(documento,fechactual);
        return resultado;
    }
    public void AñadirServicio(String documento, String Nombreservicio, String descripcion, String fecha, boolean pagado,double precio)
    {
        ServicioBase servicio = adminServicios.darServicio(Nombreservicio);
        if(servicio.getRegistro().equals("habitacion"))
        {
            adminReservas.AñadirServicio(documento,servicio,descripcion,fecha,pagado,precio);
        }
        else
        {
            adminHuespedes.AñadirServicio(documento,servicio,descripcion,fecha,pagado,precio);
        }
    }
    public double precioProducto(String nombre)
    {
        double precio = adminServicios.precioProducto(nombre);
        return precio;
    }
    public void HacerCheckIn(String documentoPrincipal, String documento, String nombre, String correo, String celular)
    {
        Huesped huesped = adminHuespedes.crearHuesped(nombre, documento, correo, celular);
        Reserva reserva = adminReservas.getReserva(documentoPrincipal);
        checkInOut.CheckIn(reserva, huesped);
    }
    public void HacerCheckout()
    {
        
    }
    public ArrayList<HabitacionBase> buscarHabitaciones(Boolean cocina, Boolean balcon, Boolean vista, String fechai, String fechaf, String tipo)
    {
        ArrayList<HabitacionBase> HabitacionesBs = adminHabitaciones.buscarHabitaciones(cocina, balcon, vista, fechai, fechaf, tipo);
        return HabitacionesBs;
    }
    public void modificarEstadoOcupado(String id,String fechainicial, String fechafinal,boolean cambio)
    {
        adminHabitaciones.modificarEstadoOcupado(id, fechainicial, fechafinal, cambio);
    }
    public Huesped crearHuesped(String nombre, String doc, String correo, String celular)
    {
        Huesped huesped = adminHuespedes.crearHuesped(nombre, doc, correo, celular);
        return huesped;
    }
    public double calcularPrecio(Reserva datosReserva)
    {
        double precio = adminTarifas.CalcularEstadia(datosReserva);
        return precio;
    }

    public HashMap<String, ArrayList<Servicio>> HacerCheckOut(String documento,
            boolean confirmarPago) {
        Reserva reserva = adminReservas.getReserva(documento);
        return checkInOut.CheckOut(reserva, confirmarPago);
    }

    public void facturarReserva(String documento){
        Reserva reserva = adminReservas.getReserva(documento);
        ArrayList<Huesped> huespedes = reserva.getGrupo();

        adminFacturas.CrearFacturaLiderGrupo(reserva);
        for (Huesped huesped : huespedes) {
            adminFacturas.CrearFacturaCliente(huesped);
        }
        
    }
    public void salirPrograma()
    {
        controladorBD.GuardarPrograma();
    }
}
