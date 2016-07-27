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
import com.oocl.mnlbc.service.impl.FeedbackService;

/**
 * @author BARREPE
 *
 */

@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

	@ResponseBody
	@RequestMapping(value = { "/getAllFeedbacks" }, method = RequestMethod.GET)
	public List<Feedback> getAllFeedbacks() {
		return feedbackService.getAllFeedbacks();
	}

	@ResponseBody
	@RequestMapping(value = "/getFeedbackById/{id}", method = RequestMethod.GET)
	public Feedback getFeedbackById(@PathVariable("id") int id) {
		return feedbackService.getFeedbackById(id);
	}

	@ResponseBody
	@RequestMapping(value = { "/addFeedback" }, method = RequestMethod.POST)
	public boolean addFeedback(@RequestBody Feedback feedback) {
		return feedbackService.addFeedback(feedback);
	}

	@ResponseBody
	@RequestMapping(value = { "/updateFeedback" }, method = RequestMethod.POST)
	public boolean updateFeedback(@RequestBody Feedback feedback) {
		return feedbackService.updateFeedback(feedback);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/removeFeedback" }, method = RequestMethod.POST)
	public boolean removeFeedback(@RequestBody Feedback feedback) {
		return feedbackService.removeFeedback(feedback);
	}
}
