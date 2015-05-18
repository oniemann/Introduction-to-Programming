//unlike java.lang, need to manually import these files
import java.awt.Container;
//implicitly creates a separate thread of execution which enters an infinite loop
//when loop detects a mouse click over JButton, method in JButton object is called
import javax.swing.*;
//imports the definition of the various event listener interfaces
import java.awt.event.*;

class HelloWorldButton {
    public static void main(String[] args) {
        //corresponds to window on computer's desktop
        //gives the window itself a name
        //from javax.swing
        JFrame frame = new JFrame("Hello World Button");

        //component to which we can add other components
        //getContentPane() gets reference to special JFrame container
        //done this way b/c adding components straight to JFrame makes things messy
        Container pane = frame.getContentPane();

        //constructor takes argument (string) and sets it as the label for JButton
        JButton hello = new JButton("Hello, World!");

        /*declares an object which tells the window to exit when the JButton is
        clicked, along with a "Goodbye!" message. 
        */
        //essentially a listener class, (i.e. delegated the responsibility of handling specific events)
            //in this case, exiting out of the window.
        GoodBye listener = new GoodBye();
        //adds the content pane to the JFrame
        hello.addActionListener(listener);

        //adds component to the JFrame's content pane
        pane.add(hello);

        /*frame.pack() tells JFrame to pack all objects within appropriately and
         then cause the window to show up on the screen*/
        //frame.pack();

        //alternately, can use fram.setSize() to pack it and provide proper size
        frame.setSize(300, 200);
        frame.setVisible(true);
        //NOTE: because there's only one button, the JFrame will fit the window to only include this button
    }
}

/*below class contains all methods specified in the interface "ActionListener"
to indicate that GoodBye contains the method actionPeformed()*/
//implementing ActionListener means the class MUST have an actionPerformed() method
class GoodBye implements ActionListener {
    //saying that the class implements the interface "ActionListener"
    public void actionPerformed(ActionEvent e) {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}