package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton Class - Only One Connection to Database
public class connectDB {
	private static Connection conn;
	
	public static Connection setConn() {
		if(conn!=null) {
			return conn;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sakila";
			String user = "root";
			String pass = "root";
			conn = DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void remConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
