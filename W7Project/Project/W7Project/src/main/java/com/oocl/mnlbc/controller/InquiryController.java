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
import com.oocl.mnlbc.service.impl.InquiryService;

/**
 * @author BARREPE
 *
 */

@Controller
@RequestMapping(value = "/inquiry")
public class InquiryController {

	@Autowired
	InquiryService inquiryService;

	@ResponseBody
	@RequestMapping(value = { "/getAllInquiries" }, method = RequestMethod.GET)
	public List<Inquiry> getAllFeedbacks() {
		return inquiryService.getAllFeedbacks();
	}

	@ResponseBody
	@RequestMapping(value = "/getAllInquiries/{id}", method = RequestMethod.GET)
	public Inquiry getInquiryById(@PathVariable("id") int id) {
		return inquiryService.getInquiryById(id);
	}

	@ResponseBody
	@RequestMapping(value = { "/addInquiry" }, method = RequestMethod.POST)
	public boolean addInquiry(@RequestBody Inquiry inquiry) {
		return inquiryService.addInquiry(inquiry);
	}

	@ResponseBody
	@RequestMapping(value = { "/updateInquiry" }, method = RequestMethod.POST)
	public boolean updateFeedback(@RequestBody Inquiry inquiry) {
		return inquiryService.updateInquiry(inquiry);
	}

}
