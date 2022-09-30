package com.edubridge.service;

import java.util.List;

import com.edubridge.bean.ProductBean;

public interface ProductService {
	
	void addProduct(ProductBean productBean);
	
	List<ProductBean> displayProduct();
	
	ProductBean getProductById(int id);
	
	void updateProduct(ProductBean productBean);
	
	void deleteProduct(ProductBean id);

}
