package screens;

import functions.addCloseButton;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import screens.database.LoadDiv;

public class entryView extends BorderPane{
	int a=0;
	LoadDiv div = new LoadDiv();
	public entryView(Object object) {
		getChildren().clear();
		getStylesheets().add("css/entryView.css");
        giveNode(object);
		
		BorderPane mainpane = new BorderPane();
		BorderPane centerpane = new BorderPane();
		BorderPane bottompane = new BorderPane();
		GridPane divgrid = new GridPane();
		Label emptylab = new Label();
		VBox options = new VBox();
		VBox tlist = new VBox();
		Button ok = new Button("ok");
		
		options.setId("options");
		tlist.setId("tlist");
		divgrid.setId("divgrid");
		bottompane.setId("bottompane");
		
		emptylab.setPrefHeight(100);
		bottompane.setStyle("-fx-background-color:#ecf0f1;");
		
		
		ToolBar toolBar = new ToolBar();

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");
        Button button5 = new Button("button5");
        Button button6 = new Button("button6");
        toolBar.getItems().addAll(button1, button2, button3, button4, button5, button6);
        options.getChildren().clear();
        options.getChildren().add(div.loadDiv());
		divgrid.add(emptylab, 0, 0);
		divgrid.add(toolBar, 0, 1);
		divgrid.setAlignment(Pos.TOP_CENTER);
		mainpane.setCenter(centerpane);
		mainpane.setLeft(options);
		mainpane.setRight(tlist);
		centerpane.setCenter(divgrid);
		centerpane.setBottom(bottompane);
		bottompane.setRight(ok);
		
		addCloseButton cb = new addCloseButton();
		cb.addxb(1);
		setTop(cb);
		setCenter(mainpane);
	}
	public void giveNode(Object object) {
		div.getNode(object);
	}
	
}