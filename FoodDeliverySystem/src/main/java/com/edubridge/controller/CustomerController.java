package com.edubridge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edubridge.bean.CustomerBean;
import com.edubridge.bean.HotelBean;
import com.edubridge.bean.ProductBean;
import com.edubridge.bean.ProductQuantityBean;
import com.edubridge.service.CustomerService;
import com.edubridge.service.OrderService;
import com.edubridge.service.ProductService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	private static final String CUSTOMERBEAN="customer";
	
	private static final String HOTELBEAN="hotel";
	
	private static final String PRODUCTBEAN="product";
	
	
	@RequestMapping(value = "/customerSignup.html", method = RequestMethod.GET)
	public String customerSignup() {
		

		return "customerSignup";
	}
	
	@RequestMapping(value = "/customerRegistrationSuccess.html", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute(CUSTOMERBEAN) CustomerBean customer,
			HttpSession session, Model model) {
		
		try {
			customerService.addCustomer(customer);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "customerRegistrationSuccess";
		
	}
	
	@RequestMapping(value = "showHotels.html", method = RequestMethod.GET)
	public ModelAndView showHotels(@ModelAttribute(HOTELBEAN)HotelBean hotel, HttpSession session,
			Model model) {
		CustomerBean customerBean=(CustomerBean) session.getAttribute(CUSTOMERBEAN);
		String customerName=customerBean.getCustomerName();
		String productDisplay = "none";
		String btnLink="showHotels.html";
		String btnDisp="Show Hotels";
		
				
		
		List<HotelBean> hotel1= customerService.showHotels();
		session.setAttribute("customer", customerBean);
		session.setAttribute("hotel", hotel1);
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("customerDashboard");
		mv.addObject("productDisplay", productDisplay);
		mv.addObject("btnLink", btnLink);
		mv.addObject("btnDisp", btnDisp);
		mv.addObject("customerName", customerName);
		mv.addObject("hotels", hotel1);
		return mv;
	}
	
	@RequestMapping(value = "/showProductListCustomer.html", method = RequestMethod.GET)
	public ModelAndView showProductList(@RequestParam("hotelId") int hotelId,@ModelAttribute(PRODUCTBEAN) ProductBean product, HttpSession session,
			Model model) {
				
				CustomerBean customerBean= (CustomerBean) session.getAttribute(CUSTOMERBEAN);
				
				
				
				String hotelDisplay="none";
				String btnDisp="Back";
				String btnLink="showHotel.html";
				
				
				List<ProductBean> products= productService.displayProduct();
				List<ProductBean> list= new ArrayList<ProductBean>();
				
				for (ProductBean productBean : products) {
					if(productBean.getHotelBean().getHotelId()==hotelId) {
						list.add(productBean);
					}
				}
				
				session.setAttribute("customer", customerBean);
				
				model.addAttribute(CUSTOMERBEAN, customerBean);
				
				ModelAndView mv= new ModelAndView();
				mv.setViewName("customerDashboard");
				
				mv.addObject("hotelDisplay", hotelDisplay);
				mv.addObject("btnDisp", btnDisp);
				mv.addObject("btnLink", btnLink);
				mv.addObject("customerName", customerBean.getCustomerName());
				mv.addObject("customerId", customerBean.getCustomerId());
				mv.addObject("hotelId", hotelId);
				mv.addObject("list", list);
				
				return mv;
		
	}
	
//	@RequestMapping(value = "/returnCustomerDashboard.html", method = RequestMethod.GET)
//	public ModelAndView returnCustomerDashboard() {
//		ModelAndView mv= new ModelAndView();
//		mv.setViewName("customerDashboard")
//		
//		return mv;
//	}

}
