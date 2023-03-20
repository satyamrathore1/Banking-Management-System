package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinNumber;
    
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("ATM Machine");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);
        
        JLabel text = new JLabel("Balance Enquiry");
        text.setBounds(230, 190, 600, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);
        
        back = new JButton("Back");
        back.setBounds(318, 384, 140, 20);
        back.setFont(new Font("Raleway", Font.BOLD, 11));
        back.addActionListener(this);
        image.add(back);
        
        Conn conn = new Conn();
        int balance = 0;
        try{
            ResultSet rs = conn.s.executeQuery("select * from bank where pin_number = '"+pinNumber+"'");            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel balanceAmount = new JLabel("Your Current Balance is : Rs " + balance);
        balanceAmount.setBounds(180, 250, 600, 25);
        balanceAmount.setForeground(Color.WHITE);
        balanceAmount.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(balanceAmount);
        
        setSize(800, 700);
        setLocation(300, 0);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    
    public static void main(String[]args){
        new BalanceEnquiry("");
    }
}
