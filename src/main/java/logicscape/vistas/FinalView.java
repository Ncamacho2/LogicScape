package logicscape.vistas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import logicscape.controladores.FinalController;

/**
 * La clase FinalView representa la vista de la pantalla de final del
 * juego.
 */public class FinalView extends Application {
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 628;
	private static final String BACKGROUND_SUCCESS = "/img/registro.png";
	private static final String BACKGROUND_FAIL = "/img/nivel_final.png";
	private static final String FONT_PATH = "/font/PressStart2P-Regular.ttf";
	private static final String MESSAGE_STYLE = "-fx-padding: 20px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 30px; -fx-background-radius: 30px;";
	private FinalController finalController;
	private boolean lograEscapar;

	/**
	 * Construye un nuevo objeto FinalView con la condición de logro de escape
	 * especificada.
	 * 
	 * @param lograEscapar true si el jugador logra escapar, false en caso
	 *                     contrario.
	 */
	public FinalView(boolean lograEscapar) {
		this.lograEscapar = lograEscapar;
	}

	@Override
	public void start(Stage primaryStage) {
		// Configuración de la ventana principal
		primaryStage.setWidth(WIDTH);
		primaryStage.setHeight(HEIGHT);

		// Creación del contenedor principal
		BorderPane root = new BorderPane();

		// Creación del ImageView para la imagen de fondo
		Image backgroundImage = new Image(
				getClass().getResource(lograEscapar ? BACKGROUND_SUCCESS : BACKGROUND_FAIL).toExternalForm());
		ImageView backgroundImageView = new ImageView(backgroundImage);
		backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
		backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());
		root.getChildren().add(backgroundImageView);

		// Creación del contenedor para el mensaje
		StackPane messageContainer = new StackPane();
		Label messageLabel = new Label(lograEscapar ? "¡Felicidades\nLograste escapar!" : "Game Over\n Buen intento");
		messageLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 48));
		messageLabel.setTextFill(Color.WHITE);
		// Estilos del mensaje + condicional para cambiar el color de fondo según el
		// resultado
		messageLabel.setStyle(MESSAGE_STYLE + "-fx-background-color:" + (lograEscapar ? "#00CB6D;" : "#ff3535"));
		messageLabel.setTextAlignment(TextAlignment.CENTER);
		messageContainer.getChildren().add(messageLabel);
		messageContainer.setAlignment(Pos.CENTER);

		root.setCenter(messageContainer);

		// Creación de los botones
		Button jugarDeNuevoBtn = new Button("Jugar de nuevo");
		Button salirBtn = new Button("Salir");

		// Metodos botones
		jugarDeNuevoBtn.setOnAction(event -> {
			finalController.jugardeNuevo(primaryStage);
		});

		salirBtn.setOnAction(event -> {
			System.exit(0);
		});

		// Estilos de los botones
		jugarDeNuevoBtn.getStyleClass().add("my-button");
		salirBtn.getStyleClass().add("my-button");

		// Contenedor para los botones
		HBox buttonContainer = new HBox(10);
		buttonContainer.getChildren().addAll(jugarDeNuevoBtn, salirBtn);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setStyle("-fx-background-color: #F9ED65; -fx-padding: 20px;");

		root.setBottom(buttonContainer);

		Scene scene = new Scene(root, WIDTH, HEIGHT);

		// Agregar una hoja de estilos CSS
		scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

		primaryStage.setTitle("Logic Scape");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Establece el controlador finalController para esta vista.
	 * 
	 * @param finalController El controlador FinalController a establecer.
	 */
	public void setFinalController(FinalController finalController) {
		this.finalController = finalController;
	}

	// Método no implementado, se debe implementar correctamente si se va a
	// utilizar.
	void setStage(Stage primaryStag) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
