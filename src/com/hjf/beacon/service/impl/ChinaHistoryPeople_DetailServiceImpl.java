package com.hjf.beacon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.hjf.beacon.dao.Dao;
import com.hjf.beacon.entity.China_History_People_Detail;
import com.hjf.beacon.service.ChinaHistoryPeopleDetailService;

@Service("ChinaHistoryPeopleDetailService")
public class ChinaHistoryPeople_DetailServiceImpl implements ChinaHistoryPeopleDetailService {

	@Resource(name = "Dao")
	private Dao dao;

	@Override
	public <T> void save(China_History_People_Detail china_History_People_Detail) {
		// TODO Auto-generated method stub
		dao.save(china_History_People_Detail);

	}

	@Override
	public <T> void merge(China_History_People_Detail china_History_People_Detail) {
		// TODO Auto-generated method stub
		dao.merge(china_History_People_Detail);

	}

	@Override
	public <T> void delete(Class<T> clazz, Object id) {
		// TODO Auto-generated method stub
		Object obj = dao.find(clazz, id);
		dao.delete(obj);
	}

	@Override
	public <T> Query getQuery(String hql) {
		// TODO Auto-generated method stub
		return (Query) dao.getQuery(hql);
	}

	@Override
	public <T> T find(Class<T> clazz, Object id) {
		// TODO Auto-generated method stub
		return (T) dao.find(clazz, id);
	}

	@Override
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize) {
		// TODO Auto-generated method stub
		return dao.getResult(hql, firstIndex, maxSize);
	}

}