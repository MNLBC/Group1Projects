package com.oocl.mnlbc.impl;

import java.util.List;

import com.oocl.mnlbc.dao.IAbstractJPADAO;
import com.oocl.mnlbc.entity.Student;

public class AbstractJPADAOImpl extends GenericDAOImpl<Student> implements IAbstractJPADAO{

	public List<Student> getAll() {
		//No code, just apply the GENERIC DAO concept :)
		return null;
	}

	public Student findByName(String name) {
		//No code, just apply the GENERIC DAO concept :)
		return null;
	}

}
