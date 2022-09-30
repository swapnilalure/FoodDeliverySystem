package com.edubridge.dao;

import com.edubridge.bean.HotelBean;

public interface HotelDao {
	
	void add(HotelBean hotel);
	HotelBean authenticateHotel(String emailAddress, String pass);
	HotelBean getHotelById(int id);

}
