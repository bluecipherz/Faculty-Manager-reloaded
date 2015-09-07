package screens;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class weekView extends BorderPane {
	
	public weekView() {
		
		getChildren().clear();
		getStylesheets().add("css/week.css");
		
		BorderPane combopane = new BorderPane();
		BorderPane weekscrollpane = new BorderPane();
		GridPane weekgrid = new GridPane();
		GridPane prdgrid = new GridPane();
		ComboBox deptcombo = new ComboBox();
		
		
		HBox combohbox = new HBox();
		
		
		
		Button prevweek = new Button("<");
		Button nextweek = new Button(">");
		
		
		
		weekscrollpane.setId("grid-hbox");
		combohbox.setId("combo-hbox");
		deptcombo.setId("combo-box");
		combopane.setId("wvcombopane");
		weekgrid.setId("weekgrid");
		prdgrid.setId("prdgrid");
		prevweek.setId("prevweek");
		nextweek.setId("nextweek");
		
		combohbox.getChildren().clear();
		combohbox.getChildren().add(deptcombo);
		
		weekgrid.getChildren().clear();
		
		
		weekscrollpane.setLeft(prevweek);
		weekscrollpane.setRight(nextweek);
		
		weekgrid.add(weekscrollpane,0,0);
		weekgrid.add(prdgrid,0,1);
		
		for(int i=0;i<=6;i++) {
			for(int j=0;j<=6;j++) {
				
				prdgrid.add(new Label("prd"+ i + j ), j, i);
			}
			
		}
			
		prdgrid.setAlignment(Pos.CENTER);
		weekgrid.setAlignment(Pos.TOP_CENTER);
		
		weekgrid.setVgap(3);
		prdgrid.setHgap(5);
		prdgrid.setVgap(5);
		
		prdgrid .setMinSize(10, 10);
		weekscrollpane .setMinSize(550, 30);
		
		
		
		deptcombo.getItems().add("BCA");
		deptcombo.getItems().add("BCOM");
		deptcombo.getItems().add("BBA");
		
		combopane.setRight(combohbox);
		setTop(combopane);
		setCenter(weekgrid);
		
	}
}
