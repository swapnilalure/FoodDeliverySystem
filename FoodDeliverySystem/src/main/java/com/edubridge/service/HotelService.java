package com.edubridge.service;

import com.edubridge.bean.HotelBean;

public interface HotelService {
	
	void add(HotelBean hotel);
	
	HotelBean authenticateHotel(String emailAddress, String pass);
	
	HotelBean getHotelById(int id);


}
