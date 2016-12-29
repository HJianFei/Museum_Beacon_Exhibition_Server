package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.Appreciate;

public interface AppreciateService {

	<T> void save(Appreciate appreciate);
	
	<T> void merge(Appreciate appreciate);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
	
	public int updateViewCount(String sql);
}
