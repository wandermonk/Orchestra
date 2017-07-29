package com.orchestra.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

	private String _dbUrl;
	private String _userName;
	private String _password;
	private String _driverName;

	public JDBCConnector(String driverName, String dbUrl, String userName, String password) {
		this._dbUrl = dbUrl;
		this._userName = userName;
		this._password = password;
		this._driverName = driverName;
	}

	public JDBCConnector(String driverName, String dbUrl) {
		this._dbUrl = dbUrl;
		this._driverName = driverName;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			if (_driverName != null) {
				Class.forName(_driverName);
				if (_userName != null && _password != null) {
					connection = DriverManager.getConnection(_dbUrl, _userName, _password);
				} else {
					connection = DriverManager.getConnection(_dbUrl);
				}
			} else {
				throw new IllegalArgumentException("drivername is mandatory");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
