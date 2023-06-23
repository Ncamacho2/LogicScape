package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;
import java.util.ArrayList;
import logicscape.vistas.RetoView;

public class RetoController {
	
	private RetoView retoView;
	private RespuestasController respuestasController;
	private String correctAnswer = "4"; 
    private List<String> answers = new ArrayList<>();

	public RetoController(RetoView retoView) {
            this.retoView = retoView;
            this.retoView.setRetoController(this);
            // Add possible answers
            answers.add("2");
            answers.add("3");
            answers.add("4");
            answers.add("5");
    }

    // Method to set RespuestasController
    public void setRespuestasController(RespuestasController respuestasController) {
        this.respuestasController = respuestasController;
    }

	public List<String> getAnswers() {
		return answers;
	}
	public String getCorrectAnswer() {
	    return correctAnswer;
	}

	public boolean checkAnswer(String userAnswer) {
		return correctAnswer.equals(userAnswer);
	}

    public void mostrarMensaje(String mensaje) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ventana emergente");
            alert.setHeaderText("Información");
            alert.setContentText(mensaje);
            alert.showAndWait();
    }
}
