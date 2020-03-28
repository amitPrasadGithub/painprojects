package DriverConnectio;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class DriverConnection {
	public static final String user = "root";
	public static final String pass = "vbesfb";
	public static final String url  = "jdbc:mysql://localhost:3306/vbesfb";
	
	public static final String dname = "com.mysql.jdbc.Driver";
	
	Scanner sc = null;
	public void loadDriver() {
		sc = new Scanner(System.in);
		System.out.print("\n :::Load Driver Approach:::");
		System.out.print("\n ---------------------");
		System.out.print("\n 1> Class.forName");
		System.out.print("\n 2> DriverManager.registerDriver");
		System.out.print("\n 3> Runtime loading driver");
		System.out.print("\n :::Enter your choice:::");
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				classDotForName(dname);
				getDriver();
				break;
			case 2:
				registerDriver();
				getDriver();
				break;
			default:
				System.exit(0);
		}
	}
	public void connection() {
		System.out.print("\n :::GetConnection approach:::");
		System.out.print("\n ----------------------");
		System.out.print("\n 1> String Url Password::");
		System.out.print("\n 2> url and properties file::");
		System.out.print("\n Enter your choice::");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			Connection con = getConnection(url, user, pass);
			System.out.print("\n Connection done"+con);
			break;
			
			default:
				System.exit(0);
		}
	}
	public void classDotForName(String str) {
		try {
			Class.forName(str);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void registerDriver() {
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void getDriver() {
		Enumeration en = DriverManager.getDrivers();
		while (en.hasMoreElements()) {
			Driver d = (Driver)en.nextElement();
			System.out.print("\n"+d.getClass().getName());
		}
	}
	public Connection getConnection(String url, Properties p) {
		try {
			return DriverManager.getConnection(url, p);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Connection getConnection(String url, String username, String password) {
		try {
			return DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		DriverConnection dc = new DriverConnection();
		dc.loadDriver();
		dc.connection();
	}
}
