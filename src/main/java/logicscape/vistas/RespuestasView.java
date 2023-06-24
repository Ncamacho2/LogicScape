package logicscape.vistas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logicscape.controladores.RespuestasController;

public class RespuestasView extends Application {

    private RespuestasController respuestasController;
    private Label answerLabel;
    private Scene scene;
    private StackPane layout;

    @Override
    public void start(Stage primaryStage) {
        answerLabel = new Label();
        layout = new StackPane();
        layout.getChildren().add(answerLabel);
        scene = new Scene(layout, 300, 200);
        
        scene.getStylesheets().add("css/application2.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initiate controller after all your view components have been set up
        if (respuestasController != null) {
            respuestasController.setRespuesta(respuestasController.getRespuesta()); // use the respuesta already set in the controller
            respuestasController.iniciar();
        }}
       

    public Scene getScene() {
        return this.scene;
    }

    public void setRespuestasController(RespuestasController respuestasController) {
        this.respuestasController = respuestasController;
    }

    public void setAnswer(String answer, boolean isCorrect) {
        answerLabel.setText(answer);
        if (isCorrect) {
            layout.getStyleClass().add("green-background");
        } else {
            layout.getStyleClass().add("red-background");
        }
    }
}
