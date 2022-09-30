package com.edubridge.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.bean.CustomerBean;
import com.edubridge.bean.HotelBean;
import com.edubridge.dao.CustomerDao;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(CustomerBean customer) {
		try {
			session.getCurrentSession().save(customer);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public CustomerBean authenticateCustomer(String emailAddress, String pass) {
		
		CustomerBean customerBean=new CustomerBean();
		customerBean=(CustomerBean) session.getCurrentSession().createQuery("FROM CustomerBean U WHERE U.emailAddress=:email AND U.password=:pass")
				.setString("email", emailAddress).setString("pass", pass).uniqueResult();
		if(customerBean !=null) {
			return customerBean;
			
		}else {
			return null;
		}
		
		
	}

	@Override
	public List<HotelBean> showHotels() {
		
		return session.getCurrentSession().createQuery("from HotelBean").list();
	}

}
