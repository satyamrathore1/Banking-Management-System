package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField newPintf, reEnterPintf;
    JButton change, back;
    String pinNumber;
    
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;        
        setLayout(null);        
        setTitle("ATM Machine");
        
        ImageIcon ATM = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = ATM.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(230, 190, 600, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);
        
        JLabel newPin = new JLabel("New PIN : ");
        newPin.setBounds(145, 250, 180, 25);
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(newPin);
        
        newPintf = new JPasswordField();
        newPintf.setBounds(300, 250, 140, 25);
        newPintf.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(newPintf);
        
        JLabel reEnterPin = new JLabel("Re-Enter the PIN : ");
        reEnterPin.setBounds(145, 300, 180, 25);
        reEnterPin.setForeground(Color.WHITE);
        reEnterPin.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(reEnterPin);
        
        reEnterPintf = new JPasswordField();
        reEnterPintf.setBounds(300, 300, 140, 25);
        reEnterPintf.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(reEnterPintf);
        
        change = new JButton("CHANGE");
        change.setBounds(318, 384, 140, 20);
        change.setFont(new Font("Raleway", Font.BOLD, 11));
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(140, 384, 140, 20);
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
            try{
                String nPin = newPintf.getText();
                String rPin = reEnterPintf.getText();
            
                if(nPin.equals("") || rPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter the PIN");
                    return;
                }
                
                if(!nPin.equals(rPin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match  \nRe-Enter the PIN");                
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin_number = '"+rPin+"' where pin_number = '"+pinNumber+"'";
                String query2 = "update login set pin_number = '"+rPin+"' where pin_number = '"+pinNumber+"'";
                String query3 = "update signupthree set pin_number = '"+rPin+"' where pin_number = '"+pinNumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new Transactions(rPin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }        
    }
    
    public static void main(String[]args){
        new PinChange("");
    }
}
