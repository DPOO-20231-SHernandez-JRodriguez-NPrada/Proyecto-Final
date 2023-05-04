package Aplicacion.Huespedes;

import java.util.ArrayList;

import Aplicacion.Servicios.Servicio;

public class Huesped {
    private String nombre;
    private String documento;
    private String correo;
    private String celular;
    private ArrayList<Servicio> servicios;
     //si es false, su lista de acompanantes deberia ser vacia, pero que este vacia no significa que sea un acompañante, puede estar solo

    public Huesped(String nombre, String doc, String correo, String celular,ArrayList<Servicio> servicios){
        this.nombre=nombre;
        documento=doc;
        this.correo=correo;
        this.celular=celular;
        this.servicios = servicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }   
}
