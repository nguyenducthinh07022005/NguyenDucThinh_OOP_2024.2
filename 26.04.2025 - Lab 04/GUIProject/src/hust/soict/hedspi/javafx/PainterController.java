package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	public PainterController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML 
	private Pane drawingAreaPane;

	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	
	@FXML
	void drawingAreaMouseDrag(MouseEvent event) {
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
		drawingAreaPane.getChildren().add(newCircle);			
	}
}
