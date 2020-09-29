package Studing02_Наследование;

public class TestExtended {
    public static void main(String[] args) {
        Person person = new Person("Bob", 26);
        person.showPerson();

        Employ employ = new Employ("Kate", 35, "Test");
        employ.showPerson();

        employ.showPerson2();

        Person vasiko = new Employ("Vasiko", 12, "NoCompany");
        vasiko.showText();
        //vasiko.showPerson2(); //error because vasiko can use method only included in both classes (parent and child)

    }
}

class Person{
    protected String name;
    protected int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void showPerson(){
        System.out.printf("\nName: %s, age: %s", name, age);
    }

    public void showText(){
        System.out.println("\nhello 1");
    }
}

class Employ extends Person{
    private String company;

    Employ(String name, int age, String company){
        super(name, age);
        this.company = company;
    }

    @Override
    public void showPerson(){
        System.out.printf("\nName: %s, age: %d, company: %s", name, age, company);
    }

    public void showPerson2(){
        super.showPerson();
        System.out.printf(" company: %s", company);
    }

    public void showText(){
        System.out.println("\nhello 2");
    }
}
