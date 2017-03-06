package Java8_new.lambda.otherFunction.toList;

import java.util.List;
import java.util.stream.Collectors;

import Java8_new.lambda.otherFunction.Person;
import Java8_new.lambda.otherFunction.SearchCriteria;

/**
 * Created by liangyh on 2016-11-28.
 */
public class Test03toList {

    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        SearchCriteria searchCriteria = SearchCriteria.getInstance();

        List<Person> pilotList = personList
                .stream()
                .filter(searchCriteria.getCriteria("allPilots"))
                .collect(Collectors.toList());

        System.out.println("\n western pilot phone list");
        pilotList.forEach(Person::printWesternName);
        //或者
        //pilotList.forEach(person -> person.printWesternName());
    }
}
