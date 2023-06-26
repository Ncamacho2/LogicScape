package logicscape.controladores;

import javafx.stage.Stage;
import logicscape.modelos.Usuario;
import logicscape.vistas.InfoView;
import logicscape.vistas.InicioView;
import logicscape.vistas.JugarView;
import logicscape.vistas.NivelView;
/**
 * Clase: JugarController Descripción: Esta clase es responsable de controlar
 * las interacciones y eventos en la vista de jugar.
 *
 */
public class JugarController {
	private JugarView jugarView;
	private Usuario usuario;

	/**
	 * Contructor de la clase.
 	 * @param jugarView vista.
	 * @param usuario usuario.
	 */
	public JugarController(JugarView jugarView, Usuario usuario) {
		this.jugarView = jugarView;
		this.usuario = usuario;
		this.jugarView.setJugarController(this);
	}

	/**
	 * Maneja el evento del un usuario.
	 *
	 * @param action       El nombre de usuario.
	 * @param primaryStage la ventana principal.
	 */
	public void handleButtonClick(String action, Stage primaryStage) {
		if (action.contentEquals("JUGAR")) {
			NivelView nivelView = new NivelView();
			new NivelController(nivelView, usuario, 5);
			nivelView.start(primaryStage);
		} else {
			InfoView infoView = new InfoView();
			new InfoController(infoView, usuario);
			infoView.start(primaryStage);
		}
	}

	/**
	 * Retorna a la ventana de inicio.
	 * 
	 * @param primaryStage la ventana principal.
	 */
	public void handleCancelar(Stage primaryStage) {
		InicioView inicioView = new InicioView();
		new InicioController(inicioView);
		inicioView.start(primaryStage);
	}

}
