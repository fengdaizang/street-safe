package com.service.impl;

import java.util.ArrayList;

import com.dao.DshopDao;
import com.entity.Dshop;
import com.service.DshopService;

public class DshopServiceImpl implements DshopService {
	private static DshopDao dshopDao=new DshopDao();

	@Override
	public ArrayList<Dshop> getAllDshop() {
		return dshopDao.getAllDshop();
	}

	@Override
	public int addDshop(Dshop dshop) {
		return dshopDao.addDshop(dshop);
	}

	@Override
	public int updateDshop(Dshop dshop) {
		return dshopDao.updateDshop(dshop);
	}

	@Override
	public int deleteDshop(String dno) {
		return dshopDao.deleteDshop(dno);
	}

}
