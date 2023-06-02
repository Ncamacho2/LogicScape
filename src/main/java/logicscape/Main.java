package logicscape;

import javafx.application.Application;
import javafx.stage.Stage;
import logicscape.controladores.InicioController;
import logicscape.vistas.InicioView;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		InicioView inicioView = new InicioView();
		InicioController controller = new InicioController(inicioView);
		inicioView.start(primaryStage);
	}
}
