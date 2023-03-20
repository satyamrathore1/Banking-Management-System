package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    
    JButton back;
    String pinNumber;
    
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("Mini-Statement");
        
        JLabel bank = new JLabel("ICICI Bank");
        bank.setBounds(140, 10, 200, 25);
        bank.setForeground(Color.BLACK);
        bank.setFont(new Font("Raleway", Font.BOLD, 16));
        add(bank);
        
        JLabel cardNumber = new JLabel();
        cardNumber.setBounds(30, 80, 300, 25);
        cardNumber.setForeground(Color.BLACK);
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 12));
        add(cardNumber);
        
        JLabel mini = new JLabel();
        mini.setBounds(30, 110, 400, 200);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(30, 500, 300, 25);
        add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_number = '"+pinNumber+"'");
            while(rs.next()){
                cardNumber.setText("Card Number : " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin_number = '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
//                using html to have spaces and then using &nbsp; for adding spaces 
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
//                        to convert string into integer bcz balance is int and our amount is a string
//                          this amount is from our database
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }                
            }
            balance.setText("Your current balance is Rs " + bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400, 600);
        setLocation(450, 60);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[]args){
        new MiniStatement("");
    }
}
