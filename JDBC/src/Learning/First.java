package Learning;

import java.sql.*;

public class First{
    public static void main(String args[]) {
        try {
            // to get the drivers name we can use String.drivers.next() instead of mentionng the name along with scanner class
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "Shreyank", "your_password");
            System.out.println("Connection successful: " + con);

            Statement statement = con.createStatement();
            System.out.println(statement);

           //  Corrected 'insert' statement and proper formatting of the date
            long i = statement.executeUpdate("insert into employees values (5, 'Cherry', 'Tungol', 'Owner', 10000000.00, '2006-11-02')");
            
            if (i > 0) {
                System.out.println("Executed successfully");
            } else {
                System.out.println("Something went wrong");
            }
            ResultSet rs = statement.executeQuery("select * from employees");
            System.out.println(rs);
            while(rs.next()) {
            	System.out.println(rs.getString(2));
            }
        	con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
