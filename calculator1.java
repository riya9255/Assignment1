package question2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class calculator1 extends Application {

@Override
public void start(Stage primaryStage) throws Exception {
	
	Calculator panes = new Calculator();
	//gets the title of the pane and sets the width and the height of the pane
	primaryStage.setScene(new Scene(panes, panes.getPrefWidth(), panes.getPrefHeight()));
	primaryStage.setTitle("Calculator");
	primaryStage.show();
	}

public static void main(String[] args) {

Application.launch(args);//launch the calculator
}


private class Calculator extends GridPane {
	//generate the labels
	
	Label InvestLabel = new Label("Investment Amount:");
	TextField InvestText = new TextField();
	
	Label yearsLabel = new Label("Years:");
	TextField yearsText = new TextField();
	
	Label AnnualLabel = new Label("Annual Interest Rate:");
	TextField AnnualText = new TextField();
	
	Label futureLabel = new Label("Future Value:");
	TextField futureText = new TextField();
	
	Button Calc = new Button("Calculate");
	
	private Calculator() {
	
	// Creates the layout of the form 
	setPadding(new Insets(10, 10, 10, 10));
	setAlignment(Pos.CENTER);
	setHgap(10);
	setVgap(10);
	
	add(InvestLabel, 0, 0);
	add(InvestText, 1, 0);
	
	add(yearsLabel, 0, 1);
	add(yearsText, 1, 1);
	
	add(AnnualLabel, 0, 2);
	add(AnnualText, 1, 2);
	
	add(futureLabel, 0, 3);
	add(futureText, 1, 3);
	
	HBox buttons = new HBox();
	buttons.getChildren().add(Calc);
	buttons.setAlignment(Pos.BOTTOM_RIGHT);//fixes the desired position of the button
	add(buttons, 1, 4);
	Calc.setOnAction(e-> CalculatorVal());
	
	//Makes the text field an array
	TextField[] textFields = (TextField[])getArray(
	InvestText, yearsText, AnnualText, futureText);
	
	//aligns the textfield to the right 
	for (TextField tf : textFields) {
	tf.setAlignment(Pos.BASELINE_RIGHT);
	}
	futureText.setDisable(true);//disables the textfield for future val
	
	}

//gets the  objects and makes it into an array using the length
private Object[] getArray(Object... objects) {
	Object[] temp = new TextField[objects.length];
	for (int i = 0; i < objects.length; i++) {
		temp[i] = objects[i];
		}
		return temp;
		}

//calculates the future Value
public void CalculatorVal() {
	double investment = Double.parseDouble(InvestText.getText());
	double years = Double.parseDouble(yearsText.getText());
	double IntRate= Double.parseDouble(AnnualText.getText()) / 12 / 100;
	
	double futureValue = investment * Math.pow(1 + IntRate, years * 12);
	futureText.setText(String.format("$%.2f", futureValue));//set text to calculated value
	}
}
}
