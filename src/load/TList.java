package load;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class TList extends BorderPane{
	public TList() {
		getChildren().clear();
		getStylesheets().add("css/tlist.css");
		
		LoadTeachers listpane = new LoadTeachers();
		BorderPane toppane = new BorderPane();
		Label title = new Label("Teachers List");
		Label main = new Label("main");
		Label test = new Label("testing");
		Label test1 = new Label("test2");
		TextField search = new TextField();
		
		title.setId("title");
		main.setId("title");
		listpane.setId("list");
		toppane.setId("toppane");
		
		search.setPromptText("Search");
		
//		search.seton
		
		
		listpane.setAlignment(Pos.CENTER);
		listpane.setVgap(1);
		toppane.setTop(title);
		toppane.setCenter(search);
		
		setTop(toppane);
		setBottom(main);
		setCenter(listpane);
	}
}