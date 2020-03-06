package question2;
import java.awt.*;

import javax.swing.*;

//Class DisplayCards extends the JFrame properties

public class Cards extends JFrame

{
     //constructor

     public Cards()

     {
          //This function makes a display with 1 row, 3 columns, with 5 space each
          setLayout(new GridLayout(1,3,5,5));

          //This function make a image icon for the cards.png
          ImageIcon []icon=new ImageIcon[100];

          //loops through 54 cards .png images to randomize later on
          for(int i=1; i<54 ; i++)
          {
              icon[i]= new ImageIcon("images/Cards/"+(i)+".png");
          }

          //generates random for each 

          int r=(int)(Math.random()*54);

          int q=(int)(Math.random()*54);

          int p=(int)(Math.random()*54);

          //adding the random image to JLabel for each spades,hearts and diamond

          add(new JLabel(icon[r]));

          add(new JLabel(icon[q]));

          add(new JLabel(icon[p]));

     }

     public static void main(String args[])

     {

          Cards cards = new Cards();

          //setting a title to a frame

          cards.setTitle("Display Three Cards Randomly");

          //Frame size

          cards.setSize(600,600);        

          //This would exit the frame

          cards.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

          //This alters the visibility of the frame

          cards.setVisible(true);

     }

}
