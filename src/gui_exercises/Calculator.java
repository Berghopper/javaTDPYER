package gui_exercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JLabel display = new JLabel("");
    String operator;
    int firstNumber;
    int secondNumber;
    String firstNumberRaw = "";
    String secondNumberRaw = "";
    boolean firstNumberEntered = false;
    boolean secondNumberEntered = false;

    public Calculator() {
        String[] labels = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","+",
                "C","0","=","-",
        };
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        getContentPane().add(panel, BorderLayout.CENTER);


        for (int i = 0; i < 16; i++) {
            JButton button = new JButton(labels[i]);
            panel.add(button);
            button.addActionListener(this);
        }

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        setDefaultCalculatorProperties(calculator);
    }

    public static void setDefaultCalculatorProperties(Calculator calculator) {
        calculator.setSize(400, 400);
        calculator.setVisible(true);
        calculator.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void parsePressedButtons(String theButton) {
        switch(theButton) {
            // num
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                if (firstNumberEntered) {
                    this.secondNumberEntered = true;
                    this.secondNumberRaw += theButton;
                } else {
                    this.firstNumberRaw += theButton;
                }

                break;
            // save operator
            case "/": case "*": case "+": case "-":
                this.operator = theButton;
                if (!this.firstNumberRaw.equals("")) {
                    this.firstNumberEntered = true;
                }
                break;
            // clear
            case "C":
                resetAllStates();
                break;
            // calc
            case "=":
                if (this.firstNumberEntered && this.secondNumberEntered && !this.operator.equals("")) {
                    this.firstNumber = Integer.parseInt(this.firstNumberRaw);
                    this.secondNumber = Integer.parseInt(this.secondNumberRaw);
                    switch (this.operator) {
                        case "/":
                            System.out.printf("Result of %d / %d =\n", this.firstNumber, this.secondNumber);
                            System.out.println(this.firstNumber/this.secondNumber);
                            break;
                        case "*":
                            System.out.printf("Result of %d * %d =\n", this.firstNumber, this.secondNumber);
                            System.out.println(this.firstNumber*this.secondNumber);
                            break;
                        case "+":
                            System.out.printf("Result of %d + %d =\n", this.firstNumber, this.secondNumber);
                            System.out.println(this.firstNumber+this.secondNumber);
                            break;
                        case "-":
                            System.out.printf("Result of %d - %d =\n", this.firstNumber, this.secondNumber);
                            System.out.println(this.firstNumber-this.secondNumber);
                            break;
                        default:
                            System.out.println("Undefined operator!");
                    }
                }
                resetAllStates();
                break;
            default:
                System.out.println("Fatal error, you pressed a button that does not exist?");
        }
    }

    public void resetAllStates() {
        this.firstNumberRaw = "";
        this.secondNumberRaw = "";
        this.firstNumberEntered = false;
        this.secondNumberEntered = false;
        this.operator = "";
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String currentButton = e.getActionCommand();
        parsePressedButtons(currentButton);
    }
}
