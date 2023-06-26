package logicscape.controladores;

import javafx.stage.Stage;
import logicscape.modelos.Usuario;
import logicscape.vistas.InfoView;
import logicscape.vistas.JugarView;

/**
 * El controlador para la vista de información (InfoView) en el juego
 * LogicScape. Controla las interacciones y acciones relacionadas con la vista
 * de información.
 */
public class InfoController {
	private InfoView infoView;
	private Usuario usuario;

	/**
	 * Crea una instancia del controlador de información con la vista y el usuario
	 * proporcionados.
	 *
	 * @param infoView La vista de información asociada al controlador.
	 * @param usuario  El usuario asociado al controlador.
	 */
	public InfoController(InfoView infoView, Usuario usuario) {
		this.infoView = infoView;
		this.usuario = usuario;
		this.infoView.setInfoController(this);
	}

	/**
	 * Maneja el evento de clic del botón en la vista de información. Crea una nueva
	 * vista de juego (JugarView) y muestra la vista.
	 *
	 * @param primaryStage El Stage principal de la aplicación.
	 */
	public void handleButtonClick(Stage primaryStage) {
		JugarView jugarView = new JugarView();
		new JugarController(jugarView, usuario);
		jugarView.start(primaryStage);
	}
}
