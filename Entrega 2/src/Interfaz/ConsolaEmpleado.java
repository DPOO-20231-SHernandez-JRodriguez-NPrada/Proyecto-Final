package Interfaz;
import java.util.ArrayList;
import java.util.HashMap;

import Aplicacion.Input;
import Aplicacion.Habitaciones.HabitacionBase;
import Aplicacion.Servicios.Servicio;

public class ConsolaEmpleado {

    protected InterfazPrincipal padreInterfaz;

    /* 
    * Constructor
    * @Params
    *  -padreInterfaz: InterfazPrincipal

    * El constructor tiene como parámetro a su padre para poder
    * comunicarse con el enrutador principal y acceder mas facilmente
    * a los metodos de la clase 
    */
    public ConsolaEmpleado(InterfazPrincipal padreInterfaz) {
       this.padreInterfaz = padreInterfaz; 
    }
    
    
    public void IniciarPrograma() {
        /*
         * Muestra el menu de las opciones
         * Permite elegir entre diferentes opciones haste que se termine el loop
         */
        boolean parar = false;
        while(parar == false)
        {
            this.MostrarMenuPrincipal();
            String numeroOpcion = Input.input("Elija la opcion");
            EjecutarOpcion(Integer.parseInt(numeroOpcion));
            if (numeroOpcion.equals("9"))
            {
                parar = true;
            } 
        }
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
        9. Salir
        """);
    }

    public void EjecutarOpcion(int numeroOpcion)
    {
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

            case 9:
            
                salirPrograma();
                break;
            
            default:
                break;
        }
    }


    
    public void CrearReserva()
    {
        /*
         * Se piden los datos necesarios para crear la reserva
         * Además de especificaciones de como desea la habitacion para encontrale una
         */
        System.out.println("Ingrese los siguientes datos para crear la reserva");
        String documento = Input.input("Ingrese el documento del huesped principal");
        String nombre = Input.input("Ingrese el nombre del huesped principal");
        String correo = Input.input("Ingrese el correo del huesped principal");
        String celular = Input.input("Ingrese el celular del huesped principal");
        int personasEsperadas = Integer.parseInt(Input.input("Ingrese el numero de personas que se esperan"));
        
        String fechainicial = Input.input("Ingrese la fecha de ingreso esperado(formato -01/01/2000-)");
        String fechafinal = Input.input("Ingrese la fecha de salida(formato -01/01/2000-)");
        System.out.println("Seleccione con true o false las caracteristicas que desea un su habitacion");
        
        String vista = Input.input("¿Es necesario que cuente con vistas?(true/false)");
        String cocina = Input.input("¿Es necesario que cuente con cocina?(true/false)");
        String balcon = Input.input("¿Es necesario que cuente con balcon?(true/false)");
        boolean vistaB = Boolean.parseBoolean(vista);
        boolean cocinaB = Boolean.parseBoolean(cocina);
        boolean balconB = Boolean.parseBoolean(balcon);

        System.out.println("Seleccione un tipo de habitacion");
        System.out.println("Contamos con habitaciones de tipo: 1. estandar, 2. suite, 3. doble");
        String tipo = Input.input("Escriba el tipo de habitacion deseada");
        
        ArrayList<HabitacionBase> HabitacionesBs = padreInterfaz.buscarHabitaciones(cocinaB, balconB, vistaB, fechainicial, fechafinal, tipo);
        String estadoReserva = "reservado";
        double precio = padreInterfaz.CrearReserva(documento,estadoReserva,personasEsperadas,fechainicial,fechafinal,HabitacionesBs,nombre,correo,celular);
        System.out.println("Se creo con exito su reserva");
        System.out.println("El valor total de su reserva es de " + String.valueOf(precio));

    }
    public void VerReserva()
    {
        System.out.println("Ingrese los siguientes datos para verificar la reserva");
        String documento = Input.input("Ingrese el documento del huesped principal");
        String Texto = padreInterfaz.VerReserva(documento);
        String[] info = Texto.split(",");
        System.out.println("El documento del huesped principal es " + documento + ".");
        System.out.println("La fecha de ingreso es: " + info[0] + ".");
        System.out.println("La fecha de salida es: " + info[1] + ".");
        System.out.println("Se esperan un total de " + info[2] + " personas.");
        System.out.println("El total de habitaciones reservadas es de " + info[3] + ".");
        String[] ids =  info[4].split(";");
        for(String id: ids)
        {
            System.out.println("Los id de las habitaciones son " + id +  ".");
        }
    }
    public void EliminarReserva()
    {
        System.out.println("Ingrese los siguientes datos para eliminar la reserva");
        String documento = Input.input("Ingrese el documento del huesped principal");
        String fechactual = Input.input("Ingrese la fecha actual");
        String resultado = padreInterfaz.EliminarReserva(documento,fechactual);
        System.out.println(resultado);
    }
    public void AñadirServicio()
    {
        String descripcion = "";
        double precio = 0;
        System.out.println("Para cargar el servicio ingrese los siguientes datos");
        String documento = Input.input("Ingrese el documento del huesped principal");
        String fecha = Input.input("Ingrese la fecha en la que se consumio el producto");
        boolean pagado = Boolean.parseBoolean(Input.input("Ingrese si el servicio esta pago(true/false)"));
        String servicio = Input.input("Ingrese el nombre del servicio");
        if(servicio.equals("Restaurante"))
        {
            boolean parar = false;
            while(parar == false)
            {
                System.out.println(
                    """
                        El menu del restaurante es el siguiente con sus precios
                    1) Hamburguesa-5.99
                    2) Pizza-7.99
                    3)Papas Fritas-4.99
                    4) Perro Caliente-5.99
                    5) Nachos-3.99
                    6) Ensalada Cesar-7.99
                    7) Ensalada de Frutas-3.99
                    8) Omelet-4.99
                    9) Huevos Fritos-3.99
                    10) Huevos Revueltos-3.99
                    11) Mojito-12.49
                    12) Margarita-14.49
                    13) Coca-Cola-3.99
                    14) Agua-3.99
                    15) Cerveza-4.99
                    """);
                String producto = Input.input("Ingrese el nombre del producto");
                String cantidad = Input.input("Ingrese las veces que se consumio dicho producto");
                String confirmar = Input.input("Escriba cancelar para no guardar este producto. Escriba repetir para repetir el proceso completo.Escriba continuar para no hacer ninguna de los opciones anteriores.");
                String pararT = Input.input("Si desea finalizar el proceso escriba parar");
                if (confirmar.equals("cancelar"))
                {
                    producto = "";
                    cantidad = "";                
                }
                if (confirmar.equals("repetir"))
                {
                    producto = "";
                    cantidad = "";
                    descripcion = "";                
                }
                if (pararT.equals("parar"))  
                {   
                    parar = true;
                }
                else
                {
                    if (descripcion.equals("")==false) 
                    {
                        descripcion += ";";
                    }
                    descripcion = producto + cantidad;
                    precio += padreInterfaz.precioProducto(producto);
                }
            }
        }
        padreInterfaz.AñadirServicio(documento,servicio,descripcion,fecha,pagado,precio);

    }

    public void HacerCheckIn()
    {
        boolean flag = true;

        String documentoPrincipal = Input.input("Ingrese el documento del huesped principal");

        while(flag == true)
        {
            System.out.println("Ingrese los siguientes datos para hacer el check in");
            String documento = Input.input("Ingrese el documento de la persona");
            String nombre = Input.input("Ingrese el nombre de la persona");
            String correo = Input.input("Ingrese el correo de la persona (Escriba un espacio si no tiene)");
            String celular = Input.input("Ingrese el celular de la persona (Escriba un espacio si no tiene)");
            padreInterfaz.HacerCheckIn(documentoPrincipal,documento,nombre,correo,celular);
            String continuar = Input.input("Si desea hacer el check in de otra persona escriba continuar. Si desea salir escriba salir");
            if (continuar.equals("salir"))
            {
                flag = false;
            }
        }
        
    }
    
    public void HacerCheckOut()
    {
        System.out.println("Ingrese los siguientes datos para hacer el check out");
        String documento = Input.input("Ingrese el documento del huesped principal");

        HashMap<String, ArrayList<Servicio>> servicosPorPagar = padreInterfaz.HacerCheckOut(documento, false);
        if(servicosPorPagar.size() != 0){
            System.out.println("Los servicios por pagar son: ");
            for (String key : servicosPorPagar.keySet()) {
                System.out.println("Servicios: " + key);
                for (Servicio servicio : servicosPorPagar.get(key)) {
                    System.out.println("Descripcion: " + servicio.getDescripcion());
                    System.out.println("Precio: " + servicio.getPrecio());
                }
            }

            System.out.println("Confirmar pago servicios...");

            padreInterfaz.HacerCheckOut(documento, true);
            padreInterfaz.FacturarGrupo(documento);

        }

        System.out.println("El check out se ha realizado con exito");
        
    }

    private void salirPrograma()
    {
        padreInterfaz.salirPrograma();
    }
}
