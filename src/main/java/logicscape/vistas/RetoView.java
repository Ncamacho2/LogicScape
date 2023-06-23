package logicscape.vistas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logicscape.controladores.RespuestasController;
import logicscape.controladores.RetoController;

import java.util.List;

public class RetoView extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    private static final int HEIGHTBUTTON = 100;
    private Button loginBtn;
    private Button inicioBtn;
    private RetoController retoController;
    private Label ecuacionField;
    private ToggleGroup group;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-image: url('file:/C:/Users/tomsu/git/LogicScape/src/main/resources/img/fondo.png'); -fx-background-size: cover;");
        HBox buttonContainer = new HBox();
        buttonContainer.setPadding(new Insets(20));
        buttonContainer.setSpacing(10);
        buttonContainer.setPrefHeight(HEIGHTBUTTON);
        buttonContainer.getStyleClass().add("my-container");

        GridPane inputContainer = new GridPane();
        inputContainer.setPadding(new Insets(85));
        inputContainer.setVgap(20);
        inputContainer.setAlignment(Pos.CENTER);

        ecuacionField = new Label("2 + 2");
        ecuacionField.setFont(new Font(45));
        ecuacionField.setStyle("-fx-text-fill: black;"); 
        group = new ToggleGroup();
        List<String> answers = retoController.getAnswers();
        for (int i = 0; i < answers.size(); i++) {
            RadioButton radioButton = new RadioButton(answers.get(i));
            radioButton.setToggleGroup(group);
            radioButton.setStyle("-fx-text-fill: black; -fx-font-size: 30;"); // Add this line to make the text color white and larger
            inputContainer.add(radioButton, i % 2, i / 2 + 1);
        }

        inputContainer.add(ecuacionField, 0,0, 2, 1);
        inicioBtn = new Button("Aceptar");
        loginBtn = new Button("Cancelar");

        loginBtn.getStyleClass().add("my-button");
        inicioBtn.getStyleClass().add("my-button");

        loginBtn.prefHeightProperty().bind(buttonContainer.heightProperty().multiply(0.3)); // 60% of the container height
        loginBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1.1)); // 2/3 of the primaryStage width
        inicioBtn.prefHeightProperty().bind(buttonContainer.heightProperty().multiply(0.3)); // 60% of the container height
        inicioBtn.prefWidthProperty().bind(primaryStage.widthProperty().divide(1.1)); // 2/3 of the primaryStage width

        
        loginBtn.setOnAction(event -> {
            // Handle the event for the Cancelar button
        });
        
        inicioBtn.setOnAction(event -> {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String selectedAnswer = selectedRadioButton.getText();
            
            // Check if the answer is correct
            if (retoController.checkAnswer(selectedAnswer)) {
                // if correct, display correct scene
                RespuestasView respuestasView = new RespuestasView();
                RespuestasController respuestasController = new RespuestasController(respuestasView, primaryStage);
                respuestasController.setRespuesta("Correcto!");
                respuestasView.start(primaryStage);
            } else {
                // if incorrect, display incorrect scene or message
                RespuestasView respuestasView = new RespuestasView();
                RespuestasController respuestasController = new RespuestasController(respuestasView, primaryStage);
                respuestasController.setRespuesta("Incorrecto!");
                respuestasView.start(primaryStage);
            }
        });

        buttonContainer.getChildren().addAll(inicioBtn, loginBtn);

        root.setCenter(inputContainer);
        root.setBottom(buttonContainer);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("file:src/main/resources/css/application2.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Reto");
        primaryStage.show();
    }

    public void setRetoController(RetoController retoController) {
        this.retoController = retoController;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
