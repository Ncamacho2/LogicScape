package logicscape.controladores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logicscape.vistas.InicioView;



class InicioControllerTest {

	private InicioController inicioController;
    private InicioView inicioView;

    @BeforeEach
    public void setUp() {
        inicioView = Mockito.mock(InicioView.class);
        inicioController = new InicioController(inicioView);
    }

    @Test
    public void testHandleButtonClick() {
    	
    }
}
