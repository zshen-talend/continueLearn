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
             //ͨ��Configuration���һ��SessionFactory����
         	SessionFactory sf = new Configuration().configure().buildSessionFactory();
             //��һ��Session
             Session session = sf.openSession();
             //��ʼһ������
             Transaction tx = session.beginTransaction();
             //����һ��Student����
             Student stu = new Student();
             //ͨ��Student��setter�����ı���������
             //ע��student_id������������
             stu.setStudent_name("��");
             stu.setStudent_age(18);
             //ͨ��session��save()������Student���󱣴浽���ݿ���
             session.save(stu);
             //�ύ����
             tx.commit();
             //�رջỰ
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
    		//ͨ��Configuration���һ��SessionFactory����
    		SessionFactory sf = new Configuration().configure().buildSessionFactory();
    		//��һ��Session
    		Session session = sf.openSession();
    		//��ʼһ������
    		Transaction tx = session.beginTransaction();
    		//����һ��Student����
//    		session.createSQLQuery("select * from TDQ_VALUES c where c.VAL_STRING ='һ'").addEntity("c",TdqValues.class).list();
    		Query query = session.createQuery("from TdqValues value where value.valString='һ'");
//    		query.setParameter(0,"һ");
    		List<?> list =query.list();
//    		List<?> list = session.createCriteria(TdqValues.class).add(Restrictions.eq("valString", new String("һ".getBytes(),"UTF-8"))).list();
//    		List<?> list = session.createCriteria(Student.class).add(Expression.eq("student_name", "һ")).list();
//    		Student stu=(Student)session.get(Student.class, 1005);
//    		Student stu=(Student)list.get(0);
    		TdqValues value=(TdqValues)list.get(0);
    		tx.commit();
    		
    		//�رջỰ
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
