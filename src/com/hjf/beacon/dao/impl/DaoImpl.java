package com.hjf.beacon.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hjf.beacon.dao.Dao;

@Repository("Dao")
public class DaoImpl implements Dao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionfactory;

	/**
	 * ����
	 * 
	 * @param object
	 *            �������
	 */
	@Override
	public <T> void save(Object object) {
		this.sessionfactory.getCurrentSession().save(object);
		this.sessionfactory.getCurrentSession().flush();
	}

	/**
	 * ɾ��
	 * 
	 * @param object
	 *            ɾ���Ķ���
	 */
	@Override
	public <T> void delete(Object object) {

		this.sessionfactory.getCurrentSession().delete(object);
		this.sessionfactory.getCurrentSession().flush();
	}

	/**
	 * ����
	 */
	@Override
	public <T> void merge(Object ojbect) {
		this.sessionfactory.getCurrentSession().merge(ojbect);
		this.sessionfactory.getCurrentSession().flush();
	}

	/**
	 * ��ѯ��䣬��ȡQuery����
	 * 
	 * @param hql
	 *            hql����
	 * 
	 */
	@Override
	public <T> Query getQuery(String hql) {

		return (Query) this.sessionfactory.getCurrentSession().createQuery(hql);
	}

	/**
	 * ����Id���Ҷ���
	 * 
	 * @param id
	 *            �����
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T find(Class<T> clazz, Object id) {

		if ("Integer".equals(id.getClass().getSimpleName()))
			return (T) this.sessionfactory.getCurrentSession().get(clazz, Integer.valueOf(id.toString()));
		return (T) this.sessionfactory.getCurrentSession().get(clazz, id.toString());
	}

	/**
	 * ����hql��ѯ����firstIndex�޶���ѯ����Ŀ�ͷ��maxSize�޶�����ĳ���
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize) {
		Query query = getQuery(hql);
		if (firstIndex == 0 && maxSize == 0)
			return query.list();
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxSize);
		return query.list();
	}

	/**
	 * 使用sql,更新数据
	 * */
	@Override
	public int executeSql(String sql) {
		Query query = this.sessionfactory.getCurrentSession().createSQLQuery(sql);
		return query.executeUpdate();
	}

}
