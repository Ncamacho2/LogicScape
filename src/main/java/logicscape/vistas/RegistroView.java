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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logicscape.controladores.RegistroController;

public class RegistroView extends Application {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final int HEIGHTBUTTON = 100;
    private Button aceptarBtn;
    private Button cancelarBtn;
    private RegistroController registroController;
    private TextField userField;
    private PasswordField passwordField;

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

        // Creación del contenedor para los campos de entrada
        GridPane inputContainer = new GridPane();
        inputContainer.setPadding(new Insets(50));
        inputContainer.setVgap(20);
        inputContainer.setAlignment(Pos.CENTER);

        // Creación de los elementos gráficos
        userField = new TextField();
        passwordField = new PasswordField();
        Label userLabel = new Label("Usuario:");
        Label passwordLabel = new Label("Contraseña:");

        userLabel.getStyleClass().add("my-label");
        passwordLabel.getStyleClass().add("my-label");
        userLabel.setTextFill(Color.WHITE);
        passwordLabel.setTextFill(Color.WHITE);
        userLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 16));
        passwordLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 16));

        // Agregar estilo CSS personalizado a las etiquetas
        userLabel.getStyleClass().add("my-registro");
        passwordLabel.getStyleClass().add("my-registro");

        userLabel.setPadding(new Insets(10));
        passwordLabel.setPadding(new Insets(10));

        // Agregar los elementos gráficos al contenedor
        inputContainer.add(userLabel, 0, 3);
        inputContainer.add(userField, 1, 3);
        inputContainer.add(passwordLabel, 0, 4);
        inputContainer.add(passwordField, 1, 4);

        // Creación de los botones
        aceptarBtn = new Button("Aceptar");
        cancelarBtn = new Button("Volver");

        // Agregar clases CSS a los botones
        cancelarBtn.getStyleClass().add("my-button");
        aceptarBtn.getStyleClass().add("my-button");

        // Establecer propiedades de tamaño de los botones
        cancelarBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        cancelarBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        aceptarBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        aceptarBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));

        // Acción al hacer clic en el botón "Aceptar"
        aceptarBtn.setOnAction(event -> {
            registroController.handleRegistro(userField.getText(), passwordField.getText(), primaryStage);
        });

        // Acción al hacer clic en el botón "Cancelar"
        cancelarBtn.setOnAction(event -> {
            registroController.handleCancelar(primaryStage);
        });

        // Agregar los botones al contenedor
        buttonContainer.getChildren().addAll( cancelarBtn, aceptarBtn);

        // Establecer el fondo para el registro
        Image backgroundImage = new Image("img/registro.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty()
                .bind(primaryStage.heightProperty().subtract(buttonContainer.heightProperty()));
        root.getChildren().add(backgroundImageView);

        // Agregar los contenedores al contenedor principal
        root.setCenter(inputContainer);
        root.setBottom(buttonContainer);

        Scene scene = new Scene(root, 1024, 628);
        Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 12);

        // Agregar una hoja de estilos CSS
        scene.getStylesheets().add("css/application.css");

        primaryStage.setTitle("Logic Scape - Registro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Establece el controlador del registro.
     *
     * @param registroController El controlador del registro.
     */
    public void setRegistroController(RegistroController registroController) {
        this.registroController = registroController;
    }

    /**
     * Establece el `Stage` de la ventana principal.
     *
     * @param primaryStage el `Stage` principal de la aplicación
     */
    void setStage(Stage primaryStage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
