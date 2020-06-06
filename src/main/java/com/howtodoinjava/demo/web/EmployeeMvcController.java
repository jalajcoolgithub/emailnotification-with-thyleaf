package com.howtodoinjava.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeMvcController {
	@Autowired
	EmployeeService service;

	@RequestMapping
	public String getAllEmployees(Model model) {
		model.addAttribute("employee", new EmployeeEntity());
		return "add-edit-employee";

	}

	@RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee(EmployeeEntity employee) {
		service.sendEmail(employee);
	
		//return "redirect:/";
		return "succuessfull.html";
	}
}
