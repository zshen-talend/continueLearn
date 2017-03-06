package Java8_new.lambda.otherFunction.filter;

import java.util.List;

import Java8_new.lambda.otherFunction.Person;
import Java8_new.lambda.otherFunction.SearchCriteria;

/**
 * Created by liangyh on 2016-11-27.
 */
public class Test02Filter {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        SearchCriteria search = SearchCriteria.getInstance();
        System.out.println("western pilot phone list");
      //两个冒号表示方法引用，method reference，
        personList.stream().filter(search.getCriteria("allPilots"))
                .forEach(Person::printWesternName);
        //或者
        /*personList.stream().filter(search.getCriteria("allPilots"))
                .forEach(p->p.printWesternName());*/

        System.out.println("\n eastern draftee phone list");
        personList.stream().filter(search.getCriteria("allDraftees"))
                .forEach(Person::printEasternName);
    }
}
