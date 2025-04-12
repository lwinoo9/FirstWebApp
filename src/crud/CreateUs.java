package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateUs {

	public static void main(String[] args) {
		UserTable user = new UserTable();
		user.deleteUser(6);
	}

}

class UserTable {

	public void createUser(String name, String pass) {

		String query = "INSERT INTO users (name,pass) VALUES (?,?)";

		try (Connection connection = DBCon.getCon(); PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, name);
			ps.setString(2, pass);
			System.out.println(ps.executeUpdate() == 1 ? "Success" : "Failed");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ReadUser(int id) {
		String query = "SELECT * FROM users WHERE id=?";
		try (Connection connection = DBCon.getCon(); PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				System.out.printf("Id is %d Name is %s Password is %s", set.getInt("id"), set.getString("name"),
						set.getString("pass"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateUser(int id, String name) {

		String query = "UPDATE users SET id=? WHERE name=?";
		try (Connection connection = DBCon.getCon(); PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(2, name);
			ps.setInt(1, id);

			System.out.println(ps.executeUpdate() == 1 ? "Updated." : "Failed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteUser(int id) {
		String query = "DELETE FROM users WHERE id=?";
		try (Connection connection = DBCon.getCon(); PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			System.out.println(ps.executeUpdate() == 1 ? "Deleted" : "Failed");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
