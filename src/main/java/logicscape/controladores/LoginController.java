package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.vistas.LoginView;
import logicscape.utilidades.Autenticacion;

/**
 * Controlador para la vista de inicio de sesión.
 */
public class LoginController {
    private LoginView loginView;

    /**
     * Crea una instancia del controlador asociado a la vista de inicio de sesión.
     *
     * @param loginView La vista de inicio de sesión.
     */
    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.loginView.setLoginController(this);
    }

    /**
     * Maneja el evento de inicio de sesión.
     *
     * @param usuario     El nombre de usuario.
     * @param contrasenia La contraseña.
     * @return true si el inicio de sesión es exitoso, false de lo contrario.
     */
    public boolean handleLogin(String usuario, String contrasenia) {
        Autenticacion autenticacion = new Autenticacion();
        if (autenticacion.autenticarUsuario(usuario, contrasenia)) {
            return true;
        } else {
            mostrarMensaje("Usuario o contraseña incorrectos");
            return false;
        }
    }

    /**
     * Muestra un mensaje emergente con la información proporcionada.
     *
     * @param mensaje El mensaje a mostrar.
     */
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Ventana emergente");
        alert.setHeaderText("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
