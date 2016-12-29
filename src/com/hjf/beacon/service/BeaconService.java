package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.Beacon;

public interface BeaconService {
	/**
	 * ����
	 * 
	 * @param object
	 */
	<T> void save(Beacon beacon);
	
	<T> void save(List<Beacon> beacon);

	/**
	 * ����
	 * 
	 * @param ojbect
	 */
	<T> void merge(Beacon beacon);

	/**
	 * ɾ��
	 * 
	 * @param object
	 */
	<T> void delete(Class<T> clazz, Object id);

	/**
	 * ��ȡQuery����
	 * 
	 * @param hql
	 * @return
	 */
	<T> Query getQuery(String hql);

	/**
	 * ���Ҷ���
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T find(Class<T> clazz, Object id);

	/**
	 * �����б�
	 * 
	 * @param hql
	 * @param firstIndex
	 * @param maxSize
	 * @return
	 */
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);

}
