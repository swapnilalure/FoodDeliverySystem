package com.edubridge.dao.Impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.bean.HotelBean;
import com.edubridge.dao.HotelDao;

@Repository
public class HotelDaoImpl implements HotelDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(HotelBean hotel) {
		try {
			session.getCurrentSession().save(hotel);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public HotelBean authenticateHotel(String emailAddress, String pass) {
		
		System.out.println(emailAddress+"    "+pass);
		
			HotelBean hotelBean=new HotelBean();
					hotelBean= (HotelBean) session.getCurrentSession().createQuery("FROM HotelBean U WHERE U.emailAddress=:email AND U.password=:pass")
					.setString("email", emailAddress).setString("pass", pass).uniqueResult();
			if(hotelBean !=null) {
				return hotelBean;
				
			}else {
				return null;
			}
			
		
		
		
	}

	@Override
	public HotelBean getHotelById(int id) {
		 
		HotelBean hotelBean= session.getCurrentSession().get(HotelBean.class, id);
		return hotelBean;
	}

}
