package Collection;

import java.util.TreeSet;

public class TestCollection02 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("Germany");
        treeSet.add("Spain");
        treeSet.add("Belgium");
        treeSet.add("Makedonia");
        treeSet.add("France");
        for(String item : treeSet)
            System.out.printf("%s ", item);

        treeSet.add("Germany");
        System.out.println();
        for(String item : treeSet)
            System.out.printf("%s ", item);

        TreeSet<Person> person = new TreeSet<Person>();
        person.add(new Person("Bob", 35));
        person.add(new Person("Sam", 25));
        person.add(new Person("Frank", 41));
        person.add(new Person("Lily", 21));
        person.add(new Person("Kate", 38));
        person.add(new Person("Jimmy", 48));
    }
}

class Person implements Comparable <Person>{
    private String name;
    private byte age;
    Person(String name, byte age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    @Override
    public String compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
