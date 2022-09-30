package com.edubridge.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.bean.ProductQuantityBean;
import com.edubridge.dao.OrderDao;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SessionFactory session;

	@Override
	public void addCart(ProductQuantityBean productQuantityBean) {
		
		session.getCurrentSession().save(productQuantityBean);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductQuantityBean> showCart() {
		
		return session.getCurrentSession().
				createQuery("from ProductQuantityBean")
				.list();
	}

	@SuppressWarnings("unused")
	@Override
	public ProductQuantityBean getCartProductById(int id) {
		
		System.out.println(id);
		ProductQuantityBean productQuantityBean=session.getCurrentSession().get(ProductQuantityBean.class, id);
		return productQuantityBean;
	}

	@Override
	public void deleteCart(ProductQuantityBean id) {
		
		session.getCurrentSession().delete(id);
	}

}
