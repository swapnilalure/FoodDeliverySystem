package com.edubridge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edubridge.bean.HotelBean;
import com.edubridge.bean.ProductBean;
import com.edubridge.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	private static final String PRODUCTBEAN= "ProductBean";
	
	private static final String HOTELBEAN= "hotel";
	
	/* ADD PRODUCT */
	
	@RequestMapping(value = "/addProduct.html", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute(PRODUCTBEAN) ProductBean product, HttpSession session,
			Model model) {
		String hotelName;
		HotelBean hotelBean= (HotelBean) session.getAttribute(HOTELBEAN);
		product.setHotelBean(hotelBean);
		System.out.println(hotelBean.getHotelId());
		String message="Product Added Successfully";
		productService.addProduct(product);
		model.addAttribute(PRODUCTBEAN, product);
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("hotelDashboard");
		mv.addObject("hotelName", hotelBean.getHotelName());
		mv.addObject("message", message);
				
		return mv;
	}
	
	/* DISPLAY PRODUCT */
	
	@RequestMapping(value = "/showProductList.html", method = RequestMethod.GET)
	public ModelAndView showProductList(@ModelAttribute(PRODUCTBEAN) ProductBean product, HttpSession session,
			Model model) {
		String hotelName;
		HotelBean hotelBean=(HotelBean) session.getAttribute(HOTELBEAN);
		
		
		List<ProductBean> products= productService.displayProduct();
		List<ProductBean> list= new ArrayList<ProductBean>();
		
		for (ProductBean productBean : products) {
			if(productBean.getHotelBean().getHotelId()== hotelBean.getHotelId()) {
				
				list.add(productBean);
			}
		}
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("hotelDashboard");
		mv.addObject("hotelName", hotelBean.getHotelName());
		mv.addObject("list",list);
		
		return mv;
	}
	
	/* UPDATE PRODUCT */
	
	@RequestMapping(value = "/edit.html/{id}", method = RequestMethod.GET)
	public ModelAndView showEditForm(@PathVariable int id,@ModelAttribute(PRODUCTBEAN) ProductBean product, HttpSession session,
			Model model) {
		String hotelName;
		HotelBean hotelBean=(HotelBean) session.getAttribute(HOTELBEAN);
		System.out.println(id);
		product= productService.getProductById(id);
		
		ModelAndView mv= new ModelAndView();
		model.addAttribute(PRODUCTBEAN);
	
		mv.addObject("hotelName", hotelBean.getHotelName());
		mv.addObject("product",product);
		mv.setViewName("updateProduct");
		return mv;	
	}
	
	@RequestMapping(value = "/editSave.html", method = RequestMethod.POST)
	public @ResponseBody ModelAndView editSave(@ModelAttribute(PRODUCTBEAN) ProductBean product, HttpSession session,
			Model model) {
		
		
		HotelBean hotelBean= (HotelBean) session.getAttribute(HOTELBEAN);
		product.setHotelBean(hotelBean);
		
		productService.updateProduct(product);
		
		
		String message="Product Updated Successfully";
		String hotelName=hotelBean.getHotelName();
				
		model.addAttribute(PRODUCTBEAN);
		ModelAndView mv= new ModelAndView();
		mv.addObject("updateSuccess", message);
		mv.addObject("hotelName", hotelName);
		mv.setViewName("hotelDashboard");
		
		
		return mv;
	}
	
	@RequestMapping(value = "/deleteProduct.html/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable int id, HttpSession session,
			Model model) {
		ModelAndView mv=new ModelAndView();
		
			ProductBean productBean=productService.getProductById(id);
			productBean.setProductId(id);
			
			productService.deleteProduct(productBean);
			
			mv.setViewName("hotelDashboard");
		
			return mv;
		
	}
	

}
