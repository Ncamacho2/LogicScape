package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.vistas.RetoView;

public class RetoController {
	
	private RetoView retoView;

    public RetoController(RetoView retoView) {
        this.retoView = retoView;
        this.retoView.setRetoController(this);
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ventana emergente");
        alert.setHeaderText("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
