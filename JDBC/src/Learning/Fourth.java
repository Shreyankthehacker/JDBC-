package Learning;

import java.sql.*;

public class Fourth {
	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","Shreyank","sathisharini");
		DatabaseMetaData dbmd = con.getMetaData();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employees");
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount()+" "+rsmd.getColumnName(4)+dbmd.getDriverVersion());
		con.close();
		
	}
}
