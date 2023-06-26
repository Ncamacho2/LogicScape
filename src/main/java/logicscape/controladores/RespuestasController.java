package logicscape.controladores;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logicscape.modelos.Usuario;
import logicscape.vistas.NivelView;
import logicscape.vistas.RespuestasView;

/**
 * Controlador para la vista de Respuestas en la aplicación LogicScape. Permite
 * controlar la lógica y las interacciones en la vista de Respuestas.
 */
public class RespuestasController {

	// Declaración de variables privadas
	private RespuestasView respuestasView;
	private Stage stage;
	private String respuesta;
	private Usuario usuario;

	/**
	 * Crea una instancia de RespuestasController.
	 *
	 * @param respuestasView la vista de Respuestas
	 * @param stage          el Stage principal de la aplicación
	 * @param usuario        el usuario actual
	 */
	public RespuestasController(RespuestasView respuestasView, Stage stage, Usuario usuario) {
		this.respuestasView = respuestasView;
		this.usuario = usuario;
		this.stage = stage;

		// Establecer el controlador de respuestas en respuestasView
		this.respuestasView.setRespuestasController(this);
	}

	/**
	 * Establece la respuesta.
	 *
	 * @param respuesta la respuesta a establecer
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Obtiene la respuesta actual.
	 *
	 * @return la respuesta actual
	 */
	public String getRespuesta() {
		return this.respuesta;
	}

	/**
	 * Muestra un mensaje de alerta con una imagen y un mensaje basado en si la
	 * respuesta es correcta o no.
	 *
	 * @param mensaje   el mensaje a mostrar
	 * @param isCorrect indica si la respuesta es correcta o no
	 */
	private void mostrarMensaje(String mensaje, boolean isCorrect) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Resultado");
		alert.setHeaderText(null);

		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.setPrefSize(600, 400);

		ImageView imageViewMarciano;

		if (isCorrect) {
			imageViewMarciano = new ImageView(new Image(getClass().getResource("/img/marciano.png").toExternalForm()));
		} else {
			imageViewMarciano = new ImageView(
					new Image(getClass().getResource("/img/sadmarciano.png").toExternalForm()));
		}

		imageViewMarciano.setFitWidth(100);
		imageViewMarciano.setFitHeight(100);

		ImageView imageViewFondo2 = new ImageView(
				new Image(getClass().getResource("/img/fondo_2.png").toExternalForm()));
		imageViewFondo2.setFitWidth(100);
		imageViewFondo2.setFitHeight(100);

		Text textNode = new Text(mensaje);
		textNode.setStyle("-fx-font-size: 30px; -fx-fill: white;");

		VBox vbox = new VBox(imageViewFondo2, imageViewMarciano, textNode);
		vbox.setAlignment(Pos.CENTER);

		dialogPane.setContent(vbox);

		if (isCorrect) {
			dialogPane.setStyle("-fx-background-color: green;");
		} else {
			dialogPane.setStyle("-fx-background-color: red;");
		}

		alert.showAndWait();
	}

	/**
	 * Inicia el controlador, muestra un mensaje y carga la vista del nivel.
	 */
	public void iniciar() {
		if (respuesta != null) {
			boolean isCorrect = respuesta.equals("Correcto!");
			System.out.println("Respuesta: " + respuesta);
			System.out.println("isCorrect: " + isCorrect);
			this.mostrarMensaje(respuesta, isCorrect);
			NivelView nivelView = new NivelView();
			new NivelController(nivelView, usuario, 0);
			nivelView.start(stage);
		}
	}

	/**
	 * Muestra el resultado en la vista.
	 *
	 * @param result el resultado a mostrar
	 */
	public void displayResult(String result) {
		boolean isCorrect = result.equals("Correcto!");
		System.out.println("Result: " + result);
		System.out.println("isCorrect: " + isCorrect);
		this.mostrarMensaje(result, isCorrect);
	}
}
