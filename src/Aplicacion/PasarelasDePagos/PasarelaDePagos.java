package Aplicacion.PasarelasDePagos;

import java.sql.Date;

public interface PasarelaDePagos {
    Boolean procesarPago(TarjetaDeCredito tarjetaDeCredito, Double monto);

    Boolean validarTarjeta(TarjetaDeCredito tarjetaDeCredito);

    Boolean validarCupo(TarjetaDeCredito tarjetaDeCredito, Double monto);

    Boolean validarReportada(TarjetaDeCredito tarjetaDeCredito);

    void registrarTransaccion(TarjetaDeCredito tarjetaDeCredito, Double monto, Boolean transaccionCompletada);

}
