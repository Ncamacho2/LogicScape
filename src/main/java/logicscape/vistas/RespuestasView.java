package logicscape.vistas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logicscape.controladores.RespuestasController;

/**
 * Clase que representa la vista de las respuestas.
 */
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

        scene.getStylesheets().add("file:src/main/resources/css/application2.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Iniciar el controlador después de que todos los componentes de la vista hayan sido configurados
        if (respuestasController != null) {
            respuestasController.setRespuesta(respuestasController.getRespuesta()); // usar la respuesta ya establecida en el controlador
            respuestasController.iniciar();
        }
    }

    /**
     * Obtiene la escena de la vista.
     *
     * @return La escena de la vista.
     */
    public Scene getScene() {
        return this.scene;
    }

    /**
     * Establece el controlador de respuestas.
     *
     * @param respuestasController El controlador de respuestas.
     */
    public void setRespuestasController(RespuestasController respuestasController) {
        this.respuestasController = respuestasController;
    }

    /**
     * Establece la respuesta y su estado de corrección en la vista.
     *
     * @param answer     La respuesta.
     * @param isCorrect  Indica si la respuesta es correcta o no.
     */
    public void setAnswer(String answer, boolean isCorrect) {
        answerLabel.setText(answer);
        if (isCorrect) {
            layout.getStyleClass().add("green-background");
        } else {
            layout.getStyleClass().add("red-background");
        }
    }
}
