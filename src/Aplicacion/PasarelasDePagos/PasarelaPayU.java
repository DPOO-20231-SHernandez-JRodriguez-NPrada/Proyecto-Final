package Aplicacion.PasarelasDePagos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class PasarelaPayU implements PasarelaDePagos {

    private String nombrePasarela;
    private BufferedWriter bw = null;

    PasarelaPayU() {
        this.nombrePasarela = "PayU";
    }

    public String getNombrePasarela() {
        return nombrePasarela;
    }

    @Override
    public Boolean procesarPago(TarjetaDeCredito tarjetaDeCredito, Double monto) {
        // Si la tarjeta es válida, tiene cupo suficiente y no está reportada, se
        // procesa el pago

        boolean valida = validarTarjeta(tarjetaDeCredito);
        boolean tieneCupo = validarCupo(tarjetaDeCredito, monto);
        boolean noReportada = !validarReportada(tarjetaDeCredito);

        return valida && tieneCupo && noReportada;
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

    @Override
    public void registrarTransaccion(TarjetaDeCredito tarjetaDeCredito, Double monto, Boolean transaccionCompletada) {
        // Registrar la transacción en un archivo txt
        // Se registra la fecha, el monto y el número de la tarjeta

        try {
            bw = new BufferedWriter(new FileWriter("Data/Pagos/LogPayU.csv", true));
            String estado = transaccionCompletada ? "completada" : "fallida";
            bw.write(new Date(System.currentTimeMillis()) + "," + estado + ","
                    + tarjetaDeCredito.getNumeroTarjeta() + "," + monto + "COP");
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally

        {
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException ioe2) {

                }
        }
    }
}
