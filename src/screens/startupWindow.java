package screens;

import functions.addCloseButton;
import animations.animations;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.*;

public class startupWindow extends BorderPane{
	
startupWindow(){
	
	getChildren().clear();
	getStylesheets().add("css/style.css");
	
	animations a= new animations();
	addCloseButton cb = new addCloseButton();
	GridPane startupgrid = new GridPane();
	VBox startgaphbox = new VBox();
	final Button detailb = new Button("Detail Mode");
	final Button entryb = new Button("Entry Mode");
	
//	Image close = new Image(getClass().getResourceAsStream("../img/detailicon.png"));
//    detailb.setGraphic(new ImageView(close));

	detailb.setStyle("-fx-background-image: url('img/detailicon.png');");
	entryb.setStyle("-fx-background-image: url('img/entryicon.png');");

	detailb.setId("detailb");
	entryb.setId("entryb");

//CSS OF STARUPWINDOW	
	
	//rootpane.setStyle("-fx-background-color: #1f0068;");
	
    detailb.setAlignment(Pos.BOTTOM_LEFT);
    entryb.setAlignment(Pos.BOTTOM_LEFT);
	
	Reflection r1 = new Reflection();
	Reflection r2 = new Reflection();
    r1.setFraction(5);
    r2.setFraction(5);
    entryb.setEffect(r1);
    detailb.setEffect(r2);
    
    a.transition(a.path(0,10,100),entryb,1500,1);
   
    a.fadeIn(entryb,1500,0,1,1);
    try {
		Thread.sleep(150);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    a.transition(a.path(0,10,100),detailb,1500,1);
    a.fadeIn(detailb,1500,0,1,1);
    
//ACTIONS OF STARTUPWINDOW	
	
	detailb.setOnAction(new EventHandler<ActionEvent>() {
		
		public void handle(ActionEvent ae) {
			getChildren().clear();
			final detailView dview = new detailView();
			setCenter(dview);
		}
	});
	
	entryb.setOnAction(new EventHandler<ActionEvent>() {
		
		public void handle(ActionEvent ae) {
			getChildren().clear();
			final entryViewDept eviewdept = new entryViewDept();
			setCenter(eviewdept);
		}
	});
	
//	detailb.setOnMouseEntered(new EventHandler<MouseEvent>() {
//
//		public void handle(MouseEvent e) {
//			
//		}
//		
//	});
	
	
	startgaphbox .setMinSize(10, 10);
	detailb.setPrefWidth(185);
	detailb.setPrefHeight(100);
	entryb.setPrefWidth(185);
	entryb.setPrefHeight(100);
	
	setCenter(startupgrid);
	startupgrid.add(entryb, 0, 0);
	startupgrid.add(startgaphbox, 1, 0);
	startupgrid.add(detailb, 2, 0);
	
	startupgrid .setAlignment(Pos.CENTER);
	startupgrid .setMinSize(10, 10);
	cb.addx();
	setTop(cb);
	
}
  }
