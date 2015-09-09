package screens;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class monthView extends BorderPane {
	
	public monthView(){
		getChildren().clear();
		getStylesheets().add("css/month.css");
		
		BorderPane monthpane =new BorderPane();
		GridPane monthgrid = new GridPane();
		GridPane monthScroll = new GridPane();
		TableView table = new TableView();
		
//		table.set
		TableColumn date = new TableColumn("DATE");
        TableColumn period1 = new TableColumn("Prd1");
        TableColumn period2 = new TableColumn("Prd2");
        TableColumn period3 = new TableColumn("Prd3");
        TableColumn period4 = new TableColumn("Prd4");
        TableColumn period5 = new TableColumn("Prd5");
        TableColumn period6 = new TableColumn("Prd6");
        
        table.getColumns().addAll(date, period1, period2,period3,period4,period5,period6);
        monthpane.setTop(table);
        
        table.setPrefWidth(400);
        table.setPrefHeight(400);
        
		
	}

}
