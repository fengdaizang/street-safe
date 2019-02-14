package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据连接基本类
 *
 */
public class BaseDao{
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql:///street_safe";
	private String user="root";
	private String password="123456";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	/**
	 * 连接数据库
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws Exception{
		Class.forName(driver);
		connection=(Connection) DriverManager.getConnection(url,user,password);
	
		return connection;
	}
	/**
	 * 执行查询语句
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet doQuery(String sql,Object [] params){
		try {
			connection = getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			if(params!=null){
				for (int i=0; i<params.length;i++) {
					//设置占位符
					preparedStatement.setObject(i+1, params[i]);
				}
			}
			
			return preparedStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 执行增删改
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public int doUpdate(String sql,Object[] params){
		int num=0;
		try {
			connection=getConnection();
			preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			//判断参数列表是否为空
			if(params!=null){
				//设置占位符
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i+1, params[i]);
				}
				
			}
			num=preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dispose();
		}
		return num;
	}
	/**
	 * 释放资源
	 */
	public void dispose(){
		try {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connection!=null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}