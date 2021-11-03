package net.codejava;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlite {

	public static void main(String[] args) {
		String jdbcurl = "jbdc:sqlite:/D:\\sqlite\\sqlite-tools-win32-x86-3360000\\sqlite-tools-win32-x86-3360000\\movies.db";
		try {
			Connection connection = DriverManager.getConnection(jdbcurl);
			String sql = "SELECT * FROM movies";
			
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = ((java.sql.Statement) statement).executeQuery(sql);
			while (result.next()) {
				String actor = result.getString("actor");
				String actress = result.getString("actress");
				String director = result.getString("director");
				String year_of_release = result.getString("year_of_release");
				
				System.out.println(actor + "|" + actress + "|" + director + "|" + year_of_release);

			}
		} catch (SQLException e) {
			System.out.println("error connecting to database");
			e.printStackTrace();
		}
		
	}

}
