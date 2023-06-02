package Aplicacion.Reservas;
import java.util.ArrayList;

import Aplicacion.Habitaciones.HabitacionReserva;
import Aplicacion.Huespedes.Huesped;



public class Reserva {
    String documento;
    String estadoReserva;
    int personasEsperadas;
    String fechaIni;
    String fechaFin;
    ArrayList<HabitacionReserva> habitacionesReservadas;
	ArrayList<Huesped> grupo;

	public Reserva(String documento, String estadoReserva, int personasEsperadas, String fechaIni, String fechaFin, ArrayList<HabitacionReserva> habitacionesReservadas) {
		this.documento = documento;
		this.estadoReserva = estadoReserva;
		this.personasEsperadas = personasEsperadas;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.habitacionesReservadas = habitacionesReservadas;
		this.grupo = new ArrayList<Huesped>();
    }

	public Reserva(String documento, String estadoReserva, int personasEsperadas, String fechaIni, String fechaFin, ArrayList<HabitacionReserva> habitacionesReservadas, ArrayList<Huesped> grupo) {
		this.documento = documento;
		this.estadoReserva = estadoReserva;
		this.personasEsperadas = personasEsperadas;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.habitacionesReservadas = habitacionesReservadas;
		this.grupo = grupo;
    }

    public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEstadoReserva() {
		return estadoReserva;
	}

	public void setEstadoReserva(String estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	public int getPersonasEsperadas() {
		return personasEsperadas;
	}

	public void setPersonasEsperadas(int personasEsperadas) {
		this.personasEsperadas = personasEsperadas;
	}

	public String getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public ArrayList<HabitacionReserva> getHabitacionesReservadas() {
		return habitacionesReservadas;
	}

	public void setHabitacionesReservadas(ArrayList<HabitacionReserva> habitacionesReservadas) {
		this.habitacionesReservadas = habitacionesReservadas;
	}

	public ArrayList<Huesped> getGrupo() {
		return grupo;
	}
}


