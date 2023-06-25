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
import logicscape.controladores.LoginController;

/**
 * La clase LoginView es una aplicación de JavaFX que representa la vista de inicio de sesión de la aplicación Logic Scape.
 */
public class LoginView extends Application {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final int HEIGHTBUTTON = 100;
    private Button loginBtn;
    private Button inicioBtn;
    private LoginController loginController;
    private TextField usuarioField;
    private PasswordField contraseniaField;

    /**
     * El método start es llamado cuando se inicia la aplicación y muestra la interfaz de inicio de sesión.
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

        // Creación del contenedor para los campos de entrada
        GridPane inputContainer = new GridPane();
        inputContainer.setPadding(new Insets(50));
        inputContainer.setVgap(20);
        inputContainer.setAlignment(Pos.CENTER);

        usuarioField = new TextField();
        contraseniaField = new PasswordField();

        Label usuarioLabel = new Label("Usuario:");
        Label contraseniaLabel = new Label("Contraseña:");

        usuarioLabel.getStyleClass().add("my-label");
        contraseniaLabel.getStyleClass().add("my-label");
        usuarioLabel.setTextFill(Color.WHITE);
        contraseniaLabel.setTextFill(Color.WHITE);
        usuarioLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 16));
        contraseniaLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 16));

        // Agregar estilo CSS personalizado a las etiquetas
        usuarioLabel.getStyleClass().add("my-registro");
        contraseniaLabel.getStyleClass().add("my-registro");

        usuarioLabel.setPadding(new Insets(10));
        contraseniaLabel.setPadding(new Insets(10));

        inputContainer.add(usuarioLabel, 0, 0);
        inputContainer.add(usuarioField, 1, 0);
        inputContainer.add(contraseniaLabel, 0, 1);
        inputContainer.add(contraseniaField, 1, 1);

        // Creación de los botones
        inicioBtn = new Button("Volver");
        loginBtn = new Button("Login");

        // Agregar clases CSS a los botones
        inicioBtn.getStyleClass().add("my-button");
        loginBtn.getStyleClass().add("my-button");

        // Asignar propiedades de tamaño a los botones
        inicioBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        inicioBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        loginBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        loginBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));

        // Acción del botón "Volver"
        inicioBtn.setOnAction(event -> {
            loginController.handleCancelar(primaryStage);
        });

        // Acción del botón "Login"
        loginBtn.setOnAction(event -> {
            loginController.handleLogin(usuarioField.getText(), contraseniaField.getText(), primaryStage);
        });

        // Agregar los botones al contenedor
        buttonContainer.getChildren().addAll(inicioBtn, loginBtn);

        // Creación del ImageView para la imagen de fondo
        Image backgroundImage = new Image(getClass().getResource("/img/registro.png").toExternalForm());
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
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

        primaryStage.setTitle("Logic Scape - Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Establece el controlador de inicio de sesión para esta vista.
     *
     * @param loginController El controlador de inicio de sesión.
     */
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    /**
     * Establece el stage de la vista.
     *
     * @param primaryStage El stage principal.
     */
    void setStage(Stage primaryStage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
