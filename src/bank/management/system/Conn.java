package bank.management.system;

import java.sql.*;
//Need to import sql library

public class Conn {
    
    Connection c;
//    making object of connection class
    Statement s;
//    creating statement
    public Conn() {
         try{
//             Class.forName(com.mysql.cj.jdbc.Driver);
//             to register our driver with the use of class name "class" having static method forName and here we put our driver name
             c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Zxcvbnm,2");
//             creating connection
             s = c.createStatement();
//             declare statement 
         } catch(Exception e){
             System.out.println(e);
         }
//         Did exceptional handling to try and catch errors
    }
    
}

