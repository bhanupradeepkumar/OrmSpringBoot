package testbhanu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class SelectTest2 {
	
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb","SA","");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM YOLO");
			while(rs.next()) {
				System.out.println("emp id :"+rs.getInt(1));
				System.out.println("emp name :"+rs.getString(2));
				System.out.println("loc :"+rs.getString(3));
			}
			
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
