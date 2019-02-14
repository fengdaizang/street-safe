package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Person;

public class PersonDao {
	private static BaseDao baseDao=new BaseDao();
	
	private Person getEntity(ResultSet rs) throws SQLException{
		Person person=new Person();
		person.setDno(rs.getString("dno"));
		person.setSno(rs.getString("sno"));
		person.setPname(rs.getString("pname"));
		person.setPsex(rs.getString("psex"));
		person.setPtel(rs.getString("ptel"));
		person.setPtime(rs.getInt("ptime"));
		
		return person;
	}
	
	/**
	 * 得到所有的街道信息
	 * @return
	 */
	public ArrayList<Person> getAllDshop(){
		ArrayList<Person> persons = new ArrayList<Person>();
		String sql = "select * from person";
		ResultSet resultSet = baseDao.doQuery(sql, null);
		try {
			while(resultSet.next()){
				persons.add(getEntity(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		return persons;
	}
	/**
	 * 添加街道信息
	 * @param street
	 * @return
	 */
	public int addPerson(Person person){
		String sql = "insert into person(sno, dno,pname,psex,ptel,ptime) values(?,?,?,?,?)";
		String [] params = {person.getSno(),person.getDno(),
				person.getPname(),person.getPsex(),
				person.getPtel(),0+""};
		
		return baseDao.doUpdate(sql, params);
	}
	/**
	 * 更新街道信息
	 * @param street
	 * @return
	 */
	public int updatePerson(Person person){
		String sql = "update dshop set pname=?,psex=?,ptel=?,ptime=? where sno=? and dno=?";
		String [] params = {person.getPname(),person.getPsex(),
				person.getPtel(),person.getPtime()+"",person.getSno(),person.getDno()};
		
		return baseDao.doUpdate(sql, params);
	}
	/**
	 * 删除街道信息
	 * @param sno
	 * @return
	 */
	public int deletePerson(String sno,String dno){
		String sql = "delete from person where sno=? and dno=?";
		String [] params = {sno,dno};
		
		return baseDao.doUpdate(sql, params);
	}
	
}
