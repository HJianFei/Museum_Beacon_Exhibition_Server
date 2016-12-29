package com.hjf.beacon.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.Query;

import com.hjf.beacon.entity.User;

public interface UserService {

	<T> void save(User user, File file, String filePath, String fileFileName);

	<T> void merge(User user, File file, String fileFileName);

	<T> void delete(Class<T> clazz, Object id);

	<T> Query getQuery(String hql);

	<T> T find(Class<T> clazz, Object id);

	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);

	// 保存附件
	String saveFile(File file, String fileName, User user) throws IOException;
}
