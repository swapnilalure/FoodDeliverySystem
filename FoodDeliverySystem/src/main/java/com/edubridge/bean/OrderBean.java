package com.edubridge.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class OrderBean {
	
	private Integer orderId;
	private String orderName;
	private HotelBean hotelBean;
	private CustomerBean customerBean;
//	private List<ProductQuantityBean> productQuantityBean;
	
	public OrderBean() {
		super();
	}
	public OrderBean(Integer orderId, HotelBean hotelBean, CustomerBean customerBean) {
		super();
		this.orderId = orderId;
		this.hotelBean = hotelBean;
		this.customerBean = customerBean;
	}
	
	
	public OrderBean(Integer orderId, String orderName, HotelBean hotelBean, CustomerBean customerBean,
			List<ProductQuantityBean> productQuantityBean) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.hotelBean = hotelBean;
		this.customerBean = customerBean;
//		this.productQuantityBean = productQuantityBean;
	}
	public OrderBean(Integer orderId, HotelBean hotelBean, CustomerBean customerBean,
			List<ProductQuantityBean> productQuantityBean) {
		super();
		this.orderId = orderId;
		this.hotelBean = hotelBean;
		this.customerBean = customerBean;
//		this.productQuantityBean = productQuantityBean;
	}
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	@Column
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@ManyToOne(targetEntity = HotelBean.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "hotelId")
	public HotelBean getHotelBean() {
		return hotelBean;
	}
	public void setHotelBean(HotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}
	
	@ManyToOne(targetEntity = HotelBean.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId")
	public CustomerBean getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderBean")
//	public List<ProductQuantityBean> getProductQuantityBean() {
//		return productQuantityBean;
//	}
//	public void setProductQuantityBean(List<ProductQuantityBean> productQuantityBean) {
//		this.productQuantityBean = productQuantityBean;
//	}
	
	

}
