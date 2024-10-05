package Learning;

import java.sql.Connection;
import java.io.FileInputStream;
import java.sql.*;

public class Fifth {
	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","Shreyank","sathisharini");
		PreparedStatement ps = con.prepareStatement("insert into image( name,img) values (?,?)");
	//	FileInputStream file = new FileInputStream("file:///home/shreyank/eclipse-workspace/JDBC/src/Learning/c.jpg");
		String loc = System.getProperty("user.dir");
		loc = loc + "//src//Learning//c.jpg";
		FileInputStream files = new FileInputStream(loc);
		ps.setString(1, "Image ");
		ps.setBinaryStream(2, files, files.available());
		int i = ps.executeUpdate();
		if(i>0) {
			System.out.println("Image is successfully uploaded");
		}
		else {
			System.out.println("MMMM something is error");
		}
		con.close();
	}
}
