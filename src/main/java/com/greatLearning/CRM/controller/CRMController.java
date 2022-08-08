package com.greatLearning.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.CRM.entity.CustomerDetails;
import com.greatLearning.CRM.service.CRMService;

@Controller
@RequestMapping("/crmData")
public class CRMController {

	@Autowired
	private CRMService crmService;
	
	@RequestMapping("/list")
	public String showDetails(Model theModel) {
		
		List<CustomerDetails> theCustomer = crmService.findAll();
		theModel.addAttribute("CustomerDetails", theCustomer);
		return "welcome";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		CustomerDetails theCustomer = new CustomerDetails();

		theModel.addAttribute("CustomerDetails", theCustomer);

		return "customer-data-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the Book from the service
		CustomerDetails theCustomer = crmService.findById(theId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("CustomerDetails", theCustomer);

		// send over to our form
		return "customer-data-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println(id);
		CustomerDetails theCustomer;
		if (id != 0) {
			theCustomer = crmService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		} else
			theCustomer = new CustomerDetails(firstName, lastName, email);
		crmService.save(theCustomer);

		return "redirect:/crmData/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		crmService.deleteById(theId);
		return "redirect:/crmData/list";

	}
}
