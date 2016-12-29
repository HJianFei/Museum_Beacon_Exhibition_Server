package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.ChinaDynasty;

public interface ChinaDynastyService {

	<T> void save(ChinaDynasty chinaDynasty);
	
	<T> void merge(ChinaDynasty chinaDynasty);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
}
