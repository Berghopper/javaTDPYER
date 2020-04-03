package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JLabel display = new JLabel("");
    String operator;
    int firstNumber;
    int secondNumber;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentButton = e.getActionCommand();
        System.out.println(currentButton);
    }
}
