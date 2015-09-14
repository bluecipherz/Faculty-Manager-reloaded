package screens;

import functions.addCloseButton;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import load.TList;
import screens.database.LoadDiv;

public class entryView extends BorderPane{
	int a=0,i=0;
	LoadDiv div = new LoadDiv();
	public entryView(Object object) {
		getChildren().clear();
		getStylesheets().add("css/entryView.css");
        giveNode(object);
		
		BorderPane mainpane = new BorderPane();
		BorderPane centerpane = new BorderPane();
		BorderPane bottompane = new BorderPane();
		GridPane divgrid = new GridPane();
		GridPane maingrid = new GridPane();
		Label emptylab = new Label();
		Label divlab = new Label("A");
		VBox options = new VBox();
		VBox tlist = new VBox();
		Button ok = new Button("ok");
		HBox periods = new HBox(1);
		Label test = new Label("testing");
		Label test1 = new Label("test2");
		TList loadteacher = new TList();
//		tlist.getChildren().add(test);
//		tlist.getChildren().add(test1);
		ClipboardContent content = new ClipboardContent();
		
		
		////////////////////////////////////////////
		test.setOnDragDetected(e -> {
			Dragboard db = test.startDragAndDrop(TransferMode.COPY);
			db.setDragView(new Text(test.getText()).snapshot(null, null), e.getX()-10, e.getY()-10);
			content.putString(test.getText());
			db.setContent(content);
			
		});
		test1.setOnDragDetected(e -> {
			Dragboard db = test1.startDragAndDrop(TransferMode.COPY);
			db.setDragView(new Text(test1.getText()).snapshot(null, null), e.getX()-10, e.getY()-10);
			content.putString(test1.getText());
			db.setContent(content);
			
		});
		
		
		
		options.setId("options");
		tlist.setId("tlist");
		divgrid.setId("divgrid");
		bottompane.setId("bottompane");
		periods.setId("period");
		divlab.setId("divlabel");
		
		
		emptylab.setPrefHeight(100);
		bottompane.setStyle("-fx-background-color:#ecf0f1;");
		

		while(i<6) {
			periods.getChildren().add(new Label());
			i++;
		}
		
//		for(i=0;i<6;i++) {
		
		periods.getChildren().get(0).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		periods.getChildren().get(0).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)periods.getChildren().get(0)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		periods.getChildren().get(1).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		periods.getChildren().get(1).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)periods.getChildren().get(1)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		periods.getChildren().get(2).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		periods.getChildren().get(2).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)periods.getChildren().get(2)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		periods.getChildren().get(3).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		periods.getChildren().get(3).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)periods.getChildren().get(3)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		periods.getChildren().get(4).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		periods.getChildren().get(4).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)periods.getChildren().get(4)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		periods.getChildren().get(5).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		periods.getChildren().get(5).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)periods.getChildren().get(5)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
//		}
		maingrid=div.loadDiv();
		final Node node = maingrid.getChildren().get(0);
		Platform.runLater(new Runnable() {
		     @Override
		     public void run() {
		         node.requestFocus();
		     }
		});
		
//		tlist.getChildren().add(loadteacher);
        options.getChildren().clear();
        options.getChildren().add(maingrid);
        divgrid.setHgap(5);
		divgrid.add(emptylab, 0, 0);
		divgrid.add(divlab, 0, 1);
		divgrid.add(periods, 1, 1);
		divgrid.setAlignment(Pos.TOP_CENTER);
		mainpane.setCenter(centerpane);
		mainpane.setLeft(options);
		mainpane.setRight(loadteacher);
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