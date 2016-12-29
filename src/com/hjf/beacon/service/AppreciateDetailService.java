package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.AppreciateDetail;

public interface AppreciateDetailService {

	<T> void save(AppreciateDetail appreciateDetail);
	
	<T> void merge(AppreciateDetail appreciateDetail);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
}
