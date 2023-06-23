package logicscape;

import javafx.application.Application;
import javafx.stage.Stage;
import logicscape.controladores.JugarController;
import logicscape.controladores.RetoController;
import logicscape.vistas.JugarView;
import logicscape.vistas.RetoView;

public class JugarMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		RetoView jugarView = new RetoView();
		RetoController controller = new RetoController(jugarView);
		jugarView.start(primaryStage);
	}
}
