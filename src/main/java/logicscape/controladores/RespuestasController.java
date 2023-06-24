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

	    ImageView imageViewMarciano;

	    // Escoger la imagen apropiada basada en si la rta es correcta
	    if (isCorrect) {
	        // Use the happy marciano image when the answer is correct
	        imageViewMarciano = new ImageView(new Image(getClass().getResource("/img/marciano.png").toExternalForm()));
	    } else {
	        // Usar el marciano triste en la imagen que la rta es incorrecta. 
	        imageViewMarciano = new ImageView(new Image(getClass().getResource("/img/sadmarciano.png").toExternalForm()));
	    }

	    imageViewMarciano.setFitWidth(100); // Set width
	    imageViewMarciano.setFitHeight(100); // Set height

	    // Create an ImageView for the new image and set its size
	    ImageView imageViewFondo2 = new ImageView(new Image(getClass().getResource("/img/fondo_2.png").toExternalForm()));
	    imageViewFondo2.setFitWidth(100); // Definir Ancho 
	    imageViewFondo2.setFitHeight(100); // Definir alto

	    // Crear un nodo de texto para el mensaje en una fuente mas grande
	    Text textNode = new Text(mensaje);
	    textNode.setStyle("-fx-font-size: 30px; -fx-fill: white;"); // Set the font size and color

	    // Crea un vbox que contenga la imagen y el mensaje 
	    VBox vbox = new VBox(imageViewMarciano, imageViewFondo2, textNode);
	    vbox.setAlignment(Pos.CENTER); // Center align the contents

	    //Poner el vbox y el contenido del dialogo de panel
	    dialogPane.setContent(vbox);

	    // Aplicar el estilo CSS
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
		System.out.println("Result: " + result); // Debug print 
		System.out.println("isCorrect: " + isCorrect); // Debug print 
		this.mostrarMensaje(result, isCorrect);
	}

}
