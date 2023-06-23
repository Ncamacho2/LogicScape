package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import logicscape.utilidades.Autenticacion;
import logicscape.vistas.InicioView;
import logicscape.vistas.LoginView;
import logicscape.vistas.RegistroView;
/**
 * Clase: RegistroController
 * Descripción: Esta clase es responsable de controlar las interacciones y eventos en la vista de Registro.
 * 
*/
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
	 * @param tipo 
	 */
	private void mostrarMensaje(String mensaje, AlertType tipo) {
		Alert alert = new Alert(tipo);
		alert.setTitle("Logic Scape");
		alert.setHeaderText("Registro de Usuarios");
		alert.setContentText(mensaje);
		alert.showAndWait();
	}

	/**
	 * Maneja el evento de registro de un usuario.
	 *
	 * @param user         El nombre de usuario.
	 * @param password     La contraseña.
	 * @param primaryStage
	 */
	public void handleRegistro(String user, String password, Stage primaryStage) {
		Autenticacion autenticacion = new Autenticacion();
		if (autenticacion.registrarUsuario(user, password)) {
			mostrarMensaje("Registro Exitoso.", AlertType.INFORMATION);
			LoginView loginView = new LoginView();
			LoginController loginControler = new LoginController(loginView);
			loginView.start(primaryStage);

		} else {
			mostrarMensaje("Registro Fallido",AlertType.ERROR);
		}
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
