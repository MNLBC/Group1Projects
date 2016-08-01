package com.oocl.mnlbc.dao;

import com.oocl.mnlbc.entity.Student;

public interface IAbstractJPADAO extends IGenericDAO<Student> {
	Student findByName(String name);
}
