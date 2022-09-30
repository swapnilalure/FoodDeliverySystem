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
import javax.persistence.Table;

@Entity
@Table (name="hotel")
public class HotelBean {

	private static final String HOTELBEAN = "hotel";
	
	/** hotel ID  **/
	
	private Integer hotelId;
	
	/** hotel Name  **/
	
	private String hotelName;
	
	/** hotel Number  **/
	
	private Long mobileNumber;
	
	/** hotel emailAddress  **/
	
	private String emailAddress;
	
	/** hotel password  **/
	
	private String password;
	
	/** hotel confirm password  **/
	
	private String confirmPassword;
	
	/** hotel address  **/
	
	private String address;
	
	/** hotel City  **/
	
	private String city;
	
	/** hotel pincode  **/
	
	private Integer pincode;
	
	/** The Product **/
	
	private Set<ProductBean> productBean;
	
	private List<OrderBean> orderBean;
	
	
	
	/** Instantiate new Hotel  **/
	public HotelBean() {
		
	}
	
	/** Instantiate new Hotel  
	 * 	@param hotelId
	 * 	@param hotelName
	 * 	@param mobileNumber
	 * 	@param emailAddress
	 * 	@param password
	 * 	@param confirmPassword
	 * 	@param address
	 * 	@param city
	 * 	@param pincode
	 * **/
	public HotelBean(Integer hotelId, String hotelName, Long mobileNumber, String emailAddress, String password,
			String confirmPassword, String address, String city, Integer pincode) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
	}

	public HotelBean(Integer hotelId, String hotelName, Long mobileNumber, String emailAddress, String password,
			String confirmPassword, String address, String city, Integer pincode, Set<ProductBean> productBean) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.productBean = productBean;
		
	}
	
	

	

	public HotelBean(Integer hotelId, String hotelName, Long mobileNumber, String emailAddress, String password,
			String confirmPassword, String address, String city, Integer pincode, Set<ProductBean> productBean,
			List<OrderBean> orderBean) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.productBean = productBean;
		this.orderBean = orderBean;
	}

	@Id
	@Column(name = "hotelId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	@Column(name = "hotelName")
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@Column(name = "mobileNumber")
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "emailAddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "confirmPassword")
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "pincode")
	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotelBean")
	public Set<ProductBean> getProductBean() {
		return productBean;
	}

	public void setProductBean(Set<ProductBean> productBean) {
		this.productBean = productBean;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = OrderBean.class, mappedBy = "hotelBean")
	public List<OrderBean> getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(List<OrderBean> orderBean) {
		this.orderBean = orderBean;
	}

	
	
	

}
