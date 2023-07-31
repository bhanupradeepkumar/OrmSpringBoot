package testbhanu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class InsertTestDeleteTest2 {
	public static void main(String[] args) {
		
		
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb","SA","");
			System.out.println("connected to db...");
			conn.setAutoCommit(false);
			PreparedStatement pst = conn.prepareStatement("INSERT INTO YOLO  VALUES(?,?,?)");
			Scanner sc1 =new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			Scanner sc3 = new Scanner(System.in);

			int newEmployeeId = sc1.nextInt();
			String newEmployeeName = sc2.nextLine();
			String newLocation = sc3.nextLine();
			pst.setInt(1, newEmployeeId);
			pst.setString(2, newEmployeeName);
			pst.setString(3, newLocation);
			int rows = pst.executeUpdate();
			System.out.println(rows);
			
			/*PreparedStatement pst2 = conn.prepareStatement("DELETE FROM YOLO WHERE EMPLOYEEID=?");
			Scanner sc4 = new Scanner(System.in);
			
			int newEmployeeId2 = sc4.nextInt();
			pst2.setInt(1, newEmployeeId2);
			int rows1 = pst2.executeUpdate();
			System.out.println(rows1);
			sc1.close();
			sc2.close();
			sc3.close();
			sc4.close();            */
			conn.commit();
			pst.close();
			conn.close();
			System.out.println("disconnected from db...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}


