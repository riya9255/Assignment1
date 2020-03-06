package question2;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseDragEvent;
import java.awt.Point;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class partThree extends Application {
  // UI components are defined

    private Circle circle;
    // main circle
    private Circle p1, p2, p3;
    // points on circle
    private Line l1, l2, l3;
    // points on line
    private Text ang1Txt, ang2Txt, ang3Txt;
    //angles

    @Override

    public void start(Stage primaryStage) {

    	//circle has to carry a radius of 150 so it will fit in the scene and the angles will be accurate
        circle = new Circle(150);

      //This measures the centre of the circle for x and y
        circle.setCenterX(250);
        circle.setCenterY(250);
      //makes the circle transparent
        circle.setFill(Color.TRANSPARENT);

      //black outline for the circle
        circle.setStroke(Color.BLACK);

        // 3 circles as points
        p1 = new Circle(10);
        p1.setFill(Color.RED);
        p1.setStroke(Color.BLACK);

     // made an event listener if mouse is dragged it will call the move point function amongst the points
        p1.setOnMouseDragged(e -> PointNew(p1, e));
        p2 = new Circle(10);
        p2.setFill(Color.RED);
        p2.setStroke(Color.BLACK);
        p2.setOnMouseDragged(e -> PointNew(p2, e));
        p3 = new Circle(10);
        p3.setFill(Color.RED);
        p3.setStroke(Color.BLACK);
        p3.setOnMouseDragged(e -> PointNew(p3, e));

        //default points and angles are initialized
        initialize();
        update();

        //pane is created
        Pane root = new Pane(circle, l1, l2, l3, ang1Txt, ang2Txt, ang3Txt, p1, p2, p3);

        // scene is displayed for the circle
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dragging Points Circle");
        primaryStage.show();
    }

    // initialize default values
    void initialize() {

        // text objects for angles 
        ang1Txt = new Text();
        ang2Txt = new Text();
        ang3Txt = new Text();

      //getting the center coordinates and radius of the circle
        double centerX = circle.getCenterX();
        double centerY = circle.getCenterY();
        double radius = circle.getRadius();

        // positioning points of angle
        double angle = 0;

        //Radians to angle, x and y coordinates are found
        double x = centerX + radius * Math.cos(Math.toRadians(angle));
        double y = centerY + radius * Math.sin(Math.toRadians(angle));
      
        p1.setCenterX(x);
        p1.setCenterY(y);

      //angle difference in distance form radius to point
        x = centerX + (radius - 50) * Math.cos(Math.toRadians(angle));
        y = centerY + (radius - 50) * Math.sin(Math.toRadians(angle));

        ang1Txt.setLayoutX(x);
        ang1Txt.setLayoutY(y);

        angle = 90;

        x = centerX + radius * Math.cos(Math.toRadians(angle));
        y = centerY + radius * Math.sin(Math.toRadians(angle));

        p2.setCenterX(x);
        p2.setCenterY(y);

        x = centerX + (radius - 50) * Math.cos(Math.toRadians(angle));
        y = centerY + (radius - 50) * Math.sin(Math.toRadians(angle));

        ang2Txt.setLayoutX(x);
        ang2Txt.setLayoutY(y);

        angle = 180;

        x = centerX + radius * Math.cos(Math.toRadians(angle));
        y = centerY + radius * Math.sin(Math.toRadians(angle));

        p3.setCenterX(x);
        p3.setCenterY(y);

        x = centerX + (radius - 50) * Math.cos(Math.toRadians(angle));
        y = centerY + (radius - 50) * Math.sin(Math.toRadians(angle));

        ang3Txt.setLayoutX(x);
        ang3Txt.setLayoutY(y);

        // points are connected with lines
        l1 = new Line(p1.getCenterX(), p1.getCenterY(), p2.getCenterX(), p2.getCenterY());
        l2 = new Line(p2.getCenterX(), p2.getCenterY(), p3.getCenterX(), p3.getCenterY());
        l3 = new Line(p3.getCenterX(), p3.getCenterY(), p1.getCenterX(), p1.getCenterY());
    }

    // points updated according to mouse movement
    void PointNew(Circle point, MouseEvent event) {

        // point's locations
        double x1 = event.getX();
        double x2 = circle.getCenterX();
        double y1 = event.getY();
        double y2 = circle.getCenterY();

        //angles found
        double angle = Math.atan2(y1 - y2, x1 - x2);
        double newX = x2 + circle.getRadius() * Math.cos(angle);
        double newY = y2 + circle.getRadius() * Math.sin(angle);

        //point locations set to coordinates
        point.setCenterX(newX);
        point.setCenterY(newY);

        //coordinates updated
        newX = x2 + (circle.getRadius() - 50) * Math.cos(angle);
        newY = y2 + (circle.getRadius() - 50) * Math.sin(angle);

        if (point.equals(p1)) {
            ang1Txt.setLayoutX(newX);
            ang1Txt.setLayoutY(newY);
        }

        else if (point.equals(p2)) {
            ang2Txt.setLayoutX(newX);
            ang2Txt.setLayoutY(newY);
        }

        else {
            ang3Txt.setLayoutX(newX);
            ang3Txt.setLayoutY(newY);
        }

        // view is updated
        update();
    }

    // view is updated
    void update() {

        // lines are connected again
        l1.setStartX(p1.getCenterX());
        l1.setStartY(p1.getCenterY());
        l1.setEndX(p2.getCenterX());
        l1.setEndY(p2.getCenterY());
        l2.setStartX(p2.getCenterX());
        l2.setStartY(p2.getCenterY());
        l2.setEndX(p3.getCenterX());
        l2.setEndY(p3.getCenterY());
        l3.setStartX(p3.getCenterX());
        l3.setStartY(p3.getCenterY());
        l3.setEndX(p1.getCenterX());
        l3.setEndY(p1.getCenterY());

        //f distance between 2 and 3 found
        double a = Point.distance(p2.getCenterX(), p2.getCenterY(), p3.getCenterX(), p3.getCenterY());
        // between 1 and 3
        double b = Point.distance(p1.getCenterX(), p1.getCenterY(), p3.getCenterX(), p3.getCenterY());
        // between 2 and 1
        double c = Point.distance(p2.getCenterX(), p2.getCenterY(), p1.getCenterX(), p1.getCenterY());

        // angles found using equation
        double angle1 = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
        double angle2 = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
        double angle3 = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

        // text shown
        ang1Txt.setText(String.format("%.1f", Math.toDegrees(angle1)));
        ang2Txt.setText(String.format("%.1f", Math.toDegrees(angle2)));
        ang3Txt.setText(String.format("%.1f", Math.toDegrees(angle3)));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
