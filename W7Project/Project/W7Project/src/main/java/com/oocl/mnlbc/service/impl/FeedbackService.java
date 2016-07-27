/**
 * 
 */
package com.oocl.mnlbc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.controller.FeedbackController;
import com.oocl.mnlbc.dao.FeedbackDAO;
import com.oocl.mnlbc.entity.Feedback;

/**
 * @author DEQUIAL
 *
 */
@Service
public class FeedbackService {
	@Autowired
	FeedbackDAO feedbackDAO;

	private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

	public List<Feedback> getAllFeedbacks() {
		logger.info("Getting all feedbacks");
		List<Feedback> feedbacks = feedbackDAO.getAll();
		return feedbacks;
	}

	public Feedback getFeedbackById(int id) {
		logger.info("Getting feedback by id");
		return feedbackDAO.find(id);
	}

	public boolean addFeedback(Feedback feedback) {
		logger.info("Adding feedback");
		feedbackDAO.add(feedback);
		return true;
	}

	public boolean updateFeedback(Feedback feedback) {
		logger.info("Updating feedback");
		feedbackDAO.update(feedback);
		return true;
	}

	public boolean removeFeedback(Feedback feedback) {
		feedbackDAO.delete(feedback);
		return true;
	}
}
