package gui_exercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TicTacToe extends JFrame implements ActionListener {
    boolean winState = false;
    boolean winStateComputer = false;
    boolean stalemate = false;
    boolean playersTurn = (new java.util.Random()).nextBoolean();
    String playerString;
    String playerStringOpposite;
    boolean[][] traveled = new boolean[3][3];
    JButton[][] buttonGrid = new JButton[3][3];
    JLabel winStateLabel = new JLabel("", JLabel.CENTER);
    String[] difficultySettings = {
            "2 Players",
            "Easy",
            "Medium",
            "Hard"
    };
    JComboBox<String> difficulty = new JComboBox<>(difficultySettings);

    public TicTacToe() {
        // set playerstring
        setPlayerString();
        // define gui things
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));
        // buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton matrixButton = new JButton("[   ]");
                matrixButton.addActionListener(this);
                buttonGrid[i][j] = matrixButton;
                panel.add(matrixButton);
            }
        }
        panel.add(difficulty);
        difficulty.addActionListener(this);
        panel.add(winStateLabel);
        JButton reset = new JButton("Reset");
        reset.addActionListener(this);
        panel.add(reset);
        getContentPane().add(panel, BorderLayout.CENTER);
        // at end check whose turn it is.
        if (!playersTurn) {
            if ("2 Players".equals(Objects.requireNonNull(difficulty.getSelectedItem()))) {
                winStateLabel.setText("Player 2's turn!");
            } else {
                computerMove();
            }
        } else {
            winStateLabel.setText("Player 1's turn!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reset")) {
            resetBoard();
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
            if (!winState && !winStateComputer && !stalemate) {
                if ("2 Players".equals(Objects.requireNonNull(difficulty.getSelectedItem()))) {
                    doPlayerMove(i, j);
                } else {
                    doPlayerMove(i, j);
                    computerMove();
                }
            }
        } else {
            winStateLabel.setText("You cant click there...");
        }

    }

    private void doPlayerMove(int i, int j) {
        buttonGrid[i][j].setText(playerString);
        traveled[i][j] = true;
        checkWinState();
        if (!winState && !winStateComputer && !stalemate) {
            playersTurn = !playersTurn;
            setPlayerString();
        }
    }

    private void resetBoard() {
        winState = false;
        winStateComputer = false;
        stalemate = false;
        playersTurn = (new java.util.Random()).nextBoolean();
        setPlayerString();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonGrid[i][j].setText("[   ]");
                traveled[i][j] = false;
            }
        }
        if (!playersTurn && !"2 Players".equals(Objects.requireNonNull(difficulty.getSelectedItem()))) {
            computerMove();
        }
    }

    private void computerMove() {
        // first check if everything has been traveled trough...
        if (!winState && !winStateComputer && !stalemate) {
            switch ((String) Objects.requireNonNull(difficulty.getSelectedItem())) {
                case "Easy":
                    computerMoveEasy();
                    break;
                case "Medium":
                    computerMoveMedium(false);
                    break;
                case "Hard":
                    computerMoveHard();
                    break;
                default:
                    System.out.println("uuuuuh, what did you do?");
            }
        }
        checkWinState();
        if (!winState && !winStateComputer && !stalemate) {
            playersTurn = true;
            setPlayerString();
        }
    }

    private void computerMoveEasy() {
        boolean done = false;
        while (!done) {
            int rowIndex = (new java.util.Random()).nextInt(3);
            int colIndex = (new java.util.Random()).nextInt(3);
            if (!traveled[rowIndex][colIndex]) {
                // fill
                traveled[rowIndex][colIndex] = true;
                buttonGrid[rowIndex][colIndex].setText(playerString);
                done = true;
            }
        }
    }

    private void computerMoveMedium(boolean hardMode) {
        int rowIndex = (new java.util.Random()).nextInt(3);
        int colIndex = (new java.util.Random()).nextInt(3);
        boolean done = false;
        while (!done) {
            rowIndex = (new java.util.Random()).nextInt(3);
            colIndex = (new java.util.Random()).nextInt(3);
            if (!traveled[rowIndex][colIndex]) {
                // fill
                done = true;
            }
        }

        // check if previously done a move.
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (traveled[i][j]) {
                    counter++;
                }
            }
        }
        if (counter == 0) {
            rowIndex = 0;
            colIndex = 0;
        } else if (counter > 0 && counter <= 2) {
            // one move has been done by opponent, add to same col
            for (int i = 0; i < 3; i++) {
                boolean placeInThisRow = false;
                for (int j = 0; j < 3; j++) {
                    if (traveled[i][j]) {
                        if (buttonGrid[i][j].getText().equals(playerStringOpposite)) {
                            placeInThisRow = true;
                        }
                    } else if (placeInThisRow) {
                        rowIndex = i;
                        colIndex = j;
                    }
                }
            }
        } else {
            // do defensive move
            int[] resultToUse = computerCounterRows(rowIndex, colIndex);
            rowIndex = resultToUse[0];
            colIndex = resultToUse[1];
            resultToUse = computerCounterCols(rowIndex, colIndex);
            rowIndex = resultToUse[0];
            colIndex = resultToUse[1];
            // do hard mode?
            if (hardMode) {
                // also do diagonal checks
                resultToUse = computerCounterDiag(rowIndex, colIndex);
                rowIndex = resultToUse[0];
                colIndex = resultToUse[1];
            }

        }
        traveled[rowIndex][colIndex] = true;
        buttonGrid[rowIndex][colIndex].setText(playerString);
    }

    private int[] computerCounterDiag(int rowIndex, int colIndex){
        int opponentsInDiag = 0;
        int amountTraveled = 0;

        // check left-right down diag
        for (int i = 0; i < 3; i++) {
            if (buttonGrid[i][i].getText().equals(playerStringOpposite)) {
                opponentsInDiag++;
                amountTraveled++;
            } else if (traveled[i][i]) {
                amountTraveled++;
            }
        }
        if (amountTraveled < 3 && opponentsInDiag == 2) {
            for (int i = 0; i < 3; i++) {
                if (!traveled[i][i]) {
                    rowIndex = i;
                    colIndex = i;
                }
            }
        }
        // check right-left up diag
        opponentsInDiag = 0;
        amountTraveled = 0;
        int j = 0;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                i = 2;
            } else if (i == 2) {
                i = 0;
                j = 2;
            }
            if (buttonGrid[i][j].getText().equals(playerStringOpposite)) {
                opponentsInDiag++;
                amountTraveled++;
            } else if (traveled[i][j]) {
                amountTraveled++;
            }
        }
        if (amountTraveled < 3 && opponentsInDiag == 2) {
            j = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    i = 2;
                } else if (i == 2) {
                    i = 0;
                    j = 2;
                }
                if (!traveled[i][j]) {
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        return (new int[] {rowIndex, colIndex});
    }

    private int[] computerCounterCols(int rowIndex, int colIndex){
        for (int j = 0; j < 3; j++) {
            int opponentsInCol = 0;
            int amountTraveled = 0;
            for (int i = 0; i < 3; i++) {
                if (buttonGrid[i][j].getText().equals(playerStringOpposite)) {
                    opponentsInCol++;
                    amountTraveled++;
                } else if (traveled[i][j]) {
                    amountTraveled++;
                }
            }
            if (amountTraveled < 3 && opponentsInCol == 2) {
                for (int i = 0; i < 3; i++) {
                    if (!traveled[i][j]) {
                        rowIndex = i;
                        colIndex = j;
                    }
                }
            }
        }
        return (new int[] {rowIndex, colIndex});
    }

    private int[] computerCounterRows(int rowIndex, int colIndex){
        for (int i = 0; i < 3; i++) {
            int opponentsInRow = 0;
            int amountTraveled = 0;
            for (int j = 0; j < 3; j++) {
                if (buttonGrid[i][j].getText().equals(playerStringOpposite)) {
                    opponentsInRow++;
                    amountTraveled++;
                } else if (traveled[i][j]) {
                    amountTraveled++;
                }
            }
            if (amountTraveled < 3 && opponentsInRow == 2) {
                for (int j = 0; j < 3; j++) {
                    if (!traveled[i][j]) {
                        rowIndex = i;
                        colIndex = j;
                    }
                }
            }
        }
        return (new int[] {rowIndex, colIndex});
    }

    private void computerMoveHard(){computerMoveMedium(true);}

    private void checkWinState() {
        if (checkWinStateCols() || checkWinStateRows() || checkWinStateDiag()) {
            if (playerString.equals("[ x ]")) {
                // win!
                System.out.println("Player 1 won!");
                winStateLabel.setText("Player 1 won!");
                winState = true;
            } else if (playerString.equals("[ o ]")) {
                // loss...
                System.out.println("Player 2 won!");
                winStateLabel.setText("Player 2 won!");
                winStateComputer = true;
            }
        } else {
            stalemate = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!traveled[i][j]) {
                        stalemate = false;
                        break;
                    }
                }
            }
            if (stalemate) {
                System.out.println("Stalemate!");
                winStateLabel.setText("Stalemate!");
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
            playerStringOpposite = "[ o ]";
            winStateLabel.setText("Player 1's turn!");
        } else {
            playerString = "[ o ]";
            playerStringOpposite = "[ x ]";
            winStateLabel.setText("Player 2's turn!");
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
