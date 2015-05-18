import java.awt.Container;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

class TextInput {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Input");
        Container pane = frame.getContentPane();
        //creates a text field
        JTextField input = new JTextField("Edit this text then hit <return>");
        JButton exit = new JButton("end");
        Echo listener = new Echo();
        GoodBye listener1 = new GoodBye();
        input.addActionListener(listener);
        exit.addActionListener(listener1);
        //must be put in to give more than one function to window!
        //2 = rows, 1 = column
        pane.setLayout(new GridLayout(2,1));
        pane.add(input);
        pane.add(exit);
        frame.pack();
        frame.setVisible(true);
    }
}

//below is action listener, uses javax.swing.JTextField
//echo whatever is in the text field by using println()
class Echo implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        //getSource() retyrbs a generic reference that must be cast into a JTextField
        //CPE: need to explicitly define "e", as e.getSource() returns an Object when it specifically needs JTextField
        JTextField source = (JTextField)e.getSource();
        //getText() retrieves the text
        String text = source.getText();
        System.out.println(text);
    }
}

//exits out of the window when the "end" button is pressed
class GoodBye implements ActionListener {
    //saying that the class implements the interface "ActionListener"
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}