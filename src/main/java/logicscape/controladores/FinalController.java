package logicscape.controladores;

import java.util.ArrayList;

import javafx.stage.Stage;
import logicscape.modelos.Usuario;
import logicscape.utilidades.Escenarios;
import logicscape.vistas.FinalView;
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
	 * @param finalView La vista de información asociada al controlador.
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
	public void jugardeNuevo(Stage primaryStage) {
		Escenarios escenario = new Escenarios(new ArrayList<Integer>(), "", 0, usuario.getEscenarioActual(),
				usuario.getNivelActual(), usuario.getId());
		usuario = escenario.reiniciarJuego(usuario.getId());
		JugarView jugarView = new JugarView();
		new JugarController(jugarView, usuario);
		jugarView.start(primaryStage);

	}
}
