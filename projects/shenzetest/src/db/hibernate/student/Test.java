package db.hibernate.student;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;


public class Test
{
    public static void main(String[] args)
    {
       getData();
       
    }
    public static void insertData(){
    	 try
         {
             //通过Configuration获得一个SessionFactory对象
         	SessionFactory sf = new Configuration().configure().buildSessionFactory();
             //打开一个Session
             Session session = sf.openSession();
             //开始一个事务
             Transaction tx = session.beginTransaction();
             //创建一个Student对象
             Student stu = new Student();
             //通过Student的setter方法改变它的属性
             //注意student_id不用我们设置
             stu.setStudent_name("二");
             stu.setStudent_age(18);
             //通过session的save()方法将Student对象保存到数据库中
             session.save(stu);
             //提交事务
             tx.commit();
             //关闭会话
             session.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }
    public static void getData(){
    	try
    	{
    		//通过Configuration获得一个SessionFactory对象
    		SessionFactory sf = new Configuration().configure().buildSessionFactory();
    		//打开一个Session
    		Session session = sf.openSession();
    		//开始一个事务
    		Transaction tx = session.beginTransaction();
    		//创建一个Student对象
//    		session.createSQLQuery("select * from TDQ_VALUES c where c.VAL_STRING ='一'").addEntity("c",TdqValues.class).list();
    		Query query = session.createQuery("from TdqValues value where value.valString='一'");
//    		query.setParameter(0,"一");
    		List<?> list =query.list();
//    		List<?> list = session.createCriteria(TdqValues.class).add(Restrictions.eq("valString", new String("一".getBytes(),"UTF-8"))).list();
//    		List<?> list = session.createCriteria(Student.class).add(Expression.eq("student_name", "一")).list();
//    		Student stu=(Student)session.get(Student.class, 1005);
//    		Student stu=(Student)list.get(0);
    		TdqValues value=(TdqValues)list.get(0);
    		tx.commit();
    		
    		//关闭会话
    		session.close();
//    		System.out.println(stu.getStudent_name());
    		System.out.println(value.getValString());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
