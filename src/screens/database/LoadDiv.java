package screens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class LoadDiv extends GridPane{
	String[] str = null;
	public void loadDiv() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from TimeScheduler where dept = '"+str[1]+"'");
			int i=0;
			while(rs.next()) {
				add(new Button(rs.getString("div")), i, 0);
				System.out.println(rs.getString("div"));
				i++;
			}
		setAlignment(Pos.TOP_CENTER);
		}catch(Exception e) {System.out.println(e);}
	}
	
	public void getNode(Object object) {
		str = object.toString().split("'");
//		System.out.println(str[1]);
	}
}