package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TestSerializableRead {
    public static void main(String[] args) throws IOException {
        try(ObjectInputStream ois = new ObjectInputStream( new FileInputStream("c:\\tmpDel\\info.dat")) ){
            Person tmpPeson;
            ArrayList<Person> persons = (ArrayList<Person>) ois.readObject();

            for(Person person : persons)
                System.out.printf("%s %d\n", person.getName(), person.getAge());
            System.out.println("\n\nAll is OK");
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
