package Aplicacion.PasarelasDePagos;

import java.lang.reflect.InvocationTargetException;

public class AdministradorPagos {

    private PasarelaDePagos pasarelaDePagos;

    public AdministradorPagos(String nombreClasePasarela)
            throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException,
            ClassNotFoundException {
        Class clasePasarela = Class.forName(nombreClasePasarela);
        this.pasarelaDePagos = (PasarelaDePagos) clasePasarela.getDeclaredConstructor(null).newInstance(null);
    }

    public Boolean procesarPago(TarjetaDeCredito tarjetaDeCredito, Double monto) {
        return this.pasarelaDePagos.procesarPago(tarjetaDeCredito, monto);
    }

}
