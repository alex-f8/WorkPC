package TestEnumObjectGeneric;

public class TestThisAll {
    public static void main(String ...args){
        //test enum
        Day today = Day.Friday;
        System.out.println(today);

        // test Objects
        Person tom = new Person("Tom", 15);
        tom.displayInfo();
        System.out.println("HashCode of tom: " + tom.hashCode());

        Person frank = new Person("Tom", 15);
        frank.displayInfo();
        System.out.println("HashCode of frank: " + frank.hashCode());

        if(tom instanceof Person) System.out.println("\ntom is object Person class");
        if(frank instanceof Person) System.out.println("frank is object Person class");

        if(tom.equals(frank)) System.out.println("\ntom equal frank");
        else System.out.println("tom not equals frank\n");

        Person2 kate = new Person2("Kate", 35);
        kate.displayInfo();
        System.out.println("HashCode of kate: " + kate.hashCode());

        Person2 lisa = new Person2("Lisa", 35);
        lisa.displayInfo();
        System.out.println("HashCode of lisa: " + lisa.hashCode());

        if(kate.equals(lisa)) System.out.println("\nkate equals lisa");
        else System.out.println("kate not equals lisa");

        Person2 sindy = kate;
        if(sindy.equals(kate)) System.out.println("sindy equlas kate");
        else System.out.println("sindy not equlas kate");

        Account<String> user1 = new Account<String>("123456789", "James Bond");
        user1.displayInfo();
        Account<Integer> user2 = new Account<Integer>(987654321, "Indiana Jons");
        user2.displayInfo();
    }
}

enum Day{
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}

class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    void displayInfo(){
        System.out.printf("Name: %s, age: %d\n", name, age)   ;
    }
}

class Person2 extends Person{
    Person2(String name, int age){
        super(name, age);
    }
/*    @Override
    public String toString(){
        return name;
    }*/

/*    @Override
    public boolean equals(Object obj) {
        if( this.name == obj.name)
            return true;
        else
            return false;
        //return super.equals(obj);
    }*/
}

class Account<VALUE>{
    private VALUE id;
    private String name;
    Account(VALUE id, String name){
        this.id = id;
        this.name = name;
    }
    public void displayInfo(){
        System.out.println("ID: " + id + ", NAME: " + name);
    }
}