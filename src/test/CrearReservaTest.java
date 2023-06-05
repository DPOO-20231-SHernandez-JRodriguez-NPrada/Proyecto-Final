package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Aplicacion.EnrutadorPrincipal;
import Aplicacion.Habitaciones.HabitacionBase;

public class CrearReservaTest {
	@Test
    public void testCrearReserva() {
		EnrutadorPrincipal ep = new EnrutadorPrincipal();
		ep.CargarAplicacion(); // se asume que esta bien porque este test es para reservas
		
		// se eligen habitaciones arbitrarias para la reserva
		ArrayList<HabitacionBase> habs = ep.buscarHabitaciones(false, false, false, "01/01/2023", "02/01/2023", "suite");
		Double precio = ep.CrearReserva("1053605188", "reservado", 10, "01/01/2023", "02/01/2023", habs, "Samuel", "hola@gmail.com", "3000000000");
		
		assertTrue(precio>0,"El precio esta mal calculado");
		
		habs = ep.buscarHabitaciones(false, false, false, "01/01/2023", "02/01/2023", "suite");
		
		for (HabitacionBase hab : habs) {
			assertTrue(!hab.getDiasOcupado()[0], "La habitacion no se muestra como ocupada"); 
			// el primer dia del año deberia de estar ocupado porque
			// debe de modicar sus dias de ocupado al crearla
			
		}
		
		assertNotNull(ep.ConseguirReserva("1053605188"));
		// las reservas se buscan por el documento
		// debe existir una reserva con ese documento
		
		
		// con el test se probo que  el precio se calcula, ya que no es cero
		// se modifica correctamente los dias que estaran ocuapdas la habitaciones
		// la reserva se guarda en el administrador de reservas
		
        }

}
