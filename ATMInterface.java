
import javax.swing.*;
import java.awt.event.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class ATMInterface extends JFrame {
    private BankAccount account;
    private JTextField amountField;
    private JLabel messageLabel;

    public ATMInterface() {
        account = new BankAccount(1000.0); // initial balance

        // setting the Frame
        setTitle("ATM Machine");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Enter the Amount:");
        label.setBounds(50, 30, 100, 30);
        add(label);

        amountField = new JTextField();
        amountField.setBounds(160, 30, 150, 30);
        add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 80, 100, 30);
        add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(160, 80, 100, 30);
        add(withdrawButton);

        JButton checkButton = new JButton("Check Balance");
        checkButton.setBounds(270, 80, 120, 30);
        add(checkButton);

        messageLabel = new JLabel("Welcome! your Balance is : " + account.getBalance());
        messageLabel.setBounds(50, 130, 300, 30);
        add(messageLabel);

        // Action Listeners
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (account.deposit(amount)) {
                        messageLabel.setText("Deposited: " + amount + " | Balance: " + account.getBalance());
                    } else {
                        messageLabel.setText("Invalid deposit amount!");
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid number!");
                }
                amountField.setText("");
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (account.withdraw(amount)) {
                        messageLabel.setText("Withdrawn: " + amount + " | Balance: " + account.getBalance());
                    } else {
                        messageLabel.setText("Invalid or Insufficient Balance!");
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid number!");
                }
                amountField.setText("");
            }
        });

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Current Balance: " + account.getBalance());
            }
        });
    }

    public static void main(String[] args) {
        new ATMInterface().setVisible(true);
    }
}

 
    

