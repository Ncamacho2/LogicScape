package logicscape;

import javafx.application.Application;
import javafx.stage.Stage;
import logicscape.controladores.InicioController;
import logicscape.vistas.InicioView;

/**
 * Clase principal.
 */
public class Main extends Application {
	/**
	 * inicializa la app.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Inicia la aplicacion.
	 * @param primaryStage the primary stage for this application, onto which
	 * the application scene can be set.
	 * Applications may create other stages, if needed, but they will not be
	 * primary stages.
	 * @throws Exception the exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
        InicioView inicioView = new InicioView();
		new InicioController(inicioView);
		inicioView.start(primaryStage);
	}
}
