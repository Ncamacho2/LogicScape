package logicscape.utilidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class EscenariosTest {

    private Escenarios escenarios;

    @Before
    public void setUp() {
        List<Integer> opciones = new ArrayList<>();
        String pregunta = "";
        Integer resultado = 10;
        Integer escenarioId = 0;
        Integer nivelId = 0;
        Integer usuarioId = 53;

        escenarios = new Escenarios(opciones, pregunta, resultado, escenarioId, nivelId, usuarioId);
    }

    @Test
    public void testGenerarPregunta() {
        escenarios.generarPregunta();

        String pregunta = escenarios.getPregunta();
        Integer resultado = escenarios.getResultado();
        List<Integer> opciones = escenarios.getOpciones();

        // Verify that the pregunta and resultado are correctly generated
        Assert.assertNotNull(pregunta);
        Assert.assertNotNull(resultado);

        // Verify that the opciones list has four elements
        Assert.assertEquals(4, opciones.size());

        // Verify that the opciones list contains the resultado
        Assert.assertTrue(opciones.contains(resultado));
    }

    @Test
    public void testValidarResultadoCorrect() {
        Integer resultado = 10;
        Integer usuarioId = escenarios.getUsuarioId();

        ConexionSql<Usuario> conexionSqlMock = Mockito.mock(ConexionSql.class);
        Usuario usuarioMock = Mockito.mock(Usuario.class);

        Mockito.when(conexionSqlMock.findById(Mockito.anyString(), Mockito.anyString(), Mockito.eq(usuarioId), Mockito.any(UsuarioMapper.class)))
                .thenReturn(usuarioMock);
        Mockito.when(usuarioMock.getNivelActual()).thenReturn(2);
        Mockito.when(usuarioMock.getEscenarioActual()).thenReturn(2);
        Mockito.when(usuarioMock.getColumnas()).thenReturn(new ArrayList<>());
        Mockito.when(usuarioMock.getValores()).thenReturn(new ArrayList<>());
        
        Boolean result = escenarios.validarResultado(resultado);
        
        Assert.assertTrue(result);

    }

    @Test
    public void testValidarResultadoIncorrect() {
        Integer resultado = 5;

        ConexionSql<Usuario> conexionSqlMock = Mockito.mock(ConexionSql.class);

        escenarios.validarResultado(resultado);

        // Verify that the user's level and scenario are not updated
        Mockito.verify(conexionSqlMock, Mockito.never()).update(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyList(), Mockito.anyList());
    }
}
