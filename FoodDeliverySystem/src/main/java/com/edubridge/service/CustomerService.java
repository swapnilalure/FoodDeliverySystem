package com.edubridge.service;

import java.util.List;

import com.edubridge.bean.CustomerBean;
import com.edubridge.bean.HotelBean;

public interface CustomerService {
	
	void addCustomer(CustomerBean customer);
	
	CustomerBean authenticateCustomer(String emailAddress, String pass);
	
	List<HotelBean> showHotels();

}
