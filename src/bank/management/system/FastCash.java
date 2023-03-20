package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
//given date specifically bcz date object is also available in sql package

public class FastCash extends JFrame implements ActionListener{
    
    JButton hundred, fiveHund, thousand, twoThous, fiveThous, tenThous, back;
    String pinNumber;
    
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        setTitle("ATM Machine");
        
        ImageIcon ATM = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = ATM.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);
        
        JLabel text = new JLabel("Please select the withdrawal amount");
        text.setBounds(170, 190, 600, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(text);
//        to set our JLabel on image we do this

        hundred = new JButton("Rs 100");
        hundred.setBounds(140, 300, 140, 20);
        hundred.setFont(new Font("Raleway", Font.BOLD, 11));
        hundred.addActionListener(this);
        image.add(hundred);
        
        fiveHund = new JButton("Rs 500");
        fiveHund.setBounds(318, 300, 140, 20);
        fiveHund.setFont(new Font("Raleway", Font.BOLD, 11));
        fiveHund.addActionListener(this);
        image.add(fiveHund);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(140, 328, 140, 20);
        thousand.setFont(new Font("Raleway", Font.BOLD, 11));
        thousand.addActionListener(this);
        image.add(thousand);
        
        twoThous = new JButton("Rs 2000");
        twoThous.setBounds(318, 328, 140, 20);
        twoThous.setFont(new Font("Raleway", Font.BOLD, 11));
        twoThous.addActionListener(this);
        image.add(twoThous);
        
        fiveThous = new JButton("Rs 5000");
        fiveThous.setBounds(140, 356, 140, 20);
        fiveThous.setFont(new Font("Raleway", Font.BOLD, 11));
        fiveThous.addActionListener(this);
        image.add(fiveThous);
       
        tenThous = new JButton("Rs 10000");
        tenThous.setBounds(318, 356, 140, 20);
        tenThous.setFont(new Font("Raleway", Font.BOLD, 11));
        tenThous.addActionListener(this);
        image.add(tenThous);
        
        back = new JButton("Back");
        back.setBounds(318, 384, 140, 20);
        back.setFont(new Font("Raleway", Font.BOLD, 11));
        back.addActionListener(this);
        image.add(back);
        
        setSize(800, 700);
        setLocation(300, 0);
//        setUndecorated(true);
//        to remove top bar(opening, minimizing bar)
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
//            did to get the text from the button. So did ae.getSource to get access of the button. This returns object so
//            first did type casting with JButton bcz we are getting source from button
//            did getText to get the text in the button and then did substring to remove first 3 letters from text(Rs_)
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin_number = '"+pinNumber+"'");
                
                int balance = 0;
                while(rs.next()){
//                    used loop with rs.next() to loop one by one every row in our table in database
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
//                        to convert string into integer bcz balance is int and our amount is a string
//                          this amount is from our database
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
//                    here this amount is amount we get from our button i.e. from line 87
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }else{
                    Date date = new Date();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[]args){
        new FastCash("");
    }
}
