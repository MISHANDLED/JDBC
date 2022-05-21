package updateData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataUpdate {
	
	public static void updateData(Connection conn) {
	
		try {
			String query = "update studentDetails set sName = ?, sCity = ? where sID = ?";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			System.out.println("Enter New Name");
			pstmt.setString(1, br.readLine());
			
			System.out.println("Enter New City");
			pstmt.setString(2, br.readLine());
			
			System.out.println("Enter Student ID");
			pstmt.setInt(3, Integer.parseInt(br.readLine()));
			
			pstmt.executeUpdate();
			
			System.out.println("Data Updated Successfully");
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
