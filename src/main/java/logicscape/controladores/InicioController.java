package logicscape.controladores;

import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;
import logicscape.utilidades.ConexionSql;
import logicscape.vistas.InicioView;

public class InicioController {
	private InicioView inicioView;
	public InicioController(InicioView inicioView) {
        this.inicioView = inicioView;
        this.inicioView.setInicioController(this);
        
    }
	public void handleButtonClick(String string) {
		ConexionSql<Usuario> conexion = new ConexionSql<>();

        // Ejemplo de consulta de todos los usuarios
        List<Usuario> usuarios = conexion.findAll("usuarios", new UsuarioMapper());
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getUsuario());
        }
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Ventana emergente");
	    alert.setHeaderText("Información");
	    alert.setContentText("Reemplazar por la nueva ventana "+ string);
	    alert.showAndWait();
	}
	
}
