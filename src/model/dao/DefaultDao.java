package model.dao;

import java.util.List;

public interface DefaultDao<T> {
	public List<T> findAll();
	public void    deleteByObject(T st);
	public void    insert(List<T> st);
	public void    update(List<T> st);
	public T       findByCode(Long code); 
}
