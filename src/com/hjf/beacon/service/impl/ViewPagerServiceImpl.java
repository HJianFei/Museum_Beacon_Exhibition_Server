package com.hjf.beacon.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.hjf.beacon.dao.Dao;
import com.hjf.beacon.entity.ViewPager;
import com.hjf.beacon.service.ViewPagerService;
import com.hjf.beacon.utils.StringUtil;

@Service("ViewPagerService")
public class ViewPagerServiceImpl implements ViewPagerService {

	@Resource(name = "Dao")
	private Dao dao;


	@Override
	public <T> void save(ViewPager viewPager, String filePath, String fileFileName) {

		if (filePath == null && "".equals(filePath)) {
			viewPager.setImg_url(viewPager.getImg_url());
			viewPager.setImg_name(viewPager.getImg_name());
		} else {
			viewPager.setImg_url(filePath);
			viewPager.setImg_name(fileFileName);
		}
		dao.save(viewPager);
	}


	public void merge(ViewPager viewPager, File file, String fileFileName) {

		ViewPager a = find(ViewPager.class, viewPager.getId());
		if (StringUtil.isNotEmpty(fileFileName)) { // 保存附件
			String myfilePath = "";
			if (!fileFileName.equals(a.getImg_name())) {
				try {
					myfilePath = saveFile(file, fileFileName);
					viewPager.setImg_url(myfilePath);
					viewPager.setImg_name(fileFileName);
				} catch (IOException e) {

					e.printStackTrace();
				}
			} else {
				viewPager.setImg_url(a.getImg_url());
				viewPager.setImg_name(a.getImg_name());
			}
		}
		dao.merge(viewPager);
	}

	public <T> void delete(Class<T> clazz, Object id) {
		Object obj = dao.find(clazz, id);
		dao.delete(obj);
	}

	public <T> Query getQuery(String hql) {
		return (Query) dao.getQuery(hql);
	}

	public <T> T find(Class<T> clazz, Object id) {
		return (T) dao.find(clazz, id);
	}

	public <T> List<T> getResult(String hql, int firstIndex, int maxSize) {
		return dao.getResult(hql, firstIndex, maxSize);

	}

	@Override
	public String saveFile(File file, String fileName) throws IOException {

		// 设置文件路径
		String savePath = ServletActionContext.getServletContext().getRealPath("/pictures");
		String filePath = "pictures";
		String name = fileName.substring(fileName.indexOf("."), fileName.length());
		// 路径设置
		String uuidName = System.currentTimeMillis() + name;
		File f = new File(savePath);
		if (!f.exists())
			f.mkdirs();

		// 文件存放
		InputStream in = new FileInputStream(file);
		OutputStream out = new FileOutputStream(new File(savePath, uuidName));
		byte buf[] = new byte[1024];
		int length = 0;
		while ((length = in.read(buf)) > 0) {
			out.write(buf, 0, length);

		}
		in.close();
		out.close();

		// 文件存放路径
		filePath += "/" + uuidName;
		return filePath;
	}

}
