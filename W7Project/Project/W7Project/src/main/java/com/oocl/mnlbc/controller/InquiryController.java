package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Inquiry;
import com.oocl.mnlbc.service.InquiryService;

/**
 * This is a controller for Inquiry requests
 * 
 * @author BARREPE
 * @since 07/27/16
 */

@Controller
@RequestMapping(value = "/inquiry")
public class InquiryController {

	/**
	 * Automatic instantiation of inquiry Service
	 */
	@Autowired
	InquiryService inquiryService;

	/**
	 * This request is for getting all inquiries using GET request.
	 * 
	 * @return the list of all inquiries
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAllInquiries" }, method = RequestMethod.GET)
	public List<Inquiry> getAllInquiry() {
		return inquiryService.getAllInquiry();
	}

	/**
	 * This request is for getting all inquiries using id by GET request.
	 * 
	 * @param id
	 *            the id of the inquiry to be retrieved
	 * @return an object of Inquiry
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllInquiries/{id}", method = RequestMethod.GET)
	public Inquiry getInquiryById(@PathVariable("id") int id) {
		return inquiryService.getInquiryById(id);
	}

	/**
	 * This request is for adding inquiry by POST request.
	 * 
	 * @param inquiry
	 *            the inquiry to be inserted
	 * 
	 * @return a boolean result of insertion
	 */
	@ResponseBody
	@RequestMapping(value = { "/addInquiry" }, method = RequestMethod.POST)
	public boolean addInquiry(@RequestBody Inquiry inquiry) {
		return inquiryService.addInquiry(inquiry);
	}

	/**
	 * This request is for updating inquiry by POST request.
	 * 
	 * @param inquiry
	 *            the inquiry to be updated
	 * @return a boolean result of update
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateInquiry" }, method = RequestMethod.POST)
	public boolean updateInquiry(@RequestBody Inquiry inquiry) {
		return inquiryService.updateInquiry(inquiry);
	}

	/**
	 * This request is for removing inquiry by POST request.
	 * 
	 * @param inquiry
	 *            the inquiry to be removed
	 * @return a boolean result of deletion
	 */
	@ResponseBody
	@RequestMapping(value = { "/removeInquiry" }, method = RequestMethod.POST)
	public boolean removeInquiry(@RequestBody Inquiry inquiry) {
		return inquiryService.removeInquiry(inquiry);
	}

	/**
	 * This request is for removing inquiry using ID by POST request.
	 * 
	 * @param id
	 *            the id of the inquiry to be removed
	 * @return a boolean result of deletion
	 */
	@ResponseBody
	@RequestMapping(value = "/removeInquiry/{id}", method = RequestMethod.GET)
	public boolean removeInquiryById(@PathVariable("id") int id) {
		return inquiryService.removeInquiryById(id);
	}

}
