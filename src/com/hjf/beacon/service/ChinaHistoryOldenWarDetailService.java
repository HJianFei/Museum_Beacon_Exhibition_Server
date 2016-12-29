package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.China_History_Olden_War_Detail;

public interface ChinaHistoryOldenWarDetailService {

	<T> void save(China_History_Olden_War_Detail china_History_Olden_War_Detail);
	
	<T> void merge(China_History_Olden_War_Detail china_History_Olden_War_Detail);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
	
	public int updateViewCount(String sql);
}
