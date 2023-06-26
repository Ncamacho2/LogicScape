package logicscape.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import logicscape.modelos.Usuario;

/**
 * Esta clase implementa la interfaz EntityMapper y se utiliza para mapear los
 * resultados de una consulta de base de datos a un objeto de tipo Usuario.
 * 
 * @author Nelson Camacho
 */
public class UsuarioMapper implements EntityMapper<Usuario> {
	/**
	 * Mapea los resultados de un objeto ResultSet a un objeto de tipo Usuario.
	 *
	 * @param resultSet el objeto ResultSet que contiene los resultados de la
	 *                  consulta.
	 * @return un objeto de tipo Usuario con los datos mapeados desde el ResultSet.
	 * @throws SQLException si ocurre algún error al acceder a los datos en el
	 *                      ResultSet.
	 */
	@Override
	public Usuario map(ResultSet resultSet) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(resultSet.getInt("id"));
		usuario.setVisible(resultSet.getBoolean("visible"));
		usuario.setDisponible(resultSet.getBoolean("disponible"));
		usuario.setUltimaActualizacion(resultSet.getTimestamp("ultimaActualizacion").toLocalDateTime());
		usuario.setFechaCreacion(resultSet.getTimestamp("fechaCreacion").toLocalDateTime());
		usuario.setUsuario(resultSet.getString("usuario"));
		usuario.setPasswordSe(resultSet.getString("password"));
		usuario.setUltimoIngreso(resultSet.getTimestamp("ultimoIngreso").toLocalDateTime());
		usuario.setEscenarioActual(resultSet.getInt("EscenarioActual"));
		usuario.setNivelActual(resultSet.getInt("NivelActual"));
		usuario.setVidas(resultSet.getInt("vidas"));
		return usuario;

	}

}
