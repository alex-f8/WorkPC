package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSerializableWrite {
    public static void main(String[] args) throws IOException {
        Person bob = new Person("Bob", 15);
        Person kate = new Person("Kate", 14);
        Person sam = new Person("Sam", 18);
        bob.displayInfo();

        File file = new File("c:\\tmpDel");
        file.mkdir();

        try( ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( "c:\\tmpDel\\info.dat", true)) ){
            oos.writeObject(bob);
            oos.writeObject(kate);
            oos.writeObject(sam);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

