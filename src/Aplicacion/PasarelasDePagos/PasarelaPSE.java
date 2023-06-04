package Aplicacion.PasarelasDePagos;

public class PasarelaPSE implements PasarelaDePagos {

    private String nombrePasarela;

    PasarelaPSE() {
        this.nombrePasarela = "PSE";
    }

    public String getNombrePasarela() {
        return nombrePasarela;
    }

    @Override
    public Boolean procesarPago(TarjetaDeCredito tarjetaDeCredito, Double monto) {
        // Si la tarjeta es válida, tiene cupo suficiente y no está reportada, se
        // procesa el pago

        if (validarTarjeta(tarjetaDeCredito) && validarCupo(tarjetaDeCredito, monto)
                && !validarReportada(tarjetaDeCredito)) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public Boolean validarTarjeta(TarjetaDeCredito tarjetaDeCredito) {
        return tarjetaDeCredito.validarTarjeta();
    }

    @Override
    public Boolean validarCupo(TarjetaDeCredito tarjetaDeCredito, Double monto) {
        return tarjetaDeCredito.validarCupo(monto);
    }

    @Override
    public Boolean validarReportada(TarjetaDeCredito tarjetaDeCredito) {
        return !tarjetaDeCredito.isReportada();
    }

}
