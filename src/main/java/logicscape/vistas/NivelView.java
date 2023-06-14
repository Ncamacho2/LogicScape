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
import logicscape.controladores.InfoController;
import logicscape.controladores.InicioController;
import logicscape.controladores.JugarController;
import logicscape.controladores.LoginController;
import logicscape.controladores.NivelController;
import java.util.concurrent.TimeUnit;

public class NivelView extends Application {
	private static final int WIDTH = 639;
    private static final int HEIGHT = 401;
    private static final int HEIGHTBUTTON = 100;
    private Button imgBtn;
    private NivelController nivelController;


    @Override
    public void start(Stage primaryStage) {
        // Configuración de la ventana principal
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        // Creación del contenedor principal
        BorderPane root = new BorderPane();
        
        // Creación del contenedor para los botones en la parte inferior
        HBox buttonContainer = new HBox();


        imgBtn = new Button();

  

        // Agregar clases CSS a los botones
        imgBtn.setStyle("-fx-background-image: url(\"file:src/main/resources/img/nivel_suma.png\")");
        /*imgBtn.getStyleClass().add("my-button3");*/



        imgBtn.prefHeightProperty().bind(primaryStage.heightProperty());
        imgBtn.prefWidthProperty().bind(primaryStage.widthProperty());

        
        imgBtn.setOnAction(event -> {
            RetoView retoView = new RetoView();
            logicscape.controladores.RetoController nivelController = new logicscape.controladores.RetoController(retoView);
            retoView.start(primaryStage);
        });
        
       

        // Agregar los botones al contenedor
        buttonContainer.getChildren().addAll(imgBtn);

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
     * @param nivelController the nivelController to set
     */
    public void setNivelController(NivelController nivelController) {
        this.nivelController = nivelController;
    }

    void setStage(Stage primaryStag) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
