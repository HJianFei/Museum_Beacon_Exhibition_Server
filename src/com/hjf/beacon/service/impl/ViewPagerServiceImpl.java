package com.hjf.beacon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.hjf.beacon.dao.Dao;
import com.hjf.beacon.entity.ViewPager;
import com.hjf.beacon.service.ViewPagerService;

@Service("ViewPagerService")
public class ViewPagerServiceImpl implements ViewPagerService {

	@Resource(name = "Dao")
	private Dao dao;

	/**
	 * ����
	 * 
	 * @param beacon
	 */
	@Override
	public <T> void save(ViewPager viewPager) {

		dao.save(viewPager);
	}

	/**
	 * ����
	 * 
	 * @param beacon
	 */
	public void merge(ViewPager viewPager) {
		dao.merge(viewPager);
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

}
