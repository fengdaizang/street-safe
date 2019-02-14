package com.service.impl;

import java.util.ArrayList;

import com.dao.StreetDao;
import com.entity.Street;
import com.service.StreetService;

public class StreetServiceImpl implements StreetService {
	
	private static StreetDao streetDao=new StreetDao();

	@Override
	public ArrayList<Street> getAllStreet() {
		return streetDao.getAllStreet();
	}

	@Override
	public int addStreet(Street street) {
		return streetDao.addStreet(street);
	}

	@Override
	public int updateStreet(Street street) {
		return streetDao.updateStreet(street);
	}

	@Override
	public int deleteStreet(String sno) {
		return streetDao.deleteStreet(sno);
	}

}
