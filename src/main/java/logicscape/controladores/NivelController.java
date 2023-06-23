package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;
import logicscape.utilidades.ConexionSql;
import logicscape.vistas.FinalView;
import logicscape.vistas.InfoView;
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
		if (action.contentEquals("Iniciar")) {
			RetoView retoView = new RetoView();
            RetoController retoController = new RetoController(retoView, usuario);
            retoView.start(primaryStage);
		} else {
			JugarView jugarView = new JugarView();
            JugarController jugarController = new JugarController(jugarView, usuario);
            jugarView.start(primaryStage);
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
		alert.setHeaderText("Registro de Usuarios");
		alert.setContentText(mensaje);
		alert.showAndWait();
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
		FinalController finalController = new FinalController(finalView, usuario);
		finalView.start(primaryStage);
	}

	public void mostrarGanador(Stage primaryStage) {
		FinalView finalView = new FinalView(true);
		FinalController finalController = new FinalController(finalView, usuario);
		finalView.start(primaryStage);
		
	}
}
