package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.China_History_Culture;

public interface ChinaHistoryCultureService {

	<T> void save(China_History_Culture china_History_Culture);
	
	<T> void merge(China_History_Culture china_History_Culture);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
}
