package Facturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Aplicacion.Habitaciones.HabitacionReserva;
import Aplicacion.Huespedes.Huesped;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Servicio;

public class AdministradorFacturas {

    private HashMap<String, ArrayList<Factura>> datosFacturas;

    public void AsignarFacturas(HashMap<String, ArrayList<Factura>> datosFacturas) {
        this.datosFacturas = datosFacturas;
    }

    public void CrearFacturaCliente(Huesped huesped){
        ArrayList<Servicio> servicios = huesped.getServicios();
        ArrayList<Servicio> serviciosBorrar= new ArrayList<Servicio>();
        Random rnd = new Random();

        for (Servicio servicio : servicios) {
            if(servicio.isPagado()){
                String codigo = "";
                for (int i = 0; i < 5; i++) {
                    codigo += rnd.nextInt(9);
                }
                
                Factura factura = new Factura(huesped.getDocumento(), huesped.getNombre(), servicio.getPrecio(), codigo);
                if(datosFacturas.containsKey(huesped.getNombre()))
                {
                    this.datosFacturas.get(huesped.getNombre()).add(factura);
                }
                else
                {
                    ArrayList<Factura> facturasHuesped = new ArrayList<Factura>();
                    facturasHuesped.add(factura);
                    this.datosFacturas.put(huesped.getNombre(), facturasHuesped);
                }
                serviciosBorrar.add(servicio);
            }
        }
        for(Servicio servicio : serviciosBorrar)
        {
            servicios.remove(servicio);
        }
    }

    public void CrearFacturaLiderGrupo(Reserva reserva){
        Huesped huespedPrincipal = reserva.getGrupo().get(0);
        ArrayList<HabitacionReserva> habitaciones = reserva.getHabitacionesReservadas();

        Random rnd = new Random();

        for (HabitacionReserva habitacionReserva : habitaciones) {
            ArrayList<Servicio> serviciosHabitacion = habitacionReserva.getServicios();

            for (Servicio servicio : serviciosHabitacion) {
                if(servicio.isPagado()){
                    String codigo = "";
                    for (int i = 0; i < 5; i++) {
                        codigo += rnd.nextInt(9);
                    }
                    
                    Factura factura = new Factura(huespedPrincipal.getDocumento(), huespedPrincipal.getNombre(), servicio.getPrecio(), codigo);
                    datosFacturas.get(huespedPrincipal.getNombre()).add(factura);

                    serviciosHabitacion.remove(servicio);
                }
            }
        }
    }
}