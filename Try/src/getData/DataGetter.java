package getData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataGetter {
	
	public static void showData(Connection conn) {
		
		try {
			String query = "select * from studentDetails";
			Statement stmt = conn.createStatement();
			ResultSet set = stmt.executeQuery(query);
			
			while(set.next()) {
				System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getString(3));
			}
			
			
			set.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
