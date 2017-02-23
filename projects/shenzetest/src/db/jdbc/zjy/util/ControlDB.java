package db.jdbc.zjy.util;


import java.util.*;
import java.sql.*;

import db.jdbc.zjy.bean.Stuinfo;

public class ControlDB {
	public List executeQueryStuinfo(String sql) {
		List list = new ArrayList();
		try {
			ResultSet set = DBUtil.executeQuery(sql);
			while (set.next()) {
				Stuinfo stuinfoObject = new Stuinfo();
				stuinfoObject.setScore(set.getString("score"));
				stuinfoObject.setClasses(set.getString("classes"));
				stuinfoObject.setName(set.getString("name"));
				stuinfoObject.setId(set.getInt("id"));
				list.add(stuinfoObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public int executeUpdate(String sql) {
		int i = 0;
		try {
			DBUtil dbUtil = new DBUtil();
			i = dbUtil.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
	}
}