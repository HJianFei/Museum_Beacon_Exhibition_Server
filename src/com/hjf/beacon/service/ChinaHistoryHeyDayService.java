package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.China_History_Hey_Day;

public interface ChinaHistoryHeyDayService {

	<T> void save(China_History_Hey_Day china_History_Hey_Day);
	
	<T> void merge(China_History_Hey_Day china_History_Hey_Day);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
	
	public int updateViewCount(String sql);
}
