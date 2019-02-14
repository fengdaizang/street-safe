package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.base.UUIDTool;
import com.entity.UserInfo;


/*
 * 用户信息dao(数据库操作类)
 */ 
public class UserInfoDao{
	
	private static BaseDao baseDao=new BaseDao();
	
	public static UserInfo getEntity(ResultSet rs) throws SQLException{
		UserInfo userInfo=new UserInfo();
		userInfo.setId(rs.getString("id"));
		userInfo.setPassword(rs.getString("password"));
		userInfo.setUsername(rs.getString("username"));
		
		return userInfo;
	}
	
	/**
	 * 用户登录
	 * @param userInfo
	 * @return
	 */
	public UserInfo userLogin(UserInfo userInfo){
		String sql = "select * from userinfo where username = ? and password = ?";
		String [] params = {userInfo.getUsername(),userInfo.getPassword()};
		ResultSet resultSet = baseDao.doQuery(sql, params);
		try {
			if(resultSet.next()){
				userInfo=getEntity(resultSet);
			}else{
				userInfo=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userInfo;
	}
	/**
	 * 用户注册
	 * @param userInfo
	 * @return
	 */
	public int userRegist(UserInfo userInfo){
		String sql = "INSERT INTO userinfo(id, username, userpasswd) VALUES (?,?,?)";
		String [] params = {UUIDTool.getUUID(),userInfo.getUsername(),userInfo.getPassword()};
		
		return baseDao.doUpdate(sql, params);
	}
}
