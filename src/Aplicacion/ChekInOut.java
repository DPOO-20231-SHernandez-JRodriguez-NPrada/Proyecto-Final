package Aplicacion;

import java.util.ArrayList;
import java.util.HashMap;

import Aplicacion.Huespedes.Huesped;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Servicio;

public class ChekInOut {

    double pago = 0;

    public ChekInOut() {
    }

    public void CheckIn(Reserva reserva, Huesped huesped) {
        ArrayList<Huesped> grupo = reserva.getGrupo();
        reserva.setEstadoReserva("checked");
        grupo.add(huesped);
    }

    public HashMap<String, ArrayList<Servicio>> CheckOut(Reserva reserva, boolean confirmarPago) {
        HashMap<String, ArrayList<Servicio>> serviciosPorPagar = new HashMap<String, ArrayList<Servicio>>();

        if (!confirmarPago) {
            ArrayList<Huesped> grupo = reserva.getGrupo();
            for (Huesped huesped : grupo) {
                ArrayList<Servicio> servicios = new ArrayList<Servicio>();
                ArrayList<Servicio> huespedServicios = huesped.getServicios();
                for (Servicio servicioPosible : huespedServicios) {
                    if (!servicioPosible.isPagado()) {
                        servicios.add(servicioPosible);
                    }
                }
                serviciosPorPagar.put(huesped.getNombre(), servicios);
            }
        }
        return serviciosPorPagar;
    }

    public boolean hacerPago(Reserva reserva) {
        ArrayList<Huesped> grupo = reserva.getGrupo();
        for (Huesped huesped : grupo) {
            ArrayList<Servicio> huespedServicios = huesped.getServicios();
            for (Servicio servicioPosible : huespedServicios) {
                if (!servicioPosible.isPagado()) {
                    servicioPosible.setPagado(true);
                }
            }
        }
        return true;
    }

}
