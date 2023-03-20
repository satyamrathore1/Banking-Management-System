package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    
    JTextField panNoTF, aadhaarTF;
    JRadioButton SCyes, SCno, EAyes, EAno;
    JButton next;
    JComboBox religionCB, categoryCB, incomeCB, eduQualCB, occupationCB;
    String formNo;
    
    SignUpTwo(String formNo){
        
        this.formNo = formNo;
        
        setLayout(null);
        setTitle("New Account Application Form Page-2");
        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(250, 30, 500, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(80, 90, 100, 30);
        add(religion);
        
        String[] religionNames = {"Hindu", "Christian", "Sikh", "Muslim", "Other"};
        religionCB = new JComboBox(religionNames);
//        to make drop down box we use JComboBox
        religionCB.setBounds(280, 90, 380, 30);
        religionCB.setBackground(Color.WHITE);
        add(religionCB);
        
        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(80, 140, 100, 30);
        add(category);
        
        String[] categoryNames = {"General", "OBC", "SC", "ST", "Other"};
        categoryCB = new JComboBox(categoryNames);
        categoryCB.setBounds(280, 140, 380, 30);
        categoryCB.setBackground(Color.WHITE);
        add(categoryCB);
        
        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(80, 190, 100, 30);        
        add(income);
        
        String[] incomeNames = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        incomeCB = new JComboBox(incomeNames);
        incomeCB.setBounds(280, 190, 380, 30);
        incomeCB.setBackground(Color.WHITE);
        add(incomeCB);
        
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 18));
        educational.setBounds(80, 240, 200, 30);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 18));
        qualification.setBounds(80, 260, 200, 30);
        add(qualification);
        
        String[] eduQualNames = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        eduQualCB = new JComboBox(eduQualNames);
        eduQualCB.setBounds(280, 250, 380, 30);
        eduQualCB.setBackground(Color.WHITE);
        add(eduQualCB);
        
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(80, 310, 200, 30);
        add(occupation);
        
        String[] occupationNames = {"Salaried", "Self-Employed", "Business", "Student", "Retired"};
        occupationCB = new JComboBox(occupationNames);
        occupationCB.setBounds(280, 310, 380, 30);
        occupationCB.setBackground(Color.WHITE);
        add(occupationCB);
        
        JLabel panNo = new JLabel("PAN Number : ");
        panNo.setFont(new Font("Raleway", Font.BOLD, 18));
        panNo.setBounds(80, 360, 200, 30);
        add(panNo);
        
        panNoTF = new JTextField();
        panNoTF.setFont(new Font("Raleway", Font.BOLD, 12));
        panNoTF.setBounds(280, 360, 380, 30);
        add(panNoTF);
        
        JLabel aadhaar = new JLabel("Aadhaar Number : ");
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhaar.setBounds(80, 410, 200, 30);
        add(aadhaar);
        
        aadhaarTF = new JTextField();
        aadhaarTF.setFont(new Font("Raleway", Font.BOLD, 12));
        aadhaarTF.setBounds(280, 410, 380, 30);
        add(aadhaarTF);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorCitizen.setBounds(80, 460, 200, 30);
        add(seniorCitizen);
        
        SCyes = new JRadioButton("Yes");
        SCyes.setBounds(300, 460, 120, 30);
        SCyes.setBackground(Color.WHITE);
        add(SCyes);
        
        SCno = new JRadioButton("No");
        SCno.setBounds(450, 460, 120, 30);
        SCno.setBackground(Color.WHITE);
        add(SCno);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(SCyes);
        seniorCitizenGroup.add(SCno);
        
        JLabel exisitingAcc = new JLabel("Exisitng Account : ");
        exisitingAcc.setFont(new Font("Raleway", Font.BOLD, 18));
        exisitingAcc.setBounds(80, 510, 200, 30);
        add(exisitingAcc);
        
        EAyes = new JRadioButton("Yes");
        EAyes.setBounds(300, 510, 120, 30);
        EAyes.setBackground(Color.WHITE);
        add(EAyes);
        
        EAno = new JRadioButton("No");
        EAno.setBounds(450, 510, 120, 30);
        EAno.setBackground(Color.WHITE);
        add(EAno);
        
        ButtonGroup exisitngAccGroup = new ButtonGroup();
        exisitngAccGroup.add(EAyes);
        exisitngAccGroup.add(EAno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(580, 560, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);        
        setSize(750, 700);
        setLocation(300, 10);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String religion = (String) religionCB.getSelectedItem();
        String category = (String) categoryCB.getSelectedItem();
        String income = (String) incomeCB.getSelectedItem();
        String educationalQualification = (String) eduQualCB.getSelectedItem();        
        String occupation = (String) occupationCB.getSelectedItem();
        
        String panNumber = panNoTF.getText();
        String aadhaarNumber = aadhaarTF.getText();
        
        String seniorCitizen = null;
        if(SCyes.isSelected()){
            seniorCitizen = "Yes";
        }else if(SCno.isSelected()){
            seniorCitizen = "No";
        }
        
        String existingAcc = null;
        if(EAyes.isSelected()){
            existingAcc = "Yes";
        }else if(EAno.isSelected()){
            existingAcc = "No";
        }
        
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formNo+"', '"+religion+"', '"+category+"', '"+income+"', '"+educationalQualification+"', '"+occupation+"', '"+panNumber+"', '"+aadhaarNumber+"', '"+seniorCitizen+"', '"+existingAcc+"')"; 
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignUpThree(formNo).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String []args){
        new SignUpTwo("");
    }
}
