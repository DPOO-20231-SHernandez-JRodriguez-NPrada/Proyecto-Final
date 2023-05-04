package Aplicacion.Habitaciones;

import java.util.ArrayList;

public class HabitacionBase {
    private String ubicacion;
    private int capacidad;
    private int capacidadMax;
    private String id;
    private String tipo;
    private Boolean[] diasOcupado;
    private Boolean cocina;
    private Boolean balcon;
    private Boolean vista;
    public ArrayList<Integer> getCamas() {
        return camas;
    }

    public void setCamas(ArrayList<Integer> camas) {
        this.camas = camas;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    private ArrayList<Integer> camas;
    private int anio;
    
    public HabitacionBase(String ubicacion, int capacidad, int capacidadMax, String id, String tipo, Boolean[] diasOcupado, Boolean cocina, Boolean balcon, Boolean vista, ArrayList<Integer> camas, int anio){
        this.ubicacion=ubicacion;
        this.capacidad=capacidad;
        this.capacidadMax=capacidadMax;
        this.id=id;
        this.tipo=tipo;
        this.diasOcupado=diasOcupado;
        this.cocina=cocina;
        this.balcon=balcon;
        this.vista=vista;
        this.camas=camas;
        this.anio=anio;
    }

    //Getters And Setters
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean[] getDiasOcupado() {
        return diasOcupado;
    }

    public void setDiasOcupado(Boolean[] diasOcupado) {
        this.diasOcupado = diasOcupado;
    }

    public Boolean getCocina() {
        return cocina;
    }

    public void setCocina(Boolean cocina) {
        this.cocina = cocina;
    }

    public Boolean getBalcon() {
        return balcon;
    }

    public void setBalcon(Boolean balcon) {
        this.balcon = balcon;
    }

    public Boolean getVista() {
        return vista;
    }

    public void setVista(Boolean vista) {
        this.vista = vista;
    }

    public Boolean[] getOcupado(){
        return this.diasOcupado;
    }
    public void setOcupado( Boolean[] dias){
        this.diasOcupado=dias;
    }

}
