package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Street;

public class StreetDao {
	private static BaseDao baseDao=new BaseDao();
	
	private Street getEntity(ResultSet rs) throws SQLException{
		Street street=new Street();
		street.setMname(rs.getString("mname"));
		street.setMtel(rs.getString("mtel"));
		street.setSname(rs.getString("sname"));
		street.setSno(rs.getString("sno"));
		
		return street;
	}
	
	/**
	 * 得到所有的街道信息
	 * @return
	 */
	public ArrayList<Street> getAllStreet(){
		ArrayList<Street> streets = new ArrayList<Street>();
		String sql = "select * from street";
		ResultSet resultSet = baseDao.doQuery(sql, null);
		try {
			while(resultSet.next()){
				streets.add(getEntity(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		return streets;
	}
	/**
	 * 添加街道信息
	 * @param street
	 * @return
	 */
	public int addStreet(Street street){
		String sql = "INSERT INTO street(sno, sname,mname,mtel) VALUES (?,?,?,?)";
		String [] params = {street.getSno(),street.getSname(),street.getMname(),street.getMtel()};
		
		return baseDao.doUpdate(sql, params);
	}
	/**
	 * 更新街道信息
	 * @param street
	 * @return
	 */
	public int updateStreet(Street street){
		String sql = "update street set sname=?,mname=?,mtel=? where sno=?";
		String [] params = {street.getSname(),street.getMname(),street.getMtel(),street.getSno()};
		
		return baseDao.doUpdate(sql, params);
	}
	/**
	 * 删除街道信息
	 * @param sno
	 * @return
	 */
	public int deleteStreet(String sno){
		String sql = "delete from street where sno=?";
		String [] params = {sno};
		
		return baseDao.doUpdate(sql, params);
	}
	
}
