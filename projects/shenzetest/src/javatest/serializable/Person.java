package javatest.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {

    private static final long serialVersionUID = -842029427676826563L;

    public static String name;

    private int age;

    private transient int workDay = 5;

    private String fClub;

    private Egg egg = null;

    public Person() {
        System.out.println("none-arg constructor");
    }

    public Person(int age, String fClub) {
        this.age = age;
        this.fClub = fClub;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public String getfClub() {
        return fClub;
    }

    public void setfClub(String fClub) {
        this.fClub = fClub;
    }

    /*
     * //writeObject和readObject不再被执行 private void writeObject(ObjectOutputStream out) throws IOException {
     * out.defaultWriteObject();//执行默认的序列化机制 out.writeInt(workDay); System.out.println("正在进行序列持久化"); }
     * 
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
     * in.defaultReadObject(); workDay = in.readInt(); System.out.println("读取持久化对象"); }
     */

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(fClub);
        out.writeInt(age);
        out.writeObject(egg);
        System.out.println("自定义序列化过程");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        fClub = (String) in.readObject();
        age = in.readInt();
        egg = (Egg) in.readObject();
        System.out.println("自定义反序列化");
    }

    /**
     * Getter for egg.
     * 
     * @return the egg
     */
    public Egg getEgg() {
        return this.egg;
    }

    /**
     * Sets the egg.
     * 
     * @param egg the egg to set
     */
    public void setEgg(Egg egg) {
        this.egg = egg;
    }

}