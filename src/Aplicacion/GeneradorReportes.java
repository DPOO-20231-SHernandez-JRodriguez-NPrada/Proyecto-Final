package Aplicacion;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import Aplicacion.Servicios.Producto;

public class GeneradorReportes {

    private ArrayList<Producto> menu;
    private ArrayList<String> fechas_reservas;
    private int[] contador;
    private Double[] precios;

    public GeneradorReportes (){
        
    }

    public void generarReportes(){
        reportesRestaurante();
        reportesFechas();
        reportesTarifas();

    }

    private void reportesTarifas() {
        int tamanio = precios.length, i=0;
        LocalDate fecha = LocalDate.parse("01/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")); // se toma como base el primero de enero para ir sumando dias
        Double[] suma = new Double[7]; // llevara la suma de los precios
        Double[] contador = new Double[7]; // cuantos veces se repite el dia
        for (int j = 0; j < contador.length; j++) {
            contador[j] = 0.0;
            suma[j] = 0.0;
        }
        while(i<tamanio){
            Double precio = precios[i];
            LocalDate dia = fecha.plusDays(i);
            String dia_ = dia.getDayOfWeek().name().toLowerCase(); // el dia como string todo en minuscula
            int dia_i = castDia(dia_);
            suma[dia_i] += precio;
            contador[dia_i] ++;

            i++;
        } // ciclo que recorre todos los precios

        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        datos.setValue(suma[0]/contador[0],"PP","Lunes"); // se saca el promedio y se pone el los datos junto al dia de la semana
        datos.setValue(suma[1]/contador[1],"PP","Martes");
        datos.setValue(suma[2]/contador[2],"PP","Miercoles");
        datos.setValue(suma[3]/contador[3],"PP","Jueves");
        datos.setValue(suma[4]/contador[4],"PP","Viernes");
        datos.setValue(suma[5]/contador[5],"PP","Sabado");
        datos.setValue(suma[6]/contador[6],"PP","Domingo");

        JFreeChart barras = ChartFactory.createBarChart3D(
            "Promedio de precio (PP) en habitacion estandar por dias","Dias","Precio Promedio",
            datos,PlotOrientation.VERTICAL,
            true, true, false);
        
            try {
                // guarda el grafico como png en la carpeta de reportes
                File archivo1 = new File("Reportes/grafica promedio precios por dia.png");
                ChartUtilities.saveChartAsPNG(archivo1, barras, 1000, 1000);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public void reportesFechas(){
        this.contador = new int[12];
        for (String fecha: fechas_reservas){
            String[] separado = fecha.split("/");
            String mes = separado[1];
            conteoMes(mes);
        } // contador tiene una lista con la cantidad de reservas que hay en los meses
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        
        datos.setValue(contador[0],"Reservas","Enero");
        datos.setValue(contador[1],"Reservas","Febrero");
        datos.setValue(contador[2],"Reservas","Marzo");
        datos.setValue(contador[3],"Reservas","Abril");
        datos.setValue(contador[4],"Reservas","Mayo");
        datos.setValue(contador[5],"Reservas","Junio");
        datos.setValue(contador[6],"Reservas","Julio");
        datos.setValue(contador[7],"Reservas","Agosto");
        datos.setValue(contador[8],"Reservas","Septiembre");
        datos.setValue(contador[9],"Reservas","Octubre");
        datos.setValue(contador[10],"Reservas","Noviembre");
        datos.setValue(contador[11],"Reservas","Diciembre");
        
        JFreeChart barras = ChartFactory.createBarChart3D(
            "Distribucion de reservas en meses","Meses","N. Reservas",
            datos,PlotOrientation.VERTICAL,
            true, true, false); //grafico de barras sobre reservas en cada mes

        try {
            // guarda el grafico como png en la carpeta de reportes
            File archivo1 = new File("Reportes/grafica distribucion reservas.png");
            ChartUtilities.saveChartAsPNG(archivo1, barras, 1000, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void reportesRestaurante(){
        DefaultCategoryDataset datos_unidades = new DefaultCategoryDataset();
        DefaultCategoryDataset datos_dinero = new DefaultCategoryDataset();
        DefaultPieDataset datos_torta = new DefaultPieDataset();

        for (Producto producto : menu){
            // Numero de unidades vendidas , categoria, nombre
            datos_unidades.setValue(producto.getVentas(),"Unidades",producto.getNombre());
            // Valor vendido, categoria, nombre
            datos_dinero.setValue(producto.getVentas()*producto.getPrecio(),"Ventas en bruto",producto.getNombre());
            // nombre, valor
            datos_torta.setValue(producto.getNombre(),producto.getVentas()*producto.getPrecio());
        }

        JFreeChart barras_u = ChartFactory.createBarChart3D(
            "Gráfico sobre ventas de productos del restaurante","Productos","Unidades",
            datos_unidades,PlotOrientation.VERTICAL,
            true, true, false); //grafico de barras sobre las uniandes vendidas de cada producto
        
        JFreeChart barras_v = ChartFactory.createBarChart3D(
            "Gráfico sobre ventas en bruto","Productos","Ventas",
            datos_dinero,PlotOrientation.VERTICAL,
            true, true, false); //grafico de barras sobre el dinero en bruto que ha generado cada producto
        
        JFreeChart torta = ChartFactory.createPieChart("Pastel sobre lo vendido por cada producto",
        datos_torta,true,true,false); // grafico de torta ver cual es el producto que genera mas ganancia

	    try {
            // guarda los graficos como png en la carpeta de reportes
            File archivo1 = new File("Reportes/grafica venta unidades restaurante.png");
            ChartUtilities.saveChartAsPNG(archivo1, barras_u, 1000, 1000);

            File archivo2 = new File("Reportes/grafica venta en bruto restaurante.png");
            ChartUtilities.saveChartAsPNG(archivo2, barras_v, 1000, 1000);
            
            File archivo3 = new File("Reportes/torta ventas restaurante.png");
            ChartUtilities.saveChartAsPNG(archivo3, torta, 1000, 1000);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setMenu(ArrayList<Producto> menu){
        this.menu = menu;
    }
    public void setFechas(ArrayList<String> fechas){
        this.fechas_reservas = fechas;
    }
    public void setPrecios(Double[] precios){
        this.precios = precios;
    }

    private void conteoMes(String mes) {

        if (mes.equals("02")){
            contador[1]+=1;
        } else if (mes.equals("03")){
            contador[2]+=1;
        } else if (mes.equals("04")){
            contador[3]+=1;
        } else if (mes.equals("05")){
            contador[4]+=1;
        } else if (mes.equals("06")){
            contador[5]+=1;
        } else if (mes.equals("07")){
            contador[6]+=1;
        } else if (mes.equals("08")){
            contador[7]+=1;
        } else if (mes.equals("09")){
            contador[8]+=1;
        } else if (mes.equals("10")){
            contador[9]+=1;
        } else if (mes.equals("11")){
            contador[10]+=1;
        } else if (mes.equals("12")){
            contador[11]+=1;
        } else{
            contador[0]+=1;
        }

    }

    private int castDia(String dia) {
        int retorno = 0;

        if (dia.equals("tuesday")){
            retorno = 1;
        } else if (dia.equals("wednesday")){
            retorno = 2;
        } else if (dia.equals("thursday")){
            retorno = 3;
        } else if (dia.equals("friday")){
            retorno = 4;
        } else if (dia.equals("saturday")){
            retorno = 5;
        } else if (dia.equals("sunday")){
            retorno = 6;
        }

        return retorno;
    }

    
}
