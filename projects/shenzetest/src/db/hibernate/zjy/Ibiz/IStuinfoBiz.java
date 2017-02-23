package db.hibernate.zjy.Ibiz;


import java.util.*;

import db.hibernate.zjy.bean.Stuinfo;



public interface IStuinfoBiz {
	public boolean deleteStuinfo(Integer id);

	public boolean deleteStuinfo(Stuinfo stuinfoParam);

	public List<Stuinfo> findStuinfoByCondition(final String findStatement);

	public Stuinfo findStuinfoByPK(Integer id);

	public boolean saveStuinfo(Stuinfo stuinfoParam);

	public boolean updateStuinfo(Stuinfo stuinfoParam);

	public List<Stuinfo> getStuinfoPage(final String hql, final int pageId,
			final int pageSize);
}