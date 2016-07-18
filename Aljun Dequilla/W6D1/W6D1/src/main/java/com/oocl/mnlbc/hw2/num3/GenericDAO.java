/**
 * 
 */
package com.oocl.mnlbc.hw2.num3;

import java.util.List;

/**
 * @author DEQUIAL
 *
 */
public interface GenericDAO<T> {

	abstract void create(T model);

	abstract List<T> getList();

	abstract void update(T model);

	abstract void delete(T model);

	abstract T getById(int id);
}
