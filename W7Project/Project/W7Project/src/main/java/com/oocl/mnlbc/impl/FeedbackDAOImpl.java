package com.oocl.mnlbc.impl;

import com.oocl.mnlbc.dao.AbstractJPADAO;
import com.oocl.mnlbc.dao.FeedbackDAO;
import com.oocl.mnlbc.entity.Feedback;

public class FeedbackDAOImpl extends AbstractJPADAO<Feedback> implements FeedbackDAO{
	
	public FeedbackDAOImpl(){
		setClazz(Feedback.class );
	}
	
}
