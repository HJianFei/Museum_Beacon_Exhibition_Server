package com.hjf.beacon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.hjf.beacon.dao.Dao;
import com.hjf.beacon.entity.Beacon;
import com.hjf.beacon.service.BeaconService;

@Service("BeaconService")
public class BeaconServiceImpl implements BeaconService {

	@Resource(name = "Dao")
	private Dao dao;

	/**
	 * ����
	 * 
	 * @param beacon
	 */
	@Override
	public <T> void save(Beacon beacon) {

		dao.save(beacon);
	}

	/**
	 * ����
	 * 
	 * @param beacon
	 */
	public void merge(Beacon beacon) {
		dao.merge(beacon);
	}

	/**
	 * ɾ��
	 * 
	 * @param beacon
	 */
	public <T> void delete(Class<T> clazz, Object id) {
		Object obj = dao.find(clazz, id);
		dao.delete(obj);
	}

	/**
	 * ��ȡQuery����
	 * 
	 * @param hql
	 * @return
	 */
	public <T> Query getQuery(String hql) {
		return (Query) dao.getQuery(hql);
	}

	/**
	 * ���Ҷ���
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T find(Class<T> clazz, Object id) {
		return (T) dao.find(clazz, id);
	}

	/**
	 * �����б�
	 * 
	 * @param hql
	 * @param firstIndex
	 * @param maxSize
	 * @return
	 */
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize) {
		return dao.getResult(hql, firstIndex, maxSize);
	}

	@Override
	public <T> void save(List<Beacon> beacon) {
		// TODO Auto-generated method stub
		dao.save(beacon);
		
	}

}
