package com.oocl.mnlbc.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable> {

	T find(final int id);

	List<T> getAll();

	void add(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final int entityId);
}
