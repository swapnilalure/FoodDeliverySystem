package com.edubridge.dao;

import java.util.List;

import com.edubridge.bean.ProductBean;

public interface ProductDao{
	
	void addProduct(ProductBean productBean);
	
	List<ProductBean> displayProduct();
	
	ProductBean getProductById(int id);
	
	void updateProduct(ProductBean productBean);
	
	void deleteProduct(ProductBean id);

}
