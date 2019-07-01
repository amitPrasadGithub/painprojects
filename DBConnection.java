import java.util.*;
import java.sql.*;
import sun.jdbc.odbc.*;


public class DBConnection {
	String url 	= "jdbc:mysql://localhost:3306/vbesfb";
	String user = "root";
	String pass = "CDSWEB";
	
	Connection con = null;
	PreparedStatement pstmnt = null;
	
	public void registerDriver(String driver) throws Exception {
		System.out.print("\n enter which driver to load 1 or 2 :: ");
		int choice = new Scanner(System.in).nextInt();
		switch(choice) {
			case 1:
				Class.forName(driver);
				break;
			case 2:
				com.mysql.jdbc.Driver d = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(d);
				break;
			default:
				break;
		}
		
	}
	public void getConnection() throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		System.out.print("\n ## connction done");
	}
	public static void main(String[] args) throws Exception {
		System.out.print("\n Enter driver name to register :: ");
		new DBConnection().registerDriver(new Scanner(System.in).nextLine());
		new DBConnection().getConnection();
		
	}
	
}