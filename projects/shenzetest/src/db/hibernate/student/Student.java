package db.hibernate.student;

import java.io.Serializable;

public class Student implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int student_id;
    private String student_name;
    private int student_age;
    
    public int getStudent_id()
    {
        return student_id;
    }
    public String getStudent_name()
    {
        return student_name;
    }
    public int getStudent_age()
    {
        return student_age;
    }
    public void setStudent_id(int id)
    {
        this.student_id = id;
    }
    public void setStudent_name(String name)
    {
        this.student_name = name;
    }
    public void setStudent_age(int age)
    {
        this.student_age = age;
    } 
}
