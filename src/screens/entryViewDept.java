package screens;

import functions.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class entryViewDept extends BorderPane{
	public entryViewDept(){
		getChildren().clear();
		getStylesheets().add("css/dept.css");
		addCloseButton cb = new addCloseButton();
		Label title = new Label("Departments");
		GridPane deptgrid = new GridPane();
		VBox lbox = new VBox();
		VBox rbox = new VBox();
		final entryView eview = new entryView();
		final ScrollPane hscrollpane = new ScrollPane();
		final Button emptybutton = new Button();

		hscrollpane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		
		String str="";
		int i =0,j=1,count=0;
		final int k=0;

		Random r = new Random(6);
		System.out.println(r);
		
		title.setId("title");
		deptgrid.setId("grid");
		hscrollpane.setId("scroll");
		lbox.setId("lbox");
		rbox.setId("rbox");
		emptybutton.setId("empty-button");
		
		emptybutton.setMaxWidth(40);
		emptybutton.setMinWidth(40);
		
		try {
			Class.forName("org.sqlite.JDBC");
		
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from TimeScheduler");
		deptgrid.add(emptybutton, 0, 0);
		try{
		while (rs.next()) {
			if(str.equals(rs.getString("dept"))){
				continue;
			}
			else {
				if(i==4) {
					i=0;j++;
				}
				deptgrid.add(new Button(rs.getString("dept")),j,i);
				str=rs.getString("dept");
				i++;
				count++;
			}
		}
		}catch(Exception e){System.out.println(e);}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for(i=1;i<=count;i++) {
			setBtnColor(deptgrid.getChildren().get(i));
		}
		
		for(i=1;i<=count;i++) {
			deptgrid.getChildren().get(i).setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event e) {
					getChildren().clear();
					setCenter(eview);
				}

			});
		}
		
		rbox.setOnMouseMoved(new EventHandler<Event>() {
			public void handle(Event arg0) {
				hscrollpane.setHvalue(hscrollpane.getHvalue()+0.03);
			}
		});
		lbox.setOnMouseMoved(new EventHandler<Event>() {
			public void handle(Event arg0) {
				hscrollpane.setHvalue(hscrollpane.getHvalue()-0.03);
			}
		});
		
		hscrollpane.prefWidthProperty().bind(deptgrid.widthProperty());
		hscrollpane.prefHeightProperty().bind(deptgrid.heightProperty());
		hscrollpane.setContent(deptgrid);
		hscrollpane.setCenterShape(true);
		deptgrid.setAlignment(Pos.CENTER);
		deptgrid.setVgap(8);
		deptgrid.setHgap(8);
		cb.addxb();
		cb.setCenter(title);
		setTop(cb);
		setCenter(hscrollpane);
		setLeft(lbox);
		setRight(rbox);
	}
	
	
	public void setBtnColor(Node btn) {
		Random rand = new Random(System.currentTimeMillis());
		String[] colors = new String[] {
				"#cc3333",
				"#336699",
				"#3399ff",
				"#009999",
				"#663366",
				"#cc6633",
				"#336699",
				"#009900",
				"#6633cc",
		};
		for (int i = 0; i < 10000; i++) {
		 int index = rand.nextInt(9);
		 btn.setStyle("-fx-background-color:"+colors[index]);
//		 System.out.println("red "+red+" green "+green+" blue "+blue);
		}
	}
	
	
}