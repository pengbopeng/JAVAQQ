package cn.edu.pbp.chat.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSql{
	//定义MySQL数据库驱动程序
	private static final String DBRIVER="org.gjt.mm.mysql.Driver";
	//定义MySQL数据库连接地址，db_library可改成自己的数据库名称
	private static final String DBURL="jdbc:mysql://localhost:3307/db_java_qq";
	private static final String DBUSER="root"; //MySQL数据库连接用户名
	private static final String PASSWORD="123456"; //MySQL数据库连接密码
	private Connection conn=null; //保存连接对象
	public DatabaseConnectionSql(){//构造方法连接数据库
		try {
			Class.forName(DBRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//返回数据库连接对象
		return this.conn;
	}
	public void close() {//关闭数据连接
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}