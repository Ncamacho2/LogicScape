package logicscape;

import javafx.application.Application;
import javafx.stage.Stage;
import logicscape.controladores.JugarController;
import logicscape.vistas.JugarView;

public class JugarMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		JugarView jugarView = new JugarView();
		JugarController controller = new JugarController(jugarView);
		jugarView.start(primaryStage);
	}
}
