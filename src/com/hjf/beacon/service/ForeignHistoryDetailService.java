package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.Foreign_History_Detail;

public interface ForeignHistoryDetailService {

	<T> void save(Foreign_History_Detail foreign_History_Detail);
	
	<T> void merge(Foreign_History_Detail foreign_History_Detail);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
	
	public int updateViewCount(String sql);
}
