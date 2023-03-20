package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pinNumber;
    
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("ATM Machine");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(170, 190, 600, 25);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(160, 230, 280, 25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(140, 300, 140, 20);
        deposit.setFont(new Font("Raleway", Font.BOLD, 11));
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(318, 384, 140, 20);
        back.setFont(new Font("Raleway", Font.BOLD, 11));
        back.addActionListener(this);
        image.add(back);
        
        setSize(800, 700);
        setLocation(300, 0);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            
            String money = amount.getText();
            Date date = new Date();
            
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter an amount");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+money+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+money+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
//            imported from util package
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[]args){
        new Deposit("");
    }
    
}
