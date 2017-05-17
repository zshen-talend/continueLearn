package javatest.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Hello {

    public static void main(String[] args) {
        List<String> brother = new ArrayList<String>();
        brother.add("1");
        brother.add("2");
        brother.add("3");
        Person person = new Person(26, "Juventus");
        person.setWorkDay(7);
        EggSer egg = new EggSer();
        egg.setBrother(brother);
        egg.setNumber(2);
        person.setEgg(egg);
        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(person);
            os.close();

            Person.name = "Alex";

            FileInputStream in = new FileInputStream("foo.ser");
            ObjectInputStream s = new ObjectInputStream(in);
            Person p = (Person) s.readObject();
            System.out.println("name==" + Person.name + " age==" + p.getAge() + " workDay==" + p.getWorkDay() + " fClub=="
                    + p.getfClub() + " egg=" + p.getEgg().toString() + " egg brother is "
                    + (((EggSer) p.getEgg()).getBrother() == null ? "null" : ((EggSer) p.getEgg()).getBrother().size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}