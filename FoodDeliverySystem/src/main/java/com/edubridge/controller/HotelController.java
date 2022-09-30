package com.edubridge.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edubridge.bean.HotelBean;
import com.edubridge.service.HotelService;

import net.sf.ehcache.hibernate.HibernateUtil;


@Controller
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	private static final String HOTELBEAN="hotel";
	
	
	@RequestMapping(value = "/hotelSignup.html", method = RequestMethod.GET)
	public String hotelSignup() {
		

		return "hotelSignup";
	}
	
	@RequestMapping(value = "/hotelRegistrationSuccess.html", method = RequestMethod.POST)
	public String addHotel(@ModelAttribute(HOTELBEAN) HotelBean hotel,
			HttpSession session, Model model) {
		
		try {
			hotelService.add(hotel);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "hotelRegistrationSuccess";	
	}

		
}

				
		

