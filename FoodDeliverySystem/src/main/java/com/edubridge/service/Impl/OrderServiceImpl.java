package com.edubridge.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.bean.ProductQuantityBean;
import com.edubridge.dao.OrderDao;
import com.edubridge.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Transactional
	public void addCart(ProductQuantityBean productQuantityBean) {
		
		orderDao.addCart(productQuantityBean);
		
	}

	@Transactional
	public List<ProductQuantityBean> showCart() {
		
		return orderDao.showCart();
	}

	@Transactional
	public ProductQuantityBean getCartProductById(int id) {
		
		System.out.println(id);
		return orderDao.getCartProductById(id);
	}

	@Transactional
	public void deleteCart(ProductQuantityBean id) {
		
		orderDao.deleteCart(id);
	}

}
