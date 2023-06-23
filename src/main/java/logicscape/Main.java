package logicscape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logicscape.controladores.InicioController;
import logicscape.vistas.FinalView;
import logicscape.vistas.InicioView;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
		InicioView inicioView = new InicioView();
		InicioController controller = new InicioController(inicioView);
		inicioView.start(primaryStage);
		
		
	// Codigo para mostrar la vista final (el codigo de arriba debe de ser comentado)	
	//	FinalView finalView = new FinalView(true);
	//	finalView.start(primaryStage);
	}
}
