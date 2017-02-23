package db.jdbc.zjy.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import db.jdbc.zjy.bean.Stuinfo;
import db.jdbc.zjy.dao.IStuinfoDao;
import db.jdbc.zjy.util.ControlDB;
import db.jdbc.zjy.util.DBUtil;



public class StuinfoDaoImpl implements IStuinfoDao {
	public boolean deleteStuinfo(Integer id) {
		String sql = "delete from Stuinfo where id=" + id;
		ControlDB dbUtil = new ControlDB();
		dbUtil.executeUpdate(sql);
		return true;
	}

	public boolean saveStuinfo(Stuinfo stuinfoAttribute) {
//		String getIdSql="select stuinfoid_seq.nextval as id from dual";
//		ResultSet set=DBUtil.executeQuery(getIdSql);
//		int id=0;
//		try {
//			while(set.next()){
//				id=set.getInt("id");
//			}
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
		String sql = "insert into Stuinfo(score,classes,name)values(" + "'"
//		String sql = "insert into Stuinfo(score,classes,name,id)values(" + "'"
				+ stuinfoAttribute.getScore() + "'" + "," + "'"
				+ stuinfoAttribute.getClasses() + "'" + "," + "'"
				+ stuinfoAttribute.getName() + "'" +")";
//		+ stuinfoAttribute.getName() + "'" + ","+id+")";
		ControlDB dbUtil = new ControlDB();
		dbUtil.executeUpdate(sql);
		return true;
	}

	public Stuinfo findStuinfoByPK(Integer id) {
		ControlDB controlDB = new ControlDB();
		String sql = "select * from Stuinfo where id=" + id;
		List list = controlDB.executeQueryStuinfo(sql);
		if (list.size() == 0)
			return null;
		return (Stuinfo) list.get(0);
	}

	public boolean updateStuinfo(Stuinfo stuinfoParam) {
		String sql = "update Stuinfo set " + "score=" + "'"
				+ stuinfoParam.getScore() + "'" + "," + "classes=" + "'"
				+ stuinfoParam.getClasses() + "'" + "," + "name=" + "'"
				+ stuinfoParam.getName() + "'" + " where id="
				+ stuinfoParam.getId();
		ControlDB dbUtil = new ControlDB();
		dbUtil.executeUpdate(sql);
		return true;
	}

	public boolean deleteStuinfo(Stuinfo stuinfoParam) {
		return false;
	}

	public List<Stuinfo> findStuinfoByCondition(final String findStatement) {
		ControlDB dbUtil = new ControlDB();
		List list = dbUtil.executeQueryStuinfo(findStatement);
		System.out.println(list.size());
		return list;
	}

	public List<Stuinfo> getStuinfoPage(final String selectParam,
			final int pageId, final int pageSize) {
		return null;
	}
}