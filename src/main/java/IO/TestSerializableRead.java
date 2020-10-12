package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TestSerializableRead {
    public static void main(String[] args) throws IOException {

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("c:\\tmpDel\\info.dat"));
        ObjectInputStream oisAL = new ObjectInputStream(
                new FileInputStream("c:\\tmpDel\\infoAL.dat"))){


            Person person = (Person) ois.readObject();
            System.out.printf("User name %s, age %d\n\n", person.getName(), person.getAge());



            ArrayList<Person> persons = (ArrayList<Person>) oisAL.readObject();
            for(Person item : persons)
                System.out.printf("%s %d\n", item.getName(), item.getAge());
            System.out.println("All is OK\n");


        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
