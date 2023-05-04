package Interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsolaAdmin extends ConsolaEmpleado
{

    public ConsolaAdmin(InterfazPrincipal padreInterfaz) {
        super(padreInterfaz);
    }
        public void MostrarMenuPrincipal() 
        {
            System.out.println(
                """
                1. Crear reserva
                2. Ver reserva
                3. Eliminar reserva
                4. Añadir servicio
                5. Hacer check in
                6. Hacer check out
                7. Cambiar tarifa
                9. Salir
                """);
        }

        

    public void EjecutarOpcion(int numeroOpcion) {
        switch (numeroOpcion) {
            case 1:
                CrearReserva();
                
                break;

            case 2:
                VerReserva();

                break;

            case 3:
                EliminarReserva();

                break;

            case 4:
                AñadirServicio();

                break;

            case 5:
                HacerCheckIn();

                break;

            case 6:
                HacerCheckOut();

                break;

            case 7:
                CambiarTarifa();

                break;

            case 9:
                System.out.println("Saliendo del programa");
                padreInterfaz.salirPrograma();
                break;
        
            default:
                break;
        }
    }

    public void CambiarTarifa() {
    try {
        System.out.println("____________\nCambio de tarifa\n____________");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el año: ");
        String a = reader.readLine().trim();
        int anio = Integer.parseInt(a);

        System.out.print("Ingrese el tipo: ");
        String tipo = reader.readLine().trim();

        System.out.print("Ingrese el precio: ");
        String p = reader.readLine().trim();
        Double precio = Double.parseDouble(p);

        System.out.print("Ingrese la fecha de inicio con formato dd/MM/yyyy: ");
        String finicio = reader.readLine().trim();

        System.out.print("Ingrese la fecha final con formato dd/MM/yyyy: ");
        String ffinal = reader.readLine().trim();

        ArrayList<String> dias= new ArrayList<String>();

        Boolean continuar=true;

        String[] posibles={"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" , "SUNDAY"};
        ArrayList<String> posibles_dias = new ArrayList<>(Arrays.asList(posibles));
        while (continuar){
            System.out.print("Ingrese un dia de la semana como MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY o SUNDAY\n O ingrese \"salir\" si no desea agregar mas dias : ");
            String dia = reader.readLine().trim();
            if(posibles_dias.contains(dia)){
                dias.add(dia);
                System.out.println("El dia fue ingresado correctamente");
            } else if (dia.equals("salir")){
                continuar=false;
                System.out.println("Se dejaron de recibir dias");
            }
            else {
                System.out.println("El dia que ingreso no es correcto o no tiene el formato valido");
            }

        }
        // En este punto ConsolaAdmin deberia llamar a la funcion cambiarTarifa(String tipo, int anio, Double precio, String finicio, String ffinal, ArrayList<String> dias) de EnrutadorPrincipal
        this.padreInterfaz.getEP().cambiarTarifa(tipo, anio, precio, finicio, ffinal, posibles_dias);;
        } catch (IOException e) {
            System.out.println("Se produjo una excepción al leer las entradas: " + e.getMessage());
        }
    }
}