package insertData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;

public class DataInsert {
	
	public static void InsertData(Connection conn) {
		try {
			String query = "insert into studentDetails(sName, sCity) values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);

			//Taking User Input
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your Name - ");
			String name = reader.readLine();

			System.out.println("Enter your City - ");
			String city = reader.readLine();

			pstmt.setString(1, name);
			pstmt.setString(2, city);

			//If you want to set value of integer use setInteger, for double use setDouble and so on...

			pstmt.executeUpdate();
			System.out.println("Row Inserted Successfully");
			
		} catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public static void InsertImage(Connection conn) {
		try{
			String query = "insert into imageDetails(Img) values (?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			FileInputStream stream = new FileInputStream("C:\\Users\\Hp\\Desktop\\pic1.png");
			
			pstmt.setBinaryStream(1,stream,stream.available());
			pstmt.executeUpdate();
			
			System.out.println("Success");
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public static void InsertImageFromUser(Connection conn) {
		try {
			String query = "insert into imageDetails(Img) values (?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			//Creating Dialog Box for user to choose a file from
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(null);
			
			File file = jfc.getSelectedFile();
			
			FileInputStream stream = new FileInputStream(file);
			
			pstmt.setBinaryStream(1, stream, stream.available());
			pstmt.executeUpdate();
			
			System.out.println("Success");
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
}

/*
BLOB in MYSQL : 
	BLOB is a Binary Large Object that can hold a variable amount of data
	Used to store Images/Videos

	There are 4 types - 

	TINYBLOB - Up to 255 Bytes
	BLOB - Up to 64KB
	MEDIUMBLOB - Up to 16Mb
	LONGBLOB - Up to 4Gb
*/