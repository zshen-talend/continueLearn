package Java8_new.lambda.otherFunction.map;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import Java8_new.lambda.otherFunction.Person;
import Java8_new.lambda.otherFunction.SearchCriteria;

/**
 * Created by liangyh on 2016-11-28.
 */
public class Test04Map {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        SearchCriteria search = SearchCriteria.getInstance();

        System.out.println("old style");
        int sum = 0;
        int count = 0;
        for(Person p:personList){
            if(p.getAge() >= 23 && p.getAge() <= 65){
                sum += p.getAge();
                count++;
            }
        }

        long average = sum/count;
        System.out.println("total ages: "+sum);
        System.out.println("average age: "+average);

        System.out.println("\n new style");
        long totalAge = personList
                .stream()
                .filter(search.getCriteria("allPilots"))
                .mapToInt(p->p.getAge())
                .sum();

        OptionalDouble averageAge = personList
                .parallelStream()
                .filter(search.getCriteria("allPilots"))
                .mapToDouble(p -> p.getAge())
                .average();

        System.out.println("total ages: "+totalAge);
        System.out.println("average age: "+averageAge.getAsDouble());
    }
}
