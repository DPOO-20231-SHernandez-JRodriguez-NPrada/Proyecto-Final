package BaseDatos;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import Aplicacion.Habitaciones.HabitacionReserva;
import Aplicacion.Huespedes.Huesped;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Servicio;
import Aplicacion.Tarifas.Tarifa;
import Facturas.Factura;

public class TraductorObject {

    public TraductorObject() {
    }

    public void GuardarReservasHuespedesServicios(HashMap<String, Reserva> mapaReservas) {

        try {
            Set<String> llavesMapa = mapaReservas.keySet();

            File archivoViejoReservas = new File("Entrega 3/Data/Reservas/Reservas.csv");
            boolean eliminadoReservas = Files.deleteIfExists(archivoViejoReservas.toPath());

            File folderViejoServiciosHuespedes = new File("Entrega 3/Data/Reservas/HuespedesServicios");

            for (final File sHuespedFile : folderViejoServiciosHuespedes.listFiles()) {
                Files.deleteIfExists(sHuespedFile.toPath());
            }

            File folderViejoServiciosHabitaciones = new File("Entrega 3/Data/Reservas/HabitacionesReservaServicios");

            for (final File sHabitacionFile : folderViejoServiciosHabitaciones.listFiles()) {
                Files.deleteIfExists(sHabitacionFile.toPath());
            }

                if(eliminadoReservas){
                    File archivoReservas =  new File("Entrega 3/Data/Reservas/Reservas.csv");
                    archivoReservas.createNewFile();
                    FileWriter myWriterReservas = new FileWriter(archivoReservas);

                    myWriterReservas.write("documento,estadoReserva,PersonasEsperadas,fechaLlegada,fechaSalida\n");
                    myWriterReservas.write("************************************************\n");
                    myWriterReservas.write("nombre,documento,correo,numeroCelular\n");
                    myWriterReservas.write("************************************************\n");

                    for (String llave : llavesMapa) {
                        Reserva reserva = mapaReservas.get(llave);
                        ArrayList<Huesped> grupo = reserva.getGrupo();
                        ArrayList<HabitacionReserva> habitaciones = reserva.getHabitacionesReservadas();

                        myWriterReservas.write(reserva.getDocumento() + "," + reserva.getEstadoReserva() + "," + reserva.getPersonasEsperadas() + "," + reserva.getFechaIni() + "," + reserva.getFechaFin()+"\n");
                        myWriterReservas.write("************************************************\n");
                        for (Huesped huesped : grupo) {
                            myWriterReservas.write(huesped.getNombre() + "," + huesped.getDocumento() + "," + huesped.getCorreo() + "," + huesped.getCelular()+"\n");

                            
                            String nombreHuesped = huesped.getNombre();
                            String documentoHuesped = huesped.getDocumento();
                            String correoHuesped = huesped.getCorreo();
                            /*Se cambio de string a int */
                            String numeroCelularHuesped = huesped.getCelular();

                            File archivoServiciosHuesped =  new File("Entrega 3/Data/Reservas/HuespedesServicios"+documentoHuesped+"_"+nombreHuesped+".csv");
                            archivoServiciosHuesped.createNewFile();

                            FileWriter myWriterServiciosHuesped = new FileWriter(archivoServiciosHuesped);
                            myWriterServiciosHuesped.write("nombre,documento,correo,numeroCelular\n");
                            myWriterServiciosHuesped.write(nombreHuesped+","+documentoHuesped+","+correoHuesped+","+numeroCelularHuesped +"\n");
                            myWriterServiciosHuesped.write("nombre,precio,descripcion,registro,fecha,pagado\n");

                            ArrayList<Servicio> servicios = huesped.getServicios();

                            for (Servicio servicio : servicios) {
                                myWriterServiciosHuesped.write(servicio.getNombre()+","+servicio.getPrecio()+","+servicio.getDescripcion()+","+servicio.getRegistro()+","+servicio.getFecha()+","+servicio.isPagado() + "\n");
                            }

                            myWriterServiciosHuesped.close();

                        }
                        myWriterReservas.write("************************************************\n");

                        for (HabitacionReserva habitacion : habitaciones) {
                            String idHabitacion = habitacion.getId();
                            String tipoHabitacion = habitacion.getTipo();
                            boolean balconHabitacion = habitacion.getBalcon();
                            boolean vistaHabitacion = habitacion.getVista();
                            boolean cocinaHabitacion = habitacion.getCocina();

                            String idHabitacionCortada = idHabitacion.replace(".", "");

                            File archivoServiciosHabitacion =  new File("Entrega 3/Data/Reservas/HabitacionesReservaServicios"+idHabitacionCortada+"_"+reserva.getDocumento()+".csv");
                            archivoServiciosHabitacion.createNewFile();

                            FileWriter myWriterServiciosHabitacion = new FileWriter(archivoServiciosHabitacion);
                            myWriterServiciosHabitacion.write("documento,id,tipo,balcon,vista,cocina\n");
                            myWriterServiciosHabitacion.write(reserva.getDocumento()+","+idHabitacion+","+tipoHabitacion+","+balconHabitacion+","+vistaHabitacion+","+cocinaHabitacion+"\n");
                            myWriterServiciosHabitacion.write("nombre,precio,descripcion,registro,fecha,pagado\n");


                            ArrayList<Servicio> servicios = habitacion.getServicios();

                            for (Servicio servicio : servicios) {
                                myWriterServiciosHabitacion.write(servicio.getNombre()+","+servicio.getPrecio()+","+servicio.getDescripcion()+","+servicio.getRegistro()+","+servicio.getFecha()+","+servicio.isPagado()+"\n");
                            }

                            myWriterServiciosHabitacion.close();
                            
                        }

                        myWriterReservas.close();
                        
                }
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void GuardarTarifas(ArrayList<Tarifa> listaTarifas) {
        try {
            File folderViejoTarifas = new File("Entrega 3/Data/Tarifas");

            for (final File tarifaFile : folderViejoTarifas.listFiles()) {
                Files.deleteIfExists(tarifaFile.toPath());
            }

            for (Tarifa tarifa : listaTarifas) {
                int anio = tarifa.getAnio();
                Double[] preciosEstandar = tarifa.getEstandar();
                Double[] preciosSuite = tarifa.getSuite();
                Double[] preciosDoble = tarifa.getDoble();

                String estandarString = "";
                String suiteString = "";
                String dobleString = "";

                File archivoTarifa =  new File("Entrega 3/Data/Tarifas/Tarifa"+"_"+anio+".csv");
                archivoTarifa.createNewFile();

                FileWriter myWriterTarifa = new FileWriter(archivoTarifa);

                myWriterTarifa.write("anio,estandar,suite,doble\n");
                myWriterTarifa.write(anio+"\n");

                for (int i = 0; i < preciosEstandar.length; i++) {
                    estandarString = estandarString + preciosEstandar[i] + ",";
                    suiteString = suiteString + preciosSuite[i] + ",";
                    dobleString = dobleString + preciosDoble[i] + ",";
                }
                
                myWriterTarifa.write(estandarString+"\n");
                myWriterTarifa.write(suiteString+"\n");
                myWriterTarifa.write(dobleString+"\n");
                
                myWriterTarifa.close();
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GuardarFacturas(HashMap<String, ArrayList<Factura>> mapaFacturas){

    }

}
