package screens;

import functions.addCloseButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class detailView extends BorderPane {
	
	addCloseButton cb = new addCloseButton();
	weekView wview = new weekView();
	
	public detailView(){
		
		getChildren().clear();
		getStylesheets().add("css/detail.css");
		
		GridPane optiongrid = new GridPane(); 
		optiongrid.setId("optiongrid");
		BorderPane centerpane = new BorderPane();
		
		Button Weekview = new Button("Week View");
		Button Monthview= new Button("Month View");
		Button YearView= new Button("Year View");
		Button IndividualView = new Button("Individual View");
		Label labelbutton = new Label();
		labelbutton.setId("labelbutton");
		Weekview.setId("Weekview");
		Monthview.setId("Monthview");
		YearView.setId("YearView");
		IndividualView.setId("IndividualView");
	
		Weekview.setAlignment(Pos.BASELINE_LEFT);
		Monthview.setAlignment(Pos.BASELINE_LEFT);
		YearView.setAlignment(Pos.BASELINE_LEFT);
		IndividualView.setAlignment(Pos.BASELINE_LEFT);
	//	labelbutton.setStyle("-fx-background-image: url('img/BackButton.png');");
		labelbutton.setPrefSize(150, 30);
		Weekview.setPrefSize(150, 30);
		Monthview.setPrefSize(150, 30);
		YearView.setPrefSize(150, 30);
		IndividualView.setPrefSize(150, 30);
		

		setLeft(optiongrid);
		optiongrid.add(labelbutton,0,1);
		optiongrid.add(Weekview,0,2);
		optiongrid.add(Monthview,0,3);
		optiongrid.add(YearView,0,4);
		optiongrid.add(IndividualView,0,5);
		
		optiongrid .setMinSize(10, 10);
		
		optiongrid .setAlignment(Pos.TOP_CENTER);
		
		centerpane.setCenter(wview);
		setCenter(centerpane);
		cb.addxb();
		setTop(cb);
		
//		BUTTON ACTIONS
		
		Monthview.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent ae) {
				getChildren().clear();
				final monthView mview = new monthView();
				setCenter(mview);
			}
		});
		
			
			}
	}


