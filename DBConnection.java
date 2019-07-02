import java.util.*;
import java.sql.*;
import sun.jdbc.odbc.*;


public class DBConnection {
	String url 	= "jdbc:mysql://localhost:3306/vbesfb";
	String user = "root";
	String pass = "proxy";
	
	Scanner sc = null;
	
	Connection con = null;
	PreparedStatement pstmnt = null;
	Statement stmnt  = null;
	StringBuffer sb = null;
	
	public void registerDriver(String driver) throws Exception {
		System.out.print("\n enter which driver to load 1 or 2 :: ");
		System.out.print("\n 1 :: Class.forName \n 2 :: DriverManager.registerDriver ");
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
	public void createTable() throws Exception {
		sb = new StringBuffer("create table");
		sc = new Scanner(System.in);
		System.out.print("\n Table Name>");
		String tableName = sc.nextLine();
		sb.append(" "+tableName+" (");
		
		System.out.print("\n How many attributes>");
		int size = sc.nextInt();
		String[] attr = new String[size];
		for(int i=0; i<size; i++) {
			System.out.print("\n Attribute>");
			attr[i] = sc.nextLine();
			if(i==0)
				sb.append(" "+attr[i]);
			else
				sb.append(", "+attr[i]);
			
		}
		sb.append(");");
	}
	public void dropTable() throws Exception {
		System.out.print("\n Table Name to drop>");
		String tableName = new Scanner(System.in).nextLine();
		String sql = "drop table "+tableName+";";
		stmnt = con.createStatement();
		boolean b = stmnt.execute(sb.toString());
	}
	public void select() {
		String sql = "select * from contact";
		
		try {
			stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int cols = md.getColumnCount();
			String[] str = new String[6];
			for(int i=1; i<=cols; i++) {
				str[i] = md.getColumnName(i);
				System.out.print("\n  :: "+i+" = "+md.getColumnName(i));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.print("\n Enter driver name to register :: ");
		DBConnection d = new DBConnection();
		d.registerDriver(new Scanner(System.in).nextLine());
		d.getConnection();
		//new DBConnection().dropTable();
		d.select();
		
	}
	
}