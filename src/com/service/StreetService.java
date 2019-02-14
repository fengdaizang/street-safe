package com.service;

import java.util.ArrayList;

import com.entity.Street;

public interface StreetService {
	public ArrayList<Street> getAllStreet();
	public int addStreet(Street street);
	public int updateStreet(Street street);
	public int deleteStreet(String sno);
}
