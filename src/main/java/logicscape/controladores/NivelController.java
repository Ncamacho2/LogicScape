package logicscape.controladores;

import javafx.stage.Stage;
import logicscape.modelos.Usuario;
import logicscape.vistas.FinalView;
import logicscape.vistas.JugarView;
import logicscape.vistas.NivelView;
import logicscape.vistas.RetoView;

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
	 * @param primaryStage
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
	 * @param tiempoMsgInicial the tiempoMsgInicial to set
	 */
	public void setTiempoMsgInicial(Integer tiempoMsgInicial) {
		this.tiempoMsgInicial = tiempoMsgInicial;
	}

	public void mostrarGameOver(Stage primaryStage) {
		FinalView finalView = new FinalView(false);
		new FinalController(finalView, usuario);
		finalView.start(primaryStage);
	}

	public void mostrarGanador(Stage primaryStage) {
		FinalView finalView = new FinalView(true);
		new FinalController(finalView, usuario);
		finalView.start(primaryStage);

	}
}
