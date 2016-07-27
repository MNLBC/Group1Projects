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

import com.oocl.mnlbc.dao.FeedbackDAO;
import com.oocl.mnlbc.entity.Feedback;

@Controller
@RequestMapping(value ="/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackDAO feedbackDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
	@ResponseBody
	@RequestMapping(value = { "/getAllFeedbacks" }, method = RequestMethod.GET)
	public List<Feedback> getAllFeedbacks() {
		List<Feedback> feedbacks = feedbackDAO.getAll();
		return feedbacks;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getFeedbackById/{id}", method = RequestMethod.GET)
	public Feedback getFeedbackById(@PathVariable("id") int id) {
		return feedbackDAO.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/addFeedback" }, method = RequestMethod.POST)
	public boolean addFeedback(@RequestBody Feedback feedback) {
		feedbackDAO.add(feedback);
		return true;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/updateFeedback" }, method = RequestMethod.POST)
	public boolean updateFeedback(@RequestBody Feedback feedback) {
		feedbackDAO.update(feedback);
		return true;
	}
}
