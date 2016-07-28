package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Feedback;
import com.oocl.mnlbc.entity.Inquiry;
import com.oocl.mnlbc.service.impl.InquiryService;

/**
 * @author BARREPE
 *
 */

@Controller
@RequestMapping(value = "/inquiry")
public class InquiryController {
	
	/**
	 * Automatic instantiation of inqury Service
	 */
	@Autowired
	InquiryService inquiryService;
	
	/**
	 * This request is for getting all inquiries using GET request.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAllInquiries" }, method = RequestMethod.GET)
	public List<Inquiry> getAllFeedbacks() {
		return inquiryService.getAllFeedbacks();
	}
	
	/**
	 * This request is for getting all inquiries using id by GET request.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllInquiries/{id}", method = RequestMethod.GET)
	public Inquiry getInquiryById(@PathVariable("id") int id) {
		return inquiryService.getInquiryById(id);
	}
	
	/**
	 * This request is for adding inquiry by POST request.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = { "/addInquiry" }, method = RequestMethod.POST)
	public boolean addInquiry(@RequestBody Inquiry inquiry) {
		return inquiryService.addInquiry(inquiry);
	}
	
	/**
	 * This request is for updating inquiry by POST request.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateInquiry" }, method = RequestMethod.POST)
	public boolean updateFeedback(@RequestBody Inquiry inquiry) {
		return inquiryService.updateInquiry(inquiry);
	}
	
	/**
	 * This request is for removing inquiry by POST request.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = { "/removeInquiry" }, method = RequestMethod.POST)
	public boolean removeFeedback(@RequestBody Inquiry inquiry) {
		return inquiryService.removeInquiry(inquiry);
	}
	
	/**
	 * This request is for removing inquiry using ID by POST request.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/removeInquiry/{id}", method = RequestMethod.GET)
	public boolean removeFeedbackById(@PathVariable("id") int id) {
		return inquiryService.removeInquiryById(id);
	}

}
