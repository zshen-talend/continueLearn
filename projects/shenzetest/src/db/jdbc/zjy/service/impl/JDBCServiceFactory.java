package db.jdbc.zjy.service.impl;



import db.jdbc.zjy.Ibiz.IServiceLocator;
import db.jdbc.zjy.Ibiz.IStuinfoBiz;

public class JDBCServiceFactory implements IServiceLocator {
	public IStuinfoBiz forStuinfoBizImpl() {
		return new StuinfoBizImpl();
	}
}