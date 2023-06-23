package logicscape.controladores;

import javafx.stage.Stage;
import logicscape.vistas.InicioView;
import logicscape.vistas.LoginView;
import logicscape.vistas.RegistroView;
/**
 * Clase: InicioController
 * Descripción: Esta clase es responsable de controlar las interacciones y eventos en la vista de inicio.
 * 
*/
public class InicioController {
	private InicioView inicioView;
	/**
	 * Constructor de la clase InicioController.
	 * 
	 * @param inicioView La vista de inicio asociada al controlador.
	 */
	public InicioController(InicioView inicioView) {
		this.inicioView = inicioView;
		this.inicioView.setInicioController(this);

	}

	/**
	 * Maneja el evento de clic en los botones de la vista de inicio y realiza la navegación correspondiente.
	 * 
	 * @param string       El texto del botón que se ha clicado.
	 * @param primaryStage El escenario principal de la aplicación.
	 */
	public void handleButtonClick(String string, Stage primaryStage) {
		if (string.contentEquals("Ingresa")) {
			LoginView loginView = new LoginView();
			LoginController loginController = new LoginController(loginView);
			loginView.start(primaryStage);
		} else {
			RegistroView registroView = new RegistroView();
			RegistroController registroController = new RegistroController(registroView);
			registroView.start(primaryStage);
		}

	}

}
