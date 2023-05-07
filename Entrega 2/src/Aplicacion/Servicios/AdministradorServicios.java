package Aplicacion.Servicios;

import java.util.ArrayList;

public class AdministradorServicios {

    public ArrayList<ServicioBase> datosServiciosBase;
    public ArrayList<Producto> menuProductos;

    public void AsignarServiciosBase(ArrayList<ServicioBase> datosServiciosBase) {
        this.datosServiciosBase = datosServiciosBase;
    }

    public void AsignarMenu(ArrayList<Producto> menuProductos) {
        this.menuProductos = menuProductos;
    }

    public ServicioBase darServicio(String nombre) {
        ServicioBase servicio = null;
        for (int i = 0; i < datosServiciosBase.size(); i++) {
            ServicioBase servicioB = datosServiciosBase.get(i);
            String nombreS = servicioB.getNombre();
            if (nombre.equals(nombreS)) {
                servicio = servicioB;
            }
        }
        return servicio;
    }

    public double precioProducto(String nombre,String cantidad) {
        double precio = 0;
        int cant = Integer.parseInt(cantidad);
        for(int i = 0;i<this.menuProductos.size();i++)
        {
            Producto producto = menuProductos.get(i);
            if(producto.getNombre().equals(nombre))
            {
                precio = producto.getPrecio();
                precio = precio*cant;
            }
        }
        return precio;
    }

}
