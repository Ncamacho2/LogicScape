package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;
import logicscape.utilidades.ConexionSql;
import logicscape.vistas.LoginView;

public class LoginController {
    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.loginView.setLoginController(this);
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
}
