package com.edubridge.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductBean {
	
	
	private Integer productId;
	
	private String productName;
	
	private String productPrice;
	
	private String productDescription;
	
	/** The HotelBean **/
	
	private HotelBean hotelBean;
	
//	private List<ProductQuantityBean> productQuantityBean;
	

	public ProductBean() {
		
	}


	public ProductBean(Integer productId, String productName, String productPrice, String productDescription,
			Integer hotelId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}
	
	


	public ProductBean(Integer productId, String productName, String productPrice, String productDescription,
			HotelBean hotelBean) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.hotelBean = hotelBean;
	}


//	public ProductBean(Integer productId, String productName, String productPrice, String productDescription,
//			HotelBean hotelBean, List<ProductQuantityBean> productQuantityBean) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.productPrice = productPrice;
//		this.productDescription = productDescription;
//		this.hotelBean = hotelBean;
//		this.productQuantityBean = productQuantityBean;
//	}


	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Column(name = "productName")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "productPrice")
	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "productDescription")
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	@ManyToOne(targetEntity = HotelBean.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "hotelId", nullable = false)
	public HotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(HotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}


//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productBean")
//	public List<ProductQuantityBean> getProductQuantityBean() {
//		return productQuantityBean;
//	}
//
//
//	public void setProductQuantityBean(List<ProductQuantityBean> productQuantityBean) {
//		this.productQuantityBean = productQuantityBean;
//	}
	

	

}
