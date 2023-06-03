package logicscape.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicscape.mapper.EntityMapper;

public class ConexionSql<T> {
    private static final String URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public ConexionSql() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

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

