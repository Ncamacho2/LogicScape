package logicscape.controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
