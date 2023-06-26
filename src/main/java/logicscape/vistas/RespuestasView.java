package logicscape.vistas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logicscape.controladores.RespuestasController;

/**
 * Clase que representa la vista de las respuestas.
 */
public class RespuestasView extends Application {

	// Definir variables privadas que se utilizar�n en la clase
	private RespuestasController respuestasController;
	private Label answerLabel;
	private Scene scene;
	private StackPane layout;

	@Override
	public void start(Stage primaryStage) {
		// Crear una etiqueta para contener la respuesta
		answerLabel = new Label();

		// Crear un layout y agregar la etiqueta de respuesta a l
		layout = new StackPane();
		layout.getChildren().add(answerLabel);

		// Crear una escena con el layout definido y las dimensiones
		scene = new Scene(layout, 300, 200);

		// Agregar una hoja de estilos CSS a la escena
		scene.getStylesheets().add("file:src/main/resources/css/application2.css");

		// Establecer la escena creada en el primaryStage y mostrarla
		primaryStage.setScene(scene);
		primaryStage.show();

		// Inicializar el controlador después de crear los componentes
		if (respuestasController != null) {
			// Usar la respuesta creada en el setter del controlador
			respuestasController.setRespuesta(respuestasController.getRespuesta());
			respuestasController.iniciar();
		}
	}

	/**
	 * Obtiene la escena de la vista.
	 *
	 * @return La escena de la vista.
	 */
	public Scene getScene() {
		return this.scene;
	}

	/**
	 * Establece el controlador de respuestas.
	 *
	 * @param respuestasController El controlador de respuestas.
	 */
	public void setRespuestasController(RespuestasController respuestasController) {
		this.respuestasController = respuestasController;
	}

	/**
	 * Método para establecer la respuesta y su corrección
	 * 
	 * @param answer    la respuesta a establecer
	 * @param isCorrect si la respuesta es correcta o no
	 */
	public void setAnswer(String answer, boolean isCorrect) {
		// Establecer el texto de answerLabel a la respuesta proporcionada
		answerLabel.setText(answer);

		// Dependiendo de la corrección de la respuesta, cambie el color de fondo del
		// layout
		if (isCorrect) {
			layout.getStyleClass().add("green-background");
		} else {
			layout.getStyleClass().add("red-background");
		}
	}
}
