package Aplicacion.Habitaciones;

import java.util.ArrayList;

import Aplicacion.Servicios.Servicio;

public class HabitacionReserva {
    String id;
    boolean vista;
    boolean cocina;
    boolean balcon;
    String tipo;
    ArrayList<Servicio> servicios;
  

    public ArrayList<Servicio> getServicios() {
      return servicios;
    }


    public void setServicios(ArrayList<Servicio> servicios) {
      this.servicios = servicios;
    }


    public String getId() {
      return id;
    }


    public void setId(String id) {
      this.id = id;
    }


    public boolean getVista() {
      return vista;
    }


    public void setVista(boolean vista) {
      this.vista = vista;
    }


    public boolean getCocina() {
      return cocina;
    }


    public void setCocina(boolean cocina) {
      this.cocina = cocina;
    }


    public boolean getBalcon() {
      return balcon;
    }


    public void setBalcon(boolean balcon) {
      this.balcon = balcon;
    }


    public String getTipo() {
      return tipo;
    }


    public void setTipo(String tipo) {
      this.tipo = tipo;
    }


    public HabitacionReserva(String id, boolean vista, boolean cocina, boolean balcon, String tipo, ArrayList<Servicio> servicios) 
    {
		this.id = id;
		this.vista = vista;
		this.cocina = cocina;
		this.balcon = balcon;
		this.tipo = tipo;
    this.servicios = servicios;
    }
}
