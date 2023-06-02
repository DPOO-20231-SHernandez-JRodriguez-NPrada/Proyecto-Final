package Login;

import java.util.HashMap;

public class AdministradorLogin {

    private HashMap<String, String> datosLogin;

    public AdministradorLogin() {        
    }

    public void AsignarDatos(HashMap<String, String> datosLogin) {
        this.datosLogin = datosLogin;
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
    
}
