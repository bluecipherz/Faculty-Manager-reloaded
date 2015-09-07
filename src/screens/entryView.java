package screens;

import functions.addCloseButton;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import screens.database.LoadDiv;

public class entryView extends BorderPane{
	public entryView() {
		getChildren().clear();
		getStylesheets().add("css/entryView.css");
		
		LoadDiv div = new LoadDiv();
		BorderPane mainpane = new BorderPane();
		GridPane divgrid = new GridPane();
		Label emptylab = new Label();
		VBox options = new VBox();
		VBox tlist = new VBox();
		
		options.setId("options");
		tlist.setId("tlist");
		
		emptylab.setPrefHeight(100);
		
		
		ToolBar toolBar = new ToolBar();

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");
        Button button5 = new Button("button5");
        Button button6 = new Button("button6");
        toolBar.getItems().addAll(button1, button2, button3, button4, button5, button6);
        options.getChildren().clear();
        options.getChildren().add(div);
		divgrid.add(emptylab, 0, 0);
		divgrid.add(toolBar, 0, 1);
		divgrid.setAlignment(Pos.TOP_CENTER);
		mainpane.setCenter(divgrid);
		mainpane.setLeft(options);
		mainpane.setRight(tlist);
		setCenter(mainpane);
		addCloseButton cb = new addCloseButton();
		cb.addxb();
		setTop(cb);
	}
	public void giveNode(Object object) {
		LoadDiv div = new LoadDiv();
		div.getNode(object);
		div.loadDiv();
	}
	
}