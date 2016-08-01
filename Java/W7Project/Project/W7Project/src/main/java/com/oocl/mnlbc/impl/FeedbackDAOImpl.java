package com.oocl.mnlbc.impl;

import java.util.List;

import javax.persistence.Query;

import com.oocl.mnlbc.dao.AbstractJPADAO;
import com.oocl.mnlbc.dao.FeedbackDAO;
import com.oocl.mnlbc.entity.Feedback;

public class FeedbackDAOImpl extends AbstractJPADAO<Feedback> implements FeedbackDAO {

	public FeedbackDAOImpl() {
		setClazz(Feedback.class);
	}

	@Override
	public List<Feedback> getAllFeedbackByMealId(int id) {
		Query query = entityManager.createQuery("select t from Feedback t where t.meal.id = :id");
		query.setParameter("id", id);
		List<Feedback> feedbacks = query.getResultList();
		return feedbacks;
	}

}
