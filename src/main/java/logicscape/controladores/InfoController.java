package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;
import logicscape.utilidades.ConexionSql;
import logicscape.vistas.InfoView;

public class InfoController {
    private InfoView infoView;

    public InfoController(InfoView infoView) {
        this.infoView = infoView;
        this.infoView.setInfoController(this);
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
