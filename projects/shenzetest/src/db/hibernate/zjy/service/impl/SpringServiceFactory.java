package db.hibernate.zjy.service.impl;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import db.hibernate.zjy.Ibiz.IServiceLocator;
import db.hibernate.zjy.Ibiz.IStuinfoBiz;



public class SpringServiceFactory implements IServiceLocator {
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	public IStuinfoBiz forStuinfoBizImpl() {
		return (IStuinfoBiz) applicationContext.getBean("stuinfoBizImpl");
	}
}