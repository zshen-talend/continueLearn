package Java8_new.lambda.otherFunction.foreach;

import java.util.List;

import Java8_new.lambda.otherFunction.Person;

/**
 * Created by liangyh on 2016-11-27.
 */
public class Test01ForEach {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();

        System.out.println("\nwestern phone list");
        personList.forEach(p->p.printWesternName());

        System.out.println("\neastern phone list");
        personList.forEach(Person::printEasternName);

        System.out.println("\ncustom phone list");
        personList.forEach(p -> {
            System.out.println(p.printCustom(r-> "name: "+r.getGivenName()+" EMail:"+r.getEmail()));
        });
    }
}
