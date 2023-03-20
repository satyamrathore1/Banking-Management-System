package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//to use ResultSet

public class Login extends JFrame implements ActionListener{
//    JFrame package inherited from swing package using extends keyword
//    & ActionListener package (using interfaces concept)to make our buttons do some actions
    
    JButton signInButton, clearButton, signUpButton;
//    Need to define the button globally (or outside the constructor also) so that can be used from anywhere
    JTextField cardTextField;
    JPasswordField pinTextField;
//    Used for passwords
    
    Login(){
//        making constructor of our class

        setLayout(null);
//        to tell our to code to pick our custom layout and not default layout(to make setBounds work)

        setTitle("AUTOMATED TELLER MACHINE");
//        to set the title of our frame

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
//        to add image in our frame using object & using ClassLoader
        Image editSize = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        to edit the size of our iamge added in the frame (need to import awt class for Image Class)
        ImageIcon editSize1 = new ImageIcon(editSize);
//        need to convert Image into ImgeIcon as we cannot pass Image directly into JLabel
        JLabel label = new JLabel(editSize1);
//        used to add our logo and pass (ImageIcon) cannot pass direct Image
        label.setBounds(70, 10, 100, 100);
//        to set location of image in frame(from left, from top, height of image, breadth of image)
        add(label);
//        used to display logo in our frame and pass our object

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
//        to add text to our frame (by making text objext in JLabel class)

        JLabel card = new JLabel("Card No:");
        card.setFont(new Font("Raleway", Font.BOLD, 30));
        card.setBounds(120, 150, 150, 30);
        add(card);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
//        Used to add text box in our frame
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(200, 220, 250, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        signInButton = new JButton("SIGN IN");
        signInButton.setBounds(300, 300, 100, 30);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.addActionListener(this);
        add(signInButton);
//        Used to add button in our frame

        clearButton = new JButton("CLEAR");
        clearButton.setBounds(430, 300, 100, 30);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        add(clearButton);
        
        signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(300, 350, 230, 30);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.addActionListener(this);
        add(signUpButton);

        getContentPane().setBackground(Color.WHITE);
//        to add colour to frame (first we get our frame & then change the colour) that's why we used getContentPane()

        setSize(800, 480);
//        Used to set the dimensions of the frame (length, breadth)

        setVisible(true);
//        to make our frame visible to us

        setLocation(350, 200);
//        to set the location of our frame (from left, from top)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        by this when we close our app the program will stop running
    }
    
    public void actionPerformed(ActionEvent ae){
//        need to use this make our button do some action
//        This class is used to define what action will be done by clicking on specific button
        if(ae.getSource() == signInButton){
//        By this we get to know that which button has been pressed
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
//            getting cross on getText bcz it is password and we are taking text(It will work anyways)
            String query = "select * from login where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'";
//            this time we have to take out data from our database so we use select instead of insert
            try{
                ResultSet rs =  conn.s.executeQuery(query);
//                we use ResultSet bcz if our query matches from our database it will return result data type of resultset
//                we use executeQuery instead of executeUpdate bcz it is ddl command

                if(rs.next()){
//                    this means we are getting data and it is matching
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == clearButton){
            cardTextField.setText("");
            pinTextField.setText("");
//            We will set the text empty so that when we press clear box becomes empty
        }else if(ae.getSource() == signUpButton){
            setVisible(false);
//            to dissapper login page when clicked on sign up buton
            new SignUpOne().setVisible(true);
//            to open signup page when sign up button is clicked
        }
    }
    
    public static void main(String args[]){
        new Login();
//        making object of Login class so that as code runs our frame open up
    }
    
}
