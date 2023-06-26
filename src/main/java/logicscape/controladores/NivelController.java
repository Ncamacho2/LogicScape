package logicscape.controladores;

import javafx.stage.Stage;
import logicscape.modelos.Usuario;
import logicscape.vistas.FinalView;
import logicscape.vistas.JugarView;
import logicscape.vistas.NivelView;
import logicscape.vistas.RetoView;
/**
 * Clase: NivelController Descripción: Esta clase es responsable de controlar
 * las interacciones y eventos en la vista de nivel.
 *
 */
public class NivelController {
	private NivelView nivelView;
	private Usuario usuario;
	private Integer tiempoMsgInicial;

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Contructor de la clase.
	 * @param nivelView vista
	 * @param usuario usuario
	 * @param tiempoMsgInicial tiempo de mensaje
	 */
	public NivelController(NivelView nivelView, Usuario usuario, Integer tiempoMsgInicial) {
		this.nivelView = nivelView;
		this.usuario = usuario;
		this.tiempoMsgInicial = tiempoMsgInicial;
		this.nivelView.setNivelController(this);
	}

	/**
	 * Maneja el evento del un usuario.
	 *
	 * @param action       El nombre de usuario.
	 * @param primaryStage la ventana principal.
	 */
	public void handleButtonClick(String action, Stage primaryStage) {
		if (action.contentEquals("Iniciar")||action.contentEquals("Seguir")) {
			RetoView retoView = new RetoView();
			new RetoController(retoView, usuario);
			retoView.start(primaryStage);
		} else {
			JugarView jugarView = new JugarView();
			new JugarController(jugarView, usuario);
			jugarView.start(primaryStage);
		}
	}

	/**
	 * @return the tiempoMsgInicial
	 */
	public Integer getTiempoMsgInicial() {
		return tiempoMsgInicial;
	}

	/**
	 * set el tiempo inicial.
	 *
	 * @param tiempoMsgInicial the tiempoMsgInicial to set
	 */
	public void setTiempoMsgInicial(Integer tiempoMsgInicial) {
		this.tiempoMsgInicial = tiempoMsgInicial;
	}

	/**
	 * Muestra la ventana de final del juego.
	 *
	 * @param primaryStage la ventana principal.
	 */
	public void mostrarGameOver(Stage primaryStage) {
		FinalView finalView = new FinalView(false);
		new FinalController(finalView, usuario);
		finalView.start(primaryStage);
	}
	/**
	 * Muestra la ventana de final del juego.
	 *
	 * @param primaryStage la ventana principal.
	 */
	public void mostrarGanador(Stage primaryStage) {
		FinalView finalView = new FinalView(true);
		new FinalController(finalView, usuario);
		finalView.start(primaryStage);

	}
}
