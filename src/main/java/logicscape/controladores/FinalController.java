package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import logicscape.modelos.Usuario;
import logicscape.vistas.FinalView;
import logicscape.vistas.InfoView;
import logicscape.vistas.JugarView;

/**
 * El controlador para la vista de información (InfoView) en el juego
 * LogicScape. Controla las interacciones y acciones relacionadas con la vista
 * de información.
 */
public class FinalController {
	private FinalView finalView;
	private Usuario usuario;

	/**
	 * Crea una instancia del controlador de información con la vista y el usuario
	 * proporcionados.
	 *
	 * @param infoView La vista de información asociada al controlador.
	 * @param usuario  El usuario asociado al controlador.
	 */
	public FinalController(FinalView finalView, Usuario usuario) {
		this.finalView = finalView;
		this.usuario = usuario;
		this.finalView.setFinalController(this);
	}

	/**
	 * Maneja el evento de clic del botón en la vista de información. Crea una nueva
	 * vista de juego (JugarView) y muestra la vista.
	 *
	 * @param primaryStage El Stage principal de la aplicación.
	 */
	public void handleButtonClick(Stage primaryStage) {
		
	}
}
