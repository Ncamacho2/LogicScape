package logicscape.utilidades;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;

public class AutenticacionTest {
    private ConexionSql<Usuario> conexionSqlMock;
    private Autenticacion autenticacion;

    @Before
    public void setUp() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	conexionSqlMock = Mockito.mock(ConexionSql.class);
        autenticacion = new Autenticacion();
     // Use reflection to set the conexionSql field with the mock object
         Field field = Autenticacion.class.getDeclaredField("conexionSql");
        field.setAccessible(true);
        field.set(autenticacion, conexionSqlMock);
    }

    @Test
    public void testRegistrarUsuario_NuevoUsuario_RegistroExitoso() {
        String usuarioNuevo = "usuario1";
        String password = "123456";

     // Configurar el comportamiento del mock
        doNothing().when(conexionSqlMock).insert(anyString(), anyList(), anyList());

        boolean resultado = autenticacion.registrarUsuario(usuarioNuevo, password);

        assertTrue(resultado);
        verify(conexionSqlMock, times(1)).insert(eq("usuarios"), anyList(), anyList());
    }

    @Test
    public void testRegistrarUsuario_UsuarioExistente_RegistroFallido() {
        String usuarioExistente = "usuario2";
        String password = "123456";

        // Configurar el comportamiento del mock
        doNothing().when(conexionSqlMock).insert(anyString(), anyList(), anyList());
        when(conexionSqlMock.findByUsuario(eq(usuarioExistente), any(UsuarioMapper.class))).thenReturn(new Usuario());

        boolean resultado = autenticacion.registrarUsuario(usuarioExistente, password);

        assertFalse(resultado);
        verify(conexionSqlMock, times(1)).findByUsuario(eq(usuarioExistente), any(UsuarioMapper.class));
        verify(conexionSqlMock, never()).insert(eq("usuarios"), anyList(), anyList());
    }

    @Test
    public void testAutenticarUsuario_UsuarioYPasswordCorrectos_AutenticacionExitosa() {
        String nombreUsuario = "nelson";
        String password = "123";
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setUsuario(nombreUsuario);
        usuario.setPassword(password);
        usuarios.add(usuario);

        // Configurar el comportamiento del mock
        when(conexionSqlMock.findAll(eq("usuarios"), any(UsuarioMapper.class))).thenReturn(usuarios);

        boolean resultado = autenticacion.autenticarUsuario(nombreUsuario, password);

        assertTrue(resultado);
        verify(conexionSqlMock, times(1)).findAll(eq("usuarios"), any(UsuarioMapper.class));
    }

    @Test
    public void testAutenticarUsuario_UsuarioYPasswordIncorrectos_AutenticacionFallida() {
        String nombreUsuario = "usuario4";
        String password = "123456";
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setUsuario("otroUsuario");
        usuario.setPassword("contrasenaIncorrecta");
        usuarios.add(usuario);

        // Configurar el comportamiento del mock
        when(conexionSqlMock.findAll(eq("usuarios"), any(UsuarioMapper.class))).thenReturn(usuarios);

        boolean resultado = autenticacion.autenticarUsuario(nombreUsuario, password);

        assertFalse(resultado);
        verify(conexionSqlMock, times(1)).findAll(eq("usuarios"), any(UsuarioMapper.class));
    }
}

