package logicscape.vistas;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import logicscape.controladores.NivelController;
import logicscape.utilidades.Live;
import logicscape.utilidades.Marciano;
import logicscape.utilidades.Nivel;

/**
 * La clase NivelView representa la vista del nivel en el juego LogicScape.
 * Muestra la imagen del nivel, la imagen de vida y el marciano en pantalla.
 * También muestra información y botones para iniciar el juego y regresar.
 */
public class NivelView extends Application {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final int HEIGHTBUTTON = 100;
    private Button iniciarBtn;
    private Button backBtn;
    private NivelController nivelController;
    private Live live;
    private static final String RUTA_IMAGEN = "/img/estrella_uno.png";
    private static final String RUTA_IMAGEN_OFF = "/img/estrella_off.png";
    private Nivel nivel;
    private static final String RUTA_IMAGEN2 = "/img/suma.png";
    private static final String RUTA_IMAGEN3 = "/img/resta.png";
    private static final String RUTA_IMAGEN4 = "/img/multi.png";
    private static final String RUTA_IMAGEN5 = "/img/divi.png";
    private Marciano marciano;
    private static final String RUTA_MARCIANO = "/img/marciano.png";

    /**
     * Método principal que inicia la aplicación JavaFX.
     *
     * @param primaryStage el escenario principal de la aplicación
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

        // Contenedor de la barra de vidas
        HBox livesContainer = new HBox();
        livesContainer.setPadding(new Insets(20));
        livesContainer.setSpacing(50);
        livesContainer.setPrefHeight(HEIGHTBUTTON);
        // livesContainer.setStyle("-fx-background-color: #F9ED65;");

        // Creación del ImageView para la imagen de fondo
        Image backgroundImage = new Image(getClass().getResource("/img/fondo_escenario.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty()
                .bind(primaryStage.heightProperty().subtract(buttonContainer.heightProperty()));
        root.getChildren().add(backgroundImageView);

        iniciarBtn = new Button("Iniciar");
        backBtn = new Button("Volver");
        if (nivelController.getUsuario().getEscenarioActual().equals(0)) {
            nivel = new Nivel(RUTA_IMAGEN2);
        } else if (nivelController.getUsuario().getEscenarioActual().equals(1)) {
            nivel = new Nivel(RUTA_IMAGEN3);
        } else if (nivelController.getUsuario().getEscenarioActual().equals(2)) {
            nivel = new Nivel(RUTA_IMAGEN4);
        } else {
            nivel = new Nivel(RUTA_IMAGEN5);
        }

        live = new Live(RUTA_IMAGEN);
        Live live2 = new Live(RUTA_IMAGEN);
        Live live3 = new Live(RUTA_IMAGEN);
        if (nivelController.getUsuario().getVidas().equals(0)) {
            live = new Live(RUTA_IMAGEN_OFF);
            live2 = new Live(RUTA_IMAGEN_OFF);
            live3 = new Live(RUTA_IMAGEN_OFF);
            nivelController.mostrarGameOver(primaryStage);
        } else if (nivelController.getUsuario().getVidas().equals(1)) {
            live = new Live(RUTA_IMAGEN);
            live2 = new Live(RUTA_IMAGEN_OFF);
            live3 = new Live(RUTA_IMAGEN_OFF);
        } else if (nivelController.getUsuario().getVidas().equals(2)) {
            live = new Live(RUTA_IMAGEN);
            live2 = new Live(RUTA_IMAGEN);
            live3 = new Live(RUTA_IMAGEN_OFF);
        } else {
            live = new Live(RUTA_IMAGEN);
            live2 = new Live(RUTA_IMAGEN);
            live3 = new Live(RUTA_IMAGEN);
        }

        marciano = new Marciano(RUTA_MARCIANO);
        Marciano marciano2 = new Marciano(RUTA_MARCIANO);
        Marciano marciano3 = new Marciano(RUTA_MARCIANO);

        ImageView liveView = live.getImagen();
        ImageView imageView2 = nivel.getImagen();
        ImageView marciano1 = marciano.getImagen();
        if (nivelController.getUsuario().getNivelActual() == 0) {
            double nuevaPosicionX = 120; // Nueva coordenada X
            double nuevaPosicionY = 240; // Nueva coordenada Y
            marciano1.setLayoutX(nuevaPosicionX);
            marciano1.setLayoutY(nuevaPosicionY);
        }
        if (nivelController.getUsuario().getNivelActual() == 1) {

            // Establecer las coordenadas de cada instancia
            double posicionX1 = 410; // Coordenada X para la primera instancia
            double posicionY1 = 165; // Coordenada Y para la primera instancia
            marciano2.getImagen().setLayoutX(posicionX1);
            marciano2.getImagen().setLayoutY(posicionY1);
        }
        if (nivelController.getUsuario().getNivelActual() == 2) {

            // Establecer las coordenadas de cada instancia
            double posicionX2 = 700; // Coordenada X para la primera instancia
            double posicionY2 = 95; // Coordenada Y para la primera instancia
            marciano3.getImagen().setLayoutX(posicionX2);
            marciano3.getImagen().setLayoutY(posicionY2);
        }

        // Creación del contenedor del texto para la info
        HBox infoContainer = new HBox();
        infoContainer.setMinWidth(600);
        infoContainer.setMaxWidth(800);
        infoContainer.setMinHeight(200);
        infoContainer.setMaxHeight(300);
        infoContainer.setStyle("-fx-background-color: #F9ED65;"); // Color de fondo blanco
        infoContainer.setAlignment(Pos.CENTER); // Alineación central
        // Texto de la info
        Label label = new Label(" Bienvenido a LogicScape, \n" + " para ganar debes responder \n"
                + " correctamente cada una de las \n" + " preguntas segun el nivel \n" + " que corresponda \n\n"
                + " Presiona 'Iniciar' para \n" + " comenzar el juego  ");

        infoContainer.getChildren().add(label);

        // Agregar clases CSS a los botones
        iniciarBtn.getStyleClass().add("my-button");
        backBtn.getStyleClass().add("my-button");
        label.getStyleClass().add("my-texto");

        iniciarBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        iniciarBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1.7));
        backBtn.prefHeightProperty().bind(buttonContainer.heightProperty());
        backBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1.7));

        // Boton de iniciar pregunta
        iniciarBtn.setOnAction(event -> {
            nivelController.handleButtonClick(iniciarBtn.getText(), primaryStage);
        });

        // Boton de regreso
        backBtn.setOnAction(event -> {
            nivelController.handleButtonClick(backBtn.getText(), primaryStage);
        });

        // Agregar los botones al contenedor
        buttonContainer.getChildren().addAll(iniciarBtn, backBtn, imageView2);
        // Agregar los botones al contenedor
        livesContainer.getChildren().addAll(liveView, live2.getImagen(), live3.getImagen());

        // Agregar el contenedor de botones al contenedor principal
        root.getChildren().addAll(marciano1, marciano2.getImagen(), marciano3.getImagen());
        root.setBottom(buttonContainer);
        root.setTop(livesContainer);
        root.setCenter(infoContainer);
        if (nivelController.getUsuario().getVidas().equals(0)) {
            live = new Live(RUTA_IMAGEN_OFF);
            live2 = new Live(RUTA_IMAGEN_OFF);
            live3 = new Live(RUTA_IMAGEN_OFF);
            nivelController.mostrarGameOver(primaryStage);
        } else if (nivelController.getUsuario().getEscenarioActual().equals(4)) {
            live = new Live(RUTA_IMAGEN);
            live2 = new Live(RUTA_IMAGEN);
            live3 = new Live(RUTA_IMAGEN);
            nivelController.mostrarGanador(primaryStage);
        } else {

            Scene scene = new Scene(root, 1024, 628);
            Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 12);
            // Agregar una hoja de estilos CSS
            scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

            primaryStage.setTitle("Logic Scape");
            primaryStage.setScene(scene);
            primaryStage.show();

            // Configurar la duración y animación del HBox
            Duration duracionVisible = Duration.seconds(nivelController.getTiempoMsgInicial());
            Duration duracionTotal = duracionVisible.add(Duration.seconds(1)); // Agregar 1 segundo para la transición
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(infoContainer.opacityProperty(), 1.0)),
                    new KeyFrame(duracionVisible, new KeyValue(infoContainer.opacityProperty(), 1.0)),
                    new KeyFrame(duracionTotal, new KeyValue(infoContainer.opacityProperty(), 0.0)));
            timeline.play();

            // Ocultar el HBox después de la duración total
            timeline.setOnFinished(event -> infoContainer.setVisible(false));
        }
    }

    /**
     * Método para establecer el controlador de nivel.
     *
     * @param nivelController el controlador de nivel
     */
    public void setNivelController(NivelController nivelController) {
        this.nivelController = nivelController;
    }

    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}
