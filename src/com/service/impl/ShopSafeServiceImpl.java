package com.service.impl;

import java.util.ArrayList;

import com.dao.ShopSafeDao;
import com.entity.ShopSafe;
import com.service.ShopSafeService;

public class ShopSafeServiceImpl implements ShopSafeService {
	
	private static ShopSafeDao shopSafeDao=new ShopSafeDao();

	@Override
	public ArrayList<ShopSafe> getAllShopSafe() {
		return shopSafeDao.getAllDshop();
	}

	@Override
	public int addShopSafe(ShopSafe shopSafe) {
		return shopSafeDao.addShopSafe(shopSafe);
	}

	@Override
	public int updateShopSafe(ShopSafe shopSafe) {
		return shopSafeDao.updateShopSafe(shopSafe);
	}

	@Override
	public int deleteShopSafe(String sno, String dno) {
		return shopSafeDao.deleteShopSafe(sno, dno);
	}

}
