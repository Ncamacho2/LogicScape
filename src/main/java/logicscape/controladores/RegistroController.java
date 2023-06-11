package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.vistas.RegistroView;

public class RegistroController {
	
    private RegistroView registroView;

    public RegistroController(RegistroView registroView) {
        this.registroView = registroView;
        this.registroView.setRegistroController(this);
    }

    public void handleButtonClick(String action) {
  
    	
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ventana emergente");
        alert.setHeaderText("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
