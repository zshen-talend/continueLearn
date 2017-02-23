package javatest.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Hello {

    public static void main(String[] args) {
        Person person = new Person(26, "Juventus");
        person.setWorkDay(7);
        Egg egg = new Egg();
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
                    + p.getfClub() + " egg=" + p.getEgg().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}