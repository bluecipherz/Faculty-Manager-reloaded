package load;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;

public class Periods extends HBox{
	
	ObservableList<String> entries = FXCollections.observableArrayList();
	
	@SuppressWarnings("unchecked")
	public void period() {
		int i=0;
//		while(i<6) {
			getChildren().add(new ComboBox<Object>());
			getChildren().add(new ComboBox<Object>());
			((ComboBox<?>)getChildren().get(0)).setEditable(true);
			((ComboBox<?>)getChildren().get(0)).setPromptText("period 1");
			((ComboBox<?>)getChildren().get(1)).setEditable(true);
			((ComboBox<?>)getChildren().get(1)).setPromptText("period 1");
//			((ComboBox)getChildren().get(0)).getEditor().textProperty().addListener(new ChangeListener<T>() {
//				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
//					search( (String)oldValue, (String)newValue );
//				}
//			});
				for(char a = 'A'; a <= 'Z';a++) {
					for(char b = 'A'; b <= 'Z';b++) {
						entries.add(""+a+b+a+b+a+b);
					}
				}
			((ComboBox<String>)getChildren().get(0)).setItems(entries);
			((ComboBox<?>)getChildren().get(0)).getEditor().textProperty().addListener(new ChangeListener<Object>() {
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					search( (String)oldValue, (String)newValue, ((ComboBox)getChildren().get(0)));
				}
			});
			((ComboBox<String>)getChildren().get(1)).setItems(entries);
			((ComboBox<?>)getChildren().get(1)).getEditor().textProperty().addListener(new ChangeListener<Object>() {
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					search( (String)oldValue, (String)newValue, ((ComboBox)getChildren().get(1)));
				}
			});
//			i++;
//		}
		setSpacing(1);
//		for(i=0;i<6;i++) {
		
//		getChildren().get(0).setOnDragOver(e -> {
//            e.acceptTransferModes(TransferMode.COPY);
//        });
		
	}
	public void search(String oldVal , String newVal,ComboBox list) {
		if ( oldVal != null && (newVal.length() < oldVal.length()) ) {
			list.setItems(entries);
		}
		String[] parts = newVal.toUpperCase().split(" ");
		ObservableList<String> subentries = FXCollections.observableArrayList();
		for(Object entry : list.getItems()) {
			boolean match = true;
			String entryset = (String)entry;
			for(String part : parts) {
				if (! entryset.toUpperCase().contains(part)) {
					match=false;
					break;
					
				}
			}
			if (match) {
				subentries.add(entryset);
			}
//			((ComboBox)getChildren().get(0)).getEditor().setText(subentries.get(0));
		}
		list.setItems(subentries);
//		list.getSelectionModel().select(list.getSelectionModel().getSelectedIndex());
		list.show();
	}
}