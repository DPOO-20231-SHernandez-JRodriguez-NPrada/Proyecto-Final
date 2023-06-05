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
    private int metros;
    private Boolean aireAcondicionado;
    private Boolean calefaccion;
    private int tamanioCama;
    private Boolean tv;
    private Boolean cafetera;
    private Boolean ropaDeCama;
    private Boolean plancha;
    private Boolean secador;
    private Boolean voltaje;
    private Boolean usb;
    private Boolean usbc;
    private Boolean desayuno;



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

    public HabitacionBase(String ubicacion, int capacidad, int capacidadMax, String id, String tipo,
                            Boolean[] diasOcupado, Boolean cocina, Boolean balcon, Boolean vista, ArrayList<Integer> camas, int anio, 
                            int metros, Boolean aireAcondicionado, Boolean calefaccion, int tamanioCama, Boolean tv, Boolean cafetera, boolean ropaDeCama, boolean plancha, boolean secador, boolean voltaje, boolean usb, boolean usbc, boolean desayuno) {
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.capacidadMax = capacidadMax;
        this.id = id;
        this.tipo = tipo;
        this.diasOcupado = diasOcupado;
        this.cocina = cocina;
        this.balcon = balcon;
        this.vista = vista;
        this.camas = camas;
        this.anio = anio;
        this.metros = metros;
        this.aireAcondicionado = aireAcondicionado;
        this.calefaccion = calefaccion;
        this.tamanioCama = tamanioCama;
        this.tv = tv;
        this.cafetera = cafetera;
        this.ropaDeCama = ropaDeCama;
        this.plancha = plancha;
        this.secador = secador;
        this.voltaje = voltaje;
        this.usb = usb;
        this.usbc = usbc;
        this.desayuno = desayuno;

    }

    // Getters And Setters
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

    public Boolean[] getOcupado() {
        return this.diasOcupado;
    }

    public void setOcupado(Boolean[] dias) {
        this.diasOcupado = dias;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(Boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    public int getTamanioCama() {
        return tamanioCama;
    }

    public void setTamanioCama(int tamanioCama) {
        this.tamanioCama = tamanioCama;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getCafetera() {
        return cafetera;
    }

    public void setCafetera(Boolean cafetera) {
        this.cafetera = cafetera;
    }

    public Boolean getRopaDeCama() {
        return ropaDeCama;
    }

    public void setRopaDeCama(Boolean ropaDeCama) {
        this.ropaDeCama = ropaDeCama;
    }

    public Boolean getPlancha() {
        return plancha;
    }

    public void setPlancha(Boolean plancha) {
        this.plancha = plancha;
    }

    public Boolean getSecador() {
        return secador;
    }

    public void setSecador(Boolean secador) {
        this.secador = secador;
    }

    public Boolean getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(Boolean voltaje) {
        this.voltaje = voltaje;
    }

    public Boolean getUsb() {
        return usb;
    }

    public void setUsb(Boolean usb) {
        this.usb = usb;
    }

    public Boolean getUsbc() {
        return usbc;
    }

    public void setUsbc(Boolean usbc) {
        this.usbc = usbc;
    }

    public Boolean getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(Boolean desayuno) {
        this.desayuno = desayuno;
    }

    

}
