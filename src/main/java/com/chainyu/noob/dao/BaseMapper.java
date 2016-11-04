package com.chainyu.noob.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T,PK extends Serializable> {

	T findById(PK id);
	
	List<T> findAll();
	
	int save(T model);
	
	int updateByIdSelective(T model);
	
	void deleteById(PK id);
	
	void deleteAll();
	
}
