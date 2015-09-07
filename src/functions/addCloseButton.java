package functions;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class addCloseButton extends BorderPane{
	public void addx() {
		getChildren().clear();
		Button closebutton = new Button();
		closebutton.getStylesheets().add("css/menubar.css");
//		try {
		Image close = new Image(getClass().getResourceAsStream("../img/close.png"));
	    closebutton.setGraphic(new ImageView(close));
//		}catch(Exception e) {System.out.println(e);}
	    closebutton.setId("close-button");
		closebutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}
		});
		setRight(closebutton);
	}
	public void addxb() {
		try {
		getChildren().clear();
		Button closebutton = new Button();
		final Button backbutton = new Button();
		final Button restorebutton = new Button();
		final Button minimizebutton = new Button();
		HBox backbox = new HBox();
		HBox rightbox = new HBox();
		GridPane rightpane = new GridPane();
		getStylesheets().add("css/menubar.css");
		
		final Image back = new Image(getClass().getResourceAsStream("../img/arrow.png"));
		final Image backdb = new Image(getClass().getResourceAsStream("../img/arrow-black.png"));
		final Image restore = new Image(getClass().getResourceAsStream("../img/restore.png"));
		final Image minimize = new Image(getClass().getResourceAsStream("../img/minimize.png"));
		Image close = new Image(getClass().getResourceAsStream("../img/close.png"));
		closebutton.setGraphic(new ImageView(close));
		backbutton.setGraphic(new ImageView(back));
		restorebutton.setGraphic(new ImageView(restore));
		minimizebutton.setGraphic(new ImageView(minimize));
		
		closebutton.setId("close-button");
		backbutton.setId("back-button");
		restorebutton.setId("restore-button");
		backbox.setId("back-box");
		rightbox.setId("right-box");
		rightpane.setId("right-pane");
		
		backbutton.setOnMousePressed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				backbutton.setGraphic(new ImageView(backdb));
			}
		});
		backbutton.setOnMouseReleased(new EventHandler<Event>() {
			public void handle(Event arg0) {
				backbutton.setGraphic(new ImageView(back));
			}
		});
		closebutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				System.exit(0);
			}
		});
		rightpane.setAlignment(Pos.CENTER);
		
		rightbox.getChildren().clear();
		backbox.getChildren().clear();
		rightpane.add(minimizebutton, 0, 0);
		rightpane.add(restorebutton, 1, 0);
		rightpane.add(closebutton, 2, 0);
		rightbox.getChildren().add(rightpane);
		backbox.getChildren().add(backbutton);
		setRight(rightbox);
		setLeft(backbox);
		}catch(Exception e) {System.out.println(e);}
	}
}