package screens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class LoadDiv{
	String[] str = null;
	public GridPane loadDiv() {
		GridPane maingrid = new GridPane();
		try {
			System.out.println("enterd");
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from TimeScheduler where dept = '"+str[1]+"'");
			int i=0;
			while(rs.next()) {
				maingrid.add(new Button(rs.getString("div")), 0, i);
				System.out.println(rs.getString("div"));
				i++;
			}
		maingrid.setAlignment(Pos.TOP_CENTER);
//		maingrid.setVgap(1);
		}catch(Exception e) {System.out.println(e);}
		return(maingrid);
	}
	
	public void getNode(Object object) {
		str = object.toString().split("'");
//		System.out.println(str[1]);
	}
}