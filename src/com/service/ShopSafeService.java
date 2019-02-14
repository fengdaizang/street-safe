package com.service;

import java.util.ArrayList;

import com.entity.ShopSafe;

public interface ShopSafeService {
	public ArrayList<ShopSafe> getAllShopSafe();
	public int addShopSafe(ShopSafe shopSafe);
	public int updateShopSafe(ShopSafe shopSafe);
	public int deleteShopSafe(String sno,String dno);
}
