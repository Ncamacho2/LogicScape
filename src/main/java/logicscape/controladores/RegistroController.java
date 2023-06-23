package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.utilidades.Autenticacion;
import logicscape.vistas.RegistroView;

public class RegistroController {
	
    private RegistroView registroView;

    /**
     * Constructor de la clase RegistroController.
     *
     * @param registroView La vista del registro.
     */
    public RegistroController(RegistroView registroView) {
        this.registroView = registroView;
        this.registroView.setRegistroController(this);
    }

    /**
     * Maneja el evento de clic en un botón.
     *
     * @param action Acción realizada al hacer clic.
     */
    public void handleButtonClick(String action) {   	
    }

    /**
     * Muestra un mensaje de información en una ventana emergente.
     *
     * @param mensaje El mensaje a mostrar.
     */
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ventana emergente");
        alert.setHeaderText("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    /**
     * Maneja el evento de registro de un usuario.
     *
     * @param user     El nombre de usuario.
     * @param password La contraseña.
     * @return true si el registro es exitoso, false de lo contrario.
     */
    public boolean handleRegistro(String user, String password) {
        Autenticacion autenticacion = new Autenticacion();
        if (autenticacion.registrarUsuario(user, password)) {
            return true;
        } else {
            mostrarMensaje("Registro Fallido");
            return false;
        }
    }
}
