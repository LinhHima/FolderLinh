package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	@FXML
	private  ToggleGroup Group1;
	@FXML
	private RadioButton pen;
	@FXML
	private RadioButton eraser;
	
    @FXML
    private VBox drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if(Group1.getSelectedToggle().toString().equals(pen)) {
    		Circle newCircle = new Circle(event.getX(),event.getY(),4,Color.BLACK);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    	if(Group1.getSelectedToggle().toString().equals(eraser)) {
    		Circle newCircle = new Circle(event.getX(),event.getY(),4,Color.WHITE);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    	
    }

}
