package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, cashWithdrawal, fastCash, pinChange, miniStatement, balanceEnq, exit;
    String pinNumber;
    
    Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        setTitle("ATM Machine");
        
        ImageIcon ATM = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = ATM.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(190, 190, 600, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(text);
//        to set our JLabel on image we do this

        deposit = new JButton("Deposit");
        deposit.setBounds(140, 300, 140, 20);
        deposit.setFont(new Font("Raleway", Font.BOLD, 11));
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(318, 300, 140, 20);
        cashWithdrawal.setFont(new Font("Raleway", Font.BOLD, 11));
        cashWithdrawal.addActionListener(this);
        image.add(cashWithdrawal);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(140, 328, 140, 20);
        fastCash.setFont(new Font("Raleway", Font.BOLD, 11));
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(318, 328, 140, 20);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 11));
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(140, 356, 140, 20);
        miniStatement.setFont(new Font("Raleway", Font.BOLD, 11));
        miniStatement.addActionListener(this);
        image.add(miniStatement);
       
        balanceEnq = new JButton("Balance Enquiry");
        balanceEnq.setBounds(318, 356, 140, 20);
        balanceEnq.setFont(new Font("Raleway", Font.BOLD, 11));
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);
        
        exit = new JButton("Exit");
        exit.setBounds(318, 384, 140, 20);
        exit.setFont(new Font("Raleway", Font.BOLD, 11));
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(800, 700);
        setLocation(300, 0);
//        setUndecorated(true);
//        to remove top bar(opening, minimizing bar)
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource() == cashWithdrawal){
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource() == balanceEnq){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[]args){
        new Transactions("");
    }
}
