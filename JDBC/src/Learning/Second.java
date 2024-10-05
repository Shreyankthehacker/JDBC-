package Learning;
import java.sql.*;
import java.util.Scanner;
public class Second {
public static void main(String args[]) {
	System.out.println("I will win this battle first then war all over");
	try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");  // From jar file jdbc is loaded 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","Shreyank","sathisharini");// creates the connection bw database Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
	Statement statement = con.createStatement(); //Creates a Statement object for sending SQL statements to the database. SQL statements without parameters are normally executed using Statement objects. If the same SQL statement is executed many times, it may be more efficient to use a PreparedStatement object.
	Scanner scanner = new Scanner(System.in);
	String  ch = scanner.next();
	while(!ch.toLowerCase().equals("n")) {
		// create object of the detaill and pass the connection and feed into it 
		Person p = new Person();
		p  = fetchDetails(p);
		feedDetails(con,p);
		ch = scanner.next();
		
	}
	printDetails(con);
	con.close();
	
	}
	catch(Exception e ) {
		e.printStackTrace();
	}
	finally {
		System.out.println("I will win this battle first then war all over");
	}
	
}

 static void  feedDetails(Connection con,Person p ) {
	try {
//	Statement statement = con.createStatement();
//	 String query = "INSERT INTO employees VALUES (" + p.getEmp_id() + ",'" + p.getFirst_name() + "','" + p.getLast_name() + "','" + p.getPosition() + "','" + p.getSalary() + "' , '"+ p.getHiring_date()+"' )";
//	statement.executeUpdate(query);
		 String query = "INSERT INTO employees (emp_id, first_name, last_name, position, salary,hire_date) VALUES (?, ?, ?, ?, ?,?)";
    PreparedStatement preparedstatement =  con.prepareStatement(query);
    preparedstatement.setInt(1,p.getEmp_id());
    preparedstatement.setString(2, p.getFirst_name());
    preparedstatement.setString(3, p.getLast_name());
   preparedstatement.setString(4, p.getPosition());
   preparedstatement.setDouble(5, p.getSalary());
   preparedstatement.setString(6,p.getHiring_date());
   preparedstatement.executeUpdate();

	}
	catch(Exception e ) {
	   e.printStackTrace();
	}
	
}
static void printDetails(Connection con) {
	try {
	Statement statement = con.createStatement();
ResultSet rs = statement.executeQuery("select * from employees");
	}
	catch(Exception e ) {
		
	}
}


static Person fetchDetails(Person p ) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the first name of the employee");
	String first_name = scanner.next();
	p.setFirst_name(first_name);
	System.out.println("Enter the last name of the employee");
	String last_name = scanner.next();
	p.setLast_name(last_name);
	System.out.println("Enter the position of the employee");
	String position = scanner.next();
	p.setPosition(position);
	System.out.println("Enter the id of the employee");
	int  id = scanner.nextInt();
	p.setEmp_id(id);
	System.out.println("Enter the salary of the employee");
	double salary = scanner.nextDouble();
	p.setSalary(salary);
	String hiring_date = scanner.next();
	p.setHiring_date(hiring_date);
	return p;
}
}
class Person {
	private String first_name,last_name,position,hiring_date;
	public String getHiring_date() {
		return hiring_date;
	}
	public void setHiring_date(String hiring_date) {
		this.hiring_date = hiring_date;
	}
	private double salary;
	private int emp_id;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
}
/* emp_id | first_name | last_name | position  | salary      | hire_date */