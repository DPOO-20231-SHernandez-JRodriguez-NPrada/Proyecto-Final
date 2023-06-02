package BaseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Aplicacion.Habitaciones.HabitacionBase;
import Aplicacion.Habitaciones.HabitacionReserva;
import Aplicacion.Huespedes.Huesped;
import Aplicacion.Reservas.Reserva;
import Aplicacion.Servicios.Producto;
import Aplicacion.Servicios.Servicio;
import Aplicacion.Servicios.ServicioBase;
import Aplicacion.Tarifas.Tarifa;
import Facturas.Factura;

public class TraductorFile {

    private HashMap<String, Huesped> MapaHuespedes;
    private HashMap<String, Reserva> MapaReservas;

    public TraductorFile() {
    }

    public HashMap<String, String> TraducirDatosLoginFile(File datosLoginFile) {
        Scanner scannerLectura;
        HashMap<String, String> datosLogin = new HashMap<String, String>();
        try {
            scannerLectura = new Scanner(datosLoginFile);
            scannerLectura.nextLine();
            while(scannerLectura.hasNextLine()){
                String[] datos = scannerLectura.nextLine().split(",");
                String nombre = datos[0];
                String contraseniaTipoUsuario = datos[1];
                datosLogin.put(nombre, contraseniaTipoUsuario);
            }

            scannerLectura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

        return datosLogin;
    }

    public ArrayList<ServicioBase> TraducirServiciosBaseFile(File archivoServiciosBase) {
        Scanner scannerLectura;
        ArrayList<ServicioBase> serviciosBase = new ArrayList<ServicioBase>();
        try {
            scannerLectura = new Scanner(archivoServiciosBase);
            scannerLectura.nextLine();
            while(scannerLectura.hasNextLine()){
                String[] datos = scannerLectura.nextLine().split(",");
                String nombre = datos[0];
                Double precio = Double.parseDouble(datos[1]);
                String descripcion = datos[2];
                String registro = datos[3];

                ServicioBase servicio = new ServicioBase(nombre, precio, descripcion, registro);

                serviciosBase.add(servicio);
            }

            scannerLectura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return serviciosBase;
    }

    public HashMap<String, HabitacionBase> TraducirHabitacionesBaseFile(File habitacionesBaseFile, File ocupacionHabitacionesFile) {
        Scanner scannerLectura;
        
        HashMap<String, Boolean[]> ocupacionHabitaciones = new HashMap<String, Boolean[]>();
        HashMap<String, HabitacionBase> habitacionesBase = new HashMap<String, HabitacionBase>();
        
        try {
            scannerLectura = new Scanner(ocupacionHabitacionesFile);
            scannerLectura.nextLine();
            while(scannerLectura.hasNext()){
                String[] datos = scannerLectura.nextLine().split(",");
                String id = datos[0];
                String anio = datos[1];
                String ocupacionString = datos[2];
                Boolean[] ocupacion = new Boolean[365];
                for (int i = 0; i < ocupacionString.length(); i++) {
                    ocupacion[i] = "1".equals(Character.toString(ocupacionString.charAt(i)));
                }
                ocupacionHabitaciones.put(id+anio, ocupacion);
            }
            scannerLectura.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            scannerLectura = new Scanner(habitacionesBaseFile);
            scannerLectura.nextLine();
            while(scannerLectura.hasNextLine()){
                String[] datos = scannerLectura.nextLine().split(",");
                String ubicacion = datos[0];
                int capacidad = Integer.parseInt(datos[1]);
                int capacidadMax = Integer.parseInt(datos[2]);
                String id = datos[3];
                String tipo = datos[4];
                boolean balcon = Boolean.parseBoolean(datos[5]);
                boolean vista = Boolean.parseBoolean(datos[6]);
                boolean cocina = Boolean.parseBoolean(datos[7]);
                String capacidadCamasString = datos[8]; 
                int anio = Integer.parseInt(datos[9]);
                Boolean[] diasOcupado = ocupacionHabitaciones.get(id+anio);
                
                ArrayList<Integer> camas = new ArrayList<Integer>();

                for (int i = 0; i < capacidadCamasString.length(); i++) {
                    camas.add(Integer.parseInt(Character.toString(capacidadCamasString.charAt(i))));
                }

                HabitacionBase habitacion = new HabitacionBase(ubicacion, capacidad, capacidadMax, id, tipo, diasOcupado, balcon, vista, cocina, camas, anio);

                habitacionesBase.put(id, habitacion);
                
            }

            scannerLectura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return habitacionesBase;
    }

    public ArrayList<Producto> TraducirMenuFile(File menuFile){
        Scanner scannerLectura;
        ArrayList<Producto> menu = new ArrayList<Producto>();
        try {
            scannerLectura = new Scanner(menuFile);
            scannerLectura.nextLine();
            while(scannerLectura.hasNextLine()){
                String[] datos = scannerLectura.nextLine().split(",");
                String nombre = datos[0];
                Double precio = Double.parseDouble(datos[1]);
                String horaInicio = datos[2];
                String HoraFin = datos[3];
                boolean validoHabitacion = Boolean.parseBoolean(datos[4]);

                Producto producto = new Producto(nombre, precio, horaInicio, HoraFin, validoHabitacion);

                menu.add(producto);
            }

            scannerLectura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return menu;
    }

    public void TraducirReservasYHuespedes(final File datosServiciosHabitacionesFolder, final File datosServiciosHuespedesFolder, final File datosReservasYHuespedesFile) {
        Scanner scannerLectura;

        HashMap<String, ArrayList<HabitacionReserva>> habitacionesReserva = new HashMap<String, ArrayList<HabitacionReserva>>();
        HashMap<String, ArrayList<Servicio>> serviciosHuesped = new HashMap<String, ArrayList<Servicio>>();
        
        HashMap<String, Huesped> huespedes = new HashMap<String, Huesped>();
        HashMap<String, Reserva> reservas = new HashMap<String, Reserva>();
        
        try {
            for (final File sHuespedFile : datosServiciosHuespedesFolder.listFiles()) {
                scannerLectura = new Scanner(sHuespedFile);

                scannerLectura.nextLine();
                String[] datos = scannerLectura.nextLine().split(",");

                String nombre = datos[0];
                String documento = datos[1];

                ArrayList<Servicio> servicios = new ArrayList<Servicio>();

                scannerLectura.nextLine();

                while(scannerLectura.hasNextLine()){
                    String[] datosServicio = scannerLectura.nextLine().split(",");
                    String nombreServicio = datosServicio[0];
                    double precio = Double.parseDouble(datosServicio[1]);
                    String descripcion = datosServicio[2];
                    String registro = datosServicio[3];
                    String fecha = datosServicio[4];
                    boolean pagado = Boolean.parseBoolean(datosServicio[5]) ;

                    Servicio servicio = new Servicio(precio, nombreServicio, fecha, pagado, descripcion, registro);

                    servicios.add(servicio);
                }

                serviciosHuesped.put(nombre+documento, servicios);
                scannerLectura.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for (final File sHabitacionFile : datosServiciosHabitacionesFolder.listFiles()) {
                scannerLectura = new Scanner(sHabitacionFile);

                scannerLectura.nextLine();
                String[] datos = scannerLectura.nextLine().split(",");

                String documento = datos[0];
                String idHabitacion = datos[1];
                String tipoHabitacion = datos[2];
                boolean balcon = Boolean.parseBoolean(datos[3]);
                boolean vista = Boolean.parseBoolean(datos[4]);
                boolean cocina = Boolean.parseBoolean(datos[5]);

                ArrayList<Servicio> servicios = new ArrayList<Servicio>();

                scannerLectura.nextLine();

                while(scannerLectura.hasNextLine()){
                    String[] datosServicio = scannerLectura.nextLine().split(",");
                    String nombreServicio = datosServicio[0];
                    double precio = Double.parseDouble(datosServicio[1]);
                    String descripcion = datosServicio[2];
                    String registro = datosServicio[3];
                    String fecha = datosServicio[4];
                    boolean pagado = Boolean.parseBoolean(datosServicio[5]) ;

                    Servicio servicio = new Servicio(precio, nombreServicio, fecha, pagado, descripcion, registro);

                    servicios.add(servicio);
                }

                HabitacionReserva habitacionReserva = new HabitacionReserva(idHabitacion, vista, cocina, balcon, tipoHabitacion, servicios);

                if(habitacionesReserva.containsKey(documento)){
                    habitacionesReserva.get(documento).add(habitacionReserva);
                }
                else{
                    ArrayList<HabitacionReserva> habitacionesNuevaLista = new ArrayList<HabitacionReserva>();
                    habitacionesNuevaLista.add(habitacionReserva);
                    habitacionesReserva.put(documento, habitacionesNuevaLista);
                }
                
                scannerLectura.close();

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            scannerLectura = new Scanner(datosReservasYHuespedesFile);
            scannerLectura.nextLine();
            scannerLectura.nextLine();
            scannerLectura.nextLine();
            scannerLectura.nextLine();

            while(scannerLectura.hasNextLine()){
                String[] datosReserva = scannerLectura.nextLine().split(",");

                String documento = datosReserva[0];
                String estadoReserva = datosReserva[1];
                String PersonasEsperadas = datosReserva[2];
                String fechaLlegada = datosReserva[3];
                String fechaSalida = datosReserva[4];

                ArrayList<Huesped> grupo = new ArrayList<Huesped>();

                String currLine = scannerLectura.nextLine();
                currLine = scannerLectura.nextLine();

                while(currLine.split(",").length != 1){
                    String[] datosHuesped = currLine.split(",");
                    String nombre = datosHuesped[0];
                    String documentoHuesped = datosHuesped[1];
                    String correoHuesped = datosHuesped[2];
                    String celularHuesped = datosHuesped[3];

                    if(serviciosHuesped.containsKey(nombre+documento)){
                        Huesped huesped = new Huesped(nombre, documentoHuesped, correoHuesped, celularHuesped, serviciosHuesped.get(nombre+documento));
                        grupo.add(huesped);
                        huespedes.put(documentoHuesped, huesped);
                    }
                    else{
                        Huesped huesped = new Huesped(nombre, documentoHuesped, correoHuesped, celularHuesped, new ArrayList<Servicio>());
                        grupo.add(huesped);
                        huespedes.put(documentoHuesped, huesped);
                    }

                    currLine = scannerLectura.nextLine();
                }

                ArrayList<HabitacionReserva> hReserva = habitacionesReserva.get(documento);

                Reserva reserva = new Reserva(documento, estadoReserva, Integer.parseInt(PersonasEsperadas), fechaLlegada, fechaSalida, hReserva, grupo);

                reservas.put(documento, reserva);
            }
        scannerLectura.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.MapaHuespedes = huespedes;
        this.MapaReservas = reservas;
    }
    
    public ArrayList<Tarifa> TraducirTarifas(File datosTarifasFolder) {
        Scanner scannerLectura;
        ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();

        try {
            for (final File tarifaFile : datosTarifasFolder.listFiles()) {
                scannerLectura = new Scanner(tarifaFile);

                Double[] preciosEstandar = new Double[365];
                Double[] preciosSuite = new Double[365];
                Double[] preciosDoble = new Double[365];

                scannerLectura.nextLine();
                int anio = Integer.parseInt(scannerLectura.nextLine());
                String[] estandarString = scannerLectura.nextLine().split(",");
                String[] suiteString = scannerLectura.nextLine().split(",");
                String[] dobleString = scannerLectura.nextLine().split(",");

                for (int i = 0; i < estandarString.length; i++) {
                    preciosEstandar[i] = Double.parseDouble(estandarString[i]);
                    preciosSuite[i] = Double.parseDouble(suiteString[i]);
                    preciosDoble[i] = Double.parseDouble(dobleString[i]);
                }

                Tarifa tarifa = new Tarifa(anio, preciosEstandar, preciosSuite, preciosDoble);

                tarifas.add(tarifa);
                scannerLectura.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tarifas;

    }

    public HashMap<String, Reserva> ConseguirReservas() {
        return MapaReservas;
    }

    public HashMap<String, Huesped> ConseguirHuespedes() {
        return MapaHuespedes;
    }

    public HashMap<String, ArrayList<Factura>> TraducirFacturas(final File datosFacturasFolder) {
        HashMap<String, ArrayList<Factura>> nuevoMapaFacturas = new HashMap<String, ArrayList<Factura>>();

        try {
            for (final File facturaFile : datosFacturasFolder.listFiles()){
                Scanner scannerLectura = new Scanner(facturaFile);
                scannerLectura.nextLine();

                ArrayList<Factura> facturasHuesped = new ArrayList<Factura>();

                if(scannerLectura.hasNextLine()){
                    String[] datosFactura = scannerLectura.nextLine().split(",");
                    String documento = datosFactura[0];
                    String nombreHuesped = datosFactura[1];
                    String precio = datosFactura[2];
                    String codigo = datosFactura[3];

                    Factura factura = new Factura(documento, nombreHuesped, Double.parseDouble(precio), codigo);

                    facturasHuesped.add(factura);

                    nuevoMapaFacturas.put(documento, facturasHuesped);
                }

                while(scannerLectura.hasNextLine()){
                    String[] datosFactura = scannerLectura.nextLine().split(",");
                    String documento = datosFactura[0];
                    String nombreHuesped = datosFactura[1];
                    String precio = datosFactura[2];
                    String codigo = datosFactura[3];

                    Factura factura = new Factura(documento, nombreHuesped, Double.parseDouble(precio), codigo);

                    nuevoMapaFacturas.get(documento).add(factura);
                    
                    ArrayList<Factura> facturasNuevaLista = new ArrayList<Factura>();
                    facturasNuevaLista.add(factura);
                    nuevoMapaFacturas.put(documento, facturasNuevaLista);
                }
                
                scannerLectura.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nuevoMapaFacturas;
    }
    
}
