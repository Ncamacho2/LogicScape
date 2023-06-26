package logicscape.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta interfaz proporciona un mecanismo para mapear los resultados de una
 * consulta de base de datos a un objeto de tipo T.
 * 
 * @author Nelson Camacho
 *
 * @param <T> objeto
 */
public interface EntityMapper<T> {
	/**
	 * Este método toma un objeto ResultSet como entrada y devuelve un objeto de
	 * tipo T. Lanza una excepción SQLException en caso de error.
	 * 
	 * @param resultSet resultado
	 * @return objeto
	 * @throws SQLException excepcion
	 */
	T map(ResultSet resultSet) throws SQLException;
}
