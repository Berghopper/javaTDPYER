package gui_exercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessR extends JFrame implements ActionListener {
    // gui stuff
    JTextField guessField;
    JButton submitButton;
    JLabel winStateLabel;
    JProgressBar closeNess;
    Random generator = new Random();
    boolean winState = false;
    int secretNumber = giveMeANewNumber();

    public NumberGuessR() {
        // setup gui
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        // make items
        guessField = new JTextField("Guess a number between 1-1000");
        submitButton = new JButton("Submit guess!");
        winStateLabel = new JLabel("<html>You didn't win just yet...<br>Use the progressbar to see how close you are! --&gt;</html>");
        closeNess = new JProgressBar(0, 1000);
        closeNess.setValue(0);
        closeNess.setStringPainted(true);
        panel.add(guessField);
        panel.add(submitButton);
        panel.add(winStateLabel);
        panel.add(closeNess);

        // make listeners
        submitButton.addActionListener(this);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void parseAction(String currentAction) {
        if ("Submit guess!".equals(currentAction)) {
            if (winState) {
                // reset if needed
                winState = false;
                secretNumber = giveMeANewNumber();
            }
            String guessInput = guessField.getText();
            if (isInteger(guessInput)) {
                int guessInputInt = Integer.parseInt(guessInput);
                if (guessInputInt > 0 && guessInputInt <= 1000) {
                    parseCloseness(guessInputInt);
                } else {
                    winStateLabel.setText("Hey, that is NOT between 1-1000!");
                }
            } else {
                winStateLabel.setText("Hey, that is NOT a positive integer!");
            }
        } else {
            System.out.println("How did you change the button text!?");
        }
    }

    private void parseCloseness(int guessInputInt) {
        int formulaResult;
        if (guessInputInt < secretNumber) {
            formulaResult = 1000-(secretNumber-guessInputInt);
            winStateLabel.setText("That's not quite right! (you guessed smaller)");
            closeNess.setValue(Math.min(formulaResult, 990));
        } else if (guessInputInt > secretNumber) {
            formulaResult = 1000-(guessInputInt-secretNumber);
            winStateLabel.setText("That's not quite right! (you guessed larger)");
            closeNess.setValue(Math.min(formulaResult, 990));
        } else {
            winState = true;
            closeNess.setValue(1000);
            winStateLabel.setText("Congrats, you won! press submit to play again!");
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentButton = e.getActionCommand();
        parseAction(currentButton);
    }

    public int giveMeANewNumber() {
        // generate number between 1-1000
        return generator.nextInt(999)+1;
    }

    public static void main(String[] args) {
        NumberGuessR numberguesser = new NumberGuessR();
        setDefaultGUIProperties(numberguesser);
    }

    public static void setDefaultGUIProperties(JFrame currentApp) {
        currentApp.setSize(800, 600);
        currentApp.setVisible(true);
        currentApp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
