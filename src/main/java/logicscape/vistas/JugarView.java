package logicscape.vistas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logicscape.controladores.InfoController;
import logicscape.controladores.InicioController;
import logicscape.controladores.JugarController;
import logicscape.controladores.LoginController;
import logicscape.controladores.NivelController;

/**
 * La clase JugarView es una aplicación de JavaFX que representa la vista de la interfaz de juego de la aplicación Logic Scape.
 */
public class JugarView extends Application {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final int HEIGHTBUTTON = 100;
    private Button jugarBtn;
    private Button salirBtn;
    private Button infoBtn;
    private JugarController jugarController;

    /**
     * El método start es llamado cuando se inicia la aplicación y muestra la interfaz de juego.
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
        jugarBtn = new Button("JUGAR");
        salirBtn = new Button("SALIR");
        infoBtn = new Button("Info");

        // Agregar clases CSS a los botones
        jugarBtn.getStyleClass().add("my-button");
        salirBtn.getStyleClass().add("my-button2");
        infoBtn.getStyleClass().add("my-button3");

        // Asignar dimensiones de los botones
        jugarBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        jugarBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1.5));
        salirBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        salirBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        infoBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        infoBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));

        // Acción del botón "JUGAR"
        jugarBtn.setOnAction(event -> {
            jugarController.handleButtonClick(jugarBtn.getText(), primaryStage);
        });

        // Acción del botón "Info"
        infoBtn.setOnAction(event -> {
            jugarController.handleButtonClick(infoBtn.getText(), primaryStage);
        });

        // Acción del botón "SALIR"
        salirBtn.setOnAction(event -> {
            System.exit(0);
        });

        // Agregar los botones al contenedor
        buttonContainer.getChildren().addAll(jugarBtn, salirBtn, infoBtn);

        // Agregar el contenedor de botones al contenedor principal
        root.setBottom(buttonContainer);

        Scene scene = new Scene(root, 1024, 628);
        Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 12);
        // Agregar una hoja de estilos CSS
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

        primaryStage.setTitle("Logic Scape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Establece el controlador de juego.
     *
     * @param jugarController el controlador de juego a establecer
     */
    public void setJugarController(JugarController jugarController) {
        this.jugarController = jugarController;
    }

    /**
     * Establece el escenario principal.
     *
     * @param primaryStage el escenario principal a establecer
     */
    void setStage(Stage primaryStag) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
