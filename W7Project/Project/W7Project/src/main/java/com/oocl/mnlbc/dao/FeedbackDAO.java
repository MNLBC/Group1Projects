package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.Feedback;

public interface FeedbackDAO extends GenericDAO<Feedback> {
	List<Feedback> getAllFeedbackByMealId(int id);
}
