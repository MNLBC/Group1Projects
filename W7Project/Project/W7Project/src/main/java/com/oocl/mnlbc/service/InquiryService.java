/**
 * 
 */
package com.oocl.mnlbc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oocl.mnlbc.controller.InquiryController;
import com.oocl.mnlbc.dao.InquiryDAO;
import com.oocl.mnlbc.entity.Inquiry;

/**
 * @author DEQUIAL
 *
 */
@Service
public class InquiryService {
	@Autowired
	InquiryDAO inquiryDAO;

	private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);

	public List<Inquiry> getAllFeedbacks() {
		logger.info("Getting all list of inquiry");
		return inquiryDAO.getAll();
	}

	public Inquiry getInquiryById(int id) {
		logger.info("Getting inquiry by id");
		return inquiryDAO.find(id);
	}

	public boolean addInquiry(Inquiry inquiry) {
		logger.info("Adding inquiry");
		inquiryDAO.add(inquiry);
		return true;
	}

	public boolean updateInquiry(Inquiry inquiry) {
		logger.info("Updating inquiry");
		inquiryDAO.update(inquiry);
		return true;
	}

	public boolean removeInquiry(Inquiry inquiry) {
		logger.info("deleting inquiry");
		inquiryDAO.delete(inquiry);
		return true;
	}

	public boolean removeInquiryById(int id) {
		logger.info("deleting inquiry by id");
		inquiryDAO.deleteById(id);
		return false;
	}
}
