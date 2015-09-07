package screens;

import functions.addCloseButton;
import javafx.scene.layout.*;

public class entryView extends BorderPane{
	public entryView() {
		getChildren().clear();
		getStylesheets().add("css/entryView.css");
		
		BorderPane mainpane = new BorderPane();
		VBox options = new VBox();
		
		options.setId("options");
		
		options.setMinWidth(80);
		
		mainpane.setLeft(options);
		setCenter(mainpane);
		addCloseButton cb = new addCloseButton();
		cb.addxb();
		setTop(cb);
	}
	
}