package load;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TList extends BorderPane{
	public TList() {
		getChildren().clear();
		getStylesheets().add("css/tlist.css");
		
		LoadTeachers listpane = new LoadTeachers();
		BorderPane toppane = new BorderPane();
		Label title = new Label("Teachers List");
		TextField search = new TextField();
		
		title.setId("title");
		listpane.setId("list");
		toppane.setId("toppane");
		
		search.setPromptText("Search");
		
//		search.seton
		
		
		listpane.setAlignment(Pos.TOP_CENTER);
		listpane.setVgap(1);
//		toppane.setTop(title);
//		toppane.setCenter(search);
		
		setTop(title);
		setCenter(listpane);
		setId("border");
	}
}