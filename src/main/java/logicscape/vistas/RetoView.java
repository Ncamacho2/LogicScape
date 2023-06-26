package logicscape.vistas;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logicscape.controladores.InicioController;
import logicscape.controladores.RetoController;
import logicscape.utilidades.Escenarios;

/**
 * Esta es una clase para la vista del Reto en la aplicación LogicScape.
 * Esta vista permite al usuario interactuar con la interfaz del Reto.
 */
public class RetoView extends Application {

	private static final int WIDTH = 1024;
	private static final int HEIGHT = 628;
	private static final int HEIGHTBUTTON = 100;
	private Button loginBtn;
	private Button inicioBtn;
	private RetoController retoController;
	private TextField ecuacionField;
	private TextField respuesta1Field;
	private TextField respuesta2Field;
	private TextField respuesta3Field;
	private TextField respuesta4Field;

	@Override
	public void start(Stage primaryStage) {
		// Configuración de la ventana principal
		primaryStage.setWidth(WIDTH);
		primaryStage.setHeight(HEIGHT);
		
		// Creación del contenedor principal
		BorderPane root = new BorderPane();
		
		// Creación del contenedor para los botones en la parte inferior
		HBox buttonContainer = new HBox();
		buttonContainer.setPadding(new Insets(20));
		buttonContainer.setSpacing(10);
		buttonContainer.setPrefHeight(HEIGHTBUTTON);
		buttonContainer.setStyle("-fx-background-color: #F9ED65;"); // Color de fondo blanco

		// Creación del contenedor para los campos de entrada
		GridPane inputContainer = new GridPane();
		inputContainer.setPadding(new Insets(85));
		inputContainer.setVgap(20);
		inputContainer.setAlignment(Pos.CENTER_RIGHT);

		ecuacionField = new TextField();
		respuesta1Field = new TextField();
		respuesta2Field = new TextField();
		respuesta3Field = new TextField();
		respuesta4Field = new TextField();

		// Generar una pregunta para el desafío
		Escenarios escenario = new Escenarios(new ArrayList<Integer>(), "", 0,
				retoController.getUsuario().getEscenarioActual(), retoController.getUsuario().getNivelActual(),
				retoController.getUsuario().getId());
		escenario.generarPregunta();

		Label ecuacionLabel = new Label(escenario.getPregunta());
		Button respuesta1Label = new Button(escenario.getOpciones().get(0).toString());
		Button respuesta2Label = new Button(escenario.getOpciones().get(1).toString());
		Button respuesta3Label = new Button(escenario.getOpciones().get(2).toString());
		Button respuesta4Label = new Button(escenario.getOpciones().get(3).toString());

		ecuacionLabel.getStyleClass().add("my-label");
		respuesta1Label.getStyleClass().add("my-label");
		respuesta2Label.getStyleClass().add("my-label");
		respuesta3Label.getStyleClass().add("my-label");
		respuesta4Label.getStyleClass().add("my-label");

		// Añadir etiquetas al contenedor de entrada
		inputContainer.add(ecuacionLabel, 0, 0);
		ecuacionLabel.getStyleClass().add("my-ecuacion");
		inputContainer.add(respuesta1Label, 1, 1);
		respuesta1Label.getStyleClass().add("my-respuesta");
		inputContainer.add(respuesta2Label, 2, 1);
		respuesta2Label.getStyleClass().add("my-respuesta");
		inputContainer.add(respuesta3Label, 1, 3);
		respuesta3Label.getStyleClass().add("my-respuesta");
		inputContainer.add(respuesta4Label, 2, 3);
		respuesta4Label.getStyleClass().add("my-respuesta");

		inicioBtn = new Button("Aceptar");
		loginBtn = new Button("Cancelar");

		// Agregar clases CSS a los botones
		loginBtn.getStyleClass().add("my-button");
		inicioBtn.getStyleClass().add("my-button");

		loginBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
		loginBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1));
		inicioBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
		inicioBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1));
		
		// Eventos al presionar los botones
		loginBtn.setOnAction(event -> {
			// Código para ejecutar cuando se presiona el botón de inicio de sesión
		});

		inicioBtn.setOnAction(event -> {
			// Abrir la vista de inicio cuando se presiona el botón de inicio
			InicioView inicioView = new InicioView();
			InicioController inicioControler = new InicioController(inicioView);
			inicioView.start(primaryStage);
		});
		
		// Configurar la acción cuando se hace clic en cada botón de respuesta
		respuesta1Label.setOnAction(event -> {
			String respuestaStr = respuesta1Label.getText();
			Integer respuesta = Integer.parseInt(respuestaStr);
			retoController.validarRespuesta(respuesta, escenario, primaryStage);
		});
		respuesta2Label.setOnAction(event -> {
			String respuestaStr = respuesta2Label.getText();
			Integer respuesta = Integer.parseInt(respuestaStr);
			retoController.validarRespuesta(respuesta, escenario, primaryStage);
		});
		respuesta3Label.setOnAction(event -> {
			String respuestaStr = respuesta3Label.getText();
			Integer respuesta = Integer.parseInt(respuestaStr);
			retoController.validarRespuesta(respuesta, escenario, primaryStage);
		});
		respuesta4Label.setOnAction(event -> {
			String respuestaStr = respuesta4Label.getText();
			Integer respuesta = Integer.parseInt(respuestaStr);
			retoController.validarRespuesta(respuesta, escenario, primaryStage);
		});

		// Establecer el fondo para el registro
		Image backgroundImage = new Image(getClass().getResource("/img/reto.png").toExternalForm());
		ImageView backgroundImageView = new ImageView(backgroundImage);
		backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
		backgroundImageView.fitHeightProperty()
				.bind(primaryStage.heightProperty().subtract(buttonContainer.heightProperty()));
		root.getChildren().add(backgroundImageView);

		// Agregar los contenedores al contenedor principal
		root.setCenter(inputContainer);

		Scene scene = new Scene(root, 800, 500);
		Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 12);
		
		// Agregar una hoja de estilos CSS
		scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

		primaryStage.setTitle("Logic Scape - Reto");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Configurar el RetoController para esta vista.
	 * @param retoController el RetoController a establecer
	 */
	public void setRetoController(RetoController retoController) {
		this.retoController = retoController;
	}

	/**
	 * Configura el escenario para esta vista. 
	 * Este método lanza una excepción UnsupportedOperationException 
	 * ya que no está implementado aún.
	 * 
	 * @param primaryStage el Stage a configurar
	 */
	void setStage(Stage primaryStage) {
		throw new UnsupportedOperationException("Operación no soportada aún.");
	}

}
