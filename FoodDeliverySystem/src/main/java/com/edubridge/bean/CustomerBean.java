package com.edubridge.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="customer")
public class CustomerBean {
	
	private static final String CUSTOMER="customer";
	
	
	private Integer customerId;
	
	private String customerName;
	
	private String mobileNumber;
	
	private String emailAddress;
	
	private String password;
	
	private String confirmPassword;
	
	private String addressLineOne;
	
	private String addressLineTwo;
	
	private String city;
	
	private String pincode;
	
	private List<OrderBean> orderBean;
	
	private List<ProductQuantityBean> productQuantityBean;
	
	
	
	public CustomerBean() {
		
	}
	
	public CustomerBean(Integer customerId, String customerName, String mobileNumber, String emailAddress,
			String password, String confirmPassword, String addressLineOne, String addressLineTwo, String city,
			String pincode) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.pincode = pincode;
	}
	

	public CustomerBean(Integer customerId, String customerName, String mobileNumber, String emailAddress,
			String password, String confirmPassword, String addressLineOne, String addressLineTwo, String city,
			String pincode, List<OrderBean> orderBean) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.pincode = pincode;
		this.orderBean = orderBean;
	}
	

	public CustomerBean(Integer customerId, String customerName, String mobileNumber, String emailAddress,
			String password, String confirmPassword, String addressLineOne, String addressLineTwo, String city,
			String pincode, List<OrderBean> orderBean, List<ProductQuantityBean> productQuantityBean) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.pincode = pincode;
		this.orderBean = orderBean;
		this.productQuantityBean = productQuantityBean;
	}

	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	@Column
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	@Column
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Column
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = OrderBean.class, mappedBy = "customerBean")
	public List<OrderBean> getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(List<OrderBean> orderBean) {
		this.orderBean = orderBean;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = ProductQuantityBean.class, mappedBy = "customerBean")
	public List<ProductQuantityBean> getProductQuantityBean() {
		return productQuantityBean;
	}

	public void setProductQuantityBean(List<ProductQuantityBean> productQuantityBean) {
		this.productQuantityBean = productQuantityBean;
	}
	
	
	
	

}
