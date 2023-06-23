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

public class JugarView extends Application {
	private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final int HEIGHTBUTTON = 100;
    private Button jugarBtn;
    private Button salirBtn;
    private Button infoBtn;
    private JugarController jugarController;


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
        Image backgroundImage = new Image("file:src/main/resources/img/nivel_final.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty()
                .bind(primaryStage.heightProperty().subtract(buttonContainer.heightProperty()));
        root.getChildren().add(backgroundImageView);

        jugarBtn = new Button("JUGAR");
        salirBtn = new Button("SALIR");
        infoBtn = new Button("Info");
  

        // Agregar clases CSS a los botones
        jugarBtn.getStyleClass().add("my-button3");
        salirBtn.getStyleClass().add("my-button2");
        infoBtn.getStyleClass().add("my-button2");


        jugarBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        jugarBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1.5));
        salirBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        salirBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        infoBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        infoBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        
        jugarBtn.setOnAction(event -> {
            NivelView nivelView = new NivelView();
            logicscape.controladores.NivelController nivelController = new logicscape.controladores.NivelController(nivelView);
            nivelView.start(primaryStage);
        });
        
        
        infoBtn.setOnAction(event -> {
            InfoView infoView = new InfoView();
            InfoController infoController = new InfoController(infoView);
            infoView.start(primaryStage);
        });
        
        
        //Boton de salida
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
        scene.getStylesheets().add("file:src/main/resources/css/application.css");

        primaryStage.setTitle("Logic Scape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param jugarController the jugarController to set
     */
    public void setJugarController(JugarController jugarController) {
        this.jugarController = jugarController;
    }

    void setStage(Stage primaryStag) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
