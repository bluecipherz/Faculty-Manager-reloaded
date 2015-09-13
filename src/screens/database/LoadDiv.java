package screens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class LoadDiv{
	String[] str = null;
	public GridPane loadDiv() {
		GridPane maingrid = new GridPane();
		Button add = new Button("add");
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from TimeScheduler where dept = '"+str[1]+"'");
			int i=0;
			while(rs.next()) {
				maingrid.add(new Button(rs.getString("div")), 0, i);
				i++;
			}
			maingrid.add(add, 0, i);
			add.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					try {
						update(statement);
						maingrid.getChildren().clear();
						ResultSet rs = statement.executeQuery("select * from TimeScheduler where dept = '"+str[1]+"'");
						int i=0;
						while(rs.next()) {
							maingrid.add(new Button(rs.getString("div")), 0, i);
							i++;
						}
						maingrid.add(add, 0, i);
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
			});
		maingrid.setAlignment(Pos.TOP_CENTER);
//		maingrid.setVgap(1);
		}catch(Exception e) {System.out.println(e);}
		return(maingrid);
	}
	
	public void getNode(Object object) {
		str = object.toString().split("'");
//		System.out.println(str[1]);
	}
	public void update(Statement statement) throws SQLException {
		ResultSet rs = statement.executeQuery("select * from TimeScheduler where dept = '"+str[1]+"'");
		String lastdiv = "A";
		char[] newdiv;
		while(rs.next()) {
			lastdiv = rs.getString("div");
		}
		newdiv = lastdiv.toCharArray();
//		System.out.println(newdiv[0]);
		for(char alphabet = newdiv[0]; alphabet <= 'Z';alphabet++) {
			alphabet++;
			if(alphabet=='[')break;
//			System.out.println(str[1]);
			statement.executeUpdate("insert into timeScheduler (dept, div) values('"+str[1]+"','"+alphabet+"')");
			break;
		}
	}
}