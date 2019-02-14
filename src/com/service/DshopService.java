package com.service;

import java.util.ArrayList;

import com.entity.Dshop;

public interface DshopService {
	public ArrayList<Dshop> getAllDshop();
	public int addDshop(Dshop dshop);
	public int updateDshop(Dshop dshop);
	public int deleteDshop(String dno);
}
