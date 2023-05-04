package Aplicacion.Reservas;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import Aplicacion.Habitaciones.HabitacionBase;
import Aplicacion.Habitaciones.HabitacionReserva;
import Aplicacion.Huespedes.Huesped;
import Aplicacion.Servicios.Servicio;
import Aplicacion.Servicios.ServicioBase;
import Aplicacion.EnrutadorPrincipal;

public class AdministradorReservas {


    public EnrutadorPrincipal enrutadorPrincipal;
    HashMap<String, Reserva> datosReservas;

    public AdministradorReservas(EnrutadorPrincipal enrutadorPrincipal)
    {
        this.enrutadorPrincipal = enrutadorPrincipal;
    }
    public void AsignarDatosReserva(HashMap<String, Reserva> datosReservas) {
        this.datosReservas = datosReservas;
    }
    
    public double CrearReserva(String documento, String estadoReserva, int personasEsperadas, String fechainicial, String fechafinal, ArrayList<HabitacionBase> HabitacionesBs,Huesped huesped)
    {
        ArrayList<HabitacionReserva> HabitacionesRs = new ArrayList<HabitacionReserva>();
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
        boolean parar = false;
        int i = 0;
        int capacidad = 0;
        while(parar == false)
        {
            HabitacionBase habitacion = HabitacionesBs.get(i);
            String id = habitacion.getId();
            boolean vista = habitacion.getVista();
            boolean cocina = habitacion.getCocina();
            boolean balcon = habitacion.getBalcon();
            String tipo = habitacion.getTipo();
            HabitacionReserva HabitacionRs = new HabitacionReserva(id, vista, cocina, balcon, tipo,servicios);
            HabitacionesRs.add(HabitacionRs);
            enrutadorPrincipal.modificarEstadoOcupado(id,fechainicial,fechafinal,true);
            capacidad += habitacion.getCapacidad();
            if(personasEsperadas <= capacidad)
            {
                parar = true;
            }
            if(i>HabitacionesBs.size())
            {
                parar = true;
            }
            i++;
        }
        Reserva datosReserva = new Reserva(documento, estadoReserva, personasEsperadas, fechainicial, fechafinal, HabitacionesRs);
        ArrayList<Huesped> grupo = datosReserva.getGrupo();
        grupo.add(huesped);

        double precio = enrutadorPrincipal.calcularPrecio(datosReserva);
        datosReservas.put(documento, datosReserva);
        return precio;
    }

    public String VerReserva(String documento)
    {
        Reserva reserva = datosReservas.get(documento);
        String id = "";
        String fechaini = reserva.getFechaIni();
        String fechafin = reserva.getFechaFin();
        String personasEs = Integer.toString(reserva.getPersonasEsperadas());
        ArrayList<HabitacionReserva> habationcesRes = reserva.getHabitacionesReservadas();
        int cantidadHab = habationcesRes.size();
        for(int i = 0;i<cantidadHab;i++)
        {
            HabitacionReserva habitacion = habationcesRes.get(i);
            String idh = habitacion.getId();
            id += idh + ";";
        }
        String texto = fechaini + "," + fechafin + "," + personasEs + "," + cantidadHab + "," + id;
        return texto;
    }

    public String eliminarReserva(String documento, String fechactual)
    {   
        String resultado = "La reserva no ha podido ser cancelada";
        Reserva reserva = datosReservas.get(documento);
        ArrayList<HabitacionReserva> habitaciones = reserva.getHabitacionesReservadas();
        String fechaini =  reserva.getFechaIni();
        String fechafin =  reserva.getFechaFin();
        LocalDate fechainires= LocalDate.parse(fechaini, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fechactualLC= LocalDate.parse(fechactual, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period diasEntreFechasP = Period.between(fechainires, fechactualLC);
        int diasEntreFechasf =  diasEntreFechasP.getDays();
        if(diasEntreFechasf>=2)
        {   
            reserva.setEstadoReserva("cancelado");

            for(int i = 0; i<=habitaciones.size();i++)
            
            {   
                HabitacionReserva habitacion = habitaciones.get(i);
                String id = habitacion.getId();
                enrutadorPrincipal.modificarEstadoOcupado(id,fechaini,fechafin,false);
            }
            datosReservas.remove(documento);
            resultado = "Su reserva fue correctamente cancelada";
        }
        return resultado;
    }

    public void AñadirServicio(String documento, ServicioBase Nombreservicio, String descripcion, String fecha, boolean pagado,double precio) 
    {
        double precioS = Nombreservicio.getPrecio();
        double precioT = precioS + precio;
        String registro = Nombreservicio.getRegistro();
        Servicio servicio = new Servicio(precioT, documento, fecha, pagado, descripcion, registro); 
        Reserva reserva = datosReservas.get(documento);
        ArrayList<HabitacionReserva> habitacionesRes = reserva.getHabitacionesReservadas();
        HabitacionReserva habitacionRegistroSer = habitacionesRes.get(1);
        ArrayList<Servicio> listaServicios = habitacionRegistroSer.getServicios();
        listaServicios.add(servicio);
    }

    public Reserva getReserva(String documento){
        return datosReservas.get(documento);
    }
}
