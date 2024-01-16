package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.model.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/getproducts")
	public ModelAndView getProducts(HttpSession session){
		
		MyUser u= (MyUser) session.getAttribute("user");
		
		if(u!=null) {
			System.out.println("u");
			
		  List<Product> plist= pservice.getAllProducts();
		  
		  
		return new ModelAndView("displayproduct","plist",plist);
		
	}
		return new ModelAndView("redirect:/login");
    
	

  }
	@GetMapping("/addproduct")
	public String addNewProduct(HttpSession session) {
	
		MyUser u= (MyUser) session.getAttribute("user");
		if(u!=null) {
			
			return "addproduct";
			
		}
		return "redirect:/login";
		
	 }
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct(@RequestParam int pid, @RequestParam String pname,@RequestParam int qty,@RequestParam double price) {
		Product p=new Product(pid,pname,qty,price);
		pservice.addnewproduct(p);
		return new ModelAndView("redirect:/product/getproducts");
		
	}
	

		
}
	

