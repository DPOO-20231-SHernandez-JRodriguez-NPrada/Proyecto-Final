package Aplicacion.Servicios;

public class ServicioBase {
    public String nombre;
    public double precio;
    public String descripcion;
    public String registro;
    
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public ServicioBase(String nombre, double precio, String descripcion, String registro) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.registro = registro;
    }
}
