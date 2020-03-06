package question2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class histogram extends Application
{
	
	//creates a pane for the text field object
	Pane pane = new Pane();
	TextField tObj = new TextField();
	VBox vBox = new VBox();

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//creates labels for file names
		Label fileLabel =  new Label("Filename:", tObj);
		fileLabel.setContentDisplay(ContentDisplay.RIGHT);
		tObj.setPrefColumnCount(20);
		Button viewButton = new Button("View"); //button for view
		HBox hobj = new HBox(fileLabel, viewButton); //hbox to set the file label and the view button
		vBox.getChildren().addAll(pane, hobj); //pane and h box object in the v boc which sets the children
		Scene sceneObj = new Scene(vBox);
		primaryStage.setScene(sceneObj);
		primaryStage.setTitle("Histogram"); //sets the title to histogram 
		primaryStage.sizeToScene();
		viewButton.setOnAction(e ->  //sets the action key when view button is cliken is dos something
		{
		Hist();
		vBox.setTranslateY(10);
		primaryStage.sizeToScene(); //sets the display
		primaryStage.setTitle("Histogram");		
		});
		primaryStage.show();
		
	}
	private void Hist()  //histogram function
	{
		Histogram graph = new
		Histogram(tObj.getText());
		pane.getChildren().add(graph);
	}
public static void main(String[]args) {
	Application.launch(args);
}

public static class Histogram extends Pane{ //this histogram calls out the pane and sets the histograms screen displau
	private char[]chars = new char[26];
	private int counts[] = new int[26];
	private Rectangle[] bar= new Rectangle[26];
	private File fileObj;
	GridPane pane;
	double w = 350;
	double h = 350;
	
//thsis histogram function when the file name is called it will read the file
public Histogram(String filename)
{
	this.fileObj = new File(filename.trim());
	setWidth(w);
	setHeight(h);
	readFile();
	drawHistogram();
}
private void readFile()
{
	Scanner scanner;
	String fileField ="";
	try
	{
		scanner = new Scanner(fileObj); //reads the file obj function 
		while(scanner.hasNextLine())
		{
			fileField +=scanner.nextLine();
		}
	}catch(IOException ex)
	{
		
	}
	fileField = fileField.toUpperCase(); // makes all the letters uppercase
	for(int i =0; i< fileField.length();i++)
	{
		char character = fileField.charAt(i);
		
		if(Character.isLetter(character))
		{
			counts[character - 'A']++; //counts the characters 
		}
	}
}
private double CountTotal() //this function counts the numbr of letters called
{
	double total =0;
	for(int count:counts)
	{
		total += count;
	}
	return total;
}
private void drawHistogram() //this function draws the histogram out
{
	pane = new GridPane();
	double barW = w / chars.length; //this barw creates the width 
	double total = CountTotal();
	for(int i = 0; i< counts.length;i++) //iterate through thte length 
	{
		chars[i] = (char)('A' + i); //goes through each character
		double percent=counts[i] / total; //counts it and pushes it to the variable percent
		double barH = h* percent;
		bar[i] = new Rectangle(barW,barH); //sets the bar size
		Label label = new Label(chars[i] + "", bar[i]);
		label.setContentDisplay(ContentDisplay.TOP); //sets the content display
		pane.add(label, i, 0);
		GridPane.setValignment(label, VPos.BASELINE);
		}
	getChildren().addAll(pane);
}
public int[] getCounts() //gets and sets the count in the getCount and setCounts functions
{
	return counts;
}
public void setCounts(int[]counts)
{
	this.counts = counts;
	drawHistogram();
}
}
}

