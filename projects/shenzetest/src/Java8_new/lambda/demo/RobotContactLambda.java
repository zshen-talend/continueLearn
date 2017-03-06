package Java8_new.lambda.demo;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by liangyh on 2016-11-27.
 */
public class RobotContactLambda {
	//注意：这里由phoneDrivers变成了phoneContacts
    //因为call的人群范围由所传入的参数来决定。
    //所以这个函数的使用范围变广了。
    public void phoneContacts(List<Person> plist, Predicate<Person> aTest){
        for(Person p :plist){
            if(aTest.test(p)){
                robotCall(p);
            }
        }
    }

    public void emailContacts(List<Person> plist, Predicate<Person> aTest){
        for(Person p: plist){
            if(aTest.test(p)){
                robotEmail(p);
            }
        }
    }

    public void  mailContacts(List<Person> plist, Predicate<Person> aTest){
        for(Person p: plist){
            if(aTest.test(p)){
                robotMail(p);
            }
        }
    }

    public void robotCall(Person p){
        System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
    }

    public void robotEmail(Person p){
        System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
    }

    public void robotMail(Person p){
        System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
    }
}
