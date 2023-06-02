package Aplicacion.Servicios;

public class Producto {

    public String nombre;
    public double precio;
    public String horaIni; 
    public String horaFin; 
    public boolean validoHabitacion;


    
    public Producto(String nombre, double precio, String horaIni, String horaFin, boolean validoHabitacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
        this.validoHabitacion = validoHabitacion;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getHoraIni() {
        return horaIni;
    }
    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }
    public String getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    public boolean isValidoHabitacion() {
        return validoHabitacion;
    }
    public void setValidoHabitacion(boolean validoHabitacion) {
        this.validoHabitacion = validoHabitacion;
    } 

}
