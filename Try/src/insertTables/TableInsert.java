package insertTables;

import java.sql.Connection;
import java.sql.Statement;

public class TableInsert {
	
	public static void createTable(Connection conn){
		try{
			String query = "create table studentDetails(sID int primary key auto_increment, sName varchar(200) not null, sCity varchar(100))";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Table Created Successfully");
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public static void createImgTable(Connection conn){
		try{
			String query = "create table imageDetails(ImgId int primary key auto_increment, Img MEDIUMBLOB)";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Image Table Created");
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

}
