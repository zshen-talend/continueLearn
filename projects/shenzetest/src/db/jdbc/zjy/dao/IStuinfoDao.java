package db.jdbc.zjy.dao;

import java.util.*;

import db.jdbc.zjy.bean.Stuinfo;

public interface IStuinfoDao {
	public Stuinfo findStuinfoByPK(Integer id);

	public boolean updateStuinfo(Stuinfo stuinfoParam);

	public boolean deleteStuinfo(Integer id);

	public boolean saveStuinfo(Stuinfo stuinfoParam);

	public List<Stuinfo> findStuinfoByCondition(final String findStatement);

	public boolean deleteStuinfo(Stuinfo stuinfoParam);

	public List<Stuinfo> getStuinfoPage(final String selectStatement,
			final int pageId, final int pageSize);
}