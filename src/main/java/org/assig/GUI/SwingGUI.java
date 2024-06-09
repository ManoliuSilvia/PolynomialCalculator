package org.assig.GUI;

import org.assig.BusinessLogic.*;
import org.assig.DataModels.Polynomial;
import org.assig.parsing.PolynomialParse;
import org.assig.parsing.PolynomialStringify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField polynomial1, polynomial2;
    private JLabel text1, text2, resultLabel, opLabel;
    private JButton confirm;
    private JComboBox<String> operations;

    public SwingGUI() {
        frame = new JFrame("Polynomial Calculator");
        panel = new JPanel();
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel = new JPanel(new GridLayout(4, 2, 10, 10));
        polynomial1 = new JTextField();
        polynomial2 = new JTextField();
        text1 = new JLabel("Polynomial 1: ");
        text2 = new JLabel("Polynomial 2: ");
        opLabel = new JLabel("Select Operation");
        String[] operationString = {"Addition","Subtraction","Multiplication","Derivative","Integration"};
        operations = new JComboBox<>(operationString);
        resultLabel= new JLabel();
        confirm = new JButton("Confirm");
        panel.add(text1);
        panel.add(polynomial1);
        panel.add(text2);
        panel.add(polynomial2);
        panel.add(opLabel);
        panel.add(operations);
        panel.add(resultLabel);
        panel.add(confirm);
        frame.add(panel);
        addListeners();
    }
    private void addListeners(){
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = polynomial1.getText();
                String p2 = polynomial2.getText();
                Polynomial a = PolynomialParse.parse(p1);
                Polynomial b = PolynomialParse.parse(p2);
                String opString = (String) operations.getSelectedItem();
                String result = "";
                if(opString.equals("Addition")){
                    result = PolynomialStringify.stringify(PolynomialAddition.addition(a,b));
                }
                else if (opString.equals("Subtraction")){
                    result = PolynomialStringify.stringify((PolynomialSubtraction.subtraction(a,b)));
                }
                else if (opString.equals("Multiplication")){
                    result = PolynomialStringify.stringify(PolynomialMultiplication.multiplication(a,b));
                }
                else if(opString.equals("Derivative")){
                    result = PolynomialStringify.stringify(PolynomialDerivative.derivative(a));
                }
                else if(opString.equals("Integration")){
                    result = PolynomialStringify.stringify(PolynomialIntegration.integration(a));
                }
                resultLabel.setText(result);
            }
        });
        frame.setVisible(true);
    }
}