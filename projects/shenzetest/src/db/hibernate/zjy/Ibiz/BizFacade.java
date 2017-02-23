package db.hibernate.zjy.Ibiz;

import db.hibernate.zjy.service.impl.SpringServiceFactory;



public class BizFacade {
	private IServiceLocator factory = new SpringServiceFactory();

	private BizFacade() {
	}

	public static BizFacade forInstance() {
		return new BizFacade();
	}

	public IStuinfoBiz forStuinfoBizImpl() {
		return factory.forStuinfoBizImpl();
	}
}