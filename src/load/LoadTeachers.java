package load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

import database.TeacherDatabase;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class LoadTeachers extends GridPane{
	public LoadTeachers(){
		TeacherDatabase t = new TeacherDatabase();
		ClipboardContent content = new ClipboardContent();
		try {
			t.create("neethi");
		
		
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from teacherslist");
		int i=0;
		while(rs.next()) {
			Label label = new Label(rs.getString("name"));
//			setRowIndex(label, i);
//			setColumnIndex(label, i);
			add(new Label(rs.getString("name")), 0, i);
//			getChildren().lastIndexOf()
//			getChildren().get(i).setOnDragDetected(e -> {
//				Dragboard db = getChildren().get(0).startDragAndDrop(TransferMode.COPY);
////				db.setDragView(new Text(test.getText()).snapshot(null, null), e.getX()-10, e.getY()-10);
//				content.putString(((Label)getChildren().get(0)).getText());
//				db.setContent(content);
//				
//			});
			i++;
		}
		addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                for( Node node: getChildren()) {

                    if( node instanceof Label) {
//                        if( node.getBoundsInParent().contains(e.getSceneX(),  0)) {
//                            System.out.println(node);
                            node.setOnDragDetected(g -> {
                    			Dragboard db = node.startDragAndDrop(TransferMode.COPY);
//                    			db.setDragView(new Text(node.getText()).snapshot(null, null), e.getX()-10, e.getY()-10);
                    			content.putString(((Label)node).getText());
                    			db.setContent(content);
                    			
                    		});
//                        }
                    }
                }
            }
        });
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}