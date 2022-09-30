package com.edubridge.dao;

import java.util.List;

import com.edubridge.bean.ProductQuantityBean;

public interface OrderDao {
	
	void addCart(ProductQuantityBean productQuantityBean);
	
	List<ProductQuantityBean> showCart();
	
	ProductQuantityBean getCartProductById(int id);
	
	void deleteCart(ProductQuantityBean id);

}
