package logicscape.vistas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logicscape.controladores.InfoController;

/**
 * La clase InfoView representa la vista de la pantalla de información del
 * juego. Muestra la información sobre los creadores del juego y el grupo.
 */
public class InfoView extends Application {
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 628;
	private static final int HEIGHTBUTTON = 100;
	private Button backBtn;
	private InfoController infoController;

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
		buttonContainer.setSpacing(50);
		buttonContainer.setPrefHeight(HEIGHTBUTTON);
		buttonContainer.setStyle("-fx-background-color: #F9ED65;"); // Color de fondo blanco

		// Creación del contenedor del texto
		HBox infoContainer = new HBox();
		infoContainer.setMinWidth(500);
		infoContainer.setMaxWidth(700);
		infoContainer.setMinHeight(300);
		infoContainer.setMaxHeight(400);
		infoContainer.setStyle("-fx-background-color: #F9ED65;"); // Color de fondo blanco
		infoContainer.setAlignment(Pos.CENTER); // Alineación central

		StackPane stackPane = new StackPane();
		stackPane.setAlignment(Pos.CENTER);

		// Texto de la información
		Label label = new Label(" JUEGO CREADO POR:\n\n" + "-LUIS FELIPE AYALA FERNANDEZ \n"
				+ "-NICOLAS BELTRAN VARGAS \n" + "-SANTIAGO BETANCUR VILLEGAS \n" + "-NELSON ALONSO CAMACHO CAMACHO \n"
				+ "-SANTIAGO TOMAS SUAREZ PINZON \n\n" + " PPBO1 - GRUPO 14 \n\n" + " 2023");
		stackPane.getChildren().add(label);

		infoContainer.getChildren().add(stackPane);

		// Creación del ImageView para la imagen de fondo
		Image backgroundImage = new Image(getClass().getResource("/img/nivel_final.png").toExternalForm());
		ImageView backgroundImageView = new ImageView(backgroundImage);
		backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
		backgroundImageView.fitHeightProperty()
				.bind(primaryStage.heightProperty().subtract(buttonContainer.heightProperty()));
		root.getChildren().add(backgroundImageView);

		// Creación de ventana info
		HBox textboxContainer = new HBox();
		textboxContainer.setPadding(new Insets(20));
		textboxContainer.setSpacing(50);
		textboxContainer.setPrefHeight(HEIGHTBUTTON);
		textboxContainer.setStyle("-fx-background-color: #F9ED65;"); // Color de fondo blanco

		backBtn = new Button("Volver");

		// Agregar clases CSS a los elementos
		backBtn.getStyleClass().add("my-button");
		label.getStyleClass().add("my-texto");

		backBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
		backBtn.prefWidthProperty().bind(primaryStage.widthProperty());

		// Accion del botón volver
		backBtn.setOnAction(event -> {
			infoController.handleButtonClick(primaryStage);
		});

		// Agregar los botones al contenedor
		buttonContainer.getChildren().addAll(backBtn);

		// Agregar el contenedor de botones al contenedor principal
		root.setBottom(buttonContainer);
		root.setCenter(infoContainer);

		Scene scene = new Scene(root, 1024, 628);
		Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 12);

		// Agregar una hoja de estilos CSS
		scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

		primaryStage.setTitle("Logic Scape");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Establece el controlador de información de la vista.
	 *
	 * @param infoController el controlador de información a establecer
	 */
	public void setInfoController(InfoController infoController) {
		this.infoController = infoController;
	}

	void setStage(Stage primaryStag) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
