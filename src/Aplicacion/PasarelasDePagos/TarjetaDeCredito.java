package Aplicacion.PasarelasDePagos;

import java.util.Random;

public class TarjetaDeCredito {
    private String numeroTarjeta;
    private String nombreTitular;
    private String cvv;
    private Boolean reportada;
    private Double cupo;

    public TarjetaDeCredito(String numeroTarjeta, String nombreTitular, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.cvv = cvv;
        // random boolean para reportada
        this.reportada = new Random().nextBoolean();
        // random cupo entre 100000 y 10000000
        this.cupo = 100000 + (10000000 - 100000) * new Random().nextDouble();
    }

    public String getNumeroTarjeta() {
        return this.numeroTarjeta;
    }

    public String getNombreTitular() {
        return this.nombreTitular;
    }

    public String getCvv() {
        return this.cvv;
    }

    public Boolean isReportada() {
        return this.reportada;
    }

    public Double getCupo() {
        return this.cupo;
    }

    // Método para validar si la tarjeta es válida
    public Boolean validarTarjeta() {
        // Validar que el número de tarjeta tenga 16 dígitos
        if (this.numeroTarjeta.length() != 16) {
            return false;
        }
        // Validar que el nombre del titular no esté vacío
        if (this.nombreTitular.equals("")) {
            return false;
        }
        // Validar que el cvv tenga 3 dígitos
        if (this.cvv.length() != 3) {
            return false;
        }
        return true;
    }

    // Método para validar si la tarjeta tiene cupo suficiente
    public Boolean validarCupo(Double monto) {
        return this.cupo <= monto;
    }

    // Método para validar si la tarjeta está reportada
    public Boolean validarReportada() {
        return this.reportada;
    }

}
