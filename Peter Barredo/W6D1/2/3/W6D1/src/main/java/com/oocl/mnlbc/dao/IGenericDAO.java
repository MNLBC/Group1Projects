package com.oocl.mnlbc.dao;

import java.util.List;

public interface IGenericDAO<ModelT> {

	public abstract List<ModelT> getAll();
	
}
