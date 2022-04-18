package dataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import dataBase.exception.DataBaseException;

public class Connect {
	private static Connection conn = null;
	
	public static Connection oracle() {
		if(conn == null) {
			try {
				Properties pro = loadSetting();
				conn = DriverManager.getConnection(pro.getProperty("url"),pro);
			}catch(SQLException e) {
				throw new DataBaseException(e.getLocalizedMessage());
			}
		}
		return conn;
	}
	
	public static void close() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DataBaseException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DataBaseException(e.getMessage());
			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DataBaseException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DataBaseException(e.getMessage());
			}
		}
	}

	
	private static Properties loadSetting() {
		try(FileInputStream fl = new FileInputStream("DataBaseSettings.properties")){
			Properties pro = new Properties();
			pro.load(fl);
			return pro;
		}catch (IOException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
}
