package com.edubridge.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.bean.HotelBean;
import com.edubridge.dao.HotelDao;
import com.edubridge.service.HotelService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelDao hotelDao;

	@Transactional
	public void add(HotelBean hotel) {
		try {
			hotelDao.add(hotel);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Transactional
	public HotelBean authenticateHotel(String emailAddress, String pass) {
		
		System.out.println(emailAddress+"    "+pass);
		
		
			return hotelDao.authenticateHotel(emailAddress, pass);
		
	}

	@Transactional
	public HotelBean getHotelById(int id) {
		
		return hotelDao.getHotelById(id);
	}
	

}
