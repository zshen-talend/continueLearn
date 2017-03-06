package Java8_new.lambda.comparator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Java8_new.lambda.demo.Person;

/**
 * Created by liangyh on 2016-11-27.
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();

        //匿名内部类
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSurName().compareTo(o2.getSurName());
            }
        });

        for(Person p: personList){
            p.printName();
        }

        //lambda 1
        Collections.sort(personList, (Person o1, Person o2)->o1.getSurName().compareTo(o2.getSurName()));

        for(Person p: personList){
            p.printName();
        }
         //lambda 2
        Collections.sort(personList, (o1, o2)->o1.getSurName().compareTo(o2.getSurName()));
        for(Person p: personList){
            p.printName();
        }
    }
}