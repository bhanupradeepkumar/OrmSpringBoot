package testbhanu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb","SA","");
			
			System.out.println("connected to db...");
			conn.setAutoCommit(false);
			PreparedStatement pst = conn.prepareStatement("INSERT INTO DEPT VALUES(?,?,?)");
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			Scanner sc3 = new Scanner(System.in);
			                                                           
			int newDeptNo = sc1.nextInt();
			String newLoc = sc2.nextLine();
			String newDeptName = sc3.nextLine();
			pst.setInt(1, newDeptNo);
			pst.setString(2, newLoc);
			pst.setString(3, newDeptName);
			int rows = pst.executeUpdate();
			System.out.println(rows);
			
			PreparedStatement pst2 = conn.prepareStatement("DELETE FROM DEPT WHERE DEPTNO=?");
			Scanner sc4 = new Scanner(System.in);
			int DeptNo = sc4.nextInt();
			pst2.setInt(1, DeptNo);
			int rows1 = pst2.executeUpdate();
			System.out.println(rows1);
			
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
