package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Aplicacion.Habitaciones.HabitacionBase;
import Aplicacion.Huespedes.Huesped;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Producto;
import Aplicacion.Servicios.ServicioBase;
import BaseDatos.ControladorBaseDatos;

public class CargaDatosTest {
    private ControladorBaseDatos base;
    
    //
    //public void CargarAplicacion() {
    //    CargarDatosLogin();
    //    CargarDatosReservas();
    //    CargarDatosServiciosBase();
    //    CargarDatosHabitaciones();
    //    CargarDatosHuespedes();
    //   CargarDatosTarifas();
    //    CargarDatosMenu();
    //    CargarDatosFacturas();
    //}   En la carga de datos se ejecutan esos metodos, se probara cada parte
    
    
    @BeforeEach
    public void setup() {
        base = new ControladorBaseDatos();
        // antes de empezar se debe hacer la carga de datos
        // todos los test se abajo seran para ver si los datos se cargaron correctamente
    }

    @Test
    public void testLogin() {
        HashMap<String, String> login = base.ConseguirDatosLogin();

        // se verificaran algunos login del archivo usuarios.csv
        Set<String> llaves = login.keySet();

        assertTrue("No se guardo la llave np",llaves.contains("np"));
        assertEquals("No se guardo correctamente la otra informacion de np",login.get("np"),"1234;admin");

        assertTrue("No se guardo la llave val",llaves.contains("val"));
        assertEquals("No se guardo correctamente la otra informacion de val",login.get("val"),"1234;admin");
    }

    @Test
    public void testReserva() {
        HashMap<String, Reserva> dReservas = base.ConseguirDatosReservas();

        // se probara la reserva de 1101745923 que esta en la linea 20 de reservas.csv
        // linea 20: 1101745923,checked,6,29/03/2023,07/04/2023
        Reserva reserva = dReservas.get("1101745923");
        assertNotNull("La llave no existe en el mapa", reserva); // comprueba que la reserva con esa llave exista

        Reserva falsa = dReservas.get("no llave");
        assertNull("Esa llave no deberia estar en el mapa", falsa); // comprueba una llave que no existe
        
        assertEquals("El estado de reserva no coincide", reserva.getEstadoReserva(), "checked");
        assertEquals("La fecha f de reserva no coincide", reserva.getFechaFin(), "07/04/2023");
        assertEquals("La fecha i de reserva no coincide", reserva.getFechaIni(), "29/03/2023");
        assertEquals("Personas de reserva no coincide", reserva.getPersonasEsperadas(), 6);

    }

    @Test
    public void testServiciosBase() {
        // se verificara el mini golf. Es ServiciosBase.csv linea 5
        ArrayList<ServicioBase> servicios = base.ConseguirServiciosBase();

        ServicioBase golf = servicios.get(3);
        assertEquals("Su nombre es incorrecto", "Mini golf",golf.getNombre());
        assertTrue("Su descripcion es incorrecta", golf.getDescripcion().contains("Sesion de mini"));
        assertEquals("Su registro (grupo/huesped) es incorrecto", "grupo",golf.getRegistro());
    }

    @Test
    public void testHabitaciones() {
        // linea 7 HabitacionesBase.csv
        // Edificio Cancun,5,7,E.C.306,suite,false,false,false,221,2023

        HashMap<String, HabitacionBase> habitaciones = base.ConseguirHabitacionesBase();
        HabitacionBase h_306 = habitaciones.get("E.C.306");
        assertNotNull("La habitacion no existe", h_306);

        assertEquals("La capacidad no coincide", 5, h_306.getCapacidad());
        assertEquals("El tipo no coincide", "suite", h_306.getTipo());
        
        // en ocupacionhabitaciones.csv linea 7 esta 306. Inicia con cero, cero
        Boolean[] ocupacion = h_306.getDiasOcupado();

        assertTrue("No coincide la ocupacion dia 1", !ocupacion[0]);
        assertTrue("No coincide la ocupacion dia 2", !ocupacion[1]);

        // con esto tambien se prueban las tarifas
    }

    @Test
    public void testHuespedes() {
        // Luisa Gomez,51467642,L.gomez@gmail.com,3134567345
        // Sus datos se encuentran en reservas.csv linea 16

        HashMap<String, Huesped> mapa = base.ConseguirDatosHuespedes();
        Huesped luisa = mapa.get("51467642");

        assertEquals("El nombre no coincide", "Luisa Gomez", luisa.getNombre());
        assertEquals("El numero no coincide", "3134567345", luisa.getCelular());


    }

    @Test
    public void testMenu() {
        // verifica hamburguesa en menu.csv
        ArrayList<Producto> menu = base.ConseguirMenu();

        Producto h = menu.get(0);

        assertEquals("El nombre no coincide", "Hamburguesa", h.getNombre());
        assertEquals("La vaalor no coincide",5.99 ,h.getPrecio(),0.01);


    }


    
}
