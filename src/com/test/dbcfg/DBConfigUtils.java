package com.test.dbcfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库 工具类
 *
 */
public class DBConfigUtils {

	private static String ORCL_URL;

	private static String ORCL_USER;

	private static String ORCL_PWD;

	private static String ORCL_ORACLEDRIVER;

	static {
		ORCL_URL = PropertiesConfigRead.getPropertyValue("ORCL_URL");
		ORCL_USER = PropertiesConfigRead.getPropertyValue("ORCL_USER");
		ORCL_PWD = PropertiesConfigRead.getPropertyValue("ORCL_PWD");
		ORCL_ORACLEDRIVER = PropertiesConfigRead.getPropertyValue("ORCL_ORACLEDRIVER");
	}

	/**
	 * 获取连接通道
	 */
	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName(ORCL_ORACLEDRIVER);
			conn = DriverManager.getConnection(ORCL_URL, ORCL_USER, ORCL_PWD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("数据库获取通道异常：" + e.getMessage());
		}
		return conn;

	}

	/**
	 * 关闭 资源
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void close(Connection conn, Statement st, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("数据库连接关闭异常：" + e.getMessage());
		}

	}

	public static void main(String[] args) {

		System.out.println(DBConfigUtils.getConnection());

	}

}
