package edu.abc.ruanjianbei.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * ���ݿ⹤����
 *
 */
public class BaseDaoImpl {
	static ComboPooledDataSource cpds=null;
	static{
		cpds = new ComboPooledDataSource("oracle");//����oracle���ݿ�
	}
	/**
	 * ������ݿ�����
	 */
	public static Connection getConnection(){
		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ���ݿ�رղ���
	 * @param conn  
	 * @param st    
	 * @param pst
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement pst,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn,Statement sta,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(sta!=null){
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement pst,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ����DBUtil��
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn=getConnection();
		System.out.println(conn.getClass().getName());
		close(conn,null,null);
	}
}
