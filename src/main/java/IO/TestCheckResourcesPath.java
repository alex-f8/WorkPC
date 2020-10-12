package IO;

import java.io.File;
import java.io.IOException;

public class TestCheckResourcesPath {
    public static void main(String[] args) throws IOException {
        File test = new File("c:\\person.dat");
        test.createNewFile();
        if(test.exists())
            System.out.println("file person.dat exists");
        else
            System.out.println("file poerson.dat dosnt exists");

        File mkdir = new File("dir");
        System.out.println(mkdir.mkdir()? "created":"not");
    }
}
