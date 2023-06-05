package Login;

import java.util.HashMap;

public class AdministradorLogin {

    private HashMap<String, String> datosLogin;
    private HashMap<String, String> datosLoginClientes;

    public AdministradorLogin() {        
    }

    public void AsignarDatos(HashMap<String, String> datosLogin, HashMap<String, String> datosLoginClientes)
 {
        this.datosLogin = datosLogin;
        this.datosLoginClientes = datosLoginClientes;
    }

    public String ComprobarLogin(String usuario, String contrasenia) {
        
        String contraseniaTipoUsuario = datosLogin.get(usuario);
        String datoReturn = "";

        if(contraseniaTipoUsuario == null){
            datoReturn = "error";
        }
        else{
            String[] datos = contraseniaTipoUsuario.split(";");
            String contraseniaUsuario = datos[0];
            String tipoUsuario = datos[1];
            
            if(contraseniaUsuario.equals(contrasenia)){
                datoReturn = tipoUsuario;
            }
            else{
                datoReturn = "error";
            }
        }        
        
        return datoReturn;
    }

    public boolean ComprobarLoginCliente(String usuario, String contrasenia) {
        
        boolean respuesta = false;

        if(datosLoginClientes.containsKey(usuario)){
            String contraseniaDatos = datosLoginClientes.get(usuario);

            if(contraseniaDatos.equals(contrasenia)){
                respuesta = true;
            }
        }

        return respuesta;
        
    }

    public boolean CrearCuentaCliente(String usuario, String contrasenia) {
            
            boolean respuesta = false;
    
            if(!datosLoginClientes.containsKey(usuario)){
                datosLoginClientes.put(usuario, contrasenia);
                respuesta = true;
            }
    
            return respuesta;
    }
    
}
