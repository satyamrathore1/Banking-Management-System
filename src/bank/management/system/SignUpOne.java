package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*; 
import com.toedter.calendar.JDateChooser;
//to import calender in our frame
import java.awt.event.*;


public class SignUpOne extends JFrame implements ActionListener {
    
    Long random;
    JTextField nameTF, fnameTF, emailTF, addressTF, cityTF, stateTF, pinCodeTF;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser calender;
    
    SignUpOne(){
//        Constrctor class
        
        setLayout(null);
        setTitle("New Account Application Form Page-1");
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L + 1000L));
        
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 35));
        formNo.setBounds(90, 20, 600, 40);
        add(formNo);
        
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(250, 70, 500, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(80, 120, 100, 30);
        add(name);
        
        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway", Font.BOLD, 12));
        nameTF.setBounds(280, 120, 380, 30);
        add(nameTF);
        
        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(80, 170, 200, 30);
        add(fname);
        
        fnameTF = new JTextField();
        fnameTF.setFont(new Font("Raleway", Font.BOLD, 12));
        fnameTF.setBounds(280, 170, 380, 30);
        add(fnameTF);
        
        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(80, 220, 200, 30);
        add(dob);
        
        calender = new JDateChooser();
        calender.setBounds(280, 220, 380, 30);
        calender.setForeground(new Color(105, 105, 105));
//        to set colour in RGB values
        add(calender);
        
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(80, 270, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(280, 270, 120, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(430, 270, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(80, 320, 200, 30);
        add(email);
        
        emailTF = new JTextField();
        emailTF.setFont(new Font("Raleway", Font.BOLD, 12));
        emailTF.setBounds(280, 320, 380, 30);
        add(emailTF);
        
        JLabel mStatus = new JLabel("Marital Status :");
        mStatus.setFont(new Font("Raleway", Font.BOLD, 18));
        mStatus.setBounds(80, 370, 200, 30);
        add(mStatus);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(280, 370, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        married = new JRadioButton("Married");
        married.setBounds(430, 370, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        other = new JRadioButton("Other");
        other.setBounds(580, 370, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup mStatusButton = new ButtonGroup();
        mStatusButton.add(unmarried);
        mStatusButton.add(married);
        mStatusButton.add(other);
        
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(80, 420, 200, 30);
        add(address);
        
        addressTF = new JTextField();
        addressTF.setFont(new Font("Raleway", Font.BOLD, 12));
        addressTF.setBounds(280, 420, 380, 30);
        add(addressTF);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(80, 470, 200, 30);
        add(city);
        
        cityTF = new JTextField();
        cityTF.setFont(new Font("Raleway", Font.BOLD, 12));
        cityTF.setBounds(280, 470, 380, 30);
        add(cityTF);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(80, 520, 200, 30);
        add(state);
        
        stateTF = new JTextField();
        stateTF.setFont(new Font("Raleway", Font.BOLD, 12));
        stateTF.setBounds(280, 520, 380, 30);
        add(stateTF);
        
        JLabel pinCode = new JLabel("Pincode :");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 18));
        pinCode.setBounds(80, 570, 200, 30);
        add(pinCode);
        
        pinCodeTF = new JTextField();
        pinCodeTF.setFont(new Font("Raleway", Font.BOLD, 12));
        pinCodeTF.setBounds(280, 570, 380, 30);
        add(pinCodeTF);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(580, 620, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750, 700);
        setLocation(300, 10);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formNo = "" + random;
//        concatinate long into string as we will enter only string values in our database
        String sname = nameTF.getText();
//        to get name value from nameTF
        String fname = fnameTF.getText();
        String dob = ((JTextField) calender.getDateEditor().getUiComponent()).getText();
//        Needed to concatinate datechooser into textfield
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
//        to check which button is pressed
        
        String email = emailTF.getText();
        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "Married";
        }else if(unmarried.isSelected()){
            maritalStatus = "Unmarried";
        }else if(other.isSelected()){
            maritalStatus = "Other";
        }
        String address = addressTF.getText();
        String city = cityTF.getText();
        String state = stateTF.getText();
        String pinCode = pinCodeTF.getText();
            
        try{
            if(sname.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your name");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formNo+"', '"+sname+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pinCode+"')"; 
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
//            to show a message that name is not entered
        }catch(Exception e){
            System.out.println(e);
        }
//        because database is an external entity we can get erros at runtime so we do exception handling
    }
    
    public static void main(String args[]){
        new SignUpOne();
//        making object of class
    }
    
}
