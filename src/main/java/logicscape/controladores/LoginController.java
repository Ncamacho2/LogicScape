package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import logicscape.vistas.InicioView;
import logicscape.vistas.JugarView;
import logicscape.vistas.LoginView;
import logicscape.utilidades.Autenticacion;

/**
 * Clase: LoginController Descripción: Esta clase es responsable de controlar
 * las interacciones y eventos en la vista de inicio de sesión.
 * 
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
	 * @param usuario      El nombre de usuario.
	 * @param contrasenia  La contraseña.
	 * @param primaryStage
	 * @return true si el inicio de sesión es exitoso, false de lo contrario.
	 */
	public void handleLogin(String usuario, String contrasenia, Stage primaryStage) {
		Autenticacion autenticacion = new Autenticacion();
		if (autenticacion.autenticarUsuario(usuario, contrasenia)) {
			JugarView jugarView = new JugarView();
			JugarController jugarControler = new JugarController(jugarView, autenticacion.getUsuarioActivo());
			jugarView.start(primaryStage);
		} else {
			mostrarMensaje("Usuario o contraseña incorrectos", AlertType.ERROR);
		}
	}

	/**
	 * Muestra un mensaje de información en una ventana emergente.
	 *
	 * @param mensaje El mensaje a mostrar.
	 * @param tipo
	 */
	private void mostrarMensaje(String mensaje, AlertType tipo) {
		Alert alert = new Alert(tipo);
		alert.setTitle("Logic Scape");
		alert.setHeaderText("Inicio de Sesión");
		alert.setContentText(mensaje);
		alert.showAndWait();
	}

	/**
	 * Retorna a la ventana de inicio.
	 * 
	 * @param primaryStage
	 */
	public void handleCancelar(Stage primaryStage) {
		InicioView inicioView = new InicioView();
		InicioController inicioControler = new InicioController(inicioView);
		inicioView.start(primaryStage);
	}
}
