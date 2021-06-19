package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 数据库连接工具包
 * @author Administrator
 *
 */
public class JDBCUtils {
	static Connection conn =null;
	static Statement stmt=null;
	static ResultSet rs=null;
	/**
	 * 加载驱动
	 * @return 数据库连接对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException  {
			Class.forName("com.mysql.jdbc.Driver"); // 5.6以上
//			Class.forName("com.mysql.cj.jdbc.Driver"); 8.0版本以上
			String url = "jdbc:mysql://localhost:3306/product?useUnicode=true&characterEncoding=utf-8";
			String username = "root";
	    		String password = "942674";
			conn = DriverManager.getConnection(url, username, 
					password);
			return conn;
		}
	
	/**
	 * 释放数据库连接资源
	 */
	public static void release() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
	     
     /**
      * 执行查询SQL语句，并返回结果集
      * @param sql
      * @return
      */
    public static ResultSet executeQuery(String sql){
    	try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return rs;
    }
    /**
     * 执行查询SQL语句，并返回是否成功
     * @param sql
     * @return
     */
    public static boolean executeUpdate(String sql){
    	int num=0;
    	try {
			conn = getConnection();
			stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(num>0) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }
}
