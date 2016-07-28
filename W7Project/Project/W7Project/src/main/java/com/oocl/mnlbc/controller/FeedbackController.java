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
import com.oocl.mnlbc.service.FeedbackService;

/**
 * This is a controller for Feedback requests
 * @author BARREPE
 * 
 */

@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController {
	
	/**
	 * Automatic instantiation of Feedback Service
	 */
	@Autowired
	FeedbackService feedbackService;
	
	
	/**
	 * This request is for getting all the feedbacks.
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAllFeedbacks" }, method = RequestMethod.GET)
	public List<Feedback> getAllFeedbacks() {
		return feedbackService.getAllFeedbacks();
	}
	
	/**
	 * This request is for getting the feedbacks using the id.
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getFeedbackById/{id}", method = RequestMethod.GET)
	public Feedback getFeedbackById(@PathVariable("id") int id) {
		return feedbackService.getFeedbackById(id);
	}
	
	/**
	 * This request is for adding feedback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/addFeedback" }, method = RequestMethod.POST)
	public boolean addFeedback(@RequestBody Feedback feedback) {
		return feedbackService.addFeedback(feedback);
	}
	
	/**
	 * This request is for updating feedback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateFeedback" }, method = RequestMethod.POST)
	public boolean updateFeedback(@RequestBody Feedback feedback) {
		return feedbackService.updateFeedback(feedback);
	}
	
	
	/**
	 * This request is for removing feedback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/removeFeedback" }, method = RequestMethod.POST)
	public boolean removeFeedback(@RequestBody Feedback feedback) {
		return feedbackService.removeFeedback(feedback);
	}
	
	/**
	 * This request is for removing feedback using Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/removeFeedback/{id}", method = RequestMethod.GET)
	public boolean removeFeedbackById(@PathVariable("id") int id) {
		return feedbackService.removeFeedbackById(id);
	}
}
