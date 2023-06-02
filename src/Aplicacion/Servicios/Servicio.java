package Aplicacion.Servicios;



public class Servicio {
    double precio;
    String nombre;
    String fecha;
    boolean pagado;
    String descripcion;
    String registro;
    public Servicio(double precio, String nombre, String fecha, boolean pagado, String descripcion, String registro) {
        this.precio = precio;
        this.nombre = nombre;
        this.fecha = fecha;
        this.pagado = pagado;
        this.descripcion = descripcion;
        this.registro = registro;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public boolean isPagado() {
        return pagado;
    }
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
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
}
