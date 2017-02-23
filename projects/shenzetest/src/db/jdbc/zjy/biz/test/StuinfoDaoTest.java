package db.jdbc.zjy.biz.test;


import java.util.*;
import junit.framework.*;
import java.text.*;

import db.jdbc.zjy.bean.Stuinfo;
import db.jdbc.zjy.dao.impl.StuinfoDaoImpl;

public class StuinfoDaoTest extends TestCase {
	public void testSave() {
		Stuinfo stuinfoObject = new Stuinfo();
		stuinfoObject.setScore("test_new");
		stuinfoObject.setClasses("test_new");
		stuinfoObject.setName("test_new");
		StuinfoDaoImpl stuinfoDaoImplObject = new StuinfoDaoImpl();
		stuinfoDaoImplObject.saveStuinfo(stuinfoObject);
	}

	public void testUpdate() {
		StuinfoDaoImpl stuinfoDaoImplObject = new StuinfoDaoImpl();
		Integer id = 10;
		Stuinfo stuinfoObject = stuinfoDaoImplObject.findStuinfoByPK(id);
		stuinfoObject.setScore("test_new");
		stuinfoObject.setClasses("test_new");
		stuinfoObject.setName("test_new");
		stuinfoDaoImplObject.updateStuinfo(stuinfoObject);
		stuinfoObject = stuinfoDaoImplObject.findStuinfoByPK(id);
		assertEquals("test_new", stuinfoObject.getScore());
		assertEquals("test_new", stuinfoObject.getClasses());
		assertEquals("test_new", stuinfoObject.getName());
	}

	public void testFindById() {
		StuinfoDaoImpl stuinfoDaoImplObject = new StuinfoDaoImpl();
		Integer id = 10;
		Stuinfo stuinfoObject = stuinfoDaoImplObject.findStuinfoByPK(id);
		;
		assertEquals("test_new", stuinfoObject.getScore());
		assertEquals("test_new", stuinfoObject.getClasses());
		assertEquals("test_new", stuinfoObject.getName());
	}

	public void testDelete() {
		StuinfoDaoImpl stuinfoDaoImplObject = new StuinfoDaoImpl();
		Integer id = 10;
		stuinfoDaoImplObject.deleteStuinfo(id);
		Stuinfo stuinfoObject = stuinfoDaoImplObject.findStuinfoByPK(id);
		assertNull(stuinfoObject);
	}

	public Date getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(format.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}