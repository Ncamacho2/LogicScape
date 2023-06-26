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
	public void start(Stage primaryStage) throws Exception{
        InicioView inicioView = new InicioView();
		new InicioController(inicioView);
		inicioView.start(primaryStage);
	}
}
