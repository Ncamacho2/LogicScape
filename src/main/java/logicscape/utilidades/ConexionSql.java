package logicscape.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicscape.mapper.EntityMapper;

/**
 * La clase ConexionSql proporciona métodos para interactuar con una base de
 * datos SQL.
 * 
 * @param <T> el tipo de entidad con el que se va a interactuar en la base de
 *            datos
 */
public class ConexionSql<T> {
	private static final String URL = "jdbc:mysql://151.106.98.0:3306/u744168167_logic_scape_db?useCompresion=true&autoReconnet=true&useSSL=false";
	private static final String USERNAME = "u744168167_logicscape";
	private static final String PASSWORD = "Pplogicscape2023*.";

	private Connection connection;

	/**
	 * Crea una instancia de la clase ConexionSql y establece la conexión con la
	 * base de datos.
	 */
	public ConexionSql() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cierra la conexión con la base de datos.
	 */
	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Recupera todas las entidades de una tabla de la base de datos y las devuelve
	 * en forma de lista.
	 * 
	 * @param tableName el nombre de la tabla
	 * @param mapper    el objeto EntityMapper para mapear las filas de la tabla a
	 *                  objetos de tipo T
	 * @return una lista de entidades de tipo T
	 */
	public List<T> findAll(String tableName, EntityMapper<T> mapper) {
		List<T> entities = new ArrayList<>();

		try {
			String query = "SELECT * FROM " + tableName;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				T entity = mapper.map(resultSet);
				entities.add(entity);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entities;
	}

	/**
	 * Recupera una entidad de una tabla de la base de datos por su ID.
	 * 
	 * @param tableName    el nombre de la tabla
	 * @param idColumnName el nombre de la columna de ID
	 * @param id           el valor del ID
	 * @param mapper       el objeto EntityMapper para mapear la fila de la tabla a
	 *                     un objeto de tipo T
	 * @return la entidad de tipo T o null si no se encuentra ninguna entidad con el
	 *         ID especificado
	 */
	public T findById(String tableName, String idColumnName, int id, EntityMapper<T> mapper) {
		T entity = null;

		try {
			String query = "SELECT * FROM " + tableName + " WHERE " + idColumnName + " = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				entity = mapper.map(resultSet);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entity;
	}

	/**
	 * Recupera una entidad de una tabla de la base de datos por su nombre de
	 * usuario.
	 * 
	 * @param usuario el nombre de usuario
	 * @param mapper  el objeto EntityMapper para mapear la fila de la tabla a un
	 *                objeto de tipo T
	 * @return la entidad de tipo T o null si no se encuentra ninguna entidad con el
	 *         nombre de usuario especificado
	 */
	public T findByUsuario(String usuario, EntityMapper<T> mapper) {
		T entity = null;

		try {
			String query = "SELECT * FROM usuarios WHERE usuario = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setNString(1, usuario);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				entity = mapper.map(resultSet);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entity;
	}

	/**
	 * Inserta una nueva fila en una tabla de la base de datos.
	 * 
	 * @param tableName el nombre de la tabla
	 * @param columns   una lista de nombres de columna
	 * @param values    una lista de valores correspondientes a las columnas
	 */
	public void insert(String tableName, List<String> columns, List<Object> values) {
		try {
			StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
			queryBuilder.append(tableName);
			queryBuilder.append(" (");
			for (String column : columns) {
				queryBuilder.append(column);
				queryBuilder.append(",");
			}
			queryBuilder.deleteCharAt(queryBuilder.length() - 1);
			queryBuilder.append(") VALUES (");
			for (int i = 0; i < values.size(); i++) {
				queryBuilder.append("?,");
			}
			queryBuilder.deleteCharAt(queryBuilder.length() - 1);
			queryBuilder.append(")");

			PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());

			for (int i = 0; i < values.size(); i++) {
				statement.setObject(i + 1, values.get(i));
			}

			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza una fila en una tabla de la base de datos.
	 * 
	 * @param tableName    el nombre de la tabla
	 * @param idColumnName el nombre de la columna de ID
	 * @param id           el valor del ID de la fila a actualizar
	 * @param columns      una lista de nombres de columna
	 * @param values       una lista de valores correspondientes a las columnas
	 */
	public void update(String tableName, String idColumnName, int id, List<String> columns, List<Object> values) {
		try {
			StringBuilder queryBuilder = new StringBuilder("UPDATE ");
			queryBuilder.append(tableName);
			queryBuilder.append(" SET ");
			for (int i = 0; i < columns.size(); i++) {
				queryBuilder.append(columns.get(i));
				queryBuilder.append(" = ?,");
			}
			queryBuilder.deleteCharAt(queryBuilder.length() - 1);
			queryBuilder.append(" WHERE ");
			queryBuilder.append(idColumnName);
			queryBuilder.append(" = ?");

			PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());

			for (int i = 0; i < values.size(); i++) {
				statement.setObject(i + 1, values.get(i));
			}
			statement.setInt(values.size() + 1, id);

			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Elimina una fila de una tabla de la base de datos por su ID.
	 * 
	 * @param tableName    el nombre de la tabla
	 * @param idColumnName el nombre de la columna de ID
	 * @param id           el valor del ID de la fila a eliminar
	 */
	public void delete(String tableName, String idColumnName, int id) {
		try {
			String query = "DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
