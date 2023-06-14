package logicscape.vistas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logicscape.controladores.InicioController;
import logicscape.controladores.RegistroController;

public class RegistroView extends Application {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final int HEIGHTBUTTON = 100;
    private Button loginBtn;
    private Button inicioBtn;
    private RegistroController registroController;
    private TextField nombreField;
    private TextField apellidoField;
    private TextField edadField;
    private TextField userField;
    private PasswordField passwordField;
    private PasswordField validarPassField;


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
        inputContainer.setAlignment(Pos.CENTER_LEFT);

        nombreField = new TextField();
        apellidoField = new TextField();
        edadField = new TextField();
        userField = new TextField();
        passwordField = new PasswordField();
        validarPassField = new PasswordField();
   

        Label nombreLabel = new Label("Nombre:");
        Label apellidoLabel = new Label("Apellido:");
        Label edadLabel = new Label("Edad:");
        Label userLabel = new Label("Ususario:");
        Label passwordLabel = new Label("Nueva Contraseña:");
        Label validarPassLabel = new Label("Validar Contraseña:");
      

        nombreLabel.getStyleClass().add("my-label");
        apellidoLabel.getStyleClass().add("my-label");
        edadLabel.getStyleClass().add("my-label");
        userLabel.getStyleClass().add("my-label");
        passwordLabel.getStyleClass().add("my-label");
        validarPassLabel.getStyleClass().add("my-label");
        
        inputContainer.add(nombreLabel, 0,0);
        nombreLabel.getStyleClass().add("my-registro");
        inputContainer.add(nombreField, 1, 0);
        nombreField.getStyleClass().add("my-registro");
        inputContainer.add(apellidoLabel, 0, 1);
        apellidoLabel.getStyleClass().add("my-registro");
        inputContainer.add(apellidoField, 1, 1);
        apellidoField.getStyleClass().add("my-registro");
        inputContainer.add(edadLabel, 0, 2);
        edadLabel.getStyleClass().add("my-registro");
        inputContainer.add(edadField, 1, 2);
        edadField.getStyleClass().add("my-registro");
        inputContainer.add(userLabel, 0,3);
        userLabel.getStyleClass().add("my-registro");
        inputContainer.add(userField, 1, 3);
        userField.getStyleClass().add("my-registro");
        inputContainer.add(passwordLabel, 0, 4);
        passwordLabel.getStyleClass().add("my-registro");
        inputContainer.add(passwordField, 1, 4);
        passwordField.getStyleClass().add("my-registro");
        inputContainer.add(validarPassLabel, 0, 5);
        validarPassLabel.getStyleClass().add("my-registro");
        inputContainer.add(validarPassField, 1, 5);
        validarPassField.getStyleClass().add("my-registro");     
        

        inicioBtn = new Button("Aceptar");
        loginBtn = new Button("Cancelar");

        // Agregar clases CSS a los botones
        loginBtn.getStyleClass().add("my-button");
        inicioBtn.getStyleClass().add("my-button");

        loginBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        loginBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        inicioBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        inicioBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        loginBtn.setOnAction(event -> {

        });
        loginBtn.setOnAction(event -> {
            InicioView inicioView = new InicioView();
            InicioController inicioControler = new InicioController(inicioView);
            inicioView.start(primaryStage);
        });
        
        inicioBtn.setOnAction(event -> {
           LoginView loginView = new LoginView();
           logicscape.controladores.LoginController loginControler = new logicscape.controladores.LoginController(loginView);
           loginView.start(primaryStage);
        });

        // Agregar los botones al contenedor
        buttonContainer.getChildren().addAll(inicioBtn, loginBtn);

        // Establecer el fondo para el registro
        Image backgroundImage = new Image("file:src/main/resources/img/registro.png");
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
        scene.getStylesheets().add("file:src/main/resources/css/application.css");

        primaryStage.setTitle("Logic Scape - Registro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	/**
	 * @param registroController the registroController to set
	 */
	public void setRegistroController(RegistroController registroController) {
		this.registroController = registroController;
	}

	void setStage(Stage primaryStage) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
