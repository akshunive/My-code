package com.nive.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nive.springdemo.entity.Customer;
import com.nive.springdemo.service.CustomerSerivce;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerSerivce service;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer> customers= service.getCustomersService();
		
		model.addAttribute("theCustomers",customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer theCustomer = new Customer();
		
		model.addAttribute("customer", theCustomer);
		
		return "add-customer";
	}
	
	
	@PostMapping("/addCustomer")
	public ModelAndView addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		ModelAndView mav= new ModelAndView();
		service.addCustomerService(theCustomer);
		String str="Customer Added successfully";
		mav.setViewName("redirect:/customer/list");
		mav.addObject("message",str);
		return mav;
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer theCustomer= service.getCustomerByIdService(id);
		System.out.println("*********   "+theCustomer.getFirstName());
		model.addAttribute("customer",theCustomer);
		return "update-customer";
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer theCustomer) {
		 System.out.println("Upadate   "+theCustomer.getId());
		
		 service.updateCustomerService(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@ModelAttribute("customerId") int id) {
		 
		Customer theCustomer = service.getCustomerByIdService(id);
		
		System.out.println("Delete   "+theCustomer.getId());
		
		 service.deleteCustomerService(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName")String searchName,Model m) {
		
		System.out.println("Search    "+searchName);
		List<Customer> searchCustomers = service.searchCustomerService(searchName);
		m.addAttribute("theCustomers", searchCustomers);
		return "list-customers";
	}
}
