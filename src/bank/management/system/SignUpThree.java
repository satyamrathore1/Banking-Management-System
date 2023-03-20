package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton savingsAccButton, currentAccButton, fdAccButton, rdAccButton;
    JCheckBox atmCard, intBanking, mobBanking, emailsmsAlert, chequeBook, EStatement, declaration;
    JButton submit, cancel;
    String formNo;
    
    SignUpThree(String formNo){
        
        this.formNo = formNo;
        
        setLayout(null);
        setTitle("New Application Form Page-3");
        
        JLabel accountDetails = new JLabel("Page 3 : Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        accountDetails.setBounds(250, 30, 500, 30);
        add(accountDetails);
        
        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("Raleway", Font.BOLD, 19));
        accType.setBounds(80, 90, 200, 30);
        add(accType);
        
        savingsAccButton = new JRadioButton("Savings Account");
        savingsAccButton.setBounds(80, 130, 200, 30);
        savingsAccButton.setBackground(Color.WHITE);
        add(savingsAccButton);
        
        currentAccButton = new JRadioButton("Current Account");
        currentAccButton.setBounds(80, 160, 200, 30);
        currentAccButton.setBackground(Color.WHITE);
        add(currentAccButton);
        
        fdAccButton = new JRadioButton("Fixed Deposit Account");
        fdAccButton.setBounds(300, 130, 200, 30);
        fdAccButton.setBackground(Color.WHITE);
        add(fdAccButton);
        
        rdAccButton = new JRadioButton("Recurring Deposit Account");
        rdAccButton.setBounds(300, 160, 200, 30);
        rdAccButton.setBackground(Color.WHITE);
        add(rdAccButton);
        
        ButtonGroup accountType = new ButtonGroup();
        accountType.add(savingsAccButton);
        accountType.add(currentAccButton);
        accountType.add(fdAccButton);
        accountType.add(rdAccButton);
        
        JLabel cardNo = new JLabel("Card Number : ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 19));
        cardNo.setBounds(80, 210, 200, 30);
        add(cardNo);
        
        JLabel yourDigit = new JLabel("Your 16-Digit Card Number");
        yourDigit.setFont(new Font("Raleway", Font.BOLD, 10));
        yourDigit.setBounds(80, 235, 200, 19);
        add(yourDigit);
        
        JLabel cNumber = new JLabel("XXXX-XXXX-XXXX-1141");
        cNumber.setFont(new Font("Raleway", Font.BOLD, 19));
        cNumber.setBounds(300, 210, 400, 30);
        add(cNumber);
        
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 19));
        pin.setBounds(80, 280, 200, 30);
        add(pin);
        
        JLabel yourPin = new JLabel("Your 4-Digit Password");
        yourPin.setFont(new Font("Raleway", Font.BOLD, 10));
        yourPin.setBounds(80, 305, 200, 19);
        add(yourPin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 19));
        pinNumber.setBounds(300, 280, 200, 30);
        add(pinNumber);
        
        JLabel servicesRequired = new JLabel("Services Required : ");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD, 19));
        servicesRequired.setBounds(80, 355, 200, 30);
        add(servicesRequired);
        
        atmCard = new JCheckBox("ATM Card");
        atmCard.setBounds(80, 400, 200, 30);
        atmCard.setBackground(Color.WHITE);
        add(atmCard);
        
        intBanking = new JCheckBox("Internet Banking");
        intBanking.setBounds(300, 400, 200, 30);
        intBanking.setBackground(Color.WHITE);
        add(intBanking);
        
        mobBanking = new JCheckBox("Mobile Banking");
        mobBanking.setBounds(80, 440, 200, 30);
        mobBanking.setBackground(Color.WHITE);
        add(mobBanking);
        
        emailsmsAlert = new JCheckBox("Email & SMS Alert");
        emailsmsAlert.setBounds(300, 440, 200, 30);
        emailsmsAlert.setBackground(Color.WHITE);
        add(emailsmsAlert);
        
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(80, 480, 200, 30);
        chequeBook.setBackground(Color.WHITE);
        add(chequeBook);
        
        EStatement = new JCheckBox("E-Statement");
        EStatement.setBounds(300, 480, 200, 30);
        EStatement.setBackground(Color.WHITE);
        add(EStatement);
        
        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        declaration.setBounds(80, 550, 600, 30);
        declaration.setFont(new Font("Raleway", Font.BOLD, 10));
        declaration.setBackground(Color.WHITE);
        add(declaration);
        
        submit = new JButton("Submit");
        submit.setBounds(230, 590, 80, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(430, 590, 80, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(750, 700);
        setLocation(300, 10);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            String accountType = null;
            if(savingsAccButton.isSelected()){
                accountType = "Savings Account";
            }else if(currentAccButton.isSelected()){
                accountType = "Current Account";
            }else if(fdAccButton.isSelected()){
                accountType = "Fixed-Deposit Account";
            }else if(rdAccButton.isSelected()){
                accountType = "Recurring-Deposit Account";
            }
            
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 6830478200000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(atmCard.isSelected()){
                facility = facility + "ATM Card";
            }else if(intBanking.isSelected()){
                facility = facility + "Internet Banking";
            }else if(mobBanking.isSelected()){
                facility = facility + "Mobile Banking";
            }else if(emailsmsAlert.isSelected()){
                facility = facility + "Email & SMS Alert";
            }else if(chequeBook.isSelected()){
                facility = facility + "Cheque Book";
            }else if(EStatement.isSelected()){
                facility = facility + "E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Please select an Account Type");
                }else{
                    Conn conn = new Conn();
                    
                    String query1 = "insert into signupthree values('"+formNo+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formNo+"', '"+cardNumber+"', '"+pinNumber+"')";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number : " + cardNumber + "\n Pin : " + pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                    JOptionPane.showMessageDialog(null, "Please deposit some money to open an account");
                }
            }catch(Exception e){
            System.out.println(e);  
            }
                    
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[]args){
        new SignUpThree("");
    }
}
