package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.ShopSafe;

public class ShopSafeDao {
	private static BaseDao baseDao=new BaseDao();
	
	private ShopSafe getEntity(ResultSet rs) throws SQLException{
		ShopSafe shopSafe=new ShopSafe();
		shopSafe.setSno(rs.getString("sno"));
		shopSafe.setDno(rs.getString("dno"));
		shopSafe.setXflevel(rs.getString("xflevel"));
		shopSafe.setFwlevel(rs.getString("fwlevel"));
		shopSafe.setQtlevel(rs.getString("qtlevel"));
		
		return shopSafe;
	}
	
	/**
	 * 得到所有的街道信息
	 * @return
	 */
	public ArrayList<ShopSafe> getAllDshop(){
		ArrayList<ShopSafe> shopSafes = new ArrayList<ShopSafe>();
		String sql = "select * from shopsafe";
		ResultSet resultSet = baseDao.doQuery(sql, null);
		try {
			while(resultSet.next()){
				shopSafes.add(getEntity(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		return shopSafes;
	}
	/**
	 * 添加街道信息
	 * @param street
	 * @return
	 */
	public int addShopSafe(ShopSafe shopSafe){
		String sql = "insert into shopsafe(sno, dno,xflevel,fwlevel,qtlevel) values(?,?,?,?,?)";
		String [] params = {shopSafe.getSno(),shopSafe.getDno(),
				shopSafe.getXflevel(),shopSafe.getFwlevel(),
				shopSafe.getQtlevel()};
		
		return baseDao.doUpdate(sql, params);
	}
	/**
	 * 更新街道信息
	 * @param street
	 * @return
	 */
	public int updateShopSafe(ShopSafe shopSafe){
		String sql = "update dshop set xflevel=?,fwlevel=?,qtlevel=? where sno=? and dno=?";
		String [] params = {shopSafe.getXflevel(),shopSafe.getFwlevel(),
				shopSafe.getQtlevel(),shopSafe.getSno(),shopSafe.getDno()};
		
		return baseDao.doUpdate(sql, params);
	}
	/**
	 * 删除街道信息
	 * @param sno
	 * @return
	 */
	public int deleteShopSafe(String sno,String dno){
		String sql = "delete from shopsafe where sno=? and dno=?";
		String [] params = {sno,dno};
		
		return baseDao.doUpdate(sql, params);
	}
	
}
