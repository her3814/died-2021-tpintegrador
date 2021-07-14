package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddSingleton {
	private static final String JDBC_NAME = "org.mariadb.jdbc.Driver";
	private static final String DB_USER = "died_java";
	private static final String DB_PASS = "Dbcon355";
	private static final String DB_URL = "jdbc:mariadb://66.97.33.165:3307/died";

	public static Connection GetConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
