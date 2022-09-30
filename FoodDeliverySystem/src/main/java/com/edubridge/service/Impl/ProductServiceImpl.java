package com.edubridge.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.bean.ProductBean;
import com.edubridge.dao.ProductDao;
import com.edubridge.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Transactional
	public void addProduct(ProductBean productBean) {
		
		try {
			productDao.addProduct(productBean);
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	@Transactional
	public List<ProductBean> displayProduct() {
		
		return productDao.displayProduct();
	}

	@Transactional
	public ProductBean getProductById(int id) {
		
		return productDao.getProductById(id);
	}

	@Transactional
	public void updateProduct(ProductBean productBean) {
		
		
		productDao.updateProduct(productBean);;
		
	}

	@Transactional
	public void deleteProduct(ProductBean id) {
		
		productDao.deleteProduct(id);
		
	}

}
