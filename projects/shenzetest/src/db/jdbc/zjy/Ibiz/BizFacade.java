package db.jdbc.zjy.Ibiz;



import db.jdbc.zjy.service.impl.JDBCServiceFactory;

public class BizFacade {
	private IServiceLocator factory = new JDBCServiceFactory();

	private BizFacade() {
	}

	public static BizFacade forInstance() {
		return new BizFacade();
	}

	public IStuinfoBiz forStuinfoBizImpl() {
		return factory.forStuinfoBizImpl();
	}
}