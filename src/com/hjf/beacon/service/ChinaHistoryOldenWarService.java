package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.China_History_Olden_War;

public interface ChinaHistoryOldenWarService {

	<T> void save(China_History_Olden_War china_History_Olden_War);
	
	<T> void merge(China_History_Olden_War china_History_Olden_War);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
	
	public int updateViewCount(String sql);
}
