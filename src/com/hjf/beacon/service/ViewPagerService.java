package com.hjf.beacon.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.ViewPager;

public interface ViewPagerService {
	/**
	 * 保存
	 * 
	 * @param object
	 */
	<T> void save(ViewPager viewPager, String filePath, String fileFileName);

	/**
	 * 更新
	 * 
	 * @param ojbect
	 */
	<T> void merge(ViewPager viewPager, File file, String fileFileName);

	/**
	 * 删除
	 * 
	 * @param object
	 */
	<T> void delete(Class<T> clazz, Object id);

	/**
	 * 获取Query对象
	 * 
	 * @param hql
	 * @return
	 */
	<T> Query getQuery(String hql);

	/**
	 * 查找对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T find(Class<T> clazz, Object id);

	/**
	 * 查找列表
	 * 
	 * @param hql
	 * @param firstIndex
	 * @param maxSize
	 * @return
	 */
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);

	// 保存附件
	String saveFile(File file, String fileName) throws IOException;

}
