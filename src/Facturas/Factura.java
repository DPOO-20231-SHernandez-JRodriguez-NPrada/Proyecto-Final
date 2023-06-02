package Facturas;

public class Factura {

    private String documento;
    private String nombreCliente;
    private Double valor;
    private String codigo;

    public Factura(String documento, String nombreCliente, Double valor, String codigo) {
        this.documento = documento;
        this.nombreCliente = nombreCliente;
        this.valor = valor;
        this.codigo = codigo;
    }

    //Getters And Setters
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    

    
}