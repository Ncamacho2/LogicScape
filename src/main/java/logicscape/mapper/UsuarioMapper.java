package logicscape.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import logicscape.modelos.Usuario;

public class UsuarioMapper implements EntityMapper<Usuario> {

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
