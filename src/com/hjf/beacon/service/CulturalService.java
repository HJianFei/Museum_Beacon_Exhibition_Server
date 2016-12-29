package com.hjf.beacon.service;

import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.Cultural;

public interface CulturalService {
	/**
	 * ����
	 * 
	 * @param cultural
	 */
	<T> void save(Cultural cultural);

	/**
	 * ����
	 * 
	 * @param cultural
	 */
	<T> void merge(Cultural cultural);

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
