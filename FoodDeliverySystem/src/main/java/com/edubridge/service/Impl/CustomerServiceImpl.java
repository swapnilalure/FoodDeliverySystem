package com.edubridge.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.bean.CustomerBean;
import com.edubridge.bean.HotelBean;
import com.edubridge.dao.CustomerDao;
import com.edubridge.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Transactional
	public void addCustomer(CustomerBean customer) {
		try {
			customerDao.add(customer);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Transactional
	public CustomerBean authenticateCustomer(String emailAddress, String pass) {
		
		System.out.println(emailAddress+"    "+pass);
		
		return customerDao.authenticateCustomer(emailAddress, pass);
	}

	@Transactional
	public List<HotelBean> showHotels() {
		
		return customerDao.showHotels();
	}

}
