package com.edubridge.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.edubridge.bean.CustomerBean;
import com.edubridge.bean.HotelBean;
import com.edubridge.service.CustomerService;
import com.edubridge.service.HotelService;

@Controller
public class LoginController {
	
	private static final String HOTELBEAN = "hotel";
	private static final String CUSTOMERBEAN = "customer";
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@RequestMapping(value = "/hotelLogin.html", method = RequestMethod.POST)
	public ModelAndView loginHotel(@ModelAttribute(HOTELBEAN) HotelBean hotel,
			HttpSession session, Model model) {
				
		String emailAddress=hotel.getEmailAddress();
		String pass=hotel.getPassword();
		String hotelName;
		
		System.out.println(emailAddress+"    "+pass);
		
		HotelBean hotel1= hotelService.authenticateHotel(emailAddress, pass);
		
		ModelAndView mv= new ModelAndView();
		
		
		if (hotel1 == null) {
			mv.setViewName("hotel");
			return mv;
		}
		else {
			mv.addObject("hotelName", hotel1.getHotelName());
			mv.setViewName("hotelDashboard");
			session.setAttribute("hotel", hotel1);
			return mv;
		}
		
	}
	
	@RequestMapping(value = "/logoutHotel.html", method = RequestMethod.GET)
	public String logoutHotel(HttpSession session) {

		try {
			session.invalidate();
		} catch (Exception e) {
			System.out.println(e);

		}
		return "index";
	}
	
	@RequestMapping(value = "/customerLogin.html", method = RequestMethod.POST)
	public ModelAndView customerLogin(@ModelAttribute(CUSTOMERBEAN) CustomerBean customer,
			HttpSession session, Model model) {
				String emailAddress=customer.getEmailAddress();
				String pass=customer.getPassword();
				String customerName;
				String productDisplay = "none";
				String btnLink="showHotels.html";
				String btnDisp="Show Hotels";
				
				System.out.println(emailAddress+"     "+pass);
				
				CustomerBean customer1=customerService.authenticateCustomer(emailAddress, pass);
				ModelAndView mv=new ModelAndView();
				
				if(customer1 == null) {
					mv.setViewName("customer");
					return mv;
				}else {
					mv.setViewName("customerDashboard");
					mv.addObject("productDisplay", productDisplay);
					mv.addObject("btnLink", btnLink);
					mv.addObject("btnDisp", btnDisp);
					mv.addObject("customerName", customer1.getCustomerName());
					session.setAttribute("customer", customer1);
					model.addAttribute(customer1);
					
					return mv;
				}
		
				
		
	}

}
