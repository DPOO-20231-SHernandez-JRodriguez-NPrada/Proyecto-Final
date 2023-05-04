package Aplicacion.Habitaciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Set;
import java.time.temporal.ChronoUnit;
import java.time.*;

public class AdministradorHabitaciones {

    HashMap<String, HabitacionBase> hashHabitaciones;

    public void AsignarHabitacionesBase(HashMap<String,HabitacionBase> mapa){
        this.hashHabitaciones=mapa;
    }



    public void modificarEstadoOcupado(String id, String fechai, String fechaf, Boolean cambio){ //las fechas deben estar en formato dd/MM/yyyy | cambio debe ser True o false dependendiendo si se quiere ocupar o desocupar
        try {
        HabitacionBase habitacion = this.hashHabitaciones.get(id); // se obtiene la habitacion del hashmap
        Boolean[] dias = habitacion.getOcupado(); //se obtiene la lista donde se ven cuando esta ocupada
        LocalDate finicial= LocalDate.parse(fechai, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate ffinal= LocalDate.parse(fechaf, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // se convierten ambos string a fechas
        int anio = finicial.getYear();
        String primero = "01/01/"+anio;
        LocalDate fprimero = LocalDate.parse(primero, DateTimeFormatter.ofPattern("dd/MM/yyyy")); //Esta es la fecha de 1 de enero de ese año
        int diasEntreFechasf = (int) ChronoUnit.DAYS.between(fprimero, ffinal); //dias que pasan entre 1 de enero y el final, para saber cuantas veces hacer el recorrido
        int diasEntreFechasi = (int) ChronoUnit.DAYS.between(fprimero, finicial); //dias que pasan entre 1 de enero y el dia de inicio, para saber en que posicion esta ese dia
        for(int i=diasEntreFechasi; i<=diasEntreFechasf; i++){
            dias[i]=cambio; //recorre todos los dias dentro del Boolean[] y los pone como se especifica por parametro
        }
        habitacion.setOcupado(dias); //se actualiza a la nueva lista de booleanos
        this.hashHabitaciones.put(id,habitacion); //se actualiza en el hashmap
    } catch (DateTimeException e) {
        System.out.println("Se produjo una excepción al trabajar con fechas: " + e.getMessage());
    }
    }

    public ArrayList<HabitacionBase> buscarHabitaciones(Boolean cocina, Boolean balcon, Boolean vista, String fechai, String fechaf, String tipo){
        // Recibe las fechas iniciales y las caracteristicas que se quieren
        //Retorna una lista de las habitaciones que cumplen todo

        ArrayList<HabitacionBase> hab_validos = new ArrayList<HabitacionBase>();
        try {
        Set<String> ids = this.hashHabitaciones.keySet(); //obtiene todos los ids del hashMap
        for(String id : ids){//recorre cada id
            Boolean disponible= verificarDisponibilidad(id, fechai, fechaf);
            Boolean caracteristicas = verificarCaracteristicas(id, vista, cocina, balcon, tipo);
            if (disponible && caracteristicas){
                HabitacionBase habitacion = hashHabitaciones.get(id);
                hab_validos.add(habitacion); // si esta disponible y cumple con las caracteristicas, se agrega a la lista de habitaciones validas
            }
        }

    } catch (NullPointerException | ClassCastException | ConcurrentModificationException ex) {
        System.out.println("Se produjo un error con el hashmap: " + ex.getMessage());
    }
        return hab_validos;

    }


    public Boolean verificarDisponibilidad(String id, String fechai, String fechaf){ // Con dos fechas en dd/MM/yyyy verifica si esta vacia en ese rango de fechas
        Boolean centinela=false;
        try{
        centinela = true;
        HabitacionBase habitacion = this.hashHabitaciones.get(id); // se obtiene la habitacion del hashmap
        Boolean[] dias = habitacion.getOcupado(); //se obtiene la lista donde se ven cuando esta ocupada
        LocalDate finicial= LocalDate.parse(fechai, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate ffinal= LocalDate.parse(fechaf, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // se convierten ambos string a fechas
        int anio = finicial.getYear();
        String primero = "01/01/"+anio;
        LocalDate fprimero = LocalDate.parse(primero, DateTimeFormatter.ofPattern("dd/MM/yyyy")); //Esta es la fecha de 1 de enero de ese año
        int diasEntreFechasf = (int) ChronoUnit.DAYS.between(fprimero, ffinal); //dias que pasan entre 1 de enero y el final, para saber cuantas veces hacer el recorrido
        int diasEntreFechasi = (int) ChronoUnit.DAYS.between(fprimero, finicial); //dias que pasan entre 1 de enero y el dia de inicio, para saber en que posicion esta ese dia
        
        int i = diasEntreFechasi;
        while(centinela && i<=diasEntreFechasf){ //sigue mientras siga en el rango de fechas y no haya encontrado algun dia ocupado. Solo se necesita que un dia este ocupado para hacerlo false
            if (dias[i]){
                centinela = false; // si encuentra algun dia, centinela es falso
            }
            i++;
        }
        

    } catch (DateTimeException e) {
        System.out.println("Se produjo una excepción al trabajar con fechas: " + e.getMessage());
    }
    return centinela; //retorna true si esta disponible | false si alguno de los dias esta ocupado
}
    
    public Boolean verificarCaracteristicas(String id, Boolean vista, Boolean cocina, Boolean balcon, String tipo){ 
        // Esta se encarga de solo dejar pasar las habitaciones del mismo tipo y con caracteristicas requeridas
        Boolean centinela=false;
        try{
        centinela=true;
        HabitacionBase habitacion = this.hashHabitaciones.get(id); // se obtiene la habitacion del hashmap
        if (!tipo.equals(habitacion.getTipo())){ // verifica que el tipo sea igual. Si es diferente, es falso
            centinela=false;
        }
        if (vista){
            if (!habitacion.getVista()){ //Si se requiere vista y no la tiene, es falso
                centinela=false;
            }
        }
        if (cocina){
            if (!habitacion.getCocina()){ //Si se requiere cocina y no la tiene, es falso
                centinela=false;
            }
        }
        if (balcon){
            if (!habitacion.getBalcon()){ //Si se requiere balcon y no la tiene, es falso
                centinela=false;
            }
        }

        } catch (NullPointerException | ClassCastException | ConcurrentModificationException ex) {
            System.out.println("Se produjo un error con el hashmap: " + ex.getMessage());
        }
        return centinela; // retorna true si cumple | false si no cumple
    }
    
}