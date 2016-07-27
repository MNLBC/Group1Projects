package com.oocl.mnlbc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.InquiryDAO;
import com.oocl.mnlbc.entity.Inquiry;

@Controller
@RequestMapping(value ="/inquiry")
public class InquiryController {
	
	@Autowired
	InquiryDAO inquiryDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);
	
	@ResponseBody
	@RequestMapping(value = { "/getAllInquiries" }, method = RequestMethod.GET)
	public List<Inquiry> getAllFeedbacks() {
		return inquiryDAO.getAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllInquiries/{id}", method = RequestMethod.GET)
	public Inquiry getInquiryById(@PathVariable("id") int id) {
		return inquiryDAO.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/addInquiry" }, method = RequestMethod.POST)
	public boolean addInquiry(@RequestBody Inquiry inquiry) {
		inquiryDAO.add(inquiry);
		return true;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/updateInquiry" }, method = RequestMethod.POST)
	public boolean updateFeedback(@RequestBody Inquiry inquiry) {
		inquiryDAO.update(inquiry);
		return true;
	}
	
}
