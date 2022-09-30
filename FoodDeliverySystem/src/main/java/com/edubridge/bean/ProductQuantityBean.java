package com.edubridge.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ProductQuantityBean {
	
	private Integer pqId;
	private Integer quantity;
	private Integer price;
	private Integer productId;
	private String productName;
	private Integer pricePerProduct;
	private CustomerBean customerBean;
//	private ProductBean productBean;
//	private OrderBean orderBean;
	
	public ProductQuantityBean() {
		super();
	}
	public ProductQuantityBean(Integer pqId, Integer quantity, Integer price, ProductBean productBean) {
		super();
		this.pqId = pqId;
		this.quantity = quantity;
		this.price = price;
//		this.productBean = productBean;
	}
	
	public ProductQuantityBean(Integer pqId, Integer quantity, Integer price, ProductBean productBean,
			OrderBean orderBean) {
		super();
		this.pqId = pqId;
		this.quantity = quantity;
		this.price = price;
//		this.productBean = productBean;
//		this.orderBean = orderBean;
	}
	
	
	
	public ProductQuantityBean(Integer pqId, Integer quantity, Integer price, Integer productId, String productName,
			Integer pricePerProduct, OrderBean orderBean) {
		super();
		this.pqId = pqId;
		this.quantity = quantity;
		this.price = price;
		this.productId = productId;
		this.productName = productName;
		this.pricePerProduct = pricePerProduct;
//		this.orderBean = orderBean;
	}
	
	public ProductQuantityBean(Integer pqId, Integer quantity, Integer price, Integer productId, String productName,
			Integer pricePerProduct, CustomerBean customerBean) {
		super();
		this.pqId = pqId;
		this.quantity = quantity;
		this.price = price;
		this.productId = productId;
		this.productName = productName;
		this.pricePerProduct = pricePerProduct;
		this.customerBean = customerBean;
	}
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPqId() {
		return pqId;
	}
	public void setPqId(Integer pqId) {
		this.pqId = pqId;
	}
	@Column
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Column
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	@Column
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	@Column
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column
	public Integer getPricePerProduct() {
		return pricePerProduct;
	}
	public void setPricePerProduct(Integer pricePerProduct) {
		this.pricePerProduct = pricePerProduct;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerBean.class)
	@JoinColumn(name = "custoemrId", nullable = false)
	public CustomerBean getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}
	
}
