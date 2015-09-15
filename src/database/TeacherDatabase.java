package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDatabase{
	public void create(String name) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		
		statement.executeUpdate("create table if not exists teacherslist (id integer auto increment,name text unique)");
//		statement.executeUpdate("insert or replace into teacherslist (name) values('"+name+"')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('jabbar')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('prajeesh')");
		
//		statement.executeQuery("drop table if exists "+name);
//		statement.executeUpdate("create table if not exists "+name+" (id integer,date Date,period string, dept string, div string)");
	}
	public void insertDatabase(String name) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert or replace into teacherslist (name) values('"+name+"')");
	}
}