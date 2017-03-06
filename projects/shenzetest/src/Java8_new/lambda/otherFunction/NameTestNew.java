package Java8_new.lambda.otherFunction;

import java.util.List;
import java.util.function.Function;

/**
 * Created by liangyh on 2016-11-27.
 */
public class NameTestNew {
    public static void main(String[] args) {
        List<Person> list = Person.createShortList();

        System.out.println("custom list");
        for(Person person: list){
            System.out.println(
                    person.printCustom(p->"Name: "+p.getGivenName()+" Email: "+p.getEmail()));
        }

        Function<Person, String> westernStyle = p -> "\nName: " + p.getGivenName() + " " + p.getSurName() + "\n" +
                "Age: " + p.getAge() + "  " + "Gender: " + p.getGender() + "\n" +
                "EMail: " + p.getEmail() + "\n" +
                "Phone: " + p.getPhone() + "\n" +
                "Address: " + p.getAddress();

        Function<Person, String> easternStyle = p -> "\nName: " + p.getSurName() + " " + p.getGivenName() + "\n" +
                "Age: " + p.getAge() + "  " + "Gender: " + p.getGender() + "\n" +
                "EMail: " + p.getEmail() + "\n" +
                "Phone: " + p.getPhone() + "\n" +
                "Address: " + p.getAddress();

        System.out.println("western ");
        for(Person person: list){
            System.out.println(person.printCustom(westernStyle));
        }

        System.out.println("eastern ");
        for (Person person: list){
            System.out.println(person.printCustom(westernStyle));
        }
    }


}
