package logicscape.controladores;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;
import logicscape.utilidades.ConexionSql;
import logicscape.utilidades.Escenarios;
import logicscape.vistas.RespuestasView;
import logicscape.vistas.RetoView;

/**
 * Controlador para la vista del Reto en la aplicación LogicScape. Permite
 * controlar la lógica y las interacciones en el Reto.
 */
public class RetoController {

	private RetoView retoView;
	private Usuario usuario;

	/**
	 * Crea una instancia de RetoController.
	 * 
	 * @param retoView la vista del Reto
	 * @param usuario  el usuario actual
	 */
	public RetoController(RetoView retoView, Usuario usuario) {
		this.retoView = retoView;
		this.setUsuario(usuario);
		this.retoView.setRetoController(this);

	}

	/**
	 * Establece el controlador de Respuestas.
	 * 
	 * @param respuestasController el controlador de Respuestas a establecer
	 */
	public void setRespuestasController(RespuestasController respuestasController) {
	}

	/**
	 * Muestra un mensaje emergente con la información proporcionada.
	 * 
	 * @param mensaje el mensaje a mostrar
	 */
	public void mostrarMensaje(String mensaje) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ventana emergente");
		alert.setHeaderText("Información");
		alert.setContentText(mensaje);
		alert.showAndWait();
	}

	/**
	 * Ejecuta una función al finalizar el tiempo Reto.
	 * 
	 * @param primaryStage el Stage principal de la aplicación
	 */
	public void funcionFinalizarTiempo(Stage primaryStage) {
		Platform.runLater(() -> {
			mostrarMensaje("Se acabó el tiempo");
			ConexionSql<Usuario> conexion = new ConexionSql<>();
			usuario = conexion.findById("usuarios", "id", usuario.getId(), new UsuarioMapper());
			RespuestasView respuestasView = new RespuestasView();
			RespuestasController respuestasController = new RespuestasController(respuestasView, primaryStage, usuario);
			respuestasController.setRespuesta("Incorrecto!");
			respuestasView.start(primaryStage);
		});

	}

	/**
	 * Valida la respuesta proporcionada por el usuario en el Reto.
	 * 
	 * @param respuesta    el número de respuesta seleccionado
	 * @param escenario    el escenario actual del Reto
	 * @param primaryStage el Stage principal de la aplicación
	 */
	public void validarRespuesta(Integer respuesta, Escenarios escenario, Stage primaryStage) {
		ConexionSql<Usuario> conexion = new ConexionSql<>();
		if (escenario.validarResultado(respuesta)) {
			usuario = conexion.findById("usuarios", "id", usuario.getId(), new UsuarioMapper());
			RespuestasView respuestasView = new RespuestasView();
			RespuestasController respuestasController = new RespuestasController(respuestasView, primaryStage, usuario);
			respuestasController.setRespuesta("Correcto!");
			respuestasView.start(primaryStage);
		} else {
			usuario = conexion.findById("usuarios", "id", usuario.getId(), new UsuarioMapper());
			RespuestasView respuestasView = new RespuestasView();
			RespuestasController respuestasController = new RespuestasController(respuestasView, primaryStage, usuario);
			respuestasController.setRespuesta("Incorrecto!");
			respuestasView.start(primaryStage);
		}

	}

	/**
	 * Obtiene el usuario actual.
	 * 
	 * @return el usuario actual
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Establece el usuario actual.
	 * 
	 * @param usuario el usuario a establecer
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
