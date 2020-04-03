package gui_exercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    boolean winState = false;
    boolean winStateComputer = false;
    boolean stalemate = false;
    boolean playersTurn = true;
    String playerString;
    boolean[][] traveled = new boolean[3][3];
    JButton[][] buttonGrid = new JButton[3][3];
    JLabel winStateLabel = new JLabel("");

    public TicTacToe() {
        // set playerstring
        setPlayerString();
        // define gui things
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton matrixButton = new JButton("[   ]");
                matrixButton.addActionListener(this);
                buttonGrid[i][j] = matrixButton;
                panel.add(matrixButton);
            }
        }
        panel.add(new JLabel());
        panel.add(winStateLabel);
        JButton reset = new JButton("Reset");
        reset.addActionListener(this);
        panel.add(reset);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reset")) {
            winState = false;
            winStateComputer = false;
            stalemate = false;
            playersTurn = true;
            setPlayerString();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttonGrid[i][j].setText("[   ]");
                    traveled[i][j] = false;
                }
            }
            winStateLabel.setText("");
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttonGrid[i][j] == e.getSource()) {
                        // got the button!
                        parseUserButton(i, j);
                    }
                }
            }
        }
    }

    private void parseUserButton(int i, int j) {
        if (buttonGrid[i][j].getText().equals("[   ]")) {
            winStateLabel.setText("");
            buttonGrid[i][j].setText(playerString);
            traveled[i][j] = true;
            checkWinState();
            // make computer do random move.
            playersTurn = false;
            setPlayerString();
            computerMove();
            checkWinState();
            setPlayerString();
        } else {
            winStateLabel.setText("You cant click there...");
        }

    }

    private void computerMove() {
        // first check if everything has been traveled trough...
        if (!winState && !winStateComputer) {
            boolean gameStale = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!traveled[i][j]) {
                        // not a gamestale
                        gameStale = false;
                        break;
                    }
                }
            }
            if (gameStale) {
                stalemate = true;
                System.out.println("Stalemate!");
                winStateLabel.setText("Stalemate!");
            } else {
                boolean done = false;
                while (!done) {
                    int rowIndex = (new java.util.Random()).nextInt(3);
                    int colIndex = (new java.util.Random()).nextInt(3);
                    System.out.println(rowIndex);
                    System.out.println(colIndex);
                    if (!traveled[rowIndex][colIndex]) {
                        // fill
                        traveled[rowIndex][colIndex] = true;
                        buttonGrid[rowIndex][colIndex].setText(playerString);
                        playersTurn = true;
                        done = true;
                    }
                }
            }
        }
    }

    private void checkWinState() {
        if (checkWinStateCols() || checkWinStateRows() || checkWinStateDiag()) {
            if (playerString.equals("[ x ]")) {
                // win!
                System.out.println("You won!");
                winStateLabel.setText("You won!");
                winState = true;
            } else {
                // loss...
                System.out.println("You lost!");
                winStateLabel.setText("You lost!");
                winStateComputer = true;
            }
        }
    }

    private boolean checkWinStateDiag() {
        if (buttonGrid[0][0].getText().equals(playerString) &&
                buttonGrid[1][1].getText().equals(playerString) &&
                buttonGrid[2][2].getText().equals(playerString)) {
            return true;
        }
        return buttonGrid[0][2].getText().equals(playerString) &&
                buttonGrid[1][1].getText().equals(playerString) &&
                buttonGrid[2][0].getText().equals(playerString);
    }

    private boolean checkWinStateRows() {
        for (int i = 0; i < 3; i++) {
            if (buttonGrid[i][0].getText().equals(playerString) &&
                    buttonGrid[i][1].getText().equals(playerString) &&
                    buttonGrid[i][2].getText().equals(playerString)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinStateCols() {
        for (int i = 0; i < 3; i++) {
            if (buttonGrid[0][i].getText().equals(playerString) &&
                    buttonGrid[1][i].getText().equals(playerString) &&
                    buttonGrid[2][i].getText().equals(playerString)) {
                return true;
            }
        }
        return false;
    }

    private void setPlayerString() {
        if (playersTurn) {
            playerString = "[ x ]";
        } else {
            playerString = "[ o ]";
        }
    }

    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
        setDefaultGUIProperties(tictactoe);
    }

    public static void setDefaultGUIProperties(JFrame currentApp) {
        currentApp.setSize(800, 600);
        currentApp.setVisible(true);
        currentApp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
