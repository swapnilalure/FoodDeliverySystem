package com.edubridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String showIndex() {
		

		return "index";
	}
	
	@RequestMapping(value = "/hotel.html", method = RequestMethod.GET)
	public String showHotel() {
		

		return "hotel";
	}
	
	@RequestMapping(value = "/customer.html", method = RequestMethod.GET)
	public String showCustomer() {
		

		return "customer";
	}

}
