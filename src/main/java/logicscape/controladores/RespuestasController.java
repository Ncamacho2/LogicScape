package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import logicscape.modelos.Usuario;
import logicscape.vistas.JugarView;
import logicscape.vistas.NivelView;
import logicscape.vistas.RespuestasView;
import javafx.scene.control.DialogPane;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class RespuestasController {

	private RespuestasView respuestasView;
	private Stage stage;
	private String respuesta;
	private Usuario usuario;

	public RespuestasController(RespuestasView respuestasView, Stage stage, Usuario usuario) {
		this.respuestasView = respuestasView;
		this.usuario = usuario;
		this.stage = stage;

		this.respuestasView.setRespuestasController(this);
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	private void mostrarMensaje(String mensaje, boolean isCorrect) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ventana emergente");
		alert.setHeaderText(null); // Remove header text

		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.setPrefSize(600, 400); // Set preferred size for dialogPane

		// Create an ImageView for the image and set its size
		ImageView imageView = new ImageView(new Image("file:src/main/resources/img/marciano.png"));
		imageView.setFitWidth(100); // Set width
		imageView.setFitHeight(100); // Set height

		// Create a Text node for the message with larger font size
		Text textNode = new Text(mensaje);
		textNode.setStyle("-fx-font-size: 30px; -fx-fill: white;"); // Set the font size and color

		// Create a VBox to hold the image and the message
		VBox vbox = new VBox(imageView, textNode);
		vbox.setAlignment(Pos.CENTER); // Center align the contents

		// Set the vbox as the content of the DialogPane
		dialogPane.setContent(vbox);

		// Apply the CSS styles
		if (isCorrect) {
			dialogPane.setStyle("-fx-background-color: green;");
		} else {
			dialogPane.setStyle("-fx-background-color: red;");
		}

		alert.showAndWait();
	}

	public void iniciar() {
		if (respuesta != null) {
			boolean isCorrect = respuesta.equals("Correcto!"); // "Correcto!" means the answer is correct
			System.out.println("Respuesta: " + respuesta); // Debug print statement
			System.out.println("isCorrect: " + isCorrect); // Debug print statement
			this.mostrarMensaje(respuesta, isCorrect);
			NivelView nivelView = new NivelView();
			NivelController nivelController = new NivelController(nivelView, usuario, 0);
			nivelView.start(stage);
		}
	}

	public void displayResult(String result) {
		boolean isCorrect = result.equals("Correcto!");
		System.out.println("Result: " + result); // Debug print statement
		System.out.println("isCorrect: " + isCorrect); // Debug print statement
		this.mostrarMensaje(result, isCorrect);
	}

}
