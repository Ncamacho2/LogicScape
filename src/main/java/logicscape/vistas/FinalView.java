package logicscape.vistas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FinalView extends Application {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 628;
    private static final String BACKGROUND_IMAGE = "file:src/main/resources/img/nivel_final.png";
    private static final String FONT_PATH = "/font/PressStart2P-Regular.ttf";
    private static final String MESSAGE_STYLE = "-fx-padding: 20px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 30px; -fx-background-radius: 30px;";

    private boolean lograEscapar;

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
        Image backgroundImage = new Image(BACKGROUND_IMAGE);
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(backgroundImageView);

        // Creación del contenedor para el mensaje
        StackPane messageContainer = new StackPane();
        Label messageLabel = new Label(lograEscapar ? "¡Felicidades\nLograste esscapar!" : "Game Over\n Buen intento");
        messageLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 48));
        messageLabel.setTextFill(Color.WHITE);
        // Estilos del mensaje + condicional para cambiar el color de fondo segun el resultado
        messageLabel.setStyle(MESSAGE_STYLE + "-fx-background-color:" + (lograEscapar ? "#00CB6D;" : "#ff3535"));
        messageLabel.setTextAlignment(TextAlignment.CENTER);
        messageContainer.getChildren().add(messageLabel);
        messageContainer.setAlignment(Pos.CENTER);
        
        root.setCenter(messageContainer);

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        // Agregar una hoja de estilos CSS
        scene.getStylesheets().add("file:src/main/resources/css/application.css");

        primaryStage.setTitle("Final View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
