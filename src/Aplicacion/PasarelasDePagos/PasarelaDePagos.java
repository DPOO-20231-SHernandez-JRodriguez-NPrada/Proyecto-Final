package Aplicacion.PasarelasDePagos;

public interface PasarelaDePagos {
    Boolean procesarPago(TarjetaDeCredito tarjetaDeCredito, Double monto);

    Boolean validarTarjeta(TarjetaDeCredito tarjetaDeCredito);

    Boolean validarCupo(TarjetaDeCredito tarjetaDeCredito, Double monto);

    Boolean validarReportada(TarjetaDeCredito tarjetaDeCredito);
}
