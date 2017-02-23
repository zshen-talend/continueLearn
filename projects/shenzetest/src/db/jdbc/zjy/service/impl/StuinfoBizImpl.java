package db.jdbc.zjy.service.impl;




import db.jdbc.zjy.Ibiz.IStuinfoBiz;
import db.jdbc.zjy.bean.Stuinfo;
import db.jdbc.zjy.dao.IStuinfoDao;
import db.jdbc.zjy.dao.impl.StuinfoDaoImpl;


import java.util.*;

public class StuinfoBizImpl implements IStuinfoBiz {
	private IStuinfoDao stuinfoDaoImplAttribute=new StuinfoDaoImpl();

	public IStuinfoDao getStuinfoDaoImplAttribute() {
		return this.stuinfoDaoImplAttribute;
	}

	public void setStuinfoDaoImplAttribute(IStuinfoDao stuinfoDaoImplAttribute) {
		this.stuinfoDaoImplAttribute = stuinfoDaoImplAttribute;
	}

	public boolean deleteStuinfo(Integer id) {
		return stuinfoDaoImplAttribute.deleteStuinfo(id);
	}

	public boolean deleteStuinfo(Stuinfo stuinfoParam) {
		return stuinfoDaoImplAttribute.deleteStuinfo(stuinfoParam);
	}

	public List<Stuinfo> findStuinfoByCondition(final String findStatement) {
		return stuinfoDaoImplAttribute.findStuinfoByCondition(findStatement);
	}

	public Stuinfo findStuinfoByPK(Integer id) {
		return stuinfoDaoImplAttribute.findStuinfoByPK(id);
	}

	public boolean saveStuinfo(Stuinfo stuinfoParam) {
		return stuinfoDaoImplAttribute.saveStuinfo(stuinfoParam);
	}

	public boolean updateStuinfo(Stuinfo stuinfoParam) {
		return stuinfoDaoImplAttribute.updateStuinfo(stuinfoParam);
	}

	public List<Stuinfo> getStuinfoPage(final String selectStatement,
			final int pageId, final int pageSize) {
		return stuinfoDaoImplAttribute.getStuinfoPage(selectStatement, pageId,
				pageSize);
	}
}