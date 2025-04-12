
package crud;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {

//	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
//	public static final String DB_URL = "jdbc:mysql://localhost:3306/School"; 
//	public static final String DB_USER = "root";
//	public static final String DB_PASS = "";

	Properties properties = null;
	static Connection connection = null;

	private DBCon() {

		properties = new Properties();
		try {
			properties.load(new FileReader("src/env.properties"));
			connection = DriverManager.getConnection(env("DB_URL"), env("DB_USER"), env("DB_PASS"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * Class.forName(DB_DRIVER);
		 * 
		 * //First way connection = DriverManager.getConnection(DB_URL, DB_USER,
		 * DB_PASS);
		 * 
		 * 
		 * //Second way Properties properties = new Properties(); properties.put("user",
		 * DB_USER); properties.put("password", DB_PASS); connection =
		 * DriverManager.getConnection(DB_URL,properties);
		 * 
		 * 
		 * //Third way //connection = DriverManager.getConnection(DB_URL + "?user=" +
		 * DB_USER + "&password=" + DB_PASS);
		 * 
		 * } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
		 * (SQLException e) { e.printStackTrace(); }
		 */

	}

	public String env(String key) {
		return properties.getProperty(key);
	}

	public static Connection getCon() {
		if (connection == null) {
			new DBCon();
		}
		return connection;
	}
}
