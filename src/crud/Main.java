package crud;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		Connection con = DBCon.getCon();
		if (con ==  null) {
			System.out.println("Connection Failed.");
		} else {
			System.out.println("Connected.");
		}

	}

}
