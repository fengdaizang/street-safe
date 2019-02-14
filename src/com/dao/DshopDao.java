package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Dshop;

public class DshopDao {
	private static BaseDao baseDao=new BaseDao();
	
	private Dshop getEntity(ResultSet rs) throws SQLException{
		Dshop dshop=new Dshop();
		dshop.setDname(rs.getString("dname"));
		dshop.setDno(rs.getString("dno"));
		dshop.setDsafe(rs.getString("dsafe"));
		dshop.setDtel(rs.getString("dtel"));
		dshop.setDtype(rs.getString("dtype"));
		
		return dshop;
	}
	
	/**
	 * 得到所有的街道信息
	 * @return
	 */
	public ArrayList<Dshop> getAllDshop(){
		ArrayList<Dshop> dshops = new ArrayList<Dshop>();
		String sql = "select * from dshop";
		ResultSet resultSet = baseDao.doQuery(sql, null);
		try {
			while(resultSet.next()){
				dshops.add(getEntity(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		return dshops;
	}
	/**
	 * 添加街道信息
	 * @param street
	 * @return
	 */
	public int addDshop(Dshop dshop){
		String sql = "insert into dshop(dno, dname,dtype,dtel,dsafe) values(?,?,?,?,?)";
		String [] params = {dshop.getDno(),dshop.getDname(),
				dshop.getDtype(),dshop.getDtel(),dshop.getDsafe()};
		
		return baseDao.doUpdate(sql, params);
	}
	/**
	 * 更新街道信息
	 * @param street
	 * @return
	 */
	public int updateDshop(Dshop dshop){
		String sql = "update dshop set dname=?,dtype=?,dtel=?,dsafe=? where dno=?";
		String [] params = {dshop.getDname(),
				dshop.getDtype(),dshop.getDtel(),dshop.getDsafe(),dshop.getDno()};
		
		return baseDao.doUpdate(sql, params);
	}
	/**
	 * 删除街道信息
	 * @param sno
	 * @return
	 */
	public int deleteDshop(String dno){
		String sql = "delete from dshop where dno=?";
		String [] params = {dno};
		
		return baseDao.doUpdate(sql, params);
	}
	
}
