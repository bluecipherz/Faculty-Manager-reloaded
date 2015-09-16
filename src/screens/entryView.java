package screens;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import javafx.util.StringConverter;
import load.Periods;
import load.TList;
import screens.database.*;

public class entryView extends BorderPane{
	int a=0,i=0;
	LoadDiv div = new LoadDiv();
	ListView list;
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
		Label divlab = new Label();
		VBox options = new VBox();
		VBox tlist = new VBox();
		Button ok = new Button("ok");
		Periods periods = new Periods();
		TList loadteacher = new TList();
		DatePicker date = new DatePicker();
		BorderPane datepane = new BorderPane();
		
		
		
		options.setId("options");
		tlist.setId("tlist");
		divgrid.setId("divgrid");
		bottompane.setId("bottompane");
		periods.setId("period");
		divlab.setId("divlabel");
		datepane.setId("datepane");
		
		
		emptylab.setPrefHeight(100);
		bottompane.setStyle("-fx-background-color:#ecf0f1;");
		

		StringConverter converter = new StringConverter<LocalDate>() {
	        DateTimeFormatter dateFormatter = 
	            DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        
	        @Override
	        public String toString(LocalDate date) {
	            if (date != null) {
	                return dateFormatter.format(date);
	            } else {
	                return "";
	            }
	        }
	        @Override
	        public LocalDate fromString(String string) {
	            if (string != null && !string.isEmpty()) {
	                return LocalDate.parse(string, dateFormatter);
	            } else {
	                return null;
	            }
	        }
	    };           
	    date.setConverter(converter);
	    date.setPromptText("dd-MM-yyyy".toLowerCase());
		
		date.setValue(LocalDate.now());
		

		maingrid=div.loadDiv();
		list = (ListView)div.takelist();
		periods.period();
		divlab.setText((String) list.getItems().get(0));
		list.setOnMouseClicked(e ->{
			divlab.setText((String) list.getSelectionModel().getSelectedItem());
			periods.getChildren().clear();
			periods.period();
		});
		final Node node = maingrid.getChildren().get(0);
		Platform.runLater(new Runnable() {
		     @Override
		     public void run() {
		         node.requestFocus();
		     }
		});
		
		datepane.setRight(date);
        options.getChildren().clear();
        options.getChildren().add(maingrid);
        divgrid.setHgap(5);
//		divgrid.add(emptylab, 0, 1);
		divgrid.add(datepane, 1, 0);
		divgrid.add(divlab, 0, 2);
		divgrid.add(periods, 1, 2);
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