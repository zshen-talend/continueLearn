package db.hibernate.zjy.dao.impl;


import java.util.List;
import org.hibernate.*;
import java.sql.SQLException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import db.jdbc.zjy.bean.Stuinfo;
import db.jdbc.zjy.dao.IStuinfoDao;

public class StuinfoDaoImpl extends HibernateDaoSupport implements IStuinfoDao {
	public List<Stuinfo> findStuinfoByCondition(final String findStatement) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(findStatement);
				return (List<Stuinfo>) query.list();
			}
		});
	}

	public boolean saveStuinfo(Stuinfo stuinfoParam) {
		this.getHibernateTemplate().save(stuinfoParam);
		this.getHibernateTemplate().flush();
		return true;
	}

	public Stuinfo findStuinfoByPK(Integer id) {
		return (Stuinfo) this.getHibernateTemplate().get(Stuinfo.class, id);
	}

	public boolean updateStuinfo(Stuinfo stuinfoParam) {
		this.getHibernateTemplate().saveOrUpdate(stuinfoParam);
		this.getHibernateTemplate().flush();
		return true;
	}

	public boolean deleteStuinfo(Integer id) {
		Stuinfo stuinfoParam = this.findStuinfoByPK(id);
		this.deleteStuinfo(stuinfoParam);
		return true;
	}

	public boolean deleteStuinfo(Stuinfo stuinfoParam) {
		if (stuinfoParam != null) {
			this.getHibernateTemplate().delete(stuinfoParam);
			this.getHibernateTemplate().flush();
			return true;
		}
		return false;
	}

	public List<Stuinfo> getStuinfoPage(final String selectStatement,
			final int pageId, final int pageSize) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(selectStatement);
				int start = (pageId - 1) * pageSize;
				query.setFirstResult(start);
				query.setMaxResults(pageSize);
				List<Stuinfo> list = query.list();
				return list;
			}
		});
	}
}