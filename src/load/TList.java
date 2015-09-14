package load;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TList extends BorderPane{
	public TList() {
		getChildren().clear();
		getStylesheets().add("css/tlist.css");
		
		GridPane listpane = new GridPane();
		Label title = new Label("Teachers List");
		Label main = new Label("main");
		
		title.setId("title");
		main.setId("title");
		listpane.setId("list");
		
		setTop(title);
		setBottom(main);
		setCenter(listpane);
	}
}