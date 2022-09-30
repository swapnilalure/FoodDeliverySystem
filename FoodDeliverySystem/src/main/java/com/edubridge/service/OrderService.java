package com.edubridge.service;

import java.util.List;

import com.edubridge.bean.ProductQuantityBean;

public interface OrderService {
	
	void addCart(ProductQuantityBean productQuantityBean);
	
	List<ProductQuantityBean> showCart();
	
	ProductQuantityBean getCartProductById(int id);
	
	void deleteCart(ProductQuantityBean id);

}
