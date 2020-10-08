package IO;

import java.io.Serializable;

class Person implements Serializable {
    private String name;
    private int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo(){
        System.out.printf("%s %d\n", name, age);
    }
}