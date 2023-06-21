package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.utilidades.Autenticacion;
import logicscape.vistas.RegistroView;

public class RegistroController {
	
    private RegistroView registroView;

    public RegistroController(RegistroView registroView) {
        this.registroView = registroView;
        this.registroView.setRegistroController(this);
    }

    public void handleButtonClick(String action) {
  
    	
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ventana emergente");
        alert.setHeaderText("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    /**
     * Maneja el evento de inicio de sesión.
     *
     * @param usuario     El nombre de usuario.
     * @param contrasenia La contraseña.
     * @return true si el inicio de sesión es exitoso, false de lo contrario.
     */
    public boolean handleRegistro(String user, String password) {
        Autenticacion autenticacion = new Autenticacion();
        if (autenticacion.registrarUsuario(user, password)) {
            return true;
        } else {
            mostrarMensaje("Error al registrar usuario");
            return false;
        }
    }
}
