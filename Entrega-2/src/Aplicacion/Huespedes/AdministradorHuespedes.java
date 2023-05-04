package Aplicacion.Huespedes;


import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;

import Aplicacion.Servicios.Servicio;
import Aplicacion.Servicios.ServicioBase;

public class AdministradorHuespedes {
    private HashMap<String, Huesped> hashHuesped;

    public void AsignarHuespedes(HashMap<String, Huesped> datosHuespedes)
    {
        this.hashHuesped = datosHuespedes;
    }

    public Huesped crearHuesped(String nombre, String doc, String correo, String celular)
    { // se crea el huesped principal
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
        Huesped huesped = new Huesped(nombre, doc, correo, celular,servicios);
        try{
        this.hashHuesped.put(doc, huesped);}
        catch (NullPointerException | ClassCastException | ConcurrentModificationException ex) {
            System.out.println("Se produjo un error con el hashmap: " + ex.getMessage());
        }
        return huesped;
    }
    

    public void eliminarHuesped(String doc){
        try{
        this.hashHuesped.remove(doc);}
        catch (NullPointerException | ClassCastException | ConcurrentModificationException ex) {
            System.out.println("Se produjo un error con el hashmap: " + ex.getMessage());
        }
    }
    public void AñadirServicio(String documento, ServicioBase Nombreservicio, String descripcion, String fecha, boolean pagado, double precio)
    {
        double precioS = Nombreservicio.getPrecio();
        double precioT = precioS + precio;
        String registro = Nombreservicio.getRegistro();
        Servicio servicio = new Servicio(precioT, documento, fecha, pagado, descripcion, registro);
        Huesped huesped = this.hashHuesped.get(documento);
        ArrayList<Servicio> listaServicios = huesped.getServicios();
        listaServicios.add(servicio);
    }
}
