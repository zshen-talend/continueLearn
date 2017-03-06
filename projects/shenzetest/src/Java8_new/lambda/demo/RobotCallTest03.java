package Java8_new.lambda.demo;


import java.util.List;

/**
 * Created by liangyh on 2016-11-27.
 */
public class RobotCallTest03 {

    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        RobotContactAnon robot = new RobotContactAnon();

        System.out.println("calling all drivers");
        robot.phoneContacts(personList,
                new MyTest<Person>() {
                    @Override
                    public boolean test(Person person) {
                        return person.getAge() >= 16;
                    }
                });

        System.out.println("emailing all draftees");
        robot.emailContacts(personList,
                new MyTest<Person>() {
                    @Override
                    public boolean test(Person p) {
                        return p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
                    }
                });

        System.out.println("mailing all pilots");
        robot.mailContacts(personList, new MyTest<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getAge() >= 23 && p.getAge() <= 65;
            }
        });
    }
}
