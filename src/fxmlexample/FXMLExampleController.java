package fxmlexample;
 
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import com.sun.glass.ui.CommonDialogs.ExtensionFilter;
import com.sun.glass.ui.CommonDialogs.FileChooserResult;
import com.sun.glass.ui.Cursor;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.Robot;
import com.sun.glass.ui.Screen;
import com.sun.glass.ui.Size;
import com.sun.glass.ui.Timer;
import com.sun.glass.ui.View;
import com.sun.glass.ui.Window;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class FXMLExampleController extends Application{
    @FXML private Text actiontarget;
    
//    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
//        actiontarget.setText("Sign in button pressed");
//    }
    
    public void start() {
    
    }

    public static void main(String[] args) {
    	launch(args);
    }

	@Override
	public void start(Stage arg0) throws Exception {
		final Rectangle rect = new Rectangle();
		Group group = new Group();
		group.getChildren().add(rect);
		Scene scene = new Scene(group,200,200);
	    final double rectangleSpeed = 100 ; // pixels per second
	    final double minX = 0 ;
	    final double maxX = 800 ; // whatever the max value should be.. can use a property and bind to scene width if needed...
	    final DoubleProperty rectangleVelocity = new SimpleDoubleProperty();
	    final LongProperty lastUpdateTime = new SimpleLongProperty();
	    final AnimationTimer rectangleAnimation = new AnimationTimer() {
	      @Override
	      public void handle(long timestamp) {
	        if (lastUpdateTime.get() > 0) {
	          final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1 ;
	          final double deltaX = elapsedSeconds * rectangleVelocity.get();
	          final double oldX = rect.getTranslateX();
	          final double newX = Math.max(minX, Math.min(maxX, oldX + deltaX));
	          rect.setTranslateX(newX);
	        }
	        lastUpdateTime.set(timestamp);
	      }
	    };
	    rectangleAnimation.start();

	    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	      public void handle(KeyEvent event) {
	        if (event.getCode()==KeyCode.RIGHT) { // don't use toString here!!!
	          rectangleVelocity.set(rectangleSpeed);
	        } else if (event.getCode() == KeyCode.LEFT) {
	          rectangleVelocity.set(-rectangleSpeed);
	        }
	      }
	    });

	    scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
	      public void handle(KeyEvent event) {
	        if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT) {
	          rectangleVelocity.set(0);
	        }
	      }
	    });
		
	    arg0.setScene(scene);
	    arg0.show();
	}

	
}