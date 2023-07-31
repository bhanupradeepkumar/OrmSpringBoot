package testbhanu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest2 {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb","SA","");
			System.out.println("connection established ...");
		conn.setAutoCommit(false);
		PreparedStatement pst = conn.prepareStatement("UPDATE YOLO SET EMPLOYEENAME=?,LOCATION=? WHERE EMPLOYEEID=?");
		System.out.println("prepare statement created...");
		
		Scanner sc1 = new Scanner(System.in);
		
		Scanner sc2 = new Scanner(System.in);
		
		Scanner sc3 = new Scanner(System.in);
		System.out.println("enter existing  employee id ");
		int  employeeId = sc1.nextInt();
		System.out.println("enter  new employee name ");
		String employeeName = sc2.nextLine();
		System.out.println("enter   new employee location ");
		String locationNew = sc3.nextLine();
	
				pst.setInt(3, employeeId); //set
				pst.setString(1,employeeName);//set
				pst.setString(2,locationNew);//where clause
				
				
				int rows = pst.executeUpdate();
				System.out.println(rows +"rows updated...");
				conn.commit();
				pst.close();
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
