import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MiniCalc {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Calculator");
        Container pane = frame.getContentPane();
        //create major components
        //text fields are long enough to contain 20 characters
        JTextField firstNumber = new JTextField(20);
        JTextField secondNumber = new JTextField(20);
        JTextField result = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton subButton = new JButton("Subtract");
        JButton multButton = new JButton("Multiply");
        JButton divButton = new JButton("Divide");

        //set up the number of cells needed via a layout manager
        //java.iwt.GridLayout
        pane.setLayout(new GridLayout(5, 2));

        //add all contents to the content pane
        //didn't save reference to JLabels because they only need to be referenced once
        pane.add(new JLabel("Enter a number"));
        pane.add(firstNumber);
        pane.add(new JLabel("Enter another number"));
        pane.add(secondNumber);
        pane.add(new JLabel("Result"));
        pane.add(result);
        pane.add(addButton);
        pane.add(subButton);
        pane.add(multButton);
        pane.add(divButton);

        //set up the listener, listening to the buttons
        DoMath listener = new DoMath(firstNumber, secondNumber, result);
        subButton.addActionListener(listener);
        addButton.addActionListener(listener);
        multButton.addActionListener(listener);
        divButton.addActionListener(listener);
        frame.pack();
        frame.setVisible(true);
    }
}

class DoMath implements ActionListener {
    //constructor
    DoMath(JTextField first, JTextField second, JTextField result) {
        inputOne = first;
        inputTwo = second;
        output = result;
    }

    public void actionPerformed(ActionEvent e) {
        double first, second;
        /*gets text strings from each of the input text fields and converts those
        strings to numbers*/
        //getText() returns text version of input
        //trim() gets rid of unnecessary whitespace in inputs
        //Double.parseDouble(...) converts string to double 
        first = Double.parseDouble(inputOne.getText().trim());
        second = Double.parseDouble(inputTwo.getText().trim());
        //setText sets the text string displayed in the output text field
        //String.valueOf() converts double to string, of which setText() needs
        if (e.getActionCommand().equals("Add"))
            output.setText(String.valueOf(first + second));
        else if (e.getActionCommand().equals("Subtract"))
            output.setText(String.valueOf(first - second));
        else if (e.getActionCommand().equals("Multiply"))
            output.setText(String.valueOf(first * second));
        else
            output.setText(String.valueOf(first / second));
    }

    private JTextField inputOne, inputTwo, output;
}