package question1;
import java.awt.*;
import javax.swing.*;

public class firstPart extends JFrame {

     public firstPart() {
			 // the constructor
			 // GridLayout with 1 row, 3 columns
			 // 5 space eac
          setLayout(new GridLayout(1,3,5,5));
          //array of ImageIcon class
          ImageIcon []icon=new ImageIcon[52];
          //initialising the array
          for(int i=1; i<52 ; i++) {

              icon[i]= new ImageIcon("images/Cards/"+(i)+".png");
          }
          //generating the random numbers
          int r=(int)(Math.random()*52);
          int q=(int)(Math.random()*52);
          int p=(int)(Math.random()*52);

          //adding the random image to JLabel
          add(new JLabel(icon[r]));
          add(new JLabel(icon[q]));
          add(new JLabel(icon[p]));
     }

     public static void main(String args[]) {

          firstPart cards = new firstPart();
          //title
          cards.setTitle("Display Three Cards Randomly");
          //frame size
          cards.setSize(600,600);
          //exit frame
          cards.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
          //set visiblility of frame
          cards.setVisible(true);
     }

}
