package db.jdbc.zjy.test;


import java.util.*;
import junit.framework.*;
import java.text.*;

import db.jdbc.zjy.Ibiz.BizFacade;
import db.jdbc.zjy.Ibiz.IStuinfoBiz;
import db.jdbc.zjy.bean.Stuinfo;


public class StuinfoServiceTest extends TestCase {
	private BizFacade facadeAtt;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		facadeAtt = BizFacade.forInstance();
	}

	public void testSave() {
		Stuinfo stuinfoObject = new Stuinfo();
		stuinfoObject.setScore("test_new");
		stuinfoObject.setClasses("test_new");
		stuinfoObject.setName("test_new");
		IStuinfoBiz stuinfoBizImplObject = facadeAtt.forStuinfoBizImpl();
		stuinfoBizImplObject.saveStuinfo(stuinfoObject);
	}

	public void testUpdate() {
		Integer id = 10;
		IStuinfoBiz stuinfoBizImplObject = facadeAtt.forStuinfoBizImpl();
		Stuinfo stuinfoObject = stuinfoBizImplObject.findStuinfoByPK(id);
		stuinfoObject.setScore("test_new");
		stuinfoObject.setClasses("test_new");
		stuinfoObject.setName("test_new");
		stuinfoBizImplObject.updateStuinfo(stuinfoObject);
		stuinfoObject = stuinfoBizImplObject.findStuinfoByPK(id);
		assertEquals("test_new", stuinfoObject.getScore());
		assertEquals("test_new", stuinfoObject.getClasses());
		assertEquals("test_new", stuinfoObject.getName());
	}

	public void testFindById() {
		Integer id = 10;
		IStuinfoBiz stuinfoBizImplObject = facadeAtt.forStuinfoBizImpl();
		Stuinfo stuinfoObject = stuinfoBizImplObject.findStuinfoByPK(id);
		assertEquals("test_new", stuinfoObject.getScore());
		assertEquals("test_new", stuinfoObject.getClasses());
		assertEquals("test_new", stuinfoObject.getName());
	}

	public void testDelete() {
		IStuinfoBiz stuinfoBizImplObject = facadeAtt.forStuinfoBizImpl();
		Integer id = 10;
		Stuinfo stuinfoObject = stuinfoBizImplObject.findStuinfoByPK(id);
		stuinfoBizImplObject.deleteStuinfo(stuinfoObject);
		stuinfoObject = stuinfoBizImplObject.findStuinfoByPK(id);
		assertNull(stuinfoObject);
	}
}