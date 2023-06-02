package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.vistas.InicioView;

public class InicioController {
	private InicioView inicioView;
	public InicioController(InicioView inicioView) {
        this.inicioView = inicioView;
        this.inicioView.setInicioController(this);
        
    }
	public void handleButtonClick(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Ventana emergente");
	    alert.setHeaderText("Información");
	    alert.setContentText("Reemplazar por la nueva ventana "+ string);
	    alert.showAndWait();
	}
	
}
