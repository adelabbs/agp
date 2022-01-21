package persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import persistence.edb.EdbAPI;

public class JdbcConnection {
	private static final String DEFAULT_HOST = "localhost";
	private static final String DEFAULT_BASE = "agp_team1";
	private static final String DEFAULT_USER = "root";
	private static final String DEFAULT_PASSWORD = "";
	private static final String DEFAULT_URL = "jdbc:mysql://" + DEFAULT_HOST + "/" + DEFAULT_BASE;

	@SuppressWarnings("unused")
	private static String host;
	@SuppressWarnings("unused")
	private static String base;
	private static String user;
	private static String password;
	private static String url;
	private static boolean isSet = false;

	/**
	 * Lazy singleton instance.
	 */
	private static Connection connection;

	public static void setSpecifiedConnection(int connectionMode, String host, String base, String user,
			String password, String url) {
		if (connectionMode == EdbAPI.SPECIFIED_CONNECTION) {
			JdbcConnection.host = host;
			JdbcConnection.base = base;
			JdbcConnection.user = user;
			JdbcConnection.password = user;
			JdbcConnection.url = url;

			JdbcConnection.isSet = true;
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				if (!isSet) {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
				} else {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					connection = DriverManager.getConnection(url, user, password);
				}
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
		return connection;
	}
}