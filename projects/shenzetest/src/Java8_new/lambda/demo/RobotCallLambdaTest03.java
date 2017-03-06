package Java8_new.lambda.demo;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by liangyh on 2016-11-27.
 */
public class RobotCallLambdaTest03 {

    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        RobotContactAnon robot = new RobotContactAnon();

        System.out.println("calling all drivers");
        robot.phoneContacts(personList,
                person->person.getAge() >= 16);

        System.out.println("emailing all draftees");
        robot.emailContacts(personList,
                p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE);

        System.out.println("mailing all pilots");
        robot.mailContacts(personList, p -> p.getAge() >= 23 && p.getAge() <= 65);
    }
}
