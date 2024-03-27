package com.gcu.data;

import java.util.List;

/**
 * Interface for all data service classes to use
 */
public interface DataAccessInterface<T> {
	public List<T> findAll();
	public T findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(int id);
}
