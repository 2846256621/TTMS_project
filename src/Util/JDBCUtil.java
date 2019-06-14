package Util;




import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;

public class JDBCUtil {
	
	
	
	static ComboPooledDataSource datasource=null;
		
	 static {
	          datasource=new ComboPooledDataSource();    
	 }
	
	 //得到数据库连接池对象
	 public static  DataSource getDataSource() {
		 return datasource;
	 }
	 
	 
//	public static Connection getConn() throws SQLException{
//		 return datasource.getConnection();
//		}
		
	
	
	

	public static void release(Connection conn,Statement st,ResultSet rs)
	{
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	
	public static void release(Connection conn)
	{
		closeConn(conn);
	}
	
	public static void release(Connection conn,Statement ps)
	{
		closeSt(ps);
		closeConn(conn);
	}
	
	public static void release(Connection conn,PreparedStatement ps)
	{
		closeSt(ps);
		closeConn(conn);
	}
	public static void release(Connection conn,PreparedStatement ps,ResultSet rs)
	{
		closeRs(rs);
		closeSt(ps);
		closeConn(conn);
	}
	
	
	private static  void closeRs(ResultSet rs)
	{
		try {
			if(rs!=null)
	    	   rs.close();
		     } catch (SQLException e) 
	           {
			     e.printStackTrace();
		       }finally {
		    	   rs=null;
		       }
	}
	
	private static  void closeSt(Statement st)
	{
		try {
			if(st!=null)
	    	   st.close();
		     } catch (SQLException e) 
	           {
			     e.printStackTrace();
		       }finally {
		    	   st=null;
		       }
	}
	
	private static  void closeSt(PreparedStatement st)
	{
		try {
			if(st!=null)
	    	   st.close();
		     } catch (SQLException e) 
	           {
			     e.printStackTrace();
		       }finally {
		    	   st=null;
		       }
	}
	
	
	private static  void closeConn(Connection conn)
	{
		try {
			if(conn!=null)
	    	   conn.close();
		     } catch (SQLException e) 
	           {
			     e.printStackTrace();
		       }finally {
		    	   conn=null;
		       }
	}
}
