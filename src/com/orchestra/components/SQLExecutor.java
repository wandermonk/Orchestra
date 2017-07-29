package com.orchestra.components;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExecutor {

	private Connection _connection;
	private Statement _statement;

	public SQLExecutor(Connection connection) {
		this._connection = connection;
	}

	public int executeUpdateQuery(String query) {
		int results = 0;
		try {
			_statement = _connection.createStatement();
			results = _statement.executeUpdate(query);
		} catch (SQLException e) {
			// throw new DatabaseException(DatabaseError.GENERIC_DB_EXCEPTION);
		} finally {
			if (_statement != null) {
				try {
					_statement.close();
				} catch (SQLException e) {
					// throw new
					// DatabaseException(DatabaseError.GENERIC_DB_EXCEPTION);
				}
			}
		}
		return results;
	}

	public void executeCreateStatement(String insertquery) {
		try {
			_statement = (_connection).createStatement();
			_statement.executeQuery(insertquery);
		} catch (SQLException e) {
			// throw new DatabaseException(DatabaseError.GENERIC_DB_EXCEPTION);
		} finally {
			if (_statement != null) {
				try {
					_statement.close();
				} catch (SQLException e) {
					// throw new
					// DatabaseException(DatabaseError.GENERIC_DB_EXCEPTION);
				}
			}
		}
	}
}
