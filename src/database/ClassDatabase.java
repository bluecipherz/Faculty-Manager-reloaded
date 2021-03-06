package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassDatabase{
	public void createDatabase() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("drop table if exists class");
			  statement.executeUpdate("create table if not exists class (id integer auto increment, dept string, div string)");
			  statement.executeUpdate("insert into class values(1,'BCA','A')");
			  statement.executeUpdate("insert into class values(2,'BCA','B')");
			  statement.executeUpdate("insert into class values(3,'BCom','A')");
			  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void insertDatabase(String dept) {
		try {
			int i=1;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("select * from class");
			while(rs.next()) {
				i++;
			}
			statement.executeUpdate("insert into class values("+i+",'"+dept+"','A')");
			  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void update(String str) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from class where dept = '"+str+"'");
		String lastdiv = "A";
		char[] newdiv;
		int i=1;
		while(rs.next()) {
			lastdiv = rs.getString("div");
			i++;
		}
		newdiv = lastdiv.toCharArray();
		for(char alphabet = newdiv[0]; alphabet <= 'Z';alphabet++) {
			alphabet++;
			if(alphabet=='[')break;
			statement.executeUpdate("insert into class values("+i+",'"+str+"','"+alphabet+"')");
			break;
		}
	}
}