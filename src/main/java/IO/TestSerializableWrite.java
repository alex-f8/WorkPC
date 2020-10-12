package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestSerializableWrite {
    public static void main(String[] args) throws IOException {
        Person bob = new Person("Bob", 15);
        Person kate = new Person("Kate", 14);
        Person sam = new Person("Sam", 18);

        File file = new File("c:\\tmpDel");
        if(file.exists())
            file.mkdir();
        else
            System.out.println("Direcotry tmpDel (c:\\tmpDel) is created");

        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(bob);
        persons.add(kate);
        persons.add(sam);


        try( ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream( "c:\\tmpDel\\info.dat", false)) ;
             ObjectOutputStream oosArrayList = new ObjectOutputStream(
                     new FileOutputStream("c:\\tmpDel\\infoAL.dat", false)) ){

            oos.writeObject(kate);
            oos.flush();

            oosArrayList.writeObject(persons);
            oosArrayList.flush();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

