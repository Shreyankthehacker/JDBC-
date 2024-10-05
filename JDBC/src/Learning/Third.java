package Learning;

import java.sql.*;

public class Third {
	public static void main(String args[]) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","Shreyank","sathisharini");
			PreparedStatement ps = con.prepareStatement("INSERT INTO employees (emp_id, first_name, last_name, position, salary,hire_date) VALUES (?, ?, ?, ?, ?,?)");
			ps.setInt(1,208);
			ps.setString(2, "Jimm");
			ps.setString(3, "Bill");
			ps.setString(4,"unempl");
			ps.setDouble(5, 207.0);
			ps.setString(6, "2002-01-03");
			ps.addBatch();
			ps.setInt(1,2573);
			ps.setString(2, "Rhye");
			ps.setString(3, "Johnasson");
			ps.setString(4,"unemployed");
			ps.setDouble(5, 203.0);
			ps.setString(6, "2011-01-03");
			ps.addBatch();
			ps.executeBatch();
			PreparedStatement ps1 = con.prepareStatement("update employees set first_name = ? where last_name = ?");
			ps1.setString(1, "Rod");
			ps1.setString(2, "Tucker");
			ps1.addBatch();
			ps1.executeUpdate();
			System.out.println("Executed.....");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
}
