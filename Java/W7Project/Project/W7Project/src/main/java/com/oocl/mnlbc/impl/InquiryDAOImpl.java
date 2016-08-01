package com.oocl.mnlbc.impl;

import com.oocl.mnlbc.dao.AbstractJPADAO;
import com.oocl.mnlbc.dao.InquiryDAO;
import com.oocl.mnlbc.entity.Inquiry;

public class InquiryDAOImpl extends AbstractJPADAO<Inquiry> implements InquiryDAO {
	public InquiryDAOImpl() {
		setClazz(Inquiry.class);
	}
}
