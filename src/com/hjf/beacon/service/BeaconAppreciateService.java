package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.BeaconAppreciate;

public interface BeaconAppreciateService {

	<T> void save(BeaconAppreciate beaconAppreciate);
	
	<T> void merge(BeaconAppreciate beaconAppreciate);
	
	<T> void delete(Class<T> clazz, Object id);
	
	<T> Query getQuery(String hql);
	
	<T> T find(Class<T> clazz, Object id);
	
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);
}
