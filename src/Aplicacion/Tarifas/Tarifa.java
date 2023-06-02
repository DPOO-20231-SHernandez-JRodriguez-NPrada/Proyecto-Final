package Aplicacion.Tarifas;


public class Tarifa {
    
    private Double[] preciosEstandar;
    private Double[] preciosSuite;
    private Double[] preciosDoble;
    private int anio;

    public Tarifa(int anio, Double[] estandar,Double[] suite, Double[] doble){

        this.anio = anio;
        this.preciosEstandar = estandar;
        this.preciosSuite = suite;
        this.preciosSuite = doble;  
    }

    public int getAnio()
	{
		return this.anio;
	}
    
    public Double[] getEstandar()
	{
		return this.preciosEstandar;
	}
    public Double[] getSuite()
	{
		return this.preciosSuite;
	}
    public Double[] getDoble()
	{
		return this.preciosDoble;
	}
    public void setEstandar(Double[] estandar){
        this.preciosEstandar=estandar;
    }
    public void setSuite(Double[] estandar){
        this.preciosSuite=estandar;
    }
    public void setDoble(Double[] estandar){
        this.preciosDoble=estandar;
    }
}
