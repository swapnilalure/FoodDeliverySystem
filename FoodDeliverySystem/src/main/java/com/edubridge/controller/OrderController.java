package com.edubridge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edubridge.bean.CustomerBean;
import com.edubridge.bean.HotelBean;
import com.edubridge.bean.OrderBean;
import com.edubridge.bean.ProductQuantityBean;
import com.edubridge.service.OrderService;


@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	private static final String PRODUCTQUANTITYBEAN="productQuantityBean";
	
	private static final String CUSTOMERBEAN="Customer";
	
	private static final String HOTELBEAN="hotel";
	
	private static final String ORDERBEAN="orderBean";
	
	List<ProductQuantityBean> cart= new ArrayList<ProductQuantityBean>();
	
	@PostMapping("/addCart.html/{customerId}/{hotelId}")
	public String addCart(@PathVariable int customerId, @PathVariable int hotelId,
			@ModelAttribute(PRODUCTQUANTITYBEAN) ProductQuantityBean productQuantityBean,
			HttpSession session,
			Model model) {
		System.out.println(customerId+"  "+hotelId);
		System.out.println(productQuantityBean.getPrice()+"    "+productQuantityBean.getQuantity());
		
		
		String url="redirect:/showProductListCustomer.html?hotelId="+hotelId;
		
		CustomerBean customerBean= new CustomerBean();
				customerBean.setCustomerId(customerId);
		 productQuantityBean.setCustomerBean(customerBean);
		 
		
		orderService.addCart(productQuantityBean);
		
		return url;
		
	}
	
	@GetMapping(value = "/showCart.html/{customerId}")
	public ModelAndView showCart(@PathVariable int customerId,
			HttpSession session, Model model) {
		
		
		
		List<ProductQuantityBean> productQuantityBean2=orderService.showCart();
		
		List<ProductQuantityBean> list= new ArrayList<ProductQuantityBean>();
		
		for (ProductQuantityBean productQuantityBean : productQuantityBean2) {
			
			if(productQuantityBean.getCustomerBean().getCustomerId()==customerId)
			{
				list.add(productQuantityBean);
			}
		}
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("customerId", customerId);
		mv.setViewName("cart");
		
		return mv;
	}

	
	@RequestMapping(value = "/deleteCart.html/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCart(@PathVariable int id, HttpSession session, Model model) {
		
		System.out.println(id);
		ProductQuantityBean productQuantityBean=orderService.getCartProductById(id);
		
		productQuantityBean.setPqId(id);
		
		orderService.deleteCart(productQuantityBean);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/showCart.html?customerId="+productQuantityBean.getCustomerBean().getCustomerId());
		
		return mv;
		
	}
	

}
