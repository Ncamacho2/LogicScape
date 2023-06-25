package logicscape.vistas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logicscape.controladores.InicioController;
import logicscape.controladores.LoginController;
import logicscape.controladores.RegistroController;

/**
 * La clase InicioView es una aplicación de JavaFX que representa la vista de la interfaz de inicio de la aplicación Logic Scape.
 */
public class InicioView extends Application {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final int HEIGHTBUTTON = 100;
    private Button inicioBtn;
    private Button registroBtn;
    private InicioController inicioController;

    /**
     * El método start es llamado cuando se inicia la aplicación y muestra la interfaz de inicio.
     *
     * @param primaryStage el escenario principal de JavaFX
     */
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

        // Creación del ImageView para la imagen de fondo
        Image backgroundImage = new Image(getClass().getResource("/img/nivel_final.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty()
                .bind(primaryStage.heightProperty().subtract(buttonContainer.heightProperty()));
        root.getChildren().add(backgroundImageView);

        // Creación de los botones
        inicioBtn = new Button("Ingresa");
        registroBtn = new Button("Registro");

        // Agregar clases CSS a los botones
        inicioBtn.getStyleClass().add("my-button");
        registroBtn.getStyleClass().add("my-button");

        // Asignar dimensiones de los botones
        inicioBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        inicioBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        registroBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        registroBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));

        // Acción del botón "Ingresa"
        inicioBtn.setOnAction(event -> {
            inicioController.handleButtonClick(inicioBtn.getText(), primaryStage);
        });

        // Acción del botón "Registro"
        registroBtn.setOnAction(event -> {
            inicioController.handleButtonClick(registroBtn.getText(), primaryStage);
        });

        // Agregar los botones al contenedor
        buttonContainer.getChildren().addAll(inicioBtn, registroBtn);

        // Agregar el contenedor de botones al contenedor principal
        root.setBottom(buttonContainer);

        // Crear la escena y configurar estilos
        Scene scene = new Scene(root, 1024, 628);
        Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 12);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

        // Configurar el escenario principal
        primaryStage.setTitle("Logic Scape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Establece el controlador de inicio.
     *
     * @param inicioController el controlador de inicio a establecer
     */
    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    /**
     * Establece el escenario principal.
     *
     * @param primaryStage el escenario principal a establecer
     */
    void setStage(Stage primaryStage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
