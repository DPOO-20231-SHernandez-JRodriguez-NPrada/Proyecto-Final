package BaseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Aplicacion.CaracteristicasHotel;
import Aplicacion.Habitaciones.HabitacionBase;
import Aplicacion.Huespedes.Huesped;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Producto;
import Aplicacion.Servicios.ServicioBase;
import Aplicacion.Tarifas.Tarifa;
import Facturas.Factura;

public class ControladorBaseDatos {

    private TraductorFile traductor;
    private TraductorObject traductorObject;

    private HashMap<String,Reserva> datosReservas;
    private HashMap<String,Huesped> datosHuespedes;
    private ArrayList<Tarifa> datosTarifas;
    private HashMap<String, ArrayList<Factura>> datosFacturas;
    private HashMap<String, String> datosLoginClientes;

    public ControladorBaseDatos() {
        this.traductor = new TraductorFile();
        this.traductorObject = new TraductorObject();
        CargarDatosVariables();
    }

    private void CargarDatosVariables() {
        try {
            CargarDatosReservasYHuespedes();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            CargarDatosTarifas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            CargarDatosFacturas();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            CargarDatosLoginClientes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, String> CargarDatosLogin() throws IOException{
        File datosLoginFile = new File("Data/Usuarios.csv");
        if (datosLoginFile.exists()) {
            return traductor.TraducirDatosLoginFile(datosLoginFile);
        }
        else{
            return null;
        }
    }

    private void CargarDatosLoginClientes() throws IOException{
        File datosLoginFile = new File("Data/Clientes.csv");
        if (datosLoginFile.exists()) {
            this.datosLoginClientes = traductor.TraducirDatosLoginFile(datosLoginFile);
        }
        else{
            this.datosLoginClientes = null;
        }
    }

    private void CargarDatosReservasYHuespedes() throws IOException{
        
        File datosServiciosHabitacionesFolder = new File("Data/Reservas/HabitacionesReservaServicios");
        File datosServiciosHuespedesFolder = new File("Data/Reservas/HuespedesServicios");
        File datosReservasYHuespedesFile = new File("Data/Reservas/Reservas.csv");
        
        traductor.TraducirReservasYHuespedes(datosServiciosHabitacionesFolder, datosServiciosHuespedesFolder, datosReservasYHuespedesFile);

        this.datosReservas = traductor.ConseguirReservas();
        this.datosHuespedes = traductor.ConseguirHuespedes();
    }

    private ArrayList<ServicioBase> CargarServiciosBase() throws IOException {
        File serviciosBaseFile = new File("Data/ServiciosBase.csv");
        if (serviciosBaseFile.exists()) {
            return traductor.TraducirServiciosBaseFile(serviciosBaseFile);
        }
        else{
            return null;
        }
    }

    private HashMap<String, HabitacionBase> CargarHabitacionesBase() throws IOException {
        File habitacionesBaseFile = new File("Data/HabitacionesBase.csv");
        File ocupacionHabitacionesFile = new File("Data/OcupacionHabitaciones.csv");
        if (habitacionesBaseFile.exists()) {
            return traductor.TraducirHabitacionesBaseFile(habitacionesBaseFile, ocupacionHabitacionesFile);
        }
        else{
            return null;
        }
    }

    private void CargarDatosTarifas() {
        
        File datosTarifasFolder = new File("Data/Tarifas");
        
        this.datosTarifas = traductor.TraducirTarifas(datosTarifasFolder);
    }

    private ArrayList<Producto> CargarMenu() throws IOException{
        File menuFile = new File("Data/Menu.csv");
        if (menuFile.exists()) {
            return traductor.TraducirMenuFile(menuFile);
        }
        else{
            return null;
        }
    }

    private void CargarDatosFacturas() throws IOException{
        File datosFacturasFolder = new File("Data/Facturas");

        this.datosFacturas = traductor.TraducirFacturas(datosFacturasFolder);
    }

    public CaracteristicasHotel CargarCaracteristicasHotel() throws FileNotFoundException {
        File caracteristicasHotelFile = new File("Data/EspecificacionesHotel.csv");
        
        return traductor.TraducirCaracteristicasHotelFile(caracteristicasHotelFile);
    }

    //Metodos Getters
    
    public HashMap<String, String> ConseguirDatosLogin() {
        try {
            return CargarDatosLogin();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, String> ConseguirDatosLoginClientes() {
        return this.datosLoginClientes;
    }

    public HashMap<String, Reserva> ConseguirDatosReservas() {
        return this.datosReservas;
    }

    public ArrayList<ServicioBase> ConseguirServiciosBase() {
        try {
            return CargarServiciosBase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public HashMap<String, HabitacionBase> ConseguirHabitacionesBase() {
        try {
            return CargarHabitacionesBase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, Huesped> ConseguirDatosHuespedes() {
        return this.datosHuespedes;
    }

    public ArrayList<Tarifa> ConseguirDatosTarifas() {
        return this.datosTarifas;
    }

    public ArrayList<Producto> ConseguirMenu() {
        try {
            return CargarMenu();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, ArrayList<Factura>> ConseguirDatosFacturas() {
        return this.datosFacturas;
    }

    public void GuardarPrograma()
    {
        traductorObject.GuardarReservasHuespedesServicios(datosReservas);
        traductorObject.GuardarTarifas(datosTarifas);
        traductorObject.GuardarFacturas(datosFacturas);
        traductorObject.GuardarDatosLoginClientes(datosLoginClientes);
    }

}
