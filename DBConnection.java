import java.util.*;
import java.sql.*;
import java.io.*;


public class DBConnection {
	
	public static final String INSERT = "insert";
	public static final String UPDATE = "update";
	public static final String DELETE = "delete";
	public static final String SELECT = "select";
	
	String url 	= "jdbc:mysql://localhost:3306/vbesfb";
	String user = "root";
	String pass = "CDSWEB";
	
	Scanner sc = null;
	
	Connection con = null;
	PreparedStatement pstmnt;;
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
		System.out.print("\n 1> Instance variables  \n 2> Properties File ");
		System.out.print("\n Choice  :: ");
		int choice = new Scanner(System.in).nextInt();
		switch(choice) {
			case 1:
				con = DriverManager.getConnection(url, user, pass);
				System.out.print("\n ## Connction done");
				break;
			case 2: 
				Properties p = new Properties();
				p.load(new FileInputStream("DB.properties"));
				con = DriverManager.getConnection(url, p);
				System.out.print("\n ## Connection done");
				System.out.print("\n key = "+p.getProperty("user")+"\n key = "+p.getProperty("password"));
				
				break;
			default:
				break;
		}
		
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
	
	public void delete() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n ## Inside DELETE");
		String sql = "delete from contact where contactId = ?";
		pstmnt = con.prepareStatement(sql);
		while (true) {
			System.out.print("\n Enter contactId to delete => ");
			pstmnt.setInt(1, new Scanner(System.in).nextInt());
			
			int i = pstmnt.executeUpdate();
			
			System.out.print("\n Enter 0 to exit.. OR any other key to continue del");
			if(sc.nextInt() == 0) 
				System.exit(0);
		}
	}
	public void insert() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n ## Inside INSERT");
		String sql = "insert into contact (contactId, fname, lname, addressId, phoneId, webaddressId) values(?, ?, ?, ?, ?, ?)";
		pstmnt = con.prepareStatement(sql);
		while(true) {
			System.out.print("\n Enter fname => ");
			pstmnt.setString(2, sc.nextLine());
			
			System.out.print("\n Enter contactId => ");
			pstmnt.setInt(1, sc.nextInt());
			
			
			System.out.print("\n Enter lname => ");
			pstmnt.setString(3, sc.nextLine());
			System.out.print("\n Enter addressId => ");
			pstmnt.setInt(4, sc.nextInt());
			System.out.print("\n Enter phoneId => ");
			pstmnt.setInt(5, sc.nextInt());
			System.out.print("\n Enter webaddressId => ");
			pstmnt.setInt(6, sc.nextInt());
			
			int i=pstmnt.executeUpdate();
			System.out.print("\n Press 0 to exit...");
			if(sc.nextInt() == 0) 
				System.exit(0);
		}	
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
	public String getTableName() throws Exception {
		return "";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter driver name to register :: ");
		DBConnection d = new DBConnection();
		d.registerDriver(new Scanner(System.in).nextLine());
		d.getConnection();
		
		System.out.print("\n Operation => ");
		String operation = sc.nextLine();
		switch(operation) {
			case DBConnection.INSERT:
				d.insert();
				break;
			case DBConnection.UPDATE:
				//new DBConnection().update();
				break;
			case DBConnection.DELETE:
				d.delete();
				break;
			case DBConnection.SELECT:
				d.select();
			defalult:
				break;
		}
		
	}
	
}