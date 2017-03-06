package Java8_new.lambda.demo;

import java.time.Period;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by liangyh on 2016-11-27.
 */
public class RobotCallLambdaTest04 {

    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        RobotContactLambda robot = new RobotContactLambda();

        Predicate<Person> allDrivers = person->person.getAge() >= 16;
        Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
        Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

        System.out.println("calling all drivers");
        robot.phoneContacts(personList, allDrivers);

        System.out.println("emailing all draftees");
        robot.emailContacts(personList, allDraftees);

        System.out.println("mailing all pilots");
        robot.mailContacts(personList, allPilots);
    }
}
