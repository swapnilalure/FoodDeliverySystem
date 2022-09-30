package com.edubridge.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.edubridge.bean.HotelBean;
import com.edubridge.bean.ProductBean;
import com.edubridge.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory session;
	

	@Override
	public void addProduct(ProductBean productBean) {
		
		session.getCurrentSession().save(productBean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> displayProduct() {
		
		
		return session
				.getCurrentSession()
				.createQuery(
						"from ProductBean")
				.list();
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ProductBean getProductById(int id) {
		
		ProductBean productBean= session.getCurrentSession().get(ProductBean.class, id);
		 
		return productBean;
	}

	
	public void updateProduct(ProductBean productBean) {
		
		try {
			session.getCurrentSession().update(productBean);
		} catch (HibernateException e) {
			
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteProduct(ProductBean id) {
		
		session.getCurrentSession().delete(id);
		
	}
	
	

}
