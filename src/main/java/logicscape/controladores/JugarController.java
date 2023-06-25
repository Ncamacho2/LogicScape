package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;
import logicscape.utilidades.Autenticacion;
import logicscape.utilidades.ConexionSql;
import logicscape.vistas.InfoView;
import logicscape.vistas.InicioView;
import logicscape.vistas.JugarView;
import logicscape.vistas.LoginView;
import logicscape.vistas.NivelView;

public class JugarController {
	private JugarView jugarView;
	private Usuario usuario;

	public JugarController(JugarView jugarView, Usuario usuario) {
		this.jugarView = jugarView;
		this.usuario = usuario;
		this.jugarView.setJugarController(this);
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
	 * Maneja el evento del un usuario.
	 *
	 * @param action       El nombre de usuario.
	 * @param primaryStage
	 */
	public void handleButtonClick(String action, Stage primaryStage) {
		if (action.contentEquals("JUGAR")) {
			NivelView nivelView = new NivelView();
			NivelController nivelController = new NivelController(nivelView, usuario, 5);
			nivelView.start(primaryStage);
		} else {
			InfoView infoView = new InfoView();
			InfoController infoController = new InfoController(infoView, usuario);
			infoView.start(primaryStage);
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
