package com.edubridge.dao;

import java.util.List;

import com.edubridge.bean.CustomerBean;
import com.edubridge.bean.HotelBean;

public interface CustomerDao {
	
	void add(CustomerBean customer);
	CustomerBean authenticateCustomer(String emailAddress, String pass);
	List<HotelBean> showHotels();

}
