package Collection;

import javax.swing.event.TreeSelectionEvent;
import java.util.TreeSet;
import java.util.Comparator;

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
        person.add(new Person("Sam", (byte) 25));
        person.add(new Person("Frank", (byte) 41));
        person.add(new Person("Lily", (byte) 21));
        person.add(new Person("Kate", (byte) 38));
        person.add(new Person("Jimmy", (byte) 48));
        person.add(new Person("Bob", (byte)35));
        person.add(new Person("Alexander", (byte)36));
        System.out.println();
        for( Person item : person)
            System.out.printf("%s (%d), ", item.getName(), item.getAge());


        TreeSet<Person> personTreeSet = new TreeSet<Person>(new ComporatorForPersonByAge());
        personTreeSet.add(new Person("Sam", (byte) 25));
        personTreeSet.add(new Person("Frank", (byte) 41));
        personTreeSet.add(new Person("Lily", (byte) 21));
        personTreeSet.add(new Person("Kate", (byte) 38));
        personTreeSet.add(new Person("Jimmy", (byte) 48));
        personTreeSet.add(new Person("Bob", (byte) 35));
        personTreeSet.add(new Person("Alexander", (byte) 36));
        System.out.println();
        for( Person item : personTreeSet)
            System.out.printf("%s (%d), ", item.getName(), item.getAge());

        // Don't work !
/*
        Comparator cbn =
                (ComporatorForPersnByName) new ComporatorForPersnByName().thenComparing(new ComporatorForPersonByAge());
        TreeSet<Person> personTreeSet1 = new TreeSet<Person>(cbn);
        personTreeSet1.add(new Person("Suzann", (byte) 32));
        personTreeSet1.add(new Person("Suzana", (byte) 39));
        personTreeSet1.add(new Person("Suzana", (byte) 19));
        personTreeSet1.add(new Person("Bob", (byte) 29));
        personTreeSet1.add(new Person("Bob", (byte) 10));
        personTreeSet1.add(new Person("Alexander", (byte) 36));
        personTreeSet1.add(new Person("Alexandr", (byte) 36));
        personTreeSet1.add(new Person("Alexander", (byte) 19));
        System.out.println();
        for(Person item : personTreeSet1)
            System.out.printf("%s (%d), ");
*/

    }
}

class ComporatorForPersnByName implements Comparator <Person>{
    public int compare(Person a, Person b){
        return a.getName().compareTo(b.getName());
    }
}

class ComporatorForPersonByAge implements Comparator <Person>{
    public int compare(Person a, Person b){
        return a.getAge() - b.getAge();
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
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}
