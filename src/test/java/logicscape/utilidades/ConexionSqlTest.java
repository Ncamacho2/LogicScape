package logicscape.utilidades;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;

public class ConexionSqlTest {
	private ConexionSql<Usuario> conexionSql;
	private Connection connectionMock;
	private PreparedStatement statementMock;
	private ResultSet resultSetMock;
	private UsuarioMapper entityMapperMock;

	@Before
	public void setUp() throws Exception {
		connectionMock = mock(Connection.class);
		statementMock = mock(PreparedStatement.class);
		resultSetMock = mock(ResultSet.class);
		entityMapperMock = mock(UsuarioMapper.class);
		conexionSql = new ConexionSql<>();

	}

	@Test
	public void testFindAll_WhenResultSetHasData_ShouldReturnListOfEntities() throws Exception {
		// Arrange
		List<Usuario> expectedEntities = new ArrayList<>();
		int expectedId = 17;
		String expectedNombre = "PEPITO";
		Usuario expectedEntityIn = new Usuario();
		expectedEntityIn.setId(expectedId);
		expectedEntityIn.setUsuario(expectedNombre);

		expectedEntities.add(expectedEntityIn);

		when(connectionMock.prepareStatement(Mockito.anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true, true, false);
		entityMapperMock = new UsuarioMapper();
		// Act
		List<Usuario> actualEntities = conexionSql.findAll("usuarios", entityMapperMock);

		// Assert
		assertEquals(expectedEntities.size(), actualEntities.size());
		for (int i = 0; i < expectedEntities.size(); i++) {
			Usuario expectedEntity = expectedEntities.get(i);
			Usuario actualEntity = actualEntities.get(i);
			assertEquals(expectedEntity.getId(), actualEntity.getId());
			assertEquals(expectedEntity.getUsuario(), actualEntity.getUsuario());
		}
	}

	@Test
    public void testFindAll_WhenResultSetIsEmpty_ShouldReturnEmptyList() throws Exception {
        // Arrange
        when(connectionMock.prepareStatement(Mockito.anyString())).thenReturn(statementMock);
        when(statementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(false);
        
        // Act
        List<Usuario> actualEntities = conexionSql.findAll("usuarios_empty", entityMapperMock);

        // Assert
        assertEquals(0, actualEntities.size());
    }

	@Test
	public void testFindById_WhenResultSetHasData_ShouldReturnEntity() throws Exception {
		// Arrange
		int expectedId = 17;
		String expectedNombre = "PEPITO";
		Usuario expectedEntity = new Usuario();
		expectedEntity.setId(expectedId);
		expectedEntity.setUsuario(expectedNombre);

		when(connectionMock.prepareStatement(Mockito.anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(entityMapperMock.map(resultSetMock)).thenReturn(expectedEntity);
		entityMapperMock = new UsuarioMapper();
		// Act
		Usuario actualEntity = conexionSql.findById("usuarios", "id", expectedId, entityMapperMock);
		// Assert
		assertEquals(expectedEntity.getId(), actualEntity.getId());
		assertEquals(expectedEntity.getUsuario(), actualEntity.getUsuario());

	}

	@Test
    public void testFindById_WhenResultSetIsEmpty_ShouldReturnNull() throws Exception {
        // Arrange
        when(connectionMock.prepareStatement(Mockito.anyString())).thenReturn(statementMock);
        when(statementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(false);
        entityMapperMock = new UsuarioMapper();
        // Act
        Usuario actualEntity = conexionSql.findById("usuarios", "id", 1, entityMapperMock);

        // Assert
        assertEquals(null, actualEntity);
    }
}
