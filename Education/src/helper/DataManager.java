package helper;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DataManager {
	private String url;
	private String username;
	private String password;
	
	private static  Connection conn=null;
	
	public DataManager() {}
		
	public static  Connection getConn(String url,String uname,String pass) throws Exception {
		if(conn==null) {
			
			
			//注册数据库的驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//通过DriverManager获取数据库
			conn= DriverManager.getConnection(url,uname,pass);
			
		
			return conn;
		}
		return conn;
	}
			

			
			
			
		
		
	
	
	

}
