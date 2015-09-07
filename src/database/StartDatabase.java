package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StartDatabase{
	public StartDatabase() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("drop table if exists timeScheduler");
			  statement.executeUpdate("create table if not exists timeScheduler (id integer, dept string, div string)");
			  statement.executeUpdate("insert into timeScheduler values(1, 'BCA','A')");
			  statement.executeUpdate("insert into timeScheduler values(2, 'BCA','B')");
			  statement.executeUpdate("insert into timeScheduler values(3, 'BCom','A')");
			  statement.executeUpdate("insert into timeScheduler values(4, 'BCom','B')");
			  statement.executeUpdate("insert into timeScheduler values(5, 'BCom','C')");
			  statement.executeUpdate("insert into timeScheduler values(6, 'BCom','D')");
			  statement.executeUpdate("insert into timeScheduler values(7, 'BBA','A')");
			  statement.executeUpdate("insert into timeScheduler values(8, 'Bsc_English','A')");
			  statement.executeUpdate("insert into timeScheduler values(9, 'Bsc_Maths','A')");
			  statement.executeUpdate("insert into timeScheduler values(10, 'Bsc_Economics','A')");
			  statement.executeUpdate("insert into timeScheduler values(11, 'Ba_Malayalam','A')");
			  statement.executeUpdate("insert into timeScheduler values(12, 'Ba_English','A')");
			  statement.executeUpdate("insert into timeScheduler values(13, 'Ba_Urudu','A')");
			  statement.executeUpdate("insert into timeScheduler values(14, 'Ba_Arabic','A')");
			  statement.executeUpdate("insert into timeScheduler values(15, 'Ba_Sanskrit','A')");
			  statement.executeUpdate("insert into timeScheduler values(16, 'Ba_Hindi','A')");
			  statement.executeUpdate("insert into timeScheduler values(17, 'MCom','A')");
			  statement.executeUpdate("insert into timeScheduler values(18, 'MBA','A')");
			  statement.executeUpdate("insert into timeScheduler values(19, 'MCA','A')");
			  statement.executeUpdate("insert into timeScheduler values(20, 'Msc_ComputerScience','A')");
			  statement.executeUpdate("insert into timeScheduler values(21, 'Msc_Maths','A')");
			  statement.executeUpdate("insert into timeScheduler values(22, 'Msc_English','A')");
			  statement.executeUpdate("insert into timeScheduler values(23, 'Msc_Sanskrit','A')");
			  statement.executeUpdate("insert into timeScheduler values(24, 'Msc_Japan','A')");
			  statement.executeUpdate("insert into timeScheduler values(25, 'Msc_Korea','A')");
			  statement.executeUpdate("insert into timeScheduler values(26, 'Msc_Arabic','A')");
			  statement.executeUpdate("insert into timeScheduler values(27, 'Msc_Chokli','A')");
			  statement.executeUpdate("insert into timeScheduler values(28, 'Msc_Shaji','A')");
			  statement.executeUpdate("insert into timeScheduler values(29, 'Msc_Sulpi','A')");
			  statement.executeUpdate("insert into timeScheduler values(30, 'Msc_Chiyapa','A')");
			  statement.executeUpdate("insert into timeScheduler values(31, 'Msc_Shibi','A')");
			  statement.executeUpdate("insert into timeScheduler values(32, 'Msc_Rinoy','A')");
			  statement.executeUpdate("insert into timeScheduler values(33, 'Msc_Rinas','A')");
			  statement.executeUpdate("insert into timeScheduler values(34, 'Msc_Roshan','A')");
			  statement.executeUpdate("insert into timeScheduler values(35, 'Msc_Anu','A')");
			  statement.executeUpdate("insert into timeScheduler values(36, 'Msc_Basi','A')");
			  statement.executeUpdate("insert into timeScheduler values(37, 'Msc_Neethi','A')");
			  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}