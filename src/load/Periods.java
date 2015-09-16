package load;

import javafx.scene.control.Label;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;

public class Periods extends HBox{
	public void period() {
		int i=0;
		while(i<6) {
			getChildren().add(new Label());
			i++;
		}
		setSpacing(1);
//		for(i=0;i<6;i++) {
		
		getChildren().get(0).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		getChildren().get(0).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)getChildren().get(0)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		getChildren().get(1).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		getChildren().get(1).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)getChildren().get(1)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		getChildren().get(2).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		getChildren().get(2).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)getChildren().get(2)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		getChildren().get(3).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		getChildren().get(3).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)getChildren().get(3)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		getChildren().get(4).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		getChildren().get(4).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)getChildren().get(4)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
		
		getChildren().get(5).setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
        });
		getChildren().get(5).setOnDragDropped(e ->{
			Dragboard db = e.getDragboard();
			if (db.hasString()) {
				((Label)getChildren().get(5)).setText(db.getString());
                e.setDropCompleted(true);
            } else {
                e.setDropCompleted(false);
            }
		});
	}
}