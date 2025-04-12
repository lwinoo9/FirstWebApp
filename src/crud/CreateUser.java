package crud;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateUser {

	public static void main(String[] args) {
		CreateUser create = new CreateUser();
		create.deleteUser(5);

	}
	
	
	// Note : UnSecure ways

	public void createUser(String name, String pass) {

		String query = "INSERT INTO users (name,pass) VALUES ('" + name + "','" + pass + "')";
		Connection connection = DBCon.getCon();
		try {
			Statement stm = connection.createStatement();
			int result = stm.executeUpdate(query);
			if (result == 1) {
				System.out.println("Insert Success.");
			} else {
				System.out.println("Failed.");
			}
			stm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void retrieveAlluser() {
		String query = "SELECT * FROM users";
		try (Connection connection = DBCon.getCon(); Statement stm = connection.createStatement();) {
			ResultSet set = stm.executeQuery(query);
			while (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String pass = set.getString("pass");
				System.out.printf("Id is %d Name is %s and Password is %s\n", id, name, pass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void singleUser(int id) {
		String query = "SELECT * FROM users WHERE id='" + id + "'";
		try (Connection connection = DBCon.getCon(); Statement stm = connection.createStatement();) {
			ResultSet set = stm.executeQuery(query);
			if (set.next()) {
				System.out.printf("Id is %d Name is %s Id is %s", set.getInt("id"), set.getString("name"),
						set.getString("pass"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateUser(int id, String name) {
		String query = "UPDATE users SET name='" + name + "' WHERE id='" + id + "'";
		try (Connection connection = DBCon.getCon(); Statement stm = connection.createStatement()) {
			int set = stm.executeUpdate(query);
			if (set == 1) {
				System.out.println("User Updated.");
			} else {
				System.out.println("Failed.");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void deleteUser(int id) {

		String query = "DELETE FROM users where id='" + id + "'";
		try (Connection connection = DBCon.getCon(); Statement stm = connection.createStatement()) {
			int set = stm.executeUpdate(query);
			if (set == 1) {
				System.out.println("Deleted.");
			} else {
				System.out.println("Failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

}
