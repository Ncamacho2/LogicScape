package logicscape.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;
import logicscape.utilidades.ConexionSql;
import logicscape.utilidades.Escenarios;
import logicscape.vistas.RespuestasView;
import logicscape.vistas.RetoView;

public class RetoController {
	
	private RetoView retoView;
	private RespuestasController respuestasController;
	private Usuario usuario;

	public RetoController(RetoView retoView, Usuario usuario) {
            this.retoView = retoView;
            this.setUsuario(usuario);
            this.retoView.setRetoController(this);
 
    }

    // Method to set RespuestasController
    public void setRespuestasController(RespuestasController respuestasController) {
        this.respuestasController = respuestasController;
    }

	
    public void mostrarMensaje(String mensaje) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ventana emergente");
            alert.setHeaderText("Informaci�n");
            alert.setContentText(mensaje);
            alert.showAndWait();
    }

	public void validarRespuesta(Integer respuesta, Escenarios escenario, Stage primaryStage) {
		ConexionSql<Usuario> conexion = new ConexionSql<>();
		if(escenario.validarResultado(respuesta)) {
			usuario = conexion.findById("usuarios","id", usuario.getId(), new UsuarioMapper());
        	RespuestasView respuestasView = new RespuestasView();
            RespuestasController respuestasController = new RespuestasController(respuestasView, primaryStage, usuario);
            respuestasController.setRespuesta("Correcto!");
            respuestasView.start(primaryStage);        		
    	} else {
    		usuario = conexion.findById("usuarios","id", usuario.getId(), new UsuarioMapper());
        	RespuestasView respuestasView = new RespuestasView();
            RespuestasController respuestasController = new RespuestasController(respuestasView, primaryStage, usuario);
            respuestasController.setRespuesta("Incorrecto!");
            respuestasView.start(primaryStage);
    	}
		
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
