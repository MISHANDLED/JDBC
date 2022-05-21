package main;

import java.sql.Connection;
import java.sql.SQLException;

import connector.connectDB;
import getData.DataGetter;
import insertData.DataInsert;
import insertTables.TableInsert;
import updateData.DataUpdate;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		//Connecting to DB
		Connection conn = connectDB.setConn();
		System.out.println(conn==null?"Not Connected":"Connected");
		System.out.println();
		
		//Creating Table - studentDetails
		TableInsert.createTable(conn);
		//Inserting Data in Table - studentDetails
		DataInsert.InsertData(conn);
		
		//Creating Table - imageDetails
		TableInsert.createImgTable(conn);
		//Inserting Data in Table - imageDetails
		DataInsert.InsertImage(conn);
		
		//Inserting Image via user Input
		DataInsert.InsertImageFromUser(conn);
		
		//Update Data
		DataUpdate.updateData(conn);
		
		//Show Data
		DataGetter.showData(conn);
		
		//Closing the Connection
		connectDB.remConn();
		System.out.println(conn.isClosed());
	}

}
