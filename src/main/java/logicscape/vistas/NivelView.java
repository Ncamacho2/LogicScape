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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import logicscape.controladores.InfoController;
import logicscape.controladores.InicioController;
import logicscape.controladores.JugarController;
import logicscape.controladores.LoginController;
import logicscape.controladores.NivelController;
import logicscape.utilidades.Live;
import logicscape.utilidades.Marciano;
import logicscape.utilidades.Nivel;

import java.util.concurrent.TimeUnit;


public class NivelView extends Application {
	private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final int HEIGHTBUTTON = 100;
    private Button iniciarBtn;
    private Button backBtn;
    private NivelController nivelController;
    private Live live;
    private static final String RUTA_IMAGEN = "/img/estrella_uno.png";
    private Nivel nivel;
    private static final String RUTA_IMAGEN2 = "/img/suma.png";
    private Marciano marciano;
    private static final String RUTA_MARCIANO = "/img/marciano.png";



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
        
        //Contenedor de la barra de vidas
        
        HBox livesContainer = new HBox();
        livesContainer.setPadding(new Insets(20));
        livesContainer.setSpacing(50);
        livesContainer.setPrefHeight(HEIGHTBUTTON);
        //livesContainer.setStyle("-fx-background-color: #F9ED65;");

        // Creación del ImageView para la imagen de fondo
        Image backgroundImage = new Image("file:src/main/resources/img/fondo_escenario.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty()
                .bind(primaryStage.heightProperty().subtract(buttonContainer.heightProperty()));
        root.getChildren().add(backgroundImageView);

        iniciarBtn = new Button("Iniciar");
        backBtn = new Button("Volver");
        nivel = new Nivel(RUTA_IMAGEN2);
        live = new Live(RUTA_IMAGEN);
        Live live2 = new Live(RUTA_IMAGEN);
        Live live3 = new Live(RUTA_IMAGEN);
        marciano = new Marciano(RUTA_MARCIANO);
        Marciano marciano2 = new Marciano(RUTA_MARCIANO);
        Marciano marciano3 = new Marciano(RUTA_MARCIANO);
        
        ImageView liveView = live.getImagen();
        ImageView imageView2 = nivel.getImagen();
        ImageView marciano1 = marciano.getImagen();
        
        double nuevaPosicionX = 120;  // Nueva coordenada X
        double nuevaPosicionY = 240;  // Nueva coordenada Y
        marciano1.setLayoutX(nuevaPosicionX);
        marciano1.setLayoutY(nuevaPosicionY);
        
     // Establecer las coordenadas de cada instancia
        double posicionX1 = 410;  // Coordenada X para la primera instancia
        double posicionY1 = 165;  // Coordenada Y para la primera instancia
        marciano2.getImagen().setLayoutX(posicionX1);
        marciano2.getImagen().setLayoutY(posicionY1);
        
        // Establecer las coordenadas de cada instancia
        double posicionX2 = 700;  // Coordenada X para la primera instancia
        double posicionY2 = 95;  // Coordenada Y para la primera instancia
        marciano3.getImagen().setLayoutX(posicionX2);
        marciano3.getImagen().setLayoutY(posicionY2);
        

        // Agregar clases CSS a los botones
        iniciarBtn.getStyleClass().add("my-button");
        backBtn.getStyleClass().add("my-button");

       
        iniciarBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        iniciarBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1.7));
        backBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        backBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1.7));

 

        //Boton de iniciar pregunta
        iniciarBtn.setOnAction(event -> {
            RetoView retoView = new RetoView();
            logicscape.controladores.RetoController retoController = new logicscape.controladores.RetoController(retoView);
            retoView.start(primaryStage);
        });
     
            
        //Boton de regreso
        backBtn.setOnAction(event -> {
            JugarView jugarView = new JugarView();
            JugarController jugarController = new JugarController(jugarView);
            jugarView.start(primaryStage);
        });

        // Agregar los botones al contenedor
        buttonContainer.getChildren().addAll(iniciarBtn, backBtn, imageView2);
        // Agregar los botones al contenedor
        livesContainer.getChildren().addAll(liveView, live2.getImagen(), live3.getImagen());
        

        // Agregar el contenedor de botones al contenedor principal
        root.setBottom(buttonContainer);
        root.setTop(livesContainer);
        root.getChildren().addAll(marciano1, marciano2.getImagen(), marciano3.getImagen());
        
        Scene scene = new Scene(root, 1024, 628);
        Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 12);
        // Agregar una hoja de estilos CSS
        scene.getStylesheets().add("file:src/main/resources/css/application.css");

        primaryStage.setTitle("Logic Scape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * @param nivelController the nivelController to set
     */
    public void setNivelController(NivelController nivelController) {
        this.nivelController = nivelController;
    }

    void setStage(Stage primaryStag) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}