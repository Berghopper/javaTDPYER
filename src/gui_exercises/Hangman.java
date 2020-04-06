package gui_exercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangman extends JFrame implements ActionListener {
    String hangmanArt = "            +---+\n"+
            "            %s   |\n"+
            "            %s   |\n"+
            "           %s%s%s  |\n"+
            "           %s %s  |\n"+
            "                |\n"+
            "        =========\n";
    String[] hangmanArtFill = {"|","o","/","|","\\","/","\\"};
    String[] HangmanArtFillEmpty = {"","","","","","",""};

    public Hangman() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,2));

        // make items for main panel
        JTextArea hangmanASCII = new JTextArea(String.format(hangmanArt, "|","o","/","|","\\","/","\\"));
        hangmanASCII.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        hangmanASCII.setEditable(false);
        panel.add(hangmanASCII);
        // make bottom panel items
        JTextField guessField = new JTextField("Put your guesses here!");
        bottomPanel.add(guessField);
        JLabel wordView = new JLabel("", JLabel.CENTER);
        bottomPanel.add(wordView);
        bottomPanel.add(new JButton("Submit"));
        JLabel livesView = new JLabel("Lives 7", JLabel.CENTER);
        bottomPanel.add(livesView);


        // make listeners

        panel.add(bottomPanel);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        setDefaultGUIProperties(hangman);
//        System.out.printf(hangman.hangmanArt, "|", "o","/","|","\\","/","\\");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void setDefaultGUIProperties(JFrame currentApp) {
        currentApp.setSize(700, 800);
        currentApp.setVisible(true);
        currentApp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
